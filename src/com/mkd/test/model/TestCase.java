package com.mkd.test.model;

import java.sql.Timestamp;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

public class TestCase {
	public static final String STATUS_GET = "GET";
	public static final String STATUS_POST = "POST";
	public static final String STATUS_PUT = "PUT";
	public static final String STATUS_DELETE = "DEELETE";
	
	@CsvBindByName
	@CsvBindByPosition(position = 0)
	private String testCaseId;
	@CsvBindByName
	@CsvBindByPosition(position = 1)
	private String title;
	@CsvBindByName
	@CsvBindByPosition(position = 2)
	private String resource;
	@CsvBindByName
	@CsvBindByPosition(position = 3)
	private String method;
	@CsvBindByName
	@CsvBindByPosition(position = 4)
	private String status;
	private String requestBody;
	@CsvBindByName
	@CsvBindByPosition(position = 5)
	private String executionTime;
	@CsvBindByName
	@CsvBindByPosition(position = 6)
	private int statusCodeExpected;
	@CsvBindByName
	@CsvBindByPosition(position = 7)
	private String responseExpected;
	@CsvBindByName
	@CsvBindByPosition(position = 8)
	private int statusCodeResponse;
	@CsvBindByName
	@CsvBindByPosition(position = 9)
	private String response;
	
	public static String getHeader() {
		String headerRow = "";
		String [] headers = new String[]{"TestCaseId","Title","Resource","Method","Status","ExecutionTime","RequestBody","StatusCodeExpected","ResponseExpected",
				 "StatusCodeResponse","Response"};
		
		for(String h : headers) {
			headerRow += h + ",";
		}
		
		return headerRow;
	}
	
	public String getTestCaseId() {
		return testCaseId;
	}
	public void setTestCaseId(String testCaseId) {
		this.testCaseId = testCaseId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(String executionTime) {
		this.executionTime = executionTime;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	
	public void setCurrentExecutionTime() {
	    this.executionTime = ""+new Timestamp(System.currentTimeMillis());
	}
	
	public int getStatusCodeExpected() {
		return statusCodeExpected;
	}

	public void setStatusCodeExpected(int statusCodeExpected) {
		this.statusCodeExpected = statusCodeExpected;
	}

	public String getResponseExpected() {
		return responseExpected;
	}

	public void setResponseExpected(String responseExpected) {
		this.responseExpected = responseExpected;
	}

	public int getStatusCodeResponse() {
		return statusCodeResponse;
	}

	public void setStatusCodeResponse(int statusCodeResponse) {
		this.statusCodeResponse = statusCodeResponse;
	}
	
	public String getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}

	@Override
	public String toString() {
		return "TestCase [testCaseId=" + testCaseId + ", title=" + title
				+ ", resource=" + resource + ", method=" + method + ", status="
				+ status + ", executionTime=" + executionTime
				+ ", statusCodeExpected=" + statusCodeExpected
				+ ", responseExpected=" + responseExpected
				+ ", statusCodeResponse=" + statusCodeResponse + ", response="
				+ response + "]";
	}

	public String retrieveRecord() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(this.testCaseId).append(",");
		sb.append(this.title).append(",");
		sb.append(this.resource).append(",");
		sb.append(this.method).append(",");
		sb.append(this.status).append(",");
		sb.append(this.executionTime).append(",");
		sb.append(this.requestBody != null ? "\"" + this.requestBody.replace("\"", "\"\"") + "\"" : "").append(",");
		sb.append(this.statusCodeExpected).append(",");
		sb.append(this.responseExpected != null ? "\"" + this.responseExpected.replace("\"", "\"\"") + "\"" : this.responseExpected).append(",");
		sb.append(this.statusCodeResponse).append(",");
		sb.append(this.response != null ? "\"" + this.response.replace("\"", "\"\"") + "\"" : this.response).append(",");
		
		return sb.toString();
	}
}
