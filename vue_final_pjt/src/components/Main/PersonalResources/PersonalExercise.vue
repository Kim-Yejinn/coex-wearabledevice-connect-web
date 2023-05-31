<template>
  <div>
    <select
      id="goal-select"
      class="form-select"
      v-model="userExerciseList.activityParentName"
      @click="getExercise"
    >
      <option disabled value="">운동을 골라주세요</option>
      <option
        v-for="option in options"
        :value="option.value"
        :key="option.value"
        @click="getExercise"
      >
        {{ option.text }}
      </option>
    </select>
    <div>
      운동: {{ exerciseInfo.activityParentName }}<br />
      <br />
      소모 칼로리: {{ exerciseInfo.calories }} kcal<br />
      <br />
      운동 거리: {{ exerciseInfo.distance }} Km<br />
      <br />
      운동 시간: {{ exerciseInfo.duration }} 분<br />
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
export default {
  name: "PersonalExercise",
  data() {
    return {
      userExerciseList: {
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
  computed: {
    ...mapState(["exerciseInfo", "loginUser"]),
  },
  methods: {
    getExercise() {
      this.userExerciseList.userId = this.loginUser;
      this.$store.dispatch("getExerciseInfo", this.userExerciseList);
      this.$store.dispatch("getExerciseListInfo", this.userExerciseList);
    },
  },
};
</script>

<style scoped>
/* .streak-container {
  display: flex;
} */

.streak-text {
  flex: 1;
  /* 이곳에 필요한 스타일을 추가하세요 */
}

.streak-image {
  flex: 1;
  display: flex;
  justify-content: center;
  align-items: center;
}

.streak-image img {
  width: 70%; /* 원본 크기의 절반 */
  height: auto; /* 이미지 비율을 유지 */
}
</style>
