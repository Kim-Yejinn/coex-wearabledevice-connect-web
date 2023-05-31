package com.ssafy.main.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ssafy.main.model.dto.User.UserExercise;
import com.ssafy.main.model.dto.User.UserExerciseList;
import com.ssafy.main.model.dto.User.UserInfo;

@Component
public class getFitbitUtil {

	// Fitbit API 이용 및 데이터 가져오기
	RestTemplate restTemplate;
	String accessToken;

	public getFitbitUtil() {
	}

	public getFitbitUtil(String accessToken) {
		this.restTemplate = new RestTemplate();
		this.accessToken = accessToken;
	}

	// 해당 날짜의 모든 운동 데이터 가져옴.
	// 날짜 형식은 yyyy-MM-DD

	// activityParentName : 운동 별 이름
	// Run : 90009 , Bike : 90001, Hike : 90012 , Tennis : 15675,
	// Walk : 90013, Swim : 90024, Golf : 15255

	// calories : 해당 운동의 소모 칼로리
	// distance : 운동한 거리
	// duration : 운동 시간

	public List<UserExerciseList> getActivity(String date) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + accessToken);
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

		ResponseEntity<Map> response = restTemplate.exchange(
				"https://api.fitbit.com/1/user/-/activities/date/" + date + ".json", HttpMethod.GET, entity, Map.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			Map<String, Object> responseBody = response.getBody();
			if (responseBody != null) {
				List<Map<String, Object>> activity = (List<Map<String, Object>>) responseBody.get("activities");
				List<UserExerciseList> list = new ArrayList<UserExerciseList>();
				if (activity != null) {

					Map<String, UserExerciseList> m = new HashMap<String, UserExerciseList>();
					for (int i = 0; i < activity.size(); i++) {
						String activityParentName = (String) activity.get(i).get("activityParentName");
						int calories = (int) activity.get(i).get("calories");
						double distance = Double.parseDouble(activity.get(i).get("distance").toString());
						int duration = (int) activity.get(i).get("duration");
						duration/=1000;

						UserExerciseList userexerciselist = new UserExerciseList(date, activityParentName, calories,
								distance, duration);

						if (m.containsKey(activityParentName)) {
							userexerciselist.setCalories(
									m.get(activityParentName).getCalories() + userexerciselist.getCalories());
							userexerciselist.setDistance(
									m.get(activityParentName).getDistance() + userexerciselist.getDistance());
							userexerciselist.setDuration(
									m.get(activityParentName).getDuration() + userexerciselist.getDuration());
							m.replace(activityParentName, userexerciselist);
						} else {
							m.put(activityParentName, userexerciselist);

						}

					}

					for (String entry : m.keySet()) {

						list.add(m.get(entry));
					}

					return list;
				}
			}
		} else {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatusCode());
		}
		return null;
	}

	// 해당 날짜 정리된 정보 가져옴.
	// caloriesOut - 전체 소모 칼로리
	// activityCalories - 활동 소모 칼로리
	// steps : 걸음수

	public UserExercise getSummary(String date) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + accessToken);

		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

		ResponseEntity<Map> response = restTemplate.exchange(
				"https://api.fitbit.com/1/user/-/activities/date/" + date + ".json", HttpMethod.GET, entity, Map.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			Map<String, Object> responseBody = response.getBody();
			if (responseBody != null) {
				Map<String, Object> summary = (Map<String, Object>) responseBody.get("summary");

				int caloriesOut = (int) summary.get("caloriesOut");
				int activityCalories = (int) summary.get("activityCalories");
				int step = (int) summary.get("steps");

				UserExercise userexercise = new UserExercise(caloriesOut, activityCalories, step);
				return userexercise;
			}
		} else {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatusCode());
		}
		return null;
	}

	// 유저의 프로필을 가져옴.
	// fullName : 이름
	// age : 나이
	// gender : 성별
	// height : 키
	// weight : 몸무게

	public UserInfo getUserProfile() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + accessToken);
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		ResponseEntity<Map> response = restTemplate.exchange("https://api.fitbit.com/1/user/-/profile.json",
				HttpMethod.GET, entity, Map.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			Map<String, Object> responseBody = response.getBody();
			if (responseBody != null) {
				Map<String, Object> user = (Map<String, Object>) responseBody.get("user");

				if (user != null) {

					String name = (String) user.get("displayName");
					int age = (int) user.get("age");
					String gender = (String) user.get("gender");
					double height = (double) user.get("height");
					double weight = (double) user.get("weight");
					UserInfo userinfo = new UserInfo(name, age, gender, height, weight);
					return userinfo;
				}
			}
		} else {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatusCode());
		}
		return null;
	}
}
