package com.ssafy.main.model.dao.group;

import java.util.List;

import com.ssafy.main.model.dto.Group.CommunityGoal;

public interface CommunityGoalDao {
// 그룹의 목표를 정해서 넣는 Dao

	// 그룹 목표를 추가한다.
	// 입력 : 그룹 번호, 종목, 목표량
	void insertGoal(CommunityGoal communityGoal);

	// 그룹의 목표를 가져온다
	// 입력 : 그룹 번호 // 반환: 종목, 목표량
	List<CommunityGoal> getGoal(int communityNo);

	// 그룹 목표 삭제
	void deleteGoal(CommunityGoal communityGoal);

	// 그룹 목표 수정
	void modifyGoal(CommunityGoal communityGoal);
}
