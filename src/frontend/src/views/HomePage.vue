<template>
  <div id="home-page">
    <NavBar />
    <HeroSection/>

    <!-- Conditional rendering based on showAll flag -->
    <ProductGrid
        v-if="!showAll"
        title="New Arrivals"
        :comics="newArrivals"
        :wishlist="wishlistItems"
        @add-to-cart="addToCart"
        @toggle-wishlist="toggleWishlist"
    />
    <ProductGrid
        v-if="!showAll"
        title="Hot Picks"
        :comics="hotPicks"
        :wishlist="wishlistItems"
        @add-to-cart="addToCart"
        @toggle-wishlist="toggleWishlist"
    />

    <!-- Shop All Section -->
    <div v-if="showAll" class="shop-all-container">
      <FilterComponent  @filter="handleFilter" />
      <div class="comics-and-pagination">
        <ProductGrid
            title="All Comics"
            :comics="displayedComics"
            :wishlist="wishlistItems"
            @add-to-cart="addToCart"
            @toggle-wishlist="toggleWishlist"
        />

        <PaginationComponent
            :total="totalPages"
            :current-page="currentPage"
            @page-changed="handlePageChange"
        />
      </div>
    </div>

    <FooterSection />
  </div>
</template>

<script>
import NavBar from '@/components/NavBar.vue';
import HeroSection from '@/components/HeroSection.vue';
import ProductGrid from '@/components/ProductGrid.vue';
import FooterSection from '@/components/FooterSection.vue';
import PaginationComponent from '@/components/PaginationComponent.vue';
import FilterComponent from '@/components/FilterComponent.vue';
import { getAllComicBooks } from '@/services/comicBookService';
import { addBookToCart, getCustomerCart } from "@/services/cartService";
import { addBookToWishList, getCustomerWishList } from "@/services/wishlistService";

export default {
  name: 'HomePage',
  components: {
    NavBar,
    HeroSection,
    ProductGrid,
    FooterSection,
    PaginationComponent,
    FilterComponent
  },
  data() {
    return {
      newArrivals: [],
      hotPicks: [],
      allComics: [],
      displayedComics: [],
      wishlistItems: [],
      cartItems: [],
      loading: true,
      error: null,
      showAll: false,
      currentPage: 1,
      itemsPerPage: 20,
      totalPages: 0,
      filters: {
        price: '',
        genre: '',
        releaseDate: '',
        publisher: ''
      }
    };
  },
  created() {
    this.fetchComicBooks();
    // Check for the 'shopAll' query parameter and update showAll flag accordingly
    if (this.$route.query.shopAll) {
      this.showAll = true;
      this.updateDisplayedComics();
    }
  },
  watch: {
    '$route.query.shopAll'(newVal) {
      this.showAll = newVal !== undefined;
      this.updateDisplayedComics();
    }
  },
  methods: {
    async fetchComicBooks() {
      try {
        const response = await getAllComicBooks();
        const allComics = response.data;

        this.newArrivals = allComics.slice(0, 5);
        this.hotPicks = allComics.slice(5, 10);

        this.allComics = allComics;
        this.totalPages = Math.ceil(allComics.length / this.itemsPerPage);
        this.loading = false;

        // Update displayed comics if we're in "Shop All" mode
        if (this.showAll) {
          this.updateDisplayedComics();
        }
      } catch (error) {
        this.error = 'Failed to load comic books.';
        this.loading = false;
      }
    },
    updateDisplayedComics() {
      let filteredComics = this.allComics;

      // Apply filters if any
      if (this.filters.price) {
        filteredComics = filteredComics.filter(comic =>
            this.filters.price === 'low' ? comic.price <= 20 : comic.price > 20
        );
      }
      if (this.filters.genre) {
        filteredComics = filteredComics.filter(comic => comic.genre === this.filters.genre);
      }
      if (this.filters.releaseDate) {
        filteredComics = filteredComics.filter(comic => new Date(comic.releaseDate) >= new Date(this.filters.releaseDate));
      }
      if (this.filters.publisher) {
        filteredComics = filteredComics.filter(comic => comic.publisher === this.filters.publisher);
      }

      const start = (this.currentPage - 1) * this.itemsPerPage;
      const end = start + this.itemsPerPage;
      this.displayedComics = filteredComics.slice(start, end);
      this.totalPages = Math.ceil(filteredComics.length / this.itemsPerPage);
    },
    handleFilter(filters) {
      this.filters = filters;
      this.updateDisplayedComics();
    },
    handlePageChange(newPage) {
      this.currentPage = newPage;
      this.updateDisplayedComics();
    },
    async addToCart(sku) {
      const userEmail = localStorage.getItem('userEmail');

      if (userEmail === null) {
        console.error('No user email found. Please log in.');
        return;
      }

      try {
        const response = await getCustomerCart(userEmail);
        this.cartItems = response.data.comicBooks || [];
        await addBookToCart(response.data.cartId, sku);
        alert('Comic added to cart!');
      } catch (error) {
        alert('Failed to add comic to cart.');
      }
    },
    async toggleWishlist(sku) {
      const userEmail = localStorage.getItem('userEmail');

      if (userEmail === null) {
        console.error('No user email found. Please log in.');
        return;
      }

      try {
        const response = await getCustomerWishList(userEmail);
        this.wishlistItems = response.data.comicBooks || [];
        await addBookToWishList(response.data.wishListId, sku);
        alert('Comic added to WishList!');
      } catch (error) {
        alert('Failed to update wishlist.');
      }
    }
  }
};
</script>

<style scoped>
/* Styles scoped to HomePage */
body {
  margin: 0;
  font-family: 'Roboto', sans-serif;
}

.shop-all-container {
  display: flex;
}



.comics-and-pagination {
  flex: 1; /* Takes the remaining width */
  padding: 10px; /* Adjust padding as needed */
}
</style>
