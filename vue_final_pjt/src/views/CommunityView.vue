<!-- 상단에는 그룹 -->
<!-- 하단에는 유튭 -->
<template>
  <!-- 그룹 관련 컴포넌트-->
  <div>
    <!-- <Community-goal></Community-goal> -->
    <!-- 가로로 붙는거 이따가.. -->
    <!-- <div class="mid">
      <div v-for="list in lists" :key="list.test">
        {{ list }}
        <community-group-list></community-group-list>
      </div>
    </div> -->
    <CommunityGroup></CommunityGroup>
    <CommunityVideo></CommunityVideo>
  </div>

  <!-- 유튜브 관련 컴포넌트-->
</template>

<script>
import CommunityGroup from "@/components/Community/CommunityGroup.vue";
import CommunityVideo from "@/components/Community/CommunityVideo.vue";
// import CommunityGroupList from "@/components/Community/CommunityGroupList.vue";
// import CommunityGoal from "@/components/Community/CommunityGoal.vue";
export default {
  name: "CommunityView",
  //아이콘들 리스트 여기서 받고 반복문 돌릴거임.
  data() {
    return {
      lists: { test1: "test1", test2: "test2", test3: "test3" },
    };
  },
  components: {
    CommunityVideo,
    CommunityGroup,
    // CommunityGroupList,
    // CommunityGoal,
  },
};
</script>

<style scoped>
.mid {
  display: flex;
  justify-content: center;
}
</style>
