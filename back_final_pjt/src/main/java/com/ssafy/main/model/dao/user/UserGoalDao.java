package com.ssafy.main.model.dao.user;

import com.ssafy.main.model.dto.User.UserGoal;

public interface UserGoalDao {
	int readGoalToday(UserGoal condition);

	void writeGoalToday(UserGoal userGoal);
	
	void changeGoalToday(UserGoal userGoal);
}
