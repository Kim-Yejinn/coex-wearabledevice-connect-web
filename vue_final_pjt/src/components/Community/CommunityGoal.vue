<template>
  <div class="modal-body">
    <form @submit.prevent="submitGoal">
      <div class="mb-3">
        <label for="goal-select" class="form-label">목표 운동 선택</label>
        <select id="goal-select" class="form-select" v-model="selectedGoal">
          <option disabled value="">운동을 골라주세요</option>
          <option
            v-for="option in options"
            :value="option.value"
            :key="option.value"
          >
            {{ option.text }}
          </option>
        </select>
      </div>
      <div class="mb-3">
        <label for="goal-input" class="form-label"
          >목표 (kcal 단위로 적어주세요)
        </label>
        <input
          id="goal-input"
          type="text"
          class="form-control"
          v-model="goalAmount"
          placeholder="해당 운동의 목표 감량 칼로리"
        />
      </div>
      <button type="submit" class="btn btn-primary">목표 세우기</button>
      <button type="button" class="btn btn-secondary" @click="checkIn">
        출석하기
      </button>
    </form>
  </div>
</template>

<script>
export default {
  name: "CommunityGoal",
};
</script>

<style></style>
