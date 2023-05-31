package com.ssafy.main.model.dao.user;

import com.ssafy.main.model.dto.User.UserExerciseList;

public interface UserExerciseListDao {
	// 유저의 운동 리스트를 모두 넣는다.
	void insertUserExerciseList(UserExerciseList userExerciseList);

	// 유저의 운동 리스트를 업데이트 한다.
	void updateUserExerciseList(UserExerciseList userExerciseList);
	// 유저의 날짜, 종목에 맞는 운동 정보 가져오기
	UserExerciseList getConditionExercise(UserExerciseList condition);

}
