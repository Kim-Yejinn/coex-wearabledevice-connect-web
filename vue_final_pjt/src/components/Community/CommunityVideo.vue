<!-- 커뮤니티 하단, 영상 보여줄곳 -->
<!-- 영상 3개 -->
<template>
  <YoutubeVideos></YoutubeVideos>
</template>

<script>
import YoutubeVideos from "./CommunityResources/YoutubeVideos.vue";

export default {
  name: "CommunityVideo",
  components: {
    YoutubeVideos,
  },
};
</script>

<style scoped></style>
