<template>
  <div class="product-grid">
    <h2>{{ title }}</h2>
    <div class="grid">
      <ComicCard v-for="comic in comics" :key="comic.id" :comic="comic" />
    </div>
  </div>
</template>

<script>
import ComicCard from './ComicCard.vue';

export default {
  name: 'ProductGrid',
  props: ['title', 'comics'],
  components: {
    ComicCard,
  },
};
</script>

<style scoped>
.product-grid {
  margin: 20px;
}
.grid {
  display: flex;
  justify-content: center; /* Centers the items */
  flex-wrap: wrap;
  gap: 10px; /* Adjust this value to control spacing */
}
</style>
