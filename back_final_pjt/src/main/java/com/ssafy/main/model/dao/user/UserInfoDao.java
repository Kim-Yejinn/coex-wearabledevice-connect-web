package com.ssafy.main.model.dao.user;

import com.ssafy.main.model.dto.User.UserInfo;

public interface UserInfoDao {
	// 저장된 유저의 정보를 가져오기 위한 Dao

	// 로그인시 업데이트 된 유저의 정보를 저장한다 - update
	// fitbit에서 가져와 db에 저장
	// 입력 : 유저 아이디, 유저 실명, 나이, 성별, 키, 몸무게
	void updateUserInfo(UserInfo userInfo);

	void insertUserInfo(UserInfo userInfo);

	// 유저의 정보를 가져온다.
	// 입력 : 유저 아이디, 반환 : 유저 실명, 나이, 성별, 키, 몸무게
	UserInfo getUserInfo(String userId);

}
