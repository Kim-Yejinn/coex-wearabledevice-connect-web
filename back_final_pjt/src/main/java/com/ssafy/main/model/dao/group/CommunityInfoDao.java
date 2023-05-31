package com.ssafy.main.model.dao.group;

import com.ssafy.main.model.dto.Group.CommunityInfo;

public interface CommunityInfoDao {
	// 그룹저장

	// 그룹의 정보를 저장한다.
	// 입력 : 그룹의 이름, 그룹 설명
	void insertCommunity(CommunityInfo communityInfo);

	// 특정 아이디가 저장된 그룹을 가져온다.
	CommunityInfo getCommunityInfo(int communityNo);

	// 그룹 삭제
	void deleteCommunityInfo(int communityNo);

	// 그룹 수정
	void modifyCommunityInfo(CommunityInfo communityInfo);

}
