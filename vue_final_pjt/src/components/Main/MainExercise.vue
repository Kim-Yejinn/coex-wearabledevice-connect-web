<!-- 메인화면 상단, 개인 정보 요약화면 -->
<template>
  <div class="container mt-5">
    <div class="row justify-content-center">
      <div class="col-12">
        <div class="card-container mb-3">
          <div class="row g-0 image-row">
            <div class="col-12 col-md-6">
              <PersonalChart></PersonalChart>
            </div>
            <div class="col-12 col-md-6">
              <PersonalExercise></PersonalExercise>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import PersonalChart from "./PersonalResources/PersonalChart.vue";
import PersonalExercise from "./PersonalResources/PersonalExercise.vue";

export default {
  name: "MainExercise",
  components: {
    PersonalChart,
    PersonalExercise,
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

.content-image-container {
  padding: 10px 10% 0 10%;
  display: flex;
  justify-content: center;
  align-items: center;
}

.image-box {
  position: relative;
  display: flex;
  justify-content: center;
  align-items: center;
}

/* .image-row > div:last-child .content-image-container:after {
  content: none;
}

.image-row:after {
  content: "";
  display: block;
  height: 1px;
  background: #ced4da;
  width: 80%;
  margin: 10px auto;
} */

.custom-margin {
  margin: 10px 10% 0 10%;
  padding-top: 1rem;
  padding-bottom: 1rem;
}

.image-row {
  position: relative;
}

.image-row > div {
  padding: 0 10px;
}
.image-row {
  margin: 10px 10% 0 10%;
  border-bottom: 1px solid #ced4da;
}

.image-row::after {
  content: "";
  position: absolute;
  left: 50%;
  top: 10%;
  bottom: 10%;
  width: 1px;
  background: #ced4da;
  transform: translateX(-50%);
}
</style>
