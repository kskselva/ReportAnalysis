package com.report.model;

import java.io.Serializable;

public class Activity implements Serializable {

	String activityName;
	
	String activityBy;

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getActivityBy() {
		return activityBy;
	}

	public void setActivityBy(String activityBy) {
		this.activityBy = activityBy;
	}

	
	
}
