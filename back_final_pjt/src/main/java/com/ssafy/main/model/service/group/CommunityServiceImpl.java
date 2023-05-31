package com.ssafy.main.model.service.group;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.main.model.dao.group.CommunityGoalDao;
import com.ssafy.main.model.dao.group.CommunityInfoDao;
import com.ssafy.main.model.dao.group.CommunityListDao;
import com.ssafy.main.model.dto.Group.CommunityGoal;
import com.ssafy.main.model.dto.Group.CommunityInfo;
import com.ssafy.main.model.dto.Group.CommunityList;

@Service
public class CommunityServiceImpl implements CommunityService {

	@Autowired
	CommunityGoalDao communitygoaldao;

	@Autowired
	CommunityInfoDao communityinfodao;

	@Autowired
	CommunityListDao communitylistdao;

	@Override
	public void registCommunity(CommunityInfo communityInfo, String userId) {
		// TODO Auto-generated method stub
		communityinfodao.insertCommunity(communityInfo);
		CommunityList groupList = new CommunityList(communityInfo.getCommunityNo(), userId);
		communitylistdao.insertCommunityList(groupList);

	}

	@Override
	public void insertCommunityList(CommunityList communityList) {
		// TODO Auto-generated method stub
		communitylistdao.insertCommunityList(communityList);

	}

	@Override
	public CommunityInfo readCommunityInfo(int communityNo) {
		// TODO Auto-generated method stub
		return communityinfodao.getCommunityInfo(communityNo);
	}

	@Override
	public List<Integer> readCommunityId(String userId) {
		// TODO Auto-generated method stub
		return communitylistdao.getCommunityId(userId);
	}

	@Override
	public List<String> readUserId(int communityId) {
		// TODO Auto-generated method stub
		return communitylistdao.getUserId(communityId);

	}

	@Override
	public void saveGoal(CommunityGoal communityGoal) {
		// TODO Auto-generated method stub
		communitygoaldao.insertGoal(communityGoal);
	}

	@Override
	public List<CommunityGoal> readGoal(int communityNo) {
		// TODO Auto-generated method stub
		return communitygoaldao.getGoal(communityNo);
	}

	@Override
	public void removeCommunityList(int communityNo) {
		// TODO Auto-generated method stub
		communitylistdao.deleteCommunityList(communityNo);
		communityinfodao.deleteCommunityInfo(communityNo);
	}

	@Override
	public void changeCommunity(CommunityInfo communityInfo) {
		// TODO Auto-generated method stub
		communityinfodao.modifyCommunityInfo(communityInfo);
	}

	@Override
	public void removeGoal(CommunityGoal communityGoal) {
		// TODO Auto-generated method stub
		communitygoaldao.deleteGoal(communityGoal);

	}

	@Override
	public void changeGoal(CommunityGoal communityGoal) {
		// TODO Auto-generated method stub
		communitygoaldao.modifyGoal(communityGoal);
	}

}
