package com.ssafy.main.model.service.group;

import java.util.List;

import com.ssafy.main.model.dto.Group.CommunityGoal;
import com.ssafy.main.model.dto.Group.CommunityInfo;
import com.ssafy.main.model.dto.Group.CommunityList;

public interface CommunityService {

	// 그룹 등록 관련

	// 그룹 등록
	void registCommunity(CommunityInfo communityInfo, String userId);

	// 그룹 등록 및 그룹에 사람 추가
	void insertCommunityList(CommunityList communityList);

	// 그룹 정보 불러옴
	CommunityInfo readCommunityInfo(int communityNo);

	// 그룹 삭제
	// groupinfo, grouplist 모두 삭제
	void removeCommunityList(int communityId);

	// 그룹 정보 수정
	void changeCommunity(CommunityInfo communityInfo);

	// 유저 그룹 불러옴
	List<Integer> readCommunityId(String userId);

	// 그룹에 해당하는 아이디 불러옴
	List<String> readUserId(int communityId);

	// 그룹 목표 설정 관련

	// 그룹 목표를 추가한다.
	void saveGoal(CommunityGoal communityGoal);

	// 그룹의 목표를 가져온다
	List<CommunityGoal> readGoal(int communityNo);

	// 그룹 목표 삭제한다.
	void removeGoal(CommunityGoal communityGoal);

	// 그룹 목표 수정한다.
	void changeGoal(CommunityGoal communityGoal);
}
