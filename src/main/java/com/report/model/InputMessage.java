package com.report.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public class InputMessage implements Serializable{

	 @JsonProperty
	String team;
	 
	 
	 @JsonProperty
	Date date;
	
	/* @JsonProperty("category") private JsonNode data;
	 */
	 @JsonProperty("category")
	Category category;
	

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
	


	
	
	
}
