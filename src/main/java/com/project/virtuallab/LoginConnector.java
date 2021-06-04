package com.project.virtuallab;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginConnector{
	
	URL loginUrl;
	HttpURLConnection httpURLConnection;
	
	
	public static boolean makeLogin(LoginDetails user) throws IOException, InterruptedException{
		
		ObjectMapper obj = new ObjectMapper();
		String requestBody = obj.writeValueAsString(user);
		
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest httRequest = HttpRequest.newBuilder()
									.uri(URI.create("http://localhost/FinalYearProject/login.php"))
									.POST(HttpRequest.BodyPublishers.ofString(requestBody))
									.build();
		
		HttpResponse<String> response = client.send(httRequest, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
		
		return false;
		
	}
	
	public static void main(String args[]) {
		
		LoginDetails user = new LoginDetails("sanchay", "sanchay123?");
		try {
			makeLogin(user);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
