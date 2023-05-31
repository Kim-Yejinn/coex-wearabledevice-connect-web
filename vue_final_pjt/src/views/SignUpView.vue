<template>
  <main class="form-signin w-100 m-auto">
    <form @submit.prevent="signUp">
      <img
        class="mb-4 mx-auto d-block"
        src="/assets/logo.png"
        alt=""
        width="300"
        height="150"
      />
      <h1 class="h3 mb-3 fw-normal">회원가입을 해주세요!</h1>

      <div class="input-group mb-3">
        <input
          type="text"
          class="form-control"
          id="floatingId"
          v-model="user.userId"
          placeholder="Your ID"
        />
        <button class="btn btn-secondary" type="button" @click="checkId">
          중복 확인
        </button>
      </div>

      <div class="input-group mb-3">
        <input
          type="password"
          class="form-control"
          id="floatingPassword"
          v-model="user.userPass"
          placeholder="Your Password"
        />
      </div>

      <div class="input-group mb-3">
        <input
          type="text"
          class="form-control"
          id="floatingNickname"
          v-model="user.userNickName"
          placeholder="Your Nickname"
        />
        <button class="btn btn-secondary" type="button" @click="checkNickname">
          중복 확인
        </button>
      </div>

      <div class="input-group mb-3">
        <input
          type="text"
          class="form-control"
          id="floatingAccessKey"
          v-model="user.accessKey"
          placeholder="Your Access Key"
        />
      </div>

      <button class="w-100 btn btn-lg btn-primary" type="submit">
        Sign up
      </button>
      <p class="mt-5 mb-3 text-muted">&copy; 2023</p>
    </form>
  </main>
</template>

<script>
export default {
  data() {
    return {
      user: {
        userId: "",
        userPass: "",
        userNickName: "",
        accessKey: "",
      },
    };
  },
  methods: {
    async signUp() {
      this.$store.dispatch("registerUser", this.user);
    },
    async checkId() {
      const isDuplicated = await this.$store.dispatch("checkDuplication", {
        type: "userId",
        value: this.userId,
      });

      if (isDuplicated) {
        alert("중복된 아이디입니다.");
      } else {
        alert("사용 가능한 아이디입니다.");
      }
    },
    async checkNickname() {
      const isDuplicated = await this.$store.dispatch("checkDuplication", {
        type: "userNickName",
        value: this.userNickName,
      });

      if (isDuplicated) {
        alert("중복된 닉네임입니다.");
      } else {
        alert("사용 가능한 닉네임입니다.");
      }
    },
  },
};
</script>

<style scoped>
.sr-only {
  position: absolute;
  width: 1px;
  height: 1px;
  padding: 0;
  margin: -1px;
  overflow: hidden;
  clip: rect(0, 0, 0, 0);
  border: 0;
}
</style>
