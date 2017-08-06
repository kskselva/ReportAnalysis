package com.report.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.report.model.InputMessage;

import com.report.services.ReportService;
import com.report.utils.ReportUtils;

@RestController
public class SubmitController {

	
	 @PostMapping("/api/submit")
	    public ResponseEntity<?> submitResultViaAjax(@Valid @RequestBody String data) {
		 
		 
		 
		 System.out.println("Raw Data is : "+data);
		
		 
		 ReportService.generateExcel(data);
		 
		
		 //System.out.println(message);
		 
		  return ResponseEntity.ok(data);
	      
	 }
	 
	 @GetMapping("/gen")
	    public ResponseEntity<?> index() {
		// InputMessage  message = ReportUtils.getObjectFromJson();

		// System.out.println(message);
		 
		 
		return ResponseEntity.ok("test");
	    }
	    
	 @GetMapping("/excel")
	    public void downloadPDFResource( HttpServletRequest request, 
	                                     HttpServletResponse response
	                                     ) 
	    {
	        //If user is not authorized - he should be thrown out from here itself
	         
	        //Authorized user will download the file
		 
		 System.out.println("test");
		 
		String fileName= "Reports.xlsx";
	       
	        
	            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	            response.addHeader("Content-Disposition", "attachment; filename="+fileName);
	            try
	            {
	            	Path file = Paths.get("C:\\Users\\Thilak\\git\\ReportAnalysis\\Report.xlsx");
					Files.copy(file, response.getOutputStream());
	                response.getOutputStream().flush();
	            } 
	            catch (IOException ex) {
	                ex.printStackTrace();
	            }
	        }
	    
	 
	 
}
