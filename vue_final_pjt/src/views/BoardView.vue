<!-- 게시판 -->
<template>
  <div>
    <BoardCreate></BoardCreate>
    <BoardDetail></BoardDetail>
    <BoardUpdate></BoardUpdate>
    <BoardList></BoardList>
  </div>
</template>

<script>
import BoardCreate from "@/components/Board/BoardCreate.vue";
import BoardDetail from "@/components/Board/BoardDetail.vue";
import BoardList from "@/components/Board/BoardList.vue";
import BoardUpdate from "@/components/Board/BoardUpdate.vue";

export default {
  name: "BoardView",
  components: { BoardCreate, BoardDetail, BoardList, BoardUpdate },
};
</script>

<style></style>
