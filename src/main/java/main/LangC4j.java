package main;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;

public class LangC4j {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		ChatModel model = OpenAiChatModel.builder()
				.apiKey(System.getenv("OPENAI_API_KEY"))
				.modelName("gpt-5.6-luna")
				.build();
		String res = model.chat("What is MCP , How it works");
		System.out.println(res);
		
		support Support = AiServices.create(support.class,model);
		String output = Support.explain("RAG");
		System.out.println(output);
	}

}
