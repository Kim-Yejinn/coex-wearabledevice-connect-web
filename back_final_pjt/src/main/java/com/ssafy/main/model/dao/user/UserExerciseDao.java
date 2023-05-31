package com.ssafy.main.model.dao.user;

import com.ssafy.main.model.dto.User.UserExercise;

public interface UserExerciseDao {

	// 로그인 시 유저의 운동 요약을 Fitbit에서 가져와서 저장한다.
	// 유저의 마지막 접속일로 부터의 정보를 갱신
	// 입력 : 유저아이디, 날짜, 전체 소모 칼로리, 활동 소모 칼로리, 총걸음수
	void insertSummary(UserExercise userexercise);

	//유저의 운동 요약 정보를 갱신한다.
	void updateSummary(UserExercise userexercise);
	
	// 유저의 운동 요약 정보를 가져온다.
	// 입력 : 유저아이디, 날짜 / 반환: 전체소모 칼로리, 활동 소모 칼로리, 총 걸음수
	UserExercise getUserExercise(String userId);
	

	// 유저의 일주일 정보를 가져온다. - 해당 날짜의 유저 정보를 가져온다.
	UserExercise getConditionUser(UserExercise condition);
}
