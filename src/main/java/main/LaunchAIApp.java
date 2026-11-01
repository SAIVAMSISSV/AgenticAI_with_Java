package main;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LaunchAIApp {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String Api_Key=System.getenv("OPENAI_API_KEY");
		
		String requestBody="""
			{
				"model":"gpt-5.6-luna",
				"input":"Explain Java in One sentence"
			}
			""";
				
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpRequest req = HttpRequest.newBuilder()
				.uri(URI.create("https://api.openai.com/v1/responses"))
				.header("Authorization", "Bearer " + Api_Key)
				.header("Content-Type", "application/json")
				.POST(HttpRequest.BodyPublishers.ofString(requestBody))
				.build();
		
		HttpResponse<String> res = httpClient.send(req,HttpResponse.BodyHandlers.ofString());
		System.out.println(res.body());
		
		

	}

}
