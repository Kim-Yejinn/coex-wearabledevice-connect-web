<template>
  <div id="app" class="d-flex flex-column min-vh-100">
    <HeaderNav />

    <div class="flex-grow-1 backgroundIMG">
      <router-view />
    </div>
    <!-- <FooterView /> -->
  </div>
</template>

<script>
import HeaderNav from "@/views/HeaderView.vue";
// import FooterView from "@/views/FooterView.vue";

export default {
  components: {
    HeaderNav,
    // FooterView,
  },
  data() {
    return {
      isDarkMode: false,
    };
  },
  provide() {
    return {
      isDarkMode: this.isDarkMode,
      toggleDarkMode: this.toggleDarkMode,
    };
  },
  methods: {
    toggleDarkMode() {
      this.isDarkMode = !this.isDarkMode;
    },
  },
};
</script>

<style scoped>
@font-face {
  font-family: "write_font_name";
  src: url(@/assets/Dovemayo_gothic.ttf) format("woff");
  font-weight: normal;
  font-style: normal;
}
.App {
  text-align: center;
  font-size: 50px;
  font-family: write_font_name;
}

body {
  --bg-color: #fff;
  --text-color: #000;
}

body.dark {
  --bg-color: #000;
  --text-color: #fff;
}

body {
  background-color: var(--bg-color);
  color: var(--text-color);
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}

#app {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
}
</style>
