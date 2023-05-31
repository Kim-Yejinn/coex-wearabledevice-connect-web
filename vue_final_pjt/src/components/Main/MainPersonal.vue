<template>
  <div class="container mt-5">
    <div class="row justify-content-center">
      <div class="col-12">
        <div class="card-container mb-3">
          <div class="row g-0">
            <!-- Personal 왼쪽 파트 -->
            <div class="col-12 col-md-6">
              <!-- Left side의 왼쪽파트 -->

              <!-- Left side의 오른쪽 파트 -->
              <div class="row">
                <!-- 왼쪽 부분 -->
                <!-- 왼쪽 부분 -->
                <div class="col-3">
                  <div class="info-parent">
                    이름: {{ userInfo.name }}<br />
                    <br />
                    나이: {{ userInfo.age }}<br />
                    <br />
                    성별: {{ userInfo.gender }}<br />
                    <br />
                    키: {{ userInfo.height }}<br />
                    <br />
                    몸무게: {{ userInfo.weight }}<br />
                  </div>
                </div>
                <div class="col-1"></div>

                <!-- 오른쪽 부분 -->
                <div class="col-4" style="height: 100%">
                  <PersonalGoal></PersonalGoal>
                </div>
              </div>
            </div>
            <!-- Personal의 오른쪽 파트 -->
            <div class="col-12 col-md-6">
              <!-- Right side의 왼쪽파트 -->
              <!-- <div>{{ userInfo.dailyExerciseSummary }}</div> -->
              <!-- Right side의 오른쪽 파트 -->
              <!-- from here-->
              <div
                class="description d-flex justify-content-center align-items-center"
              >
                <!-- 왼쪽 부분 -->
                <div class="col-5">
                  <br /><br />
                  설정하신 목표를 달성하시면 출석이 됩니다!<br />
                  <br />
                  새싹을 나무까지 키워보세요 <br />
                  <br />
                  오늘은 {{ userN }}일차 째 출석이시군요!
                  <br />
                  <br />
                  <div>
                    <p class="infos">목표량 대비 운동량 {{ percent }}%</p>
                    <PersonalProgress></PersonalProgress>
                  </div>
                </div>
                <!-- 오른쪽 부분 -->
                <div col-7>
                  <PersonalStreak />
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import PersonalStreak from "./PersonalResources/PersonalStreak.vue";
import PersonalGoal from "./PersonalResources/PersonalGoal.vue";
import PersonalProgress from "./PersonalResources/PersonalProgress.vue";

// import PersonInfo from "./PersonalResources/PersonInfo.vue";

import { mapState } from "vuex";
export default {
  name: "MainPersonal",

  components: {
    PersonalStreak,
    PersonalGoal,
    PersonalProgress,
  },
  data() {
    return {
      showModal: false,
      conExer: {
        activityName: "",
        userId: "",
      },
    };
  },
  methods: {
    openForm() {
      console.log("openForm method called");
      this.showForm = true;
      console.log("showForm value after openForm: ", this.showForm);
    },
    cancelForm() {
      this.showForm = false;
    },
    // refreshGoals() {
    //   this.$store.dispatch("getUserGoal", this.loginUser);
    // },
    // getUserInfo1() {
    //   console.log(this.userInfo);
    //   return this.$store.state.userInfo;
    // },
  },
  computed: {
    ...mapState([
      "userInfo",
      "loginUser",
      "userExercise",
      // "userGoal",
      "todayGoal",
      "todaySport",
      "userN",
      "percent",
    ]),

    userInfo1() {
      console.log(this.userInfo);
      return this.$store.state.userInfo;
    },
    // userExercise() {
    //   return this.$store.state.userExercise;
    // },
    // userGoal() {
    //   return this.$store.state.userGoal;
    // },
  },
  created() {
    this.conExer = { activityName: "Walk", userId: this.loginUser };
    console.log(this.loginUser);
    this.$store.dispatch("getUserInfo", this.loginUser);
    this.$store.dispatch("getUserExercise", this.conExer);
    this.$store.dispatch("getNDate", this.loginUser);
  },
  watch: {
    showForm(newValue) {
      console.log("showForm changed to: ", newValue);
    },
    userN() {
      this.userInfo1();
    },
  },
};
</script>

<style scoped>
/* .container {
  margin: 0 auto;
  max-width: 80%;
  overflow-y: scroll;
} */

.card-title {
  margin-top: 1rem;
}

.card-text {
  margin: 1rem 0;
}

.btn {
  margin-bottom: 1rem;
}

/* .card-container {
  position: relative;
  margin: 20px;
  border: 1px solid #ced4da;
  border-radius: 10px;
} */

.card-container::after {
  content: "";
  position: relative;
  left: 10%;
  right: 10%;
  top: calc(50% - 0.5px);
  height: 1px;
  background: #ced4da;
}

.row {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
}

.col-3 {
  margin-top: 2rem;
  margin-bottom: 2rem;
  margin-left: 8rem;
  border: 2px solid #71b7f8;
  border-radius: 7%;
}

.col-4 {
  margin-top: 2rem;
  margin-bottom: 2rem;
  margin-left: 4rem;
  border: 2px solid #71b7f8;
  border-radius: 7%;
}

.col-12 {
  flex: 0 0 100%;
  max-width: 100%;
}

@media (min-width: 768px) {
  .col-md-6 {
    flex: 0 0 50%;
    max-width: 50%;
  }

  .col-md-4 {
    flex: 0 0 33.33%;
    max-width: 33.33%;
  }
  .infos {
    text-align: center;
  }
  .info-parent {
    justify-content: center;
    align-content: center;
    font-size: 18px;
  }
}
</style>
