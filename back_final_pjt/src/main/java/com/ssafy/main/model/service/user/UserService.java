package com.ssafy.main.model.service.user;

import java.util.List;

import com.ssafy.main.model.dto.User.User;
import com.ssafy.main.model.dto.User.UserExercise;
import com.ssafy.main.model.dto.User.UserExerciseList;
import com.ssafy.main.model.dto.User.UserInfo;

public interface UserService {

	// 회원가입 관련

	// 회원가입시 받은 유저 저장
	void registUser(User user);

	// 탈퇴시 제거
	void removeUser(User user);

	// 인증키 정보 저장
	void saveKey(User user);

	// 마지막 접속일 가져옴
	String readLastDate(String userId);
	
	// 마지막 접속일 변경
	void setDate(String userId);

	// 유저 닉네임 가져옴
	String readNickName(String userId);

	// 개인 운동 요약 관련
	// 유저의 운동 요약을 가져와 저장
	void registUserExercise(String date, String userId);

	// 유저의 운동 요약을 갱신
	void updateUserExercise(String date, String userId);

	// 로그인 시 유저의 운동 요약을 Fitbit에서 가져와서 저장한다.
	void registSummary(String userId);

	// 로그인 시 유저의 운동 요약을 Fitbit에서 가져와서 업데이트 한다.
	void updateSummary(String userId);

	// 유저의 운동 요약 정보를 가져온다.
	UserExercise readUserExcerise(String userId);

	// 개인 정보 관련
	void saveUserInfo(String userId);

	// 유저의 정보를 가져온다.
	UserInfo readUserInfo(String userId);

	//하루 운동 정보 가져오기
	UserExerciseList getTodayExercise(UserExerciseList condition);
	
	// 일주일 운동 정보 가져오기
	List<UserExerciseList> getWeekExercise(UserExerciseList condition);
              
	// 일주일 유저 운동 요약 가져오기
	// userId, 운동이름
	List<UserExercise> getWeekUser(UserExercise condition);

	// fitbit 연결 계정 변경하기
	void fitbitUser(String userId);

	// 해당 유저 정보 갱신하기(일주일)
	void updateCommunityUser(String userId, String date);

	// -- 4명의 운동 정보 가져오기
	// --- 해당하는 4명의 정보 갱신하기
	// --- 입력 : 그룹 아이디와 운동 종류
	// --> getWeekExercise
//	List<UserExerciseList> getWeek4User(String userId, String Sport);

	// -- 유저의 n일차 가져오기
	int getNUser(String userId);

	// -- 입력 받은 유저의 중복여부 확인
	boolean isExist(String userId);

	// 유저 비밀번호 맞는지 확인
	boolean userPassCheck(String userId, String userPass);

	// -- 유저 닉네임 변경
	void reName(String userId, String userNickName);

	// -- 유저 비밀번호 변경
	void rePass(String userId, String userPass);

	// 유저 목표 가져오기 -하루
	int getUserGoalToday(String userId, String Sport);

	// 유저 목표 가져오기 -일주일
	List<Integer> getUserGoalWeek(String userId, String Sport);
	
	// 유저 일주일 운동 갱신하기
	void updateWeekExercise(String userId);
	
	// 유저 일주일 요약 갱신하기
	void updateWeekSummary(String userId);
	
	// 유저 일주일 운동 넣기
	void insertWeekExercise(String userId);
	
	// 유저 일주일 요약 넣기
	void insertWeekSummary(String userId);
	
	// 일주일치 그냥 0으로 넣어두기
	void insertInit(String userId);
	
	// 유저 목표 넣기
	void insertGoal(String userId, String Sport, int Goal);
	
	// 유저 목표 수정하기
	void updateGoal(String userId, String Sport, int Goal);
	
	// N일차 추가하기
	void updateNDate(String userId, String Sport);
}
