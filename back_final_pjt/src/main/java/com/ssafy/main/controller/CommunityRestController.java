package com.ssafy.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.main.model.dto.Group.CommunityGoal;
import com.ssafy.main.model.dto.Group.CommunityInfo;
import com.ssafy.main.model.dto.Group.CommunityList;
import com.ssafy.main.model.service.group.CommunityService;

@RestController
@RequestMapping("/api")
public class CommunityRestController {

	@Autowired
	CommunityService communityService;

	// 그룹 생성
	@PutMapping("/community/{userId}")
	public ResponseEntity<?> createCommunity(CommunityInfo communityInfo, @PathVariable String userId) {
		communityService.registCommunity(communityInfo, userId);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	// 그룹에 사람 추가
	@PutMapping("/community/user")
	public ResponseEntity<?> addCommunityPerson(CommunityList communityList) {
		communityService.insertCommunityList(communityList);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	// 사람에 해당하는 그룹 조회
	@PostMapping("/community/{userId}")
	public ResponseEntity<?> selectCommunity(@PathVariable String userId) {
		return new ResponseEntity<List<Integer>>(communityService.readCommunityId(userId), HttpStatus.OK);
	}

	// 그룹 해당 사람 조회
	@GetMapping("/community/{communityNo}")
	public ResponseEntity<?> selectUser(@PathVariable int communityNo) {
		return new ResponseEntity<List<String>>(communityService.readUserId(communityNo), HttpStatus.OK);
	}

	// 그룹 목표 추가
	@PutMapping("/goal/create")
	public ResponseEntity<?> addCommunityGoal(CommunityGoal communityGoal) {
		communityService.saveGoal(communityGoal);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	// 그룹 목표 수정하기
	@PutMapping("/goal/update")
	public ResponseEntity<?> modifyCommunityGoal(CommunityGoal communityGoal) {
		communityService.changeGoal(communityGoal);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// 그룹 목표 삭제하기
	@DeleteMapping("/goal")
	public ResponseEntity<?> deleteCommunityGoal(CommunityGoal communityGoal) {
		communityService.removeGoal(communityGoal);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// 그룹 목표 가져오기 (리스트)
	@GetMapping("/goal/{communityNo}")
	public ResponseEntity<?> selectAllCommunityGoal(@PathVariable int communityNo) {
		return new ResponseEntity<List<CommunityGoal>>(communityService.readGoal(communityNo), HttpStatus.OK);
	}

	// 그룹 정보 가져오기
	@GetMapping("/goal/list/{communityNo}")
	public ResponseEntity<?> selectGroupInfo(@PathVariable int communityNo) {
		return new ResponseEntity<CommunityInfo>(communityService.readCommunityInfo(communityNo), HttpStatus.OK);
	}
	
	//-- 그룹 사람들의 특정 운동 정보 수집
	// 입력은 communityNo와 운동 종류
	
	
	
}
