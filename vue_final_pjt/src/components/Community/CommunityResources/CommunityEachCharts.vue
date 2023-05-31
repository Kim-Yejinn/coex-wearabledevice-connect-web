<template>
  <div>
    <div>유저 닉넴 들어가고</div>
    <div>유저 오늘 활성ㅇ 칼로리 들어가고</div>
    <div>유저 오늘 운동한 거리</div>
    <div>유저 오늘 운동한 시간</div>
    <div>유저 오늘 한 퍼센트</div>
  </div>
  <!-- <div class="home container mt-5">
    <div class="row justify-content-center">
      <div class="col-12">
        <div class="card-container mb-3">
          <div class="row g-0">
            <div
              class="col-md d-flex justify-content-center align-items-center"
            >
              <img
                src="/assets/logo.png"
                class="img-fluid rounded-start"
                alt="logo"
              />
            </div>
            <div class="col-md-9">
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
                <router-link :to="{ name: 'main' }" class="btn btn-primary my-3"
                  >Go to Main Page</router-link
                >
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="row justify-content-center">
      <div class="col-12">
        <div class="card-container mb-3">
          <div class="row g-0 image-row">
            <div class="col-12 col-md-6">
              <div class="content-image-container">
                <div class="image-box">
                  <img
                    src="/assets/main_left.png"
                    class="img-fluid"
                    alt="content image 1"
                    width="500"
                  />
                </div>
              </div>
            </div>
            <div class="col-12 col-md-6">
              <div class="content-image-container">
                <div class="image-box">
                  <img
                    src="/assets/main_right.png"
                    class="img-fluid"
                    alt="content image 2"
                    width="500"
                  />
                </div>
              </div>
            </div>
          </div>
          <div class="card-body text-start ms-3">
            <p class="card-text custom-margin">
              여기에는 새로운 컨텐츠에 대한 설명을 추가하실 수 있습니다.
            </p>
          </div>
        </div>
      </div>
    </div>
  </div> -->
</template>

<script>
export default {
  name: "CommunityEachCharts",
  components: {},
};
</script>

<style scoped>
.container {
  margin: 0 auto;
  max-width: 80%;
}

.card-title {
  margin-top: 1rem;
}

.card-text {
  margin: 1rem 0;
}

.btn {
  margin-bottom: 1rem;
}

.card-container {
  position: relative;
  margin: 20px;
  border: 1px solid #ced4da;
  border-radius: 10px;
}

.card-container::after {
  content: "";
  position: relative;
  left: 10%;
  right: 10%;
  top: calc(50% - 0.5px);
  height: 1px;
  background: #ced4da;
}

.content-image-container {
  padding: 10px 10% 0 10%;
  display: flex;
  justify-content: center;
  align-items: center;
}

.image-box {
  position: relative;
  display: flex;
  justify-content: center;
  align-items: center;
}

.custom-margin {
  margin: 10px 10% 0 10%;
  padding-top: 1rem;
  padding-bottom: 1rem;
}

.image-row {
  position: relative;
}

.image-row > div {
  padding: 0 10px;
}
.image-row {
  margin: 10px 10% 0 10%;
  border-bottom: 1px solid #ced4da;
}

.image-row::after {
  content: "";
  position: absolute;
  left: 50%;
  top: 10%;
  bottom: 10%;
  width: 1px;
  background: #ced4da;
  transform: translateX(-50%);
}
</style>
