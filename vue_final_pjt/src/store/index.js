import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";
// import router from "@/router";
Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    userInfo: {
      userId: "",
      name: "",
      age: "",
      gender: "",
      height: "",
      weight: "",
    },
    userN: 0,
    loginUser: "",
    exerciseInfo: {
      userId: "",
      activityParentName: "Walk",
      calories: "",
      distance: "",
      duration: "",
      saveData: "",
    },
    userExercise: {},
    userExerciseList: [0, 0, 0, 0, 0, 0, 0],
    userGoal: {},
    todayGoal: 0,
    todaySport: "Walk",
    activityGoal: 0,
    currSport: "",
    percent: 0,
  },
  getters: {
    userInfo(state) {
      return state.userInfo;
    },

    loginUser(state) {
      return state.loginUser;
    },

    exerciseInfo(state) {
      return state.exerciseInfo;
    },

    userExercise(state) {
      return state.userExercise;
    },

    userGoal(state) {
      return state.userGoal;
    },
  },
  mutations: {
    SET_USER_INFO(state, userInfo) {
      state.userInfo = userInfo;
    },
    SET_LOGIN_USER(state, res) {
      state.loginUser = res;
      console.log(state.loginUser);
    },
    // SET_EXERCISE_INFO(state, exerciseInfo) {
    // state.exerciseInfo = exerciseInfo;
    SET_EXERCISE_INFO(state, exerciseInfo) {
      state.exerciseInfo = exerciseInfo;
    },
    SET_EXERCISELIST_INFO(state, exerciseInfo) {
      state.userExerciseList = exerciseInfo;
    },
    SET_USER_EXERCISE(state, userExercise) {
      state.userExercise = userExercise;
    },
    SET_USER_GOAL(state, goal) {
      state.todayGoal = goal;
    },
    LOGOUT_USER(state) {
      state.loginUser = "";
    },
    SET_CURR_SPORT(state, Sport) {
      state.currSport = Sport;
    },
    SET_TODAY_ACTIVITY(state, activity) {
      state.activityGoal = activity;
      if (state.activityGoal && state.todayGoal) {
        state.percent = (state.activityGoal / state.todayGoal) * 100;
      }
    },
    SET_USER_N(state, num) {
      state.userN = num;
    },
    // UPDATE_USER_GOAL(state, activityGoal){
    //   state.activityGoal=
    // }
  },
  actions: {
    async registerUser({ commit }, user) {
      axios({
        url: "http://localhost:9999/api/user",
        method: "PUT",
        params: user,
      }).then(() => {
        commit;
        // router.push
      });
    },
    // loginUser({ commit }, { id, password }) {
    //   const response = axios.post("http://localhost:9999/api/login", {
    //     id: { id },
    //     password: { password },
    //   });

    //   if (response.message == "SUCCESS") {
    //     commit("SET_LOGIN_USER", response.data.userInfo);
    //   }
    // },
    async loginUser({ commit }, user) {
      axios({
        url: "http://localhost:9999/api/login",
        method: "POST",
        params: user,
      }).then((res) => {
        console.log(res.data.userInfo.userId);
        commit("SET_LOGIN_USER", res.data.userInfo.userId);
        // router.push({ name: "main" });
      });
    },

    // // check하는데 필요 없어서
    // async checkDuplication(_, { type, value }) {
    //   const response = await axios.get(
    //     `http://localhost:9999/api/check${type}/${value}`
    //   );
    //   return response.data.isDuplicated;
    // },

    // getUserInfo({ commit }, userId) {
    //   axios
    //     .get(`http://localhost:9999/api/user/${userId}`)
    //     .then((response) => {
    //       commit("SET_USER_INFO", response.data.userInfo);
    //     })
    //     .catch((error) => {
    //       console.log(error);
    //     });
    // },

    getUserInfo({ commit }, userId) {
      axios({
        url: `http://localhost:9999/api/user/${userId}`,
        method: "POST",
      }).then((res) => {
        console.log(res);

        commit("SET_USER_INFO", res.data);
      });
    },
    getNDate({ commit }, userId) {
      axios({
        url: `http://localhost:9999/api/user/Ndate/${userId}`,
        method: "GET",
      }).then((res) => {
        console.log(res);
        commit("SET_USER_N", res.data);
      });
    },

    getExerciseInfo({ commit }, userExerciseList) {
      axios({
        url: `http://localhost:9999/api/exercise/todayAll`,
        method: "GET",
        params: userExerciseList,
      }).then((res) => {
        console.log(res);
        commit("SET_EXERCISE_INFO", res.data);
      });
    },
    async getExerciseListInfo({ commit }, userExerciseList) {
      axios({
        url: `http://localhost:9999/api/exercise/list`,
        method: "GET",
        params: userExerciseList,
      }).then((res) => {
        console.log(res);
        commit("SET_EXERCISELIST_INFO", res.data);
      });
    },
    // async getExerciseInfo({ commit }, activityName) {
    //   axios({
    //     url: `http://localhost:9999/api/exercise/${activityName}`,
    //     method: "GET",
    //   }).then((res) => {
    //     console.log(res);
    //     commit("setExerciseInfo", res.data);
    //   });

    // 여기에 끝에 userId 추가 해야되나??
    // },
    async getUserExercise({ commit }, conExer) {
      axios({
        url: `http://localhost:9999/api/summary/list`,
        method: "GET",
        params: conExer,
      }).then((res) => {
        console.log(res);
        commit("SET_USER_EXERCISE", res.data);
      });
    },
    async getUserGoal({ commit }, userGoal) {
      console.log(userGoal);
      axios({
        url: `http://localhost:9999/api/user/goalToday`,
        method: "GET",
        params: userGoal,
      }).then((res) => {
        console.log(res);
        commit("SET_USER_GOAL", res.data);
      });
    },
    getTodayActivity({ commit }, userExercise) {
      axios({
        url: `http://localhost:9999/api/exercise/today`,
        method: "GET",
        params: userExercise,
      }).then((res) => {
        console.log(res);
        commit("SET_TODAY_ACTIVITY", res.data);
      });
    },
    userLogout({ commit }) {
      commit("LOGOUT_USER");
    },
    setGoal({ commit }, userGoal) {
      axios({
        url: `http://localhost:9999/api/user/goal`,
        method: "GET",
        params: userGoal,
      }).then(() => {
        commit("SET_CURR_SPORT", userGoal.activityType);
      });
    },
    setCnt({ commit }, userGoal) {
      axios({
        url: `http://localhost:9999/api/user/goal/cnt`,
        method: "Get",
        params: userGoal,
      }).then(() => {
        commit;
      });
    },
  },
});
