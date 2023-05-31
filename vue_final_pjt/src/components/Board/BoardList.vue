<template>
  <div>
    <h3>게시글 목록</h3>
    <hr />

    <div>
      <table>
        <tr>
          <th>번호</th>
          <th>제목</th>
          <th>글쓴이</th>
          <th>조회수</th>
          <th>등록일</th>
        </tr>
        <tr v-for="board in boards" :key="board.id">
          <td>{{ board.id }}</td>
          <td>
            <router-link :to="`/board/${board.id}`">
              {{ board.title }}
            </router-link>
          </td>
          <td>{{ board.writer }}</td>
          <td>{{ board.viewCnt }}</td>
          <td>{{ board.regDate }}</td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "BoardList",
  computed: {
    ...mapState(["boards"]),
  },
  created() {
    this.$store.dispatch("getBoards");
  },
};
</script>

<style></style>
