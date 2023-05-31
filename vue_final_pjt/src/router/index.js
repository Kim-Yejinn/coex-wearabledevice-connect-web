  import Vue from "vue";
  import VueRouter from "vue-router";
  import HomeView from "../views/HomeView.vue";
  import MainView from "@/views/MainView.vue";
  import BoardView from "@/views/BoardView.vue";
  import CommunityView from "@/views/CommunityView.vue";
  import LoginView from "@/views/LoginView.vue";
  import SignUpView from "@/views/SignUpView.vue";

  Vue.use(VueRouter);

  const routes = [
    {
      // 홈화면
      path: "/",
      name: "home",
      component: HomeView,
    },
    {
      // 게시판
      path: "/board",
      name: "board",
      component: BoardView,
    },
    {
      // 커뮤니티
      path: "/community",
      name: "community",
      component: CommunityView,
    },
    {
      // 로그인
      path: "/login",
      name: "login",
      component: LoginView,
    },
    {
      // 회원가입
      path: "/signup",
      name: "signup",
      component: SignUpView,
    },
    {
      // 메인
      path: "/main",
      name: "main",
      component: MainView,
    },
  ];

  const router = new VueRouter({
    mode: "history",
    base: process.env.BASE_URL,
    routes,
  });

  export default router;
