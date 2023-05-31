<template>
  <div class="home container mt-5">
    <div class="row justify-content-center">
      <div class="col-12">
        <div class="card-container mb-3">
          <div class="row g-0 image-row">
            <div class="col-12 col-md-6">
              <div class="content-image-container">
                <div class="image-box">
                  <img
                    v-if="videoThumbnail"
                    :src="videoThumbnail"
                    class="img-fluid"
                    alt="content image 1"
                    width="500"
                  />
                  <div v-else class="loading-spinner"></div>
                </div>
              </div>
            </div>
            <div class="col-12 col-md-6">
              <div></div>
            </div>
          </div>
          <div class="card-body text-start ms-3">
            <p class="card-text custom-margin">
              {{ videoTitle }}
            </p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      animate: true,
      videoThumbnail: null,
      videoTitle: "",
    };
  },
  name: "YoutubeVideos",
  components: {},
  datasets: [
    {
      data: [10, 20, 30],
    },
  ],

  mounted() {
    this.fetchVideoData();
  },

  methods: {
    async fetchVideoData() {
      try {
        const apiKey = "YOUR_YOUTUBE_API_KEY";
        const videoId = "YOUR_VIDEO_ID";

        const response = await axios.get(
          `https://www.googleapis.com/youtube/v3/videos?part=snippet&id=${videoId}&key=${apiKey}`
        );

        const videoData = response.data.items[0].snippet;
        this.videoThumbnail = videoData.thumbnails.medium.url;
        this.videoTitle = videoData.title;
      } catch (error) {
        console.error(error);
      }
    },
  },
};
</script>

<style scoped>
/* .container {
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
} */

.loading-spinner {
  width: 50px;
  height: 50px;
  border: 5px solid #f3f3f3;
  border-top-color: #3498db;
  border-radius: 50%;
  animation: spin 1s linear infinite;
  margin: 10px;
}

@keyframes spin {
  0% {
    transform: rotate(0deg);
  }
  100% {
    transform: rotate(360deg);
  }
}
</style>
