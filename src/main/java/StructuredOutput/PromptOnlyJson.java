package StructuredOutput;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.chat.completions.ChatCompletionCreateParams;

public class PromptOnlyJson {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		// TODO Auto-generated method stub
		OpenAIClient client = OpenAIOkHttpClient.builder()
                .apiKey(System.getenv("OPENAI_API_KEY"))
                .build();
        
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model("gpt-5.4-mini")
                .addSystemMessage("Read the email and return the leave details as JSON.leave type should be CASUAL, SICK, EARNED")
                .addUserMessage(Emails.SICK_LEAVE)
                .build();
        
        String reply = client.chat().completions().create(params)
                .choices().get(0).message().content().orElse("");
        
        System.out.println("model answer");
        System.out.println(reply);
        
        System.out.println("================");
        
        ObjectMapper mapper = new ObjectMapper();
        LeaveRequest leave = mapper.readValue(reply,LeaveRequest.class);
        System.out.println(leave);
        
        

	}

}
