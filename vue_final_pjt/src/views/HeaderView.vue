<template>
  <div>
    <b-navbar toggleable="lg" type="light" variant="light" class="flex-navbar">
      <div class="logo-section">
        <b-navbar-brand to="/">
          <img src="/assets/logo.png" alt="Logo" class="logo" />
        </b-navbar-brand>
      </div>

      <div class="menu-section">
        <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

        <b-collapse id="nav-collapse" is-nav>
          <b-navbar-nav class="ml-auto">
            <b-nav-item
              v-if="loginUser == ''"
              @click="showLoginModal = true"
              class="nav-item"
              >로그인</b-nav-item
            >
            <b-nav-item to="/" v-else @click="logout" class="nav-item"
              >로그아웃</b-nav-item
            >
            <b-nav-item @click="showSignUpModal = true" class="nav-item"
              >회원가입</b-nav-item
            >
            <b-nav-item @click="toggleDarkMode" class="nav-item">{{
              isDarkMode ? "Light Mode" : "Dark Mode"
            }}</b-nav-item>
          </b-navbar-nav>
        </b-collapse>
      </div>
    </b-navbar>

    <b-modal v-model="showLoginModal">
      <LoginView />
    </b-modal>

    <b-modal v-model="showSignUpModal">
      <SignUpView />
    </b-modal>
  </div>
</template>

<script>
import LoginView from "./LoginView";
import SignUpView from "./SignUpView";
import { mapState } from "vuex";
export default {
  components: { LoginView, SignUpView },
  inject: ["isDarkMode", "toggleDarkMode"],
  data() {
    return {
      showLoginModal: false,
      showSignUpModal: false,
    };
  },
  computed: {
    ...mapState(["loginUser"]),
  },
  methods: {
    logout() {
      this.$store.dispatch("userLogout");
      //   this.$router.push({ path: "/home", redirect: { name: "main" } });
    },
  },
};
</script>

<style scoped>
.flex-navbar {
  display: flex;
  justify-content: space-between;
}

.logo {
  height: 60px;
}

.logo-section {
  margin-left: 10%;
}

.menu-section {
  margin-right: 10%;
}

.nav-item {
  color: #17a2b8 !important;
}
</style>
