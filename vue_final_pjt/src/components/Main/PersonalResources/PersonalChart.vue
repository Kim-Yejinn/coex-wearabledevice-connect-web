<template>
  <div>
    <canvas ref="barChart" id="chart" />
  </div>
</template>

<script>
import { Chart, registerables } from "chart.js";
import { mapState } from "vuex";
Chart.register(...registerables);
let chart1;

export default {
  data: () => ({
    type: "bar",
    data: {
      labels: ["월", "화", "수", "목", "금", "토", "일"],
      datasets: [
        {
          label: "일주일 운동",
          data: [0, 0, 0, 0, 0, 0, 0],
          backgroundColor: [
            "rgba(255, 99, 132, 0.2)",
            "rgba(54, 162, 235, 0.2)",
            "rgba(255, 206, 86, 0.2)",
            "rgba(75, 192, 192, 0.2)",
            "rgba(255, 159, 64, 0.2)",
          ],
          borderColor: [
            "rgba(255, 99, 132, 1)",
            "rgba(54, 162, 235, 1)",
            "rgba(255, 206, 86, 1)",
            "rgba(75, 192, 192, 1)",
            "rgba(255, 159, 64, 1)",
          ],
          borderWidth: 1,
        },
      ],
    },
    options: {
      scales: {
        y: {
          beginAtZero: true,
        },
      },
    },
  }),
  async mounted() {
    this.$nextTick(function () {
      this.createChart();
    });
  },
  computed: {
    ...mapState(["userExerciseList"]),
  },
  methods: {
    createChart() {
      if (chart1 !== undefined) {
        chart1.destroy();
      }
      chart1 = new Chart(this.$refs.barChart, {
        type: "bar",
        data: this.data,
        options: this.options,
      });
      chart1.data.datasets[0].data = this.userExerciseList;
      chart1.update();
    },
  },
  watch: {
    userExerciseList() {
      this.createChart();
    },
    // deep: true,
  },
};
</script>
