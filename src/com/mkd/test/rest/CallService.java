package com.mkd.test.rest;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.mkd.test.model.ServiceResponse;
import com.mkd.test.model.TestCase;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CallService {
		
	public static ServiceResponse apiService(String url, String method, String requestBody) {
		RestAssured.baseURI = url;
		RequestSpecification request = RestAssured.given();
		
		// Post the request and check the response
		Response response = null;
		if(method.equals(TestCase.STATUS_GET)) {
			response = request.get();
		} else {
			JSONObject requestParams = (JSONObject) JSONValue.parse(requestBody);
			request.body(requestParams.toJSONString());
			
			if(method.equals(TestCase.STATUS_POST)) {
				response = request.post();
			} else if(method.equals(TestCase.STATUS_PUT)) {
				response = request.put();
			} else if(method.equals(TestCase.STATUS_DELETE)) {
				response = request.delete();
			}
		}
		
		return new ServiceResponse(response.getStatusCode(), response.getBody().asString());
	}
}
