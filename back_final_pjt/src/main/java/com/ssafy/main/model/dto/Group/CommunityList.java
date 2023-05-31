package com.ssafy.main.model.dto.Group;

public class CommunityList {
	int communityNo;
	String userId;

	public CommunityList(int communityNo, String userId) {
		this.communityNo = communityNo;
		this.userId = userId;
	}

	public int getCommunityNo() {
		return communityNo;
	}

	public void setCommunityNo(int communityNo) {
		this.communityNo = communityNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "CommunityList [communityNo=" + communityNo + ", userId=" + userId + "]";
	}

}
