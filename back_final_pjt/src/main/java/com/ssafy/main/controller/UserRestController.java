package com.ssafy.main.controller;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.ssafy.main.model.dao.user.UserDao;
import com.ssafy.main.model.dto.User.User;
import com.ssafy.main.model.dto.User.UserExercise;
import com.ssafy.main.model.dto.User.UserExerciseList;
import com.ssafy.main.model.dto.User.UserGoal;
import com.ssafy.main.model.dto.User.UserInfo;
import com.ssafy.main.model.service.user.UserService;
import com.ssafy.main.util.JwtUtil;
import com.ssafy.main.util.getFitbitUtil;

@RestController
@RequestMapping("/api")
public class UserRestController {
	@Autowired
	private JwtUtil jwtUtil;

	private static final String SUCCESS = "succes";
	private static final String FAIL = "fail";

	@Autowired
	getFitbitUtil getfitbitutil;

	@Autowired
	UserDao userdao;

	@Autowired
	UserService userService;

	// 로그인
	// in : id, pass
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(String id, String password) {
//	public ResponseEntity<?> login(String id, String pass) {

		Map<String, Object> result = new HashMap<String, Object>();
		User user = new User();
		user.setUserId(id);
		user.setUserPass(password);
		// 아이디가 null이 아니거나 길이가 있거나
		HttpStatus status = null;
		String last = userService.readLastDate(user.getUserId());
		String today = LocalDate.now().toString();
		String yesterday = LocalDate.now().minusDays(1).toString();

		User temp = new User();
		temp.setUserId(id);
//		if (!userdao.lastNupdate(id).equals(yesterday)) {
//			userdao.reset(temp);
//		}
//
//		// 현재 로그인 된 사람의 유저 정보를 갱신한다.
//		// 1. 유저 개인 정보 2. 유저 운동 요약
//		if (last.equals(today)) {
//			userService.updateWeekExercise(user.getUserId());
//			userService.updateWeekSummary(user.getUserId());
//			userService.saveUserInfo(user.getUserId());
//		} else {
//			userService.insertInit(id);
//			userService.updateWeekExercise(user.getUserId());
//			userService.updateWeekSummary(user.getUserId());
//			userService.saveUserInfo(user.getUserId());
//		}

		try {
			// if 조건 대신 login 정보가 있는지 확인.

			
			if (userService.isExist(id) && userService.userPassCheck(id, password)) {
				if (!userdao.lastNupdate(id).equals(yesterday)) {
					userdao.reset(temp);
				}

				// 현재 로그인 된 사람의 유저 정보를 갱신한다.
				// 1. 유저 개인 정보 2. 유저 운동 요약
				if (last.equals(today)) {
					userService.updateWeekExercise(user.getUserId());
					userService.updateWeekSummary(user.getUserId());
					userService.saveUserInfo(user.getUserId());
				} else {
					userService.insertInit(id);
					userService.updateWeekExercise(user.getUserId());
					userService.updateWeekSummary(user.getUserId());
					userService.saveUserInfo(user.getUserId());
				}

				
//			if (user.getUserId() != null || user.getUserId().length() > 0) {
				result.put("access-token", jwtUtil.createToken("id", user.getUserId()));
				result.put("message", SUCCESS);
				userService.setDate(id);
				// 현재 로그인 된 사람으로 key를 넣는다
				getfitbitutil = new getFitbitUtil(userdao.getKey(user.getUserId()));

				status = HttpStatus.ACCEPTED;
			} else {
				result.put("message", FAIL);
				status = HttpStatus.NO_CONTENT;
			}
		} catch (UnsupportedEncodingException e) {
			result.put("message", FAIL);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		result.put("userInfo", userService.readUserInfo(id));
//		return new ResponseEntity<UserInfo>(userService.readUserInfo(id), status);

		return new ResponseEntity<Map<String, Object>>(result, status);
	}

	// access key 인증
	// in : id, access key
	@GetMapping("/access")
	public ResponseEntity<?> setAccessKey(User user) {
		user.setLastDate("00-00-00");
		userService.saveKey(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	int[] month = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	// access key 인증 기간 확인
	// in :
	// out : T/F
	@PostMapping("/access")
	public ResponseEntity<?> check(String userId) {
		String[] day = userService.readLastDate(userId).split("-");
		String[] today = LocalDate.now().toString().split("-");

		int[] day2 = new int[3];
		int[] today2 = new int[3];

		int mon = 0;
		for (int i = 0; i < 3; i++) {
			day2[i] = Integer.parseInt(day[i]);
			today2[i] = Integer.parseInt(today[i]);
			if (i == 1) {
				mon = today2[i];
			}
		}

		for (int i = 0; i < 3; i++) {
			int a = today2[i] - day2[i];

			if (a == 0) {
				if (i == 2) {
					return new ResponseEntity<Boolean>(true, HttpStatus.OK);
				}
				continue;
			} else {
				if (i == 0) {
					today2[1] += 12 * a;
				}
				if (i == 1) {
					today2[2] += month[mon] * a;
				}
				if (i == 2) {
					if (a > 365) {
						return new ResponseEntity<Boolean>(false, HttpStatus.NO_CONTENT);
					} else {
						return new ResponseEntity<Boolean>(true, HttpStatus.OK);
					}
				}
			}
		}
		return null;

	}

	// 회원가입
	// in : id, pass, nickname
	@PutMapping("/user")
	public ResponseEntity<?> signup(User user) {
		String id = user.getUserId();
		String pass = user.getUserPass();
		user.setLastDate("00-00-00");
		userService.registUser(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	// 회원 탈퇴
	// in : userid
	@DeleteMapping("/user")
	public ResponseEntity<?> signout(User user) {
		userService.removeUser(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	// 일주일 종목별 운동 데이터
	// in : id, sport
	@GetMapping("/exercise/list")
	public ResponseEntity<?> getWeekSport(UserExerciseList userexerciselist) {
		List<UserExerciseList> list=userService.getWeekExercise(userexerciselist);
		int[] arr=new int[7];
		
		for(int i=0; i<list.size(); i++) {
			arr[i]=list.get(i).getCalories();
		}
		return new ResponseEntity<int[]>(arr, HttpStatus.OK);
	}
	
	
	@GetMapping("/exercise/todayAll")
	public ResponseEntity<?> getTodayAllSport(UserExerciseList userexerciselist) {
		UserExerciseList ans=userService.getTodayExercise(userexerciselist);
		return new ResponseEntity<UserExerciseList>(ans, HttpStatus.OK);
	}
	
	// 하루 종목별 운동 데이터
	@GetMapping("/exercise/today")
	public ResponseEntity<?> getTodaySport(UserExerciseList userexerciselist) {
		UserExerciseList ans=userService.getTodayExercise(userexerciselist);
		return new ResponseEntity<Integer>(ans.getCalories(), HttpStatus.OK);
	}

	@GetMapping("/summary")
	// 유저 요약 운동 데이터 - 하루
	// -- 목표 추가 예정
	// in : id,
	public ResponseEntity<?> getUserExercise(String userId) {
		return new ResponseEntity<UserExercise>(userService.readUserExcerise(userId), HttpStatus.OK);
	}

	// 유저 요약 일주일 데이터 - 일주일
	// -- 목표 추가 예정
	// in : id
	@GetMapping("/summary/list")
	public ResponseEntity<?> selectWeekUserInfo(UserExercise userExercise) {
		return new ResponseEntity<List<UserExercise>>(userService.getWeekUser(userExercise), HttpStatus.OK);

	}

	// 유저 개인 정보 조회
	// in : id
	@PostMapping("/user/{userId}")
	public ResponseEntity<?> selectUserInfo(@PathVariable String userId) {
		return new ResponseEntity<UserInfo>(userService.readUserInfo(userId), HttpStatus.OK);
	}

	// 유저 닉네임 가져오기
	// in : id
	@PostMapping("/user/name/{userId}")
	public ResponseEntity<?> getNickName(@PathVariable String userId) {
		return new ResponseEntity<String>(userService.readNickName(userId), HttpStatus.OK);
	}

	// 마지막 유저 접속일
	// in : id
	@PostMapping("/user/date/{userId}")
	public ResponseEntity<String> getLastDate(@PathVariable String userId) {
		return new ResponseEntity<String>(userService.readLastDate(userId), HttpStatus.OK);
	}

	// -- 유저의 N일 추가 예정
	// in : id
	@GetMapping("/user/Ndate/{userId}")
	public ResponseEntity<?> getUserNExercise(@PathVariable String userId) {

		return new ResponseEntity<Integer>(userService.getNUser(userId), HttpStatus.OK);
	}

	// -- 유저 아이디 중복 여부 확인하기
	@GetMapping("/user/exist/{userId}")
	public ResponseEntity<?> isExistUser(@PathVariable String userId) {
		return new ResponseEntity<Boolean>(userService.isExist(userId), HttpStatus.OK);
	}

	// -- 유저 닉네임 변경
	@PutMapping("/user/name/{userId}")
	public ResponseEntity<?> reNameUser(@PathVariable String userId, String userNickName) {
		userService.reName(userId, userNickName);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// -- 유저 비밀번호 변경
	@PutMapping("/user/pass/{userId}")
	public ResponseEntity<?> rePassUser(@PathVariable String userId, String userPass) {
		userService.rePass(userId, userPass);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// -- 달성 % 계산 추가 -->
	@GetMapping("/user/percent/{userId}")
	public ResponseEntity<?> getWeekPercent(@PathVariable String userId) {
		UserExercise userExercise = new UserExercise();
		userExercise.setUserId(userId);
		List<UserExercise> list = userService.getWeekUser(userExercise);
		List<Integer> ans = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			ans.add(list.get(i).getCaloriesOut() * 100 / userService.getUserGoalToday(userId, "Walk"));
		}
		return new ResponseEntity<List<Integer>>(ans, HttpStatus.OK);
	}

	// 개인 목표....
	@GetMapping("/user/goalToday")
	public ResponseEntity<?> getUserGoalToday(UserGoal userGoal) {

		return new ResponseEntity<Integer>(userService.getUserGoalToday(userGoal.getUserId(), userGoal.getActivityType()), HttpStatus.OK);
	}

	@GetMapping("/user/goalWeek/{userId}")
	public ResponseEntity<?> getUserGoalWeek(@PathVariable String userId, String Sport) {
		return new ResponseEntity<List<Integer>>(userService.getUserGoalWeek(userId, Sport), HttpStatus.OK);
	}

	// 개인 목표 수정
	@GetMapping("/user/goal")
	public ResponseEntity<?> modifyUserGoal(UserGoal userGoal) {
		userService.updateGoal(userGoal.getUserId(), userGoal.getActivityType(), userGoal.getActivityGoal());
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// 개인 목표 넣기
	@PutMapping("/user/goal/{userId}")
	public ResponseEntity<?> putUserGoal(@PathVariable String userId, String Sport, int Goal) {
		userService.insertGoal(userId, Sport, Goal);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// N일차 카운트...
	// 목표 이상이면 N이 증가되도록 한다.
	@GetMapping("/user/goal/cnt")
	public ResponseEntity<?> cntNDate(UserGoal userGoal) {
		userService.updateNDate(userGoal.getUserId(), userGoal.getActivityType());
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
