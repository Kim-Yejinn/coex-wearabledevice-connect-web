<template>
  <div>
    <b-progress
      :value="this.percent"
      variant="info"
      striped
      :animated="animate"
      class="mt-2"
    ></b-progress>
  </div>
</template>

<script>
import { mapState } from "vuex";
export default {
  name: "PersonalProgress",
  data() {
    return {
      animate: true,
    };
  },
  computed: {
    ...mapState(["activityGoal", "todayGoal", "percent"]),
  },
};
</script>

<style scoped>
.container {
  margin: 0 auto;
  max-width: 80%;
}

.card-title {
  margin-top: 1rem;
}

.card-text {
  margin: 1rem 0;
}

.btn {
  margin-bottom: 1rem;
}

.card-container {
  position: relative;
  margin: 20px;
  border: 1px solid #ced4da;
  border-radius: 10px;
}

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
