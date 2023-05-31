package com.ssafy.main.model.dto.User;

import java.time.LocalDate;

public class UserExercise {
	String userId;
	String saveDate = LocalDate.now().toString();
	int caloriesOut;
	int activityCalories;
	int step;

	public UserExercise() {

	}

	public UserExercise(int caloriesOut, int activityCalories, int step) {
		this.saveDate = LocalDate.now().toString();
		this.caloriesOut = caloriesOut;
		this.activityCalories = activityCalories;
		this.step = step;
	}

	public UserExercise(String userId, String saveDate, int caloriesOut, int activityCalories, int step) {
		this.userId = userId;
		this.saveDate = LocalDate.now().toString();
		this.caloriesOut = caloriesOut;
		this.activityCalories = activityCalories;
		this.step = step;
	}

	public String getUserNo() {
		return userId;
	}

	public void serUserId(String userId) {
		this.userId = userId;
	}

	public int getCaloriesOut() {
		return caloriesOut;
	}

	public void setCaloriesOut(int colariesOut) {
		this.caloriesOut = colariesOut;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
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

	public int getActivityCalories() {
		return activityCalories;
	}

	public void setActivityCalories(int activityCalories) {
		this.activityCalories = activityCalories;
	}

	@Override
	public String toString() {
		return "UserExercise [userId=" + userId + ", saveDate=" + saveDate + ", caloriesOut=" + caloriesOut
				+ ", activityCalories=" + activityCalories + ", step=" + step + "]";
	}

}
