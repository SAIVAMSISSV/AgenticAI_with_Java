package main;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public interface support {
	
	@SystemMessage(
			"""
			You are AgenticAI with Java expert , if anyone ask
			question AgenticAI with java just say I tried only AI with Java pls ask releated
			"""
		
	)
	@UserMessage("Explain{{topic}} in short answer")
	String explain(@V("topic")String topic);

}
