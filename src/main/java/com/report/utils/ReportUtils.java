package com.report.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.report.model.InputMessage;

public class ReportUtils {

	
	public static boolean saveJsonToFile(String obj)  {
	
	try (FileWriter file = new FileWriter("temp/report1.json")) {
		file.write(obj);
		System.out.println("Successfully Copied JSON Object to File...");
		System.out.println("\nJSON Object: " + obj);
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return true;
	}
	
	  public static InputMessage getObjectFromJson(String data) {
	         
	        ObjectMapper mapper = new ObjectMapper();
	 
	        /**
	         * Read object from file
	         */
	        InputMessage value = null;
	        try {
	            value = mapper.readValue(data, InputMessage.class);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }   
	         
	        System.out.println(value);
			return value;
	         
	    }
	
}
