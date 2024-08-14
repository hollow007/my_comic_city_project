<template>
  <div id="app">
    <NavBar />
    <HeroSection />
    <ProductGrid title="New Arrivals" :comics="newArrivals" />
    <ProductGrid title="Hot Picks" :comics="hotPicks" />
    <FooterSection />
  </div>
</template>

<script>
import NavBar from './components/NavBar.vue';
import HeroSection from './components/HeroSection.vue';
import ProductGrid from './components/ProductGrid.vue';
import FooterSection from './components/FooterSection.vue';
import { getAllComicBooks } from './services/comicBookService';

export default {
  name: 'App',
  components: {
    NavBar,
    HeroSection,
    ProductGrid,
    FooterSection
  },
  data() {
    return {
      newArrivals: [],
      hotPicks: [],
      loading: true,
      error: null,
    };
  },
  created() {
    this.fetchComicBooks();
  },
  methods: {
    async fetchComicBooks() {
      try {
        const response = await getAllComicBooks();
        const allComics = response.data;

        // Assuming 'newArrivals' and 'hotPicks' are simply the first and second halves of the comics array
        this.newArrivals = allComics.slice(0, 5); // First 5 comics for newArrivals
        this.hotPicks = allComics.slice(5, 10); // Next 5 comics for hotPicks

        this.loading = false;
      } catch (error) {
        this.error = 'Failed to load comic books.';
        this.loading = false;
      }
    }
  }
};
</script>


<style>
/* General styles, global settings */
body {
  margin: 0;
  font-family: 'Roboto', sans-serif;
}
</style>
