package com.ssafy.main.model.dao.user;

import java.util.List;

import com.ssafy.main.model.dto.User.User;

public interface UserDao {
//회원 가입 및 웹사이트 내 유저정보를 저장하기 위한 Dao
	// 유저 : 아이디, 비밀번호, 닉네임, 유저 접속일, 유저 인증키)

	// 회원가입 시 받은 유저의 정보를 저장한다.(입력: 유저 아이디, 비밀번호, 닉네임)
	void insertUser(User user);

	// 회원 탈퇴시 유저 정보를 제거한다.(입력 : 유저 아이디)
	void deleteUser(User user);

	// 회원 인증 시 인증키를 유저 정보에 저장한다.&& 재인증 필요시 다시 업데이트. (입력 : 유저 아이디, 유저 인증키)
	void updateKey(User user);

	// 유저의 마지막 접속일을 가져온다. (입력 : 유저 아이디, 반환 : 유저 접속일)
	// => 마지막 접속일로 부터 정보 갱신, 키 유효기간 확인
	String getDate(String userId);

	// 마지막 접속일을 바꾼다.
	void setDate(User user);

	// 유저의 닉네임을 가져온다.(입력 : 유저 아이디, 반환 : 유저 닉네임)
	String getNickName(String userId);

	// 유저 인증키를 가져온다.
	String getKey(String userId);

	// 유저의 N일을 가져온다
	int getN(String userId);

	// 유저의 전체 아이디를 가져온다.
	List<String> getIdList();

	// 유저의 이름을 변경한다.
	void updateNickName(User user);

	// 유저의 비밀번호를 변경한다.
	void updatePass(User user);

	// 유저의 비밀번호를 가져온다.
	String getPass(String userId);

	// N 하나 추가
	void cntN(User user);

	// N 초기화
	void reset(User user);
	
	// N 바꾼날짜 가져오기
	String lastNupdate(String userId);
}
