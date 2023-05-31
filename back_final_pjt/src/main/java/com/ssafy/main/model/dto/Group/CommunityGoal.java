package com.ssafy.main.model.dto.Group;

public class CommunityGoal {

	int communityNo;
	String activityType;
	String activityGoal;

	public CommunityGoal() {
	}

	public CommunityGoal(String activityType, String activityGoal) {
		this.activityType = activityType;
		this.activityGoal = activityGoal;
	}

	public CommunityGoal(int communityNo, String activityType, String activityGoal) {
		this.communityNo = communityNo;
		this.activityType = activityType;
		this.activityGoal = activityGoal;
	}

	public int getCommunityNo() {
		return communityNo;
	}

	public void setCommunityNo(int communityNo) {
		this.communityNo = communityNo;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public String getActivityGoal() {
		return activityGoal;
	}

	public void setActivityGoal(String activityGoal) {
		this.activityGoal = activityGoal;
	}

	@Override
	public String toString() {
		return "CommunityGoal [communityNo=" + communityNo + ", activityType=" + activityType + ", activityGoal="
				+ activityGoal + "]";
	}

}
