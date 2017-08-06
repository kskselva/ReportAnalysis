package com.report.model;

import java.io.Serializable;

public class CustomerEngagement implements Serializable {
	
	String customer;
	String ownedBy;
	String bidOwner;
	String itis;
	String geo;
	String industry;
	String ISUOwner;
	String action;
	
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getOwnedBy() {
		return ownedBy;
	}
	public void setOwnedBy(String ownedBy) {
		this.ownedBy = ownedBy;
	}
	public String getBidOwner() {
		return bidOwner;
	}
	public void setBidOwner(String bidOwner) {
		this.bidOwner = bidOwner;
	}
	public String getITIS() {
		return itis;
	}
	public void setITIS(String itis) {
		this.itis = itis;
	}
	public String getGeo() {
		return geo;
	}
	public void setGeo(String geo) {
		this.geo = geo;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getISUOwner() {
		return ISUOwner;
	}
	public void setISUOwner(String iSUOwner) {
		ISUOwner = iSUOwner;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	


}
