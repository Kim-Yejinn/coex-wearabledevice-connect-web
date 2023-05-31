<template>
  <div>
    <!-- 상단은 개인 정보 요약 화면 -->
    <MainPersonal></MainPersonal>
    <!-- 하단은 일주일 운동 -->
    <MainExercise></MainExercise>
  </div>
</template>

<script>
import MainPersonal from "@/components/Main/MainPersonal.vue";
import MainExercise from "@/components/Main/MainExercise.vue";

export default {
  name: "MainView",
  components: {
    MainPersonal,
    MainExercise,
  },
};
</script>

<style scoped></style>
