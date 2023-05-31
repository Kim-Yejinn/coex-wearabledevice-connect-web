package com.ssafy.main.model.service.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.main.model.dao.user.UserDao;
import com.ssafy.main.model.dao.user.UserExerciseDao;
import com.ssafy.main.model.dao.user.UserExerciseListDao;
import com.ssafy.main.model.dao.user.UserGoalDao;
import com.ssafy.main.model.dao.user.UserInfoDao;
import com.ssafy.main.model.dto.User.User;
import com.ssafy.main.model.dto.User.UserExercise;
import com.ssafy.main.model.dto.User.UserExerciseList;
import com.ssafy.main.model.dto.User.UserGoal;
import com.ssafy.main.model.dto.User.UserInfo;
import com.ssafy.main.util.getFitbitUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userdao;

	@Autowired
	UserExerciseDao userexercisedao;

	@Autowired
	UserExerciseListDao userexerciselistdao;

	@Autowired
	UserInfoDao userinfodao;

	@Autowired
	UserGoalDao usergoaldao;

	getFitbitUtil getfitbitutil;

	@Override
	public void registUser(User user) {
		// TODO Auto-generated method stub
		userdao.insertUser(user);
	}

	@Override
	public void removeUser(User user) {
		// TODO Auto-generated method stub
		userdao.deleteUser(user);
	}

	@Override
	public void saveKey(User user) {
		// TODO Auto-generated method stub
		userdao.updateKey(user);
	}

	@Override
	public String readLastDate(String userId) {
		// TODO Auto-generated method stub
		return userdao.getDate(userId);
	}

	@Override
	public String readNickName(String userId) {
		// TODO Auto-generated method stub
		return userdao.getNickName(userId);
	}

	// 1. 오늘 접속 x 2. 오늘 접속 o 3. 며칠동안 접속 안했음.
	@Override
	public void registUserExercise(String date, String userId) {
		// TODO Auto-generated method stub
		List<UserExerciseList> userexerciselist = getfitbitutil.getActivity(date);
		for (int i = 0; i < userexerciselist.size(); i++) {
			userexerciselist.get(i).setUserId(userId);
			userexerciselistdao.insertUserExerciseList(userexerciselist.get(i));
		}
	}

	@Override
	public void updateUserExercise(String date, String userId) {
		// TODO Auto-generated method stub
		List<UserExerciseList> userexerciselist = getfitbitutil.getActivity(date);
		for (int i = 0; i < userexerciselist.size(); i++) {
			userexerciselist.get(i).setUserId(userId);
			userexerciselistdao.updateUserExerciseList(userexerciselist.get(i));
		}
	}

	@Override
	public void registSummary(String userId) {
		// TODO Auto-generated method stub
		fitbitUser(userId);
		UserExercise userexercise = getfitbitutil.getSummary(LocalDate.now().toString());
		userexercise.setUserId(userId);
		userexercisedao.insertSummary(userexercise);
	}

	@Override
	public void updateSummary(String userId) {
		// TODO Auto-generated method stub
		UserExercise userexercise = getfitbitutil.getSummary(LocalDate.now().toString());
		userexercise.setUserId(userId);
		userexercisedao.updateSummary(userexercise);

	}

	@Override
	public UserExercise readUserExcerise(String userId) {
		// TODO Auto-generated method stub
		return userexercisedao.getUserExercise(userId);
	}

	@Override
	public void saveUserInfo(String userId) {
		// TODO Auto-generated method stub
		fitbitUser(userId);

		UserInfo userinfo = getfitbitutil.getUserProfile();
		userinfo.setUserId(userId);

		userinfodao.updateUserInfo(userinfo);
	}

	@Override
	public UserInfo readUserInfo(String userId) {
		// TODO Auto-generated method stub
		return userinfodao.getUserInfo(userId);
	}

	@Override
	public List<UserExerciseList> getWeekExercise(UserExerciseList condition) {
		// TODO Auto-generated method stub

		List<UserExerciseList> list = new ArrayList<>();
		String[] days = new String[8];
		int today = LocalDate.now().getDayOfWeek().getValue();

		for (int i = 0; i < today; i++) {
			days[today - i] = LocalDate.now().minusDays(i).toString();
			condition.setSaveDate(days[today - i]);
			list.add(userexerciselistdao.getConditionExercise(condition));
		}
		return list;
	}

	@Override
	public List<UserExercise> getWeekUser(UserExercise condition) {
		// TODO Auto-generated method stub

		List<UserExercise> list = new ArrayList<>();
		String[] days = new String[8];
		int today = LocalDate.now().getDayOfWeek().getValue();

		for (int i = 0; i < today; i++) {
			days[today - i] = LocalDate.now().minusDays(i).toString();
			condition.setSaveDate(days[today - i]);
			list.add(userexercisedao.getConditionUser(condition));
		}

		return list;
	}

	@Override
	public void fitbitUser(String userId) {
		// TODO Auto-generated method stub
		getfitbitutil = new getFitbitUtil(userdao.getKey(userId));
	}

	@Override
	public void updateCommunityUser(String userId, String date) {
		// TODO Auto-generated method stub
		List<UserExercise> list = new ArrayList<>();
		String[] days = new String[8];
		fitbitUser(userId);
		int today = LocalDate.now().getDayOfWeek().getValue();

		for (int i = 0; i < 7; i++) {
			days[today - i] = LocalDate.now().minusDays(i).toString();
			userexercisedao.insertSummary(getfitbitutil.getSummary(days[today - i]));
		}
	}

	@Override
	public int getNUser(String userId) {
		// TODO Auto-generated method stub
		return userdao.getN(userId);
	}

	@Override
	public boolean isExist(String userId) {
		// TODO Auto-generated method stub
		List<String> list = userdao.getIdList();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(userId)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void reName(String userId, String userNickName) {
		// TODO Auto-generated method stub
		User temp = new User();
		temp.setUserId(userId);
		temp.setUserNickName(userNickName);
		userdao.updateNickName(temp);
	}

	@Override
	public void rePass(String userId, String userPass) {
		// TODO Auto-generated method stub
		User temp = new User();
		temp.setUserId(userId);
		temp.setUserPass(userPass);
		userdao.updatePass(temp);
	}

	@Override
	public int getUserGoalToday(String userId, String Sport) {
		// TODO Auto-generated method stub

		UserGoal condition = new UserGoal(userId, Sport);
		condition.setSaveDate(LocalDate.now().toString());
		return usergoaldao.readGoalToday(condition);
	}

	@Override
	public List<Integer> getUserGoalWeek(String userId, String Sport) {
		// TODO Auto-generated method stub
		UserGoal condition = new UserGoal(userId, Sport);

		List<Integer> list = new ArrayList<>();
		String[] days = new String[8];
		int today = LocalDate.now().getDayOfWeek().getValue();

		for (int i = 0; i < today; i++) {
			days[today - i] = LocalDate.now().minusDays(i).toString();
			condition.setSaveDate(days[today - i]);
			list.add(usergoaldao.readGoalToday(condition));
		}
		return list;
	}

	@Override
	public boolean userPassCheck(String userId, String userPass) {
		// TODO Auto-generated method stub
		if (userId.equals(userdao.getPass(userId))) {
			return true;
		}
		return false;
	}

	@Override
	public void setDate(String userId) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUserId(userId);
		user.setLastDate(LocalDate.now().toString());
		userdao.setDate(user);

	}

	@Override
	public void updateWeekExercise(String userId) {
		// TODO Auto-generated method stub
		fitbitUser(userId);

		String[] days = new String[8];
		int today = LocalDate.now().getDayOfWeek().getValue();

		for (int i = 0; i < today; i++) {
			days[today - i] = LocalDate.now().minusDays(i).toString();
			List<UserExerciseList> userexerciselist = getfitbitutil.getActivity(days[today - i]);
			for (int j = 0; j < userexerciselist.size(); j++) {
				UserExerciseList userExerciseList = userexerciselist.get(j);
				userExerciseList.setSaveDate(days[today - i]);
				userExerciseList.setUserId(userId);
				userexerciselistdao.updateUserExerciseList(userExerciseList);
			}
		}
	}

	@Override
	public void updateWeekSummary(String userId) {
		// TODO Auto-generated method stub
		fitbitUser(userId);

		String[] days = new String[8];
		int today = LocalDate.now().getDayOfWeek().getValue();

		for (int i = 0; i < today; i++) {
			days[today - i] = LocalDate.now().minusDays(i).toString();
			UserExercise userexercise = getfitbitutil.getSummary(days[today - i]);
			userexercise.setSaveDate(days[today - i]);
			userexercise.setUserId(userId);
			userexercisedao.updateSummary(userexercise);
		}
	}

	@Override
	public void insertWeekExercise(String userId) {
		// TODO Auto-generated method stub
		fitbitUser(userId);

		String[] days = new String[8];
		int today = LocalDate.now().getDayOfWeek().getValue();

		for (int i = 0; i < today; i++) {
			days[today - i] = LocalDate.now().minusDays(i).toString();
			List<UserExerciseList> list = getfitbitutil.getActivity(days[today - i]);
			for (int j = 0; j < list.size(); j++) {
				UserExerciseList userExerciseList = list.get(j);
				userExerciseList.setSaveDate(days[today - i]);
				userExerciseList.setUserId(userId);
				userexerciselistdao.insertUserExerciseList(userExerciseList);
			}
		}
	}

	@Override
	public void insertWeekSummary(String userId) {
		// TODO Auto-generated method stub
		fitbitUser(userId);

		String[] days = new String[8];
		int today = LocalDate.now().getDayOfWeek().getValue();

		for (int i = 0; i < today; i++) {
			days[today - i] = LocalDate.now().minusDays(i).toString();
			UserExercise userexercise = getfitbitutil.getSummary(days[today - i]);
			userexercise.setSaveDate(days[today - i]);
			userexercise.setUserId(userId);
			userexercisedao.insertSummary(userexercise);
		}
	}

	String[] sport = { "Walk", "Run", "Bike", "Hike", "Tennis", "Swim", "Golf" };

	@Override
	public void insertInit(String userId) {
		// TODO Auto-generated method stub
		String[] days = new String[8];
		int today = LocalDate.now().getDayOfWeek().getValue();

		UserInfo userInfo = new UserInfo();
		userInfo.setAge(0);
		userInfo.setGender("");
		userInfo.setHeight(0);
		userInfo.setWeight(0);
		userInfo.setUserId(userId);
		userInfo.setName("");
		userinfodao.insertUserInfo(userInfo);
		for (int i = 0; i < today; i++) {
			days[today - i] = LocalDate.now().minusDays(i).toString();

			UserExercise userExercise = new UserExercise();
			userExercise.setUserId(userId);
			userExercise.setSaveDate(days[today - i]);
			userExercise.setActivityCalories(0);
			userExercise.setCaloriesOut(0);
			userExercise.setStep(0);
			userexercisedao.insertSummary(userExercise);

			for (int j = 0; j < 7; j++) {
				UserGoal userGoal = new UserGoal();
				userGoal.setUserId(userId);
				userGoal.setSaveDate(days[today - i]);
				userGoal.setActivityType(sport[j]);
				userGoal.setActivityGoal(0);
				usergoaldao.writeGoalToday(userGoal);

				UserExerciseList userExerciseList = new UserExerciseList();
				userExerciseList.setUserId(userId);
				userExerciseList.setSaveDate(days[today - i]);
				userExerciseList.setActivityParentName(sport[j]);
				userExerciseList.setCalories(0);
				userExerciseList.setDistance(0);
				userExerciseList.setDuration(0);
				userexerciselistdao.insertUserExerciseList(userExerciseList);

			}
		}
	}

	@Override
	public void insertGoal(String userId, String Sport, int Goal) {
		// TODO Auto-generated method stub
		UserGoal usergoal = new UserGoal(userId, Sport, Goal, LocalDate.now().toString());
		usergoaldao.writeGoalToday(usergoal);
	}

	@Override
	public void updateGoal(String userId, String Sport, int Goal) {
		// TODO Auto-generated method stub
		UserGoal usergoal = new UserGoal(userId, Sport, Goal, LocalDate.now().toString());
		usergoaldao.changeGoalToday(usergoal);

	}

	@Override
	public void updateNDate(String userId, String Sport) {
		// TODO Auto-generated method stub
		User temp = new User();
		temp.setUserId(userId);
		temp.setUserN(getNUser(userId) + 1);
		temp.setLastN(LocalDate.now().toString());
		userdao.cntN(temp);
	}

	@Override
	public UserExerciseList getTodayExercise(UserExerciseList condition) {
		// TODO Auto-generated method stub
		return userexerciselistdao.getConditionExercise(condition);

	}
}
