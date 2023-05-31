package com.ssafy.main.model.dto.User;

import java.time.LocalDate;

public class User {
	// 회원가입시 유저의 정보를 저장하는 dto
	// 회원가입시 ID, Password, nickname을 가져온다.

	String userId;
	String userPass;
	String userNickName;
	String lastDate = LocalDate.now().toString();
	String accessKey = "";
	// -- 유저의 N일 여기 추가
	int userN = 0;
	String lastN = "0000-00-00";

	public User() {

	}

	public User(String userId, String accessKey) {
		this.userId = userId;
		this.accessKey = accessKey;
	}

	public User(String userId, String userPass, String userNickName) {
		this.userId = userId;
		this.userPass = userPass;
		this.userNickName = userNickName;
	}

	public String getLastDate() {
		return lastDate;
	}

	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public int getUserN() {
		return userN;
	}

	public void setUserN(int userN) {
		this.userN = userN;
	}

	public String getLastN() {
		return lastN;
	}

	public void setLastN(String lastN) {
		this.lastN = lastN;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userPass=" + userPass + ", userNickName=" + userNickName + ", lastDate="
				+ lastDate + ", accessKey=" + accessKey + "]";
	}

}
