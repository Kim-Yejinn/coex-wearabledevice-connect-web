CREATE DATABASE IF NOT EXISTS final_pjt_db;

USE final_pjt_db;


-- 유저 관련 
drop table user;
CREATE TABLE IF NOT EXISTS user (
    userId VARCHAR(20) NOT NULL PRIMARY KEY,
    userPass VARCHAR(20) NOT NULL,
    userNickName VARCHAR(20) NOT NULL,
    lastDate date NOT NULL,
    accessKey varchar(500),
    userN int default 0,
    lastN date
)engine InnoDB;


drop TABLE userExercise;
CREATE TABLE IF NOT EXISTS userExercise (
	userExerciseNo int PRIMARY key AUTO_INCREMENT,
    userId VARCHAR(20) NOT NULL,
    saveDate date not null,
    caloriesOut int NOT NULL,
    activityCalories int NOT NULL,
    step int not null
)engine InnoDB;


DROP table userExerciseList;
CREATE TABLE IF NOT EXISTS userExerciseList (
	userExerciseListNo int PRIMARY KEY AUTO_INCREMENT,
    userId VARCHAR(20) NOT NULL ,
    saveDate date NOT NULL,
    activityParentName VARCHAR(30) NOT NULL,
    calories INT NOT NULL,
    distance DOUBLE NOT NULL,
    duration INT not null
)engine InnoDB;
drop table userInfo;
CREATE TABLE IF NOT EXISTS userInfo (
    userId VARCHAR(20) NOT NULL PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    age int NOT NULL,
    gender VARCHAR(20) NOT NULL,
    height double NOT NULL,
    weight double NOT NULL
)engine InnoDB;



drop table userGoal;

CREATE TABLE IF NOT EXISTS userGoal (
	goalNo int not null primary key AUTO_INCREMENT,
    userId VARCHAR(20) NOT NULL ,
    activityType VARCHAR(20) NOT NULL,
    activityGoal int NOT NULL,
    saveDate DATE not null
)engine InnoDB;



-- 그룹 관련 
CREATE TABLE IF NOT EXISTS communityList (
    userId VARCHAR(20) NOT NULL,
    communityNo INT NOT NULL PRIMARY KEY
)engine InnoDB;

CREATE TABLE IF NOT EXISTS communityInfo (
    communityNo INT NOT NULL PRIMARY KEY,
    communityName VARCHAR(20) NOT NULL,
    communityText VARCHAR(100) NOT NULL
)engine InnoDB;

CREATE TABLE IF NOT EXISTS communityGoal (
	goalNo int not null primary key AUTO_INCREMENT,
    communityNo INT NOT NULL,
    activityType VARCHAR(20) NOT NULL,
    activityGoal int,
    saveDate DATE not null
)engine InnoDB;

-- 게시판
 CREATE TABLE IF NOT EXISTS board (
    boardId INT NOT NULL PRIMARY KEY auto_increment,
    boardTitle VARCHAR(100) NOT NULL,
    boardWrite VARCHAR(20) NOT NULL,
    boardText VARCHAR(100) NOT NULL,
    boardDate date NOT NULL,
    viewCnt INT
)engine InnoDB;


select * from user;
update user set lastDate="2023-05-25" where userId="111";
SELECT lastN FROM user WHERE userId="111";
-- update user set lastDate="0000-00-00" where userId="111";
select * from userExercise;
select * from userExerciseList;
select * from userInfo;

select * from userGoal;
select * from communityInfo;
select * from communityGoal;
select * from board;
SELECT activityGoal FROM userGoal WHERE userId="111"
		and activityType="Walk" and saveDate="2023-05-25";

DESC user;
DESC userExerciseList;

SELECT * from userInfo where userId=23;
