<!-- 로그인 화면 -->
<template>
  <main class="form-signin w-100 m-auto">
    <form @submit.prevent="signIn">
      <img
        class="mb-4 mx-auto d-block"
        src="/assets/logo.png"
        alt=""
        width="250"
        height="125"
      />
      <h1 class="h3 mb-3 fw-normal">로그인을 해주세요!</h1>

      <div class="form-floating">
        <input
          type="id"
          class="form-control"
          id="floatingInput"
          v-model="user.id"
          placeholder="아이디를 적어주세요"
        />
        <label for="floatingInput">Id</label>
      </div>
      <div class="form-floating">
        <input
          type="password"
          class="form-control"
          id="floatingPassword"
          v-model="user.password"
          placeholder="비밀번호를 적어주세요"
        />
        <label for="floatingPassword">Password</label>
      </div>

      <!-- <div class="checkbox mb-3"> -->
      <!-- <label>
          <input type="checkbox" v-model="rememberMe" value="true" /> Remember
          me
        </label> -->
      <!-- </div> -->
      <button class="w-100 btn btn-lg btn-primary" type="submit">
        Sign in
      </button>
      <p class="mt-5 mb-3 text-muted">&copy; 2023</p>
    </form>
  </main>
</template>

<script>
export default {
  name: "LoginView",
  data() {
    return {
      user: { id: "", password: "" },
    };
  },
  methods: {
    async signIn() {
      this.$store.dispatch("loginUser", this.user);
    },
  },
};
</script>

<style></style>
