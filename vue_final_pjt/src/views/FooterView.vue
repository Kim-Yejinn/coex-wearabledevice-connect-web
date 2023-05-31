<template>
  <footer class="footer mt-auto py-3 bg-light text-center">
    <div class="container">
      <span class="text-muted">
        ©2023 by Team CO-EX. Proudly created with SSAFY | Team Members:
        Kim-Yejin, Lee-Dohyung
      </span>
    </div>
  </footer>
</template>

<script>
export default {
  name: "FooterView",
};
</script>

<style scoped>
body {
  min-height: 75vh;
  position: relative;
  padding-bottom: 70px;
}

.footer {
  position: absolute;
  bottom: 0;
  width: 100%;
  height: 60px;
}
</style>
