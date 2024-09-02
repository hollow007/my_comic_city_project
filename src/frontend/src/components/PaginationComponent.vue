<template>
  <div class="pagination">
    <button
        v-for="page in total"
        :key="page"
        :class="['page-button', { active: page === currentPage }]"
        @click="changePage(page)"
    >
      {{ page }}
    </button>
  </div>
</template>

<script>
export default {
  name: 'PaginationComponent',
  props: {
    total: Number,
    currentPage: Number
  },
  methods: {
    changePage(page) {
      this.$emit('page-changed', page);
    }
  }
};
</script>

<style scoped>
.pagination {
  display: flex;
  justify-content: center;
  margin-top: 20px;
}

.page-button {
  margin: 0 5px;
  padding: 10px 15px;
  cursor: pointer;
  border: none;
  background-color: #f0f0f0;
  border-radius: 4px;
}

.page-button.active {
  background-color: #007bff;
  color: white;
}
</style>
