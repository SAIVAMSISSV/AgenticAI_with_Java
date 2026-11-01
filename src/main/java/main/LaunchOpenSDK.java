package main;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.responses.ResponseCreateParams;
import com.openai.models.responses.Response;


public class LaunchOpenSDK {

	public static void main(String[] args) {
		OpenAIClient client = OpenAIOkHttpClient.builder()
				.apiKey(System.getenv("OPENAI_API_KEY"))
				.build();
		
		ResponseCreateParams params = ResponseCreateParams.builder()
				.input("Tell me about AgenticAI")
		        .model("gpt-6-astra")
		        .build();
		
		Response Res =  client.responses().create(params);
		Res.output().stream()
	        .flatMap(item -> item.message().stream())
	        .flatMap(message -> message.content().stream())
	        .flatMap(content -> content.outputText().stream())
	        .forEach(outputText -> System.out.println(outputText.text()));
		
				
	}

}
