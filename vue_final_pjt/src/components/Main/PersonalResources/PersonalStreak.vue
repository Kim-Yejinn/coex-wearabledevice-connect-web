<template>
  <div class="streak-container">
    <div class="streak-image">
      <img :src="streakImage" alt="Streak status" />
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
export default {
  name: "PersonalStreak",
  props: {},
  computed: {
    ...mapState(["userN"]),
    streakImage() {
      if (this.userN === 0) {
        return "/assets/Streak-status-leftTotree/Stacked-zero.png";
      } else if (this.userN >= 1 && this.userN <= 2) {
        return "/assets/Streak-status-leftTotree/Stacked-begining.png";
      } else if (this.userN >= 3 && this.userN <= 4) {
        return "/assets/Streak-status-leftTotree/Stacked-growing.png";
      } else if (this.userN >= 5 && this.userN <= 6) {
        return "/assets/Streak-status-leftTotree/Stacked-maturing.png";
      } else {
        return "/assets/Streak-status-leftTotree/Stacked-full.png";
      }
    },
  },
};
</script>

<style scoped>
.streak-container {
  display: flex;
}

.streak-text {
  flex: 1;
  /* 이곳에 필요한 스타일을 추가하세요 */
}

.streak-image {
  flex: 1;
  display: flex;
  justify-content: center;
  align-items: bottom;
}

.streak-image img {
  width: 60%; /* 원본 크기의 절반 */
  height: auto; /* 이미지 비율을 유지 */
  justify-content: bottom;
}
</style>
