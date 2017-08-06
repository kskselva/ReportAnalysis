package com.report.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Category implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9202363288445599018L;
	
	

	

	
	List customerVisit;
	
	
	List highlights;
	
	
	List solutionSupport;
	
	List proactiveEngagement;
	
	List deliverySupport;
	
	List labActivities;
	
	List poC;
	
	
	
	List internalActivities;
	
	List certification;
	
	List trainingConducted;
	
	List trainingAttended;
	
	List OEMMeet;
	
	List partnership;

	public List getCustomerVisit() {
		return customerVisit;
	}

	public void setCustomerVisit(List customerVisit) {
		this.customerVisit = customerVisit;
	}

	public List getHighlights() {
		
		System.out.println(highlights);
		return highlights;
	}

	public void setHighlights(List highlights) {
		this.highlights = highlights;
	}

	public List<CustomerEngagement> getSolutionSupport() {
		return solutionSupport;
	}

	public void setSolutionSupport(List<CustomerEngagement> solutionSupport) {
		this.solutionSupport = solutionSupport;
	}

	public List<CustomerEngagement> getProactiveEngagement() {
		return proactiveEngagement;
	}

	public void setProactiveEngagement(List<CustomerEngagement> proactiveEngagement) {
		this.proactiveEngagement = proactiveEngagement;
	}

	public List<CustomerEngagement> getDeliverySupport() {
		return deliverySupport;
	}

	public void setDeliverySupport(List<CustomerEngagement> deliverySupport) {
		this.deliverySupport = deliverySupport;
	}

	public List getLabActivities() {
		return labActivities;
	}

	public void setLabActivities(List labActivities) {
		this.labActivities = labActivities;
	}

	public List getPoC() {
		return poC;
	}

	public void setPoC(List poC) {
		this.poC = poC;
	}

	public List getInternalActivities() {
		return internalActivities;
	}

	public void setInternalActivities(List internalActivities) {
		this.internalActivities = internalActivities;
	}

	public List getCertification() {
		return certification;
	}

	public void setCertification(List certification) {
		this.certification = certification;
	}

	public List getTrainingConducted() {
		return trainingConducted;
	}

	public void setTrainingConducted(List trainingConducted) {
		this.trainingConducted = trainingConducted;
	}

	public List getTrainingAttended() {
		return trainingAttended;
	}

	public void setTrainingAttended(List trainingAttended) {
		this.trainingAttended = trainingAttended;
	}

	public List getOEMMeet() {
		return OEMMeet;
	}

	public void setOEMMeet(List oEMMeet) {
		OEMMeet = oEMMeet;
	}

	public List getPartnership() {
		return partnership;
	}

	public void setPartnership(List partnership) {
		this.partnership = partnership;
	}
	
	
	
	

}
