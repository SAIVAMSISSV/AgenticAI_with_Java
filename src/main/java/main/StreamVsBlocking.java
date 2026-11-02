package main;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.core.http.StreamResponse;
import com.openai.models.chat.completions.ChatCompletion;
import com.openai.models.chat.completions.ChatCompletionChunk;
import com.openai.models.chat.completions.ChatCompletionCreateParams;

public class StreamVsBlocking {

	static OpenAIClient client =  OpenAIOkHttpClient.fromEnv();
	static long start;
	static long firstTextAt=0;
	public static void main(String[] args) {
		
		ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
				.model("gpt-5.4-mini")
                .addUserMessage("Explain the Java Collections Framework in 5 short points.")
                .build();
		
		System.out.println("===Blocking===");
		start = System.currentTimeMillis();
		ChatCompletion chat = client.chat().completions().create(params);
		System.out.println("blocking chat"+chat);
		long BlockingTime = System.currentTimeMillis()-start;
		String ans = chat.choices().get(0).message().content().orElse("");
		System.out.println("diff Block time==="+BlockingTime);
		System.out.println(ans);
		System.out.println("=====Streaming=======");
		start = System.currentTimeMillis();
		StreamResponse<ChatCompletionChunk> stream = client.chat().completions().createStreaming(params);
		System.out.println("test stream o/p"+stream.toString());
        stream.stream()
        .flatMap(chunk->chunk.choices().stream())
        .flatMap(choice->choice.delta().content().stream())
        .forEach(text->{
        		if(firstTextAt==0) {
        			firstTextAt = System.currentTimeMillis()-start;
        		}
        		System.out.println(text);
        		
        }
        		);
        
		
        long streamingTime = System.currentTimeMillis() - start;
   	 System.out.println();
        System.out.println("Blocking  : user saw the first word after " + BlockingTime + " ms");
        System.out.println("Streaming : user saw the first word after " + firstTextAt + " ms");
        System.out.println("Streaming : full answer finished after    " + streamingTime + " ms");
    

	}

}
