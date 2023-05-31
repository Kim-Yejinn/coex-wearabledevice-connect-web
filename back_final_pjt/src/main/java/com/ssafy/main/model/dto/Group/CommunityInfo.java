package com.ssafy.main.model.dto.Group;

public class CommunityInfo {
	int communityNo;
	String communityName;
	String communityText;
	String communityKing;
	String img;
	
	public CommunityInfo() {

	}

	public CommunityInfo(int communityNo, String communityName, String communityText) {
		this.communityNo = communityNo;
		this.communityName = communityName;
		this.communityText = communityText;
	}

	public CommunityInfo(int communityNo, String communityName, String communityText, String communityKing,
			String img) {
		this.communityNo = communityNo;
		this.communityName = communityName;
		this.communityText = communityText;
		this.communityKing = communityKing;
		this.img = img;
	}

	public int getCommunityNo() {
		return communityNo;
	}

	public void setCommunityNo(int communityNo) {
		this.communityNo = communityNo;
	}

	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

	public String getCommunityText() {
		return communityText;
	}

	public void setCommunityText(String communityText) {
		this.communityText = communityText;
	}

	public String getCommunityKing() {
		return communityKing;
	}

	public void setCommunityKing(String communityKing) {
		this.communityKing = communityKing;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "CommunityInfo [communityNo=" + communityNo + ", communityName=" + communityName + ", communityText="
				+ communityText + ", communityKing=" + communityKing + ", img=" + img + "]";
	}

}
