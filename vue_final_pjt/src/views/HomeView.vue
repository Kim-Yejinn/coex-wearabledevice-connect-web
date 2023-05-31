<template>
  <div class="home container mt-1">
    <div class="row justify-content-center">
      <div class="col-12">
        <div class="card-container mb-2">
          <div class="row g-0">
            <!-- left content -->
            <div
              class="col-md-4 d-flex justify-content-center align-items-center"
            >
              <img
                src="/assets/logo.png"
                class="img-fluid rounded-start"
                alt="logo"
              />
            </div>

            <!-- center content -->
            <div class="col-md-4">
              <br />
              <div class="card-body text-start ms-3">
                <h5 class="card-title mt-3">CO - EX means...</h5>
                <p class="card-text my-3">
                  co- : 접두사 ‘공동’, ‘함께’의 뜻을 나타냄<br />
                  ex : exercise의 약어<br />
                  <br />
                  개인의 운동 기록 관리뿐 아닌, 다른 사람의 기록도 참고하며<br />
                  함께 하는 운동의 재미와 가치를 지속할 수 있게 디자인한 <br />
                  개인 운동 기록 관리 및 그룹 기록 열람 웹사이트입니다. <br />
                </p>
              </div>
            </div>

            <!-- right content -->
            <div class="col-md-4">
              <br />
              <div class="card-body text-start ms-3">
                <img src="/assets/joinus.png" />
              </div>
              <div class="card-body text-start ms-3">
                <router-link :to="{ name: 'main' }" class="btn btn-primary my-3"
                  >메인 페이지</router-link
                >
                <router-link
                  :to="{ name: 'community' }"
                  class="btn btn-primary my-3"
                  >커뮤니티 페이지</router-link
                >
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="row justify-content-center">
      <img src="/assets/3_2.png" />
      <br />
      <br />
      <br />
      <br />
    </div>
  </div>
</template>

<script>
export default {
  name: "HomeView",
  components: {},
};
</script>

<style scoped>
.backgroundIMG {
  background-image: url("@/assets/logo.png");
  background-repeat: no-repeat;
  background-size: cover;
}

.container {
  margin: 0 auto;
  max-width: 80%;
}

.card-container {
  position: relative;
  max-width: 100%;
  border: 6px solid hsl(0, 0%, 100%);
}

.card-text {
  font-size: 20px;
  margin: 1rem 0;
}

.btn {
  margin-bottom: 1rem;
  margin-left: 1rem;
  margin-right: 1rem;
}
</style>
