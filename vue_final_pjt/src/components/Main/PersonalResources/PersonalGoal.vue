<template>
  <div>
    <div class="modal-body">
      <form @submit.prevent="submitGoal">
        <div class="mb-3">
          <label for="goal-select" class="form-label">목표 운동 선택</label>
          <select
            id="goal-select"
            class="form-select"
            v-model="userGoal.activityType"
            @click="getGoal"
          >
            <option disabled value="">운동을 골라주세요</option>
            <option
              v-for="option in options"
              :value="option.value"
              :key="option.value"
              @click="getGoal"
            >
              {{ option.text }}
            </option>
          </select>
        </div>
        <div class="mb-3">
          <label for="goal-input" class="form-label"
            >목표 (kcal 단위로 적어주세요)
          </label>
          <input
            id="goal-input"
            type="text"
            class="form-control"
            v-model="userGoal.activityGoal"
            placeholder="해당 운동의 목표 감량 칼로리"
          />
        </div>
        <button type="submit" class="btn btn-primary" @click="submitGoal">
          목표 세우기
        </button>
        <button type="button" class="btn btn-secondary" @click="checkIn">
          출석하기
        </button>
      </form>
      <div class="lower-part" style="height: 50%">
        <div class="row-3">
          <p>목표한 운동량:{{ todayGoal }}</p>

          <p>오늘의 운동량: {{ activityGoal }}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "PersonalGoal",
  data() {
    return {
      userGoal: {
        userId: "",
        activityType: "Walk",
        activityGoal: "0",
      },
      userexercise: {
        userId: "",
        activityParentName: "Walk",
      },

      options: [
        { value: "Walk", text: "워킹" },
        { value: "Run", text: "러닝" },
        { value: "Bike", text: "바이크" },
        { value: "Hike", text: "하이킹" },
        { value: "Tennis", text: "테니스" },
        { value: "Swim", text: "수영" },
        { value: "Golf", text: "골프" },
      ],
    };
  },
  methods: {
    getGoal() {
      this.userGoal.userId = this.loginUser;
      this.$store.dispatch("getUserGoal", this.userGoal);
      this.activityParentName = this.userGoal.activityType;
      this.userexercise.userId = this.loginUser;
      this.$store.dispatch("getTodayActivity", this.userexercise);
    },
    submitGoal() {
      this.userGoal.userId = this.loginUser;
      this.$store.dispatch("setGoal", this.userGoal);
      this.$store.dispatch("getUserGoal", this.userGoal);
      this.$store.dispatch("getTodayActivity", this.userexercise);
    },
    checkIn() {
      this.userGoal.userId = this.loginUser;
      if (this.activityGoal >= this.todayGoal) {
        this.$store.dispatch("setCnt", this.userGoal);
        this.$store.dispatch("getNDate", this.loginUser);
      }
    },
  },
  computed: {
    ...mapState(["activityGoal", "loginUser", "todayGoal", "todaySport"]),
  },
};
</script>

<style scoped>
.btn {
  margin-bottom: 1rem;
  margin-right: 1rem;
}

.form-label {
  justify-content: center;
  text-align: center;
  justify-items: center;
}
</style>
