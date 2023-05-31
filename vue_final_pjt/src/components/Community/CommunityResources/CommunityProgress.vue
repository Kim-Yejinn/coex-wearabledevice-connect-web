<!-- 커뮤니티 상단, 그룹 보여줄 곳 -->
<!-- 사람 검색 창 추가 필요 -->
<!-- 사람 추가/삭제 필요 -->

<template>
  <div class="home container mt-5">
    <div class="row justify-content-center">
      <div class="col-12">
        <div class="card-container mb-3">
          <div class="row g-0 image-row">
            <div class="col-12 col-md-6">
              <div class="content-image-container">
                <Community-goal></Community-goal>
                <div class="mid">
                  <div v-for="list in lists" :key="list.test">
                    {{ list }}
                    <community-group-list></community-group-list>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-12 col-md-6">
              <div class="card-image-container">
                <community-users></community-users>
              </div>
            </div>
          </div>
          <div class="card-body text-start ms-3">
            <p class="card-text custom-margin">
              커뮤니티 멤버들의 운동 근황을 살펴보세요 ! <br />
              누가 얼마나 열심히 하고 있는지를 본다면 <br />
              더욱 자극 받게되지 않나요 ?
            </p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import CommunityUsers from "./CommunityUsers.vue";
import CommunityGoal from "../CommunityGoal.vue";
import CommunityGroupList from "../CommunityGroupList.vue";

export default {
  data() {
    return {
      animate: true,
      // Community View에 있던 녀석 고대로 들고 왔습니다.
      lists: { test1: "test1", test2: "test2", test3: "test3" },
    };
  },
  name: "CommunityProgress",
  components: {
    CommunityUsers,
    CommunityGoal,
    CommunityGroupList,
  },
  datasets: [
    {
      data: [10, 20, 30],
    },
  ],

  // These labels appear in the legend and in the tooltips when hovering different arcs
  labels: ["Red", "Yellow", "Blue"],
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
