package com.ssafy.main.model.dto.User;

import java.time.LocalDate;

public class UserGoal {
	String userId;
	String activityType;
	int activityGoal;
	String saveDate;

	public UserGoal() {
		this.saveDate = LocalDate.now().toString();
	}

	public UserGoal(String userId, String activityType) {
		super();
		this.userId = userId;
		this.activityType = activityType;
		this.saveDate = LocalDate.now().toString();

	}

	public UserGoal(String userId, String activityType, int activityGoal) {
		this.userId = userId;
		this.activityType = activityType;
		this.activityGoal = activityGoal;
		this.saveDate = LocalDate.now().toString();
	}

	public UserGoal(String userId, String activityType, int activityGoal, String saveDate) {
		super();
		this.userId = userId;
		this.activityType = activityType;
		this.activityGoal = activityGoal;
		this.saveDate = saveDate;
	}

	public String getSaveDate() {
		return saveDate;
	}

	public void setSaveDate(String saveDate) {
		this.saveDate = saveDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public int getActivityGoal() {
		return activityGoal;
	}

	public void setActivityGoal(int activityGoal) {
		this.activityGoal = activityGoal;
	}

	@Override
	public String toString() {
		return "UserGoal [userId=" + userId + ", activityType=" + activityType + ", activityGoal=" + activityGoal + "]";
	}

}
