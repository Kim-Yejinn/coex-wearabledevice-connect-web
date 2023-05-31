<template>
  <div class="community-users">
    <div class="user-grid">
      <div v-for="user in users" :key="user.test">
        <div class="user-block">
          <div class="chart-container">
            <!-- <canvas ref="chart1"></canvas> -->
            {{ user }}
            <community-each-charts></community-each-charts>
            <b-progress
              :value="25"
              variant="success"
              striped
              :animated="animate"
            ></b-progress>
          </div>
        </div>
      </div>
      <!-- <div class="user-block">
        <div class="chart-container">
          여긴 유저 2
          <canvas ref="chart2"></canvas>
        </div>
      </div>
      <div class="user-block">
        <div class="chart-container">
          여긴 유저 3
          <canvas ref="chart3"></canvas>
        </div>
      </div>
      <div class="user-block">
        <div class="chart-container">
          여긴 유저 4
          <canvas ref="chart4"></canvas>
        </div>
      </div> -->
    </div>
  </div>
</template>

<script>
import Chart from "chart.js";
import CommunityEachCharts from "./CommunityEachCharts.vue";

export default {
  name: "CommunityUsers",
  data() {
    return {
      users: { test: "유저1", test2: "유저2", test3: "유저3", test4: "유저4" },
    };
  },
  components: {
    CommunityEachCharts,
  },
  mounted() {
    this.createPieChart("chart1");
    this.createPieChart("chart2");
    this.createPieChart("chart3");
    this.createPieChart("chart4");
  },
  methods: {
    createPieChart(ref) {
      const ctx = this.$refs[ref].getContext("2d");
      new Chart(ctx, {
        type: "pie",
        data: {
          labels: ["Label 1", "Label 2", "Label 3"],
          datasets: [
            {
              data: [30, 40, 30],
              backgroundColor: ["#ff6384", "#36a2eb", "#ffce56"],
              borderWidth: 0,
            },
          ],
        },
        options: {
          responsive: true,
          maintainAspectRatio: false,
        },
      });
    },
  },
};
</script>

<style scoped>
.community-users {
  display: flex;
  justify-content: center;
  margin-top: 20px;
}

.user-grid {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  grid-gap: 20px;
  border-radius: 10px;
  overflow: hidden;
}

.user-block {
  background-color: #f5f5f5;
  border: 1px solid #ddd;
  border-radius: 10px;
  padding: 20px;
}

.chart-container {
  width: 100%;
  height: 200px;
}
</style>
