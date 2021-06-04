package com.project.virtuallab;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RegisterConnectivity {
	
	
	public static boolean makeRegister(RegistrationDetails user) throws IOException, InterruptedException {
		
		HttpClient httpClient;
		HttpRequest httpRequest;
		HttpResponse<String> response;
		ObjectMapper objMapper;
		
		objMapper = new ObjectMapper();
		String requestBody = objMapper.writeValueAsString(user);
		System.out.println(requestBody);
		httpClient = HttpClient.newHttpClient();
		httpRequest = HttpRequest.newBuilder()
						.uri(URI.create("http://localhost/FinalYearProject/register.php"))
						.header("Content-Type", "application/json")
						.POST(BodyPublishers.ofString(requestBody))
						.build();
		
		response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
		
		return false;
		
	}

	public static void main(String[] args) {
		RegistrationDetails user = new RegistrationDetails("dsanchaykumar@gmail.com", "Sanchay", "Kumar", "sanchay123?");
		try {
			makeRegister(user);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
