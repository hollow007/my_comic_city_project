<template>
  <div id="home-page">
    <NavBar @search-query="handleSearchQuery"/>
    <HeroSection/>
    <SpinnerComponent :visible="loading"/>

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
      <FilterComponent @filter="handleFilter"/>
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

    <FooterSection/>
  </div>
</template>

<script>
import NavBar from '@/components/NavBar.vue';
import HeroSection from '@/components/HeroSection.vue';
import ProductGrid from '@/components/ProductGrid.vue';
import FooterSection from '@/components/FooterSection.vue';
import PaginationComponent from '@/components/PaginationComponent.vue';
import FilterComponent from '@/components/FilterComponent.vue';
import {
  getAllComicBooks, getBooksByDateInBetween,  getBooksByGenres,
  getBooksByPlublisher,
  getBooksByPriceLessThanEqual,
  searchComicBooksByName
} from '@/services/comicBookService';
import {addBookToCart, getCustomerCart} from "@/services/cartService";
import {addBookToWishList, getCustomerWishList} from "@/services/wishlistService";
import SpinnerComponent from "@/components/SpinnerComponent.vue";
import {jwtDecode} from "jwt-decode";

export default {
  name: 'HomePage',
  components: {
    SpinnerComponent,
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
        releaseDateFrom: '',
        releaseDateTo: '',
        publisher: ''
      }, searchQuery: '',
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

        this.newArrivals = allComics.slice(0, 4);
        this.hotPicks = allComics.slice(4, 8);

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

    async handleSearchQuery(query) {
      this.searchQuery = query;
      console.log(this.searchQuery)
      if (this.searchQuery) {
        try {
          const searchResults = await searchComicBooksByName(this.searchQuery);
          this.allComics = searchResults.data;  // Update allComics to display only search results
          await this.updateDisplayedComics();
        } catch (error) {
          this.error = 'Failed to fetch search results.';
        }
      } else {
        // If searchQuery is empty, refetch all comics
        await this.fetchComicBooks();
      }
    },
    async updateDisplayedComics() {

      let filteredComics = this.allComics;


      if (this.filters.minPrice !== undefined && this.filters.maxPrice !== undefined) {
        this.loading = true
        try {
          const response = await getBooksByPriceLessThanEqual(this.filters.maxPrice);
          console.log(response.data)
          if (response.data != null) {
            filteredComics = response.data
          }

        } catch (error) {
          this.loading = false;
          throw new Error("Error fetching books")
        } finally {
          this.loading = false;
        }


      }
      if (this.filters.genre) {

        try {

          this.loading = true; // Start loading state

          const genres = [this.filters.genre];
          const response = await getBooksByGenres(genres);
          const data = await response.data;

          filteredComics = data;
        } catch (error) {
          this.errorMsg = 'Error fetching data by genres';
          console.error(error);
        } finally {
          this.loading = false; // Stop loading state after fetch completes
        }
      }
      if (this.filters.releaseDateFrom && this.filters.releaseDateTo
      ) {


        const fromDate = this.filters.releaseDateFrom;
        const toDate = this.filters.releaseDateTo;

        try {

          this.loading = true;
          const response = await getBooksByDateInBetween(fromDate,toDate)
          const data1 = await response.data;
          console.log(data1)

          filteredComics = data1;


        } catch (error) {
          this.loading = false;
          console.error(error);
        } finally {
          this.loading = false;
        }

      }

      if (this.filters.publisher) {
        try {
          this.loading = true;

          const response = await getBooksByPlublisher(this.filters.publisher);

          if (response.data == null)
            throw new Error("Error getting boooks")
          else
            filteredComics = response.data;
        } catch (error) {
          console.log(error)
          this.loading = false;
        } finally {
          this.loading = false;
        }
      }

      this.loading = false;

      const start = (this.currentPage - 1) * this.itemsPerPage;
      const end = start + this.itemsPerPage;
      this.displayedComics = filteredComics.slice(start, end);
      this.totalPages = Math.ceil(filteredComics.length / this.itemsPerPage);
    },
    handleFilter(filters) {
      this.filters = filters;
      this.updateDisplayedComics();
    }
    ,
    handlePageChange(newPage) {

      this.currentPage = newPage;
      this.updateDisplayedComics();
    }
    ,
    async addToCart(sku) {
      const token = localStorage.getItem('authToken');
      if (token) {
        const decodedToken = jwtDecode(token);
        this.isAuthenticated = true;


        try {
          const response = await getCustomerCart(decodedToken.sub);
          console .log("Customer cart fetsched for customer ",decodedToken.sub,response.data)
          this.cartItems = response.data.comicBooks || [];
          console.log(response.data.cartId)
          await addBookToCart(response.data.cartId, sku);
          alert('Comic added to cart!');
        } catch (error) {
          alert('Failed to add comic to cart.');
        }
      }
    }
    ,
    async toggleWishlist(sku) {
      const token = localStorage.getItem('authToken');
      if (token) {
        const decodedToken = jwtDecode(token);
        this.isAuthenticated = true;


        try {
          const response = await getCustomerWishList(decodedToken.sub);
          this.wishlistItems = response.data.comicBooks || [];
          await addBookToWishList(response.data.wishListId, sku);
          alert('Comic added to WishList!');
        } catch (error) {
          alert('Failed to update wishlist.');
        }
      }
    }
  }
}
;
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
