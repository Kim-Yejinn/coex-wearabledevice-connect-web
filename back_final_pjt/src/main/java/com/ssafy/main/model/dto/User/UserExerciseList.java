package com.ssafy.main.model.dto.User;

import java.time.LocalDate;

public class UserExerciseList {
	String userId;
	String saveDate = LocalDate.now().toString();
	String activityParentName;
	int calories;
	double distance;
	int duration;

	
	
	public UserExerciseList() {
	}

	public UserExerciseList(String userId, String activityParentName) {
		this.userId = userId;
		this.activityParentName = activityParentName;
	}

	public UserExerciseList(String userId, String saveDate, String activityParentName) {
		this.userId = userId;
		this.saveDate = saveDate;
		this.activityParentName = activityParentName;
	}

	public UserExerciseList(String activityParentName, int calories, double distance, int duration) {
		this.activityParentName = activityParentName;
		this.calories = calories;
		this.distance = distance;
		this.duration = duration;
		
		
	}
	
	

	public UserExerciseList(String saveDate, String activityParentName, int calories, double distance, int duration) {
		super();
		this.saveDate = saveDate;
		this.activityParentName = activityParentName;
		this.calories = calories;
		this.distance = distance;
		this.duration = duration;
	}

	public UserExerciseList(String userId, String saveDate, String activityParentName, int calories, double distance,
			int duration) {
		this.userId = userId;
		this.saveDate = saveDate;
		this.activityParentName = activityParentName;
		this.calories = calories;
		this.distance = distance;
		this.duration = duration;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSaveDate() {
		return saveDate;
	}

	public void setSaveDate(String saveDate) {
		this.saveDate = saveDate;
	}

	public String getActivityParentName() {
		return activityParentName;
	}

	public void setActivityParentName(String activityParentName) {
		this.activityParentName = activityParentName;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "UserExerciseList [userId=" + userId + ", saveDate=" + saveDate + ", activityParentName="
				+ activityParentName + ", calories=" + calories + ", distance=" + distance + ", duration=" + duration
				+ "]";
	}

}
