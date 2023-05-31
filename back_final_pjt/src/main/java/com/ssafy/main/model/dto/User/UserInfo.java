package com.ssafy.main.model.dto.User;

public class UserInfo {

	String userId;
	String name;
	int age;
	String gender;
	double height;
	double weight;

	public UserInfo() {

	}

	public UserInfo(String userId, String name, int age, String gender, double height, double weight) {
		this.userId = userId;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
	}

	public UserInfo(String name, int age, String gender, double height, double weight) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", name=" + name + ", age=" + age + ", gender=" + gender + ", height="
				+ height + ", weight=" + weight + "]";
	}

}
