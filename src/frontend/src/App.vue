<template>
  <div id="app">
    <NavBar />
    <HeroSection />
    <ProductGrid title="New Arrivals" :comics="newArrivals" :wishlist="wishlist" @add-to-cart="addToCart"  @toggle-wishlist="toggleWishlist" />
    <ProductGrid title="Hot Picks" :comics="hotPicks" :wishlist="wishlist" @add-to-cart="addToCart"  @toggle-wishlist="toggleWishlist" />
    <FooterSection />
  </div>
</template>

<script>
import NavBar from './components/NavBar.vue';
import HeroSection from './components/HeroSection.vue';
import ProductGrid from './components/ProductGrid.vue';
import FooterSection from './components/FooterSection.vue';
import { getAllComicBooks } from './services/comicBookService';
import {  addBookToCart } from './services/cartService';
import {addBookToWishList} from "@/services/wishlistService";

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
      wishlist:[],
      cartId: '2', // Replace with the actual cart ID
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

        // Split comics between new arrivals and hot picks
        this.newArrivals = allComics.slice(0, 5);
        this.hotPicks = allComics.slice(5, 10);

        this.loading = false;
      } catch (error) {
        this.error = 'Failed to load comic books.';
        this.loading = false;
      }
    },
    async addToCart(sku) {
      try {
        await addBookToCart(this.cartId, sku); // Send the correct SKU to the API
        alert('Comic added to cart!');
      } catch (error) {
        alert('Failed to add comic to cart.');
      }
    },
    async toggleWishlist(sku) {
      try {
        // Call wishlist service to toggle the comic in the wishlist
        const updatedWishlist = await addBookToWishList(1, sku); // Adjust as per your service
        this.wishlist = updatedWishlist.comicBooks; // Update the local wishlist
        alert('Comic added to WishList!');
      } catch (error) {
        alert('Failed to update wishlist.');
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
