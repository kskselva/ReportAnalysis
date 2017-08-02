package com.report.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.report.model.AjaxResponseBody;
import com.report.model.SearchCriteria;
import com.report.model.User;

@RestController
public class SubmitController {

	
	 @PostMapping("/api/submit")
	    public ResponseEntity<?> submitResultViaAjax(@Valid @RequestBody String data) {
		 
		 AjaxResponseBody result = new AjaxResponseBody();
		 
		 System.out.println("Data is : "+data);

		  return ResponseEntity.ok(result);
	      
	 }
}
