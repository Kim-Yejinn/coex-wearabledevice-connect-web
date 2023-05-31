package com.ssafy.main.model.dao.group;

import java.util.List;

import com.ssafy.main.model.dto.Group.CommunityList;

public interface CommunityListDao {
	// 유저와 그룹을 이어줄 dao

	// 모든 리스트를 가져온다.
	// 반환 : 그롭 아이디 리스트.
	List<Integer> getCommunityId(String userId);

	List<String> getUserId(int communityNo);
	// 유저와 그룹을 매칭 시킨다.
	// 입력 : 유저 아이디/그룹 아이디.

	void insertCommunityList(CommunityList communityList);

	// 그룹 삭제
	void deleteCommunityList(int communityNo);
}
