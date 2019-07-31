package com.mkd.test.model;

public class ServiceResponse {
	private int statusCode;
	private String response;
	
	public ServiceResponse() {
		
	}
	
	public ServiceResponse(int statusCode, String response) {
		this.statusCode = statusCode;
		this.response = response;
	}
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "ServiceResponse [statusCode=" + statusCode + ", response="
				+ response + "]";
	}
}
