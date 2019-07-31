package com.mkd.test.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.mkd.test.model.TestCase;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class CsvUtils {
	
	private String convertListToString(List<TestCase> testCases) {
		String output = TestCase.getHeader() + "\n";
		
		for(TestCase testCase : testCases) {
			testCase.setCurrentExecutionTime();
			output += testCase.retrieveRecord() + "\n";
		}
		
		return output;
	}
	
	public void saveTestCases(List<TestCase> testCases, String path) throws IOException {
		
		String fileContent = convertListToString(testCases);
	     
	    FileWriter fileWriter = new FileWriter(path);
			
		BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
		bufferWriter.write(fileContent);
		bufferWriter.close();
	}
	
	public List<TestCase> readFileFromCSV(String path) {
		List<TestCase> testCases = null;

		try (
	            Reader reader = Files.newBufferedReader(Paths.get(path));
	            CSVReader csvReader =new CSVReaderBuilder(reader).withSkipLines(1).build();
	        ) {
	            // Reading Records One by One in a String array
	            String[] nextRecord;
	            testCases = new ArrayList<>();
	            while ((nextRecord = csvReader.readNext()) != null) {
	            	TestCase testCase = new TestCase();
	            	testCase.setTestCaseId(nextRecord[0]);
	                testCase.setTitle(nextRecord[1]);
	                testCase.setResource(nextRecord[2]);
	                testCase.setMethod(nextRecord[3]);
	                testCase.setStatus(nextRecord[4]);
	                testCase.setRequestBody(nextRecord[6]);
	                testCase.setStatusCodeExpected(Integer.valueOf(nextRecord[7]));
	                testCase.setResponseExpected(nextRecord[8]);
	                testCases.add(testCase);
	            }
	        } catch (IOException e) {
				e.printStackTrace();
			}
		return testCases;
	}
}
