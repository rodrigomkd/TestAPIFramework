package com.mkd.test.main;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import com.mkd.test.model.ServiceResponse;
import com.mkd.test.model.TestCase;
import com.mkd.test.rest.CallService;
import com.mkd.test.utils.CsvUtils;

public class TestAPIMain {
	private static final String TEST_CASES_PATH = "";
	private static final String TEST_CASES_RESULTS_PATH = "";
	
	private void execute() {
		int passed = 0;
		int failed = 0;
		CsvUtils csv = new CsvUtils();
		List<TestCase> testCases = csv.readFileFromCSV(TEST_CASES_PATH);
		
		//execute REST API for Testing
		for(TestCase test : testCases) {
			test.setCurrentExecutionTime();
			//ServiceResponse response = new ServiceResponse();
			ServiceResponse response = CallService.apiService(test.getResource(), test.getMethod(), test.getRequestBody());

			//set response
			test.setStatusCodeResponse(response.getStatusCode());
			test.setResponse(response.getResponse());

			if(response.getStatusCode() == test.getStatusCodeExpected() && response.getResponse().equals(test.getResponse())) {
				test.setStatus("PASSED");
				passed++;
			} else {
				test.setStatus("FAILED");
				failed++;
			}	
		}
		
		try {
			csv.saveTestCases(testCases, TEST_CASES_RESULTS_PATH);//saveCsvFile(testCases, TEST_CASES_RESULTS_PATH);
		} catch (IOException e) {
			System.err.println("There was an error to try save the file for Test Cases results: " + e.getMessage());
		}
		
		System.out.println("Summary Test Cases: ");
		System.out.println("	PASSED: " + passed);
		System.out.println("	FAILED: " + failed);
		System.out.println("		TOTAL: " + (passed + failed));
		float percent = ((float)passed / (float)(passed + failed));
		System.out.println("	PERCENT (%): " + percent * 100);
	}
	
	public static void main(String [] mkd) {
		System.out.println("*** Start Test API Automation at " + new Timestamp(System.currentTimeMillis()) + " ***");
		new TestAPIMain().execute();
		System.out.println("*** End Test API Automation at " + new Timestamp(System.currentTimeMillis()) + " ***");
	}
}
