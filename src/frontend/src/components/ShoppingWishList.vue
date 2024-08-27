<template>
  <div :class="themeClass">
    <!-- Navbar -->
    <nav class="navbar">
      <!-- Top Section -->
      <div class="top-section">
        <div class="left-side">
          <font-awesome-icon icon="facebook" class="icon social-icon" />
          <font-awesome-icon icon="instagram" class="icon social-icon" />
          <span class="slogan">Best Comic Store in Town</span>
        </div>
        <div class="right-side">
          <a href="#">About Us</a>
          <a href="#">Contact Us</a>
        </div>
      </div>

      <!-- Horizontal Line -->
      <hr class="section-divider" />

      <!-- Middle Section -->
      <div class="middle-section">
        <div class="logo">
          <img :src="require('@/assets/Designer.png')" alt="Comicity Logo" />
        </div>

        <div class="icon-container">
          <div class="search-container">
            <input type="search" id="search-input" placeholder="Search..." />
            <font-awesome-icon icon="search" class="icon1" />
          </div>

          <!-- Cart Icon Wrapper -->
          <div class="relative cart-icon-wrapper" @mouseenter="showCart" @mouseleave="hideCart">
            <font-awesome-icon icon="shopping-cart" class="icon cart-icon" />
            <div class="cart-badge">{{ cartItemCount }}</div>
            <CartSummary v-if="isCartVisible" @update-cart-count="updateCartCount" />
          </div>

          <!-- Wishlist Icon Wrapper -->
          <div class="relative wishlist-icon-wrapper" @mouseenter="showWishlist" @mouseleave="hideWishlist">
            <font-awesome-icon icon="heart" class="icon wishlist-icon" />
            <div class="cart-badge">{{ wishListItemCount }}</div>
            <WishlistSummary v-if="isWishlistVisible" @update-wishList-count="updateWishListCount" :wishListId="wishListId" />
          </div>

          <font-awesome-icon icon="user" class="icon" />
          <font-awesome-icon icon="sun" class="icon" @click="toggleTheme" />
        </div>
      </div>

      <!-- Horizontal Line -->
      <hr class="section-divider" />

      <!-- Bottom Section -->
      <div class="bottom-section">
        <ul class="bottom-nav-links">
          <li><a href="#">Home <font-awesome-icon icon="faChevronUp" class="icon arrow-icon" /></a></li>
          <li><a href="#">Link 1 <font-awesome-icon icon="faChevronUp" class="icon arrow-icon" /></a></li>
          <li><a href="#">Link 2 <font-awesome-icon icon="faChevronUp" class="icon arrow-icon" /></a></li>
          <li><a href="#">Link 3 <font-awesome-icon icon="faChevronUp" class="icon arrow-icon" /></a></li>
        </ul>
      </div>
      <hr class="section-divider" />
    </nav>

    <!-- Wishlist -->
    <div class="wishlist">
      <h2>Your Wishlist</h2>
      <div v-if="wishlistItems.length">
        <table class="wishlist-table">
          <thead>
          <tr>
            <th>Product</th>
            <th>Price</th>
            <th>In Stock</th>
            <th>Action</th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="item in wishlistItems" :key="item.id">
            <td>
              <div class="product-info">
                <img :src="getPhotoUrl(item.photo)" class="product-image" />
                <div class="product-name">{{ item.name }}</div>
              </div>
            </td>
            <td>{{ formatCurrency(item.price) }}</td>
            <td>{{ item.inStock ? 'Yes' : 'No' }}</td>
            <td>
              <button @click="removeFromWishlist(item)">Remove</button>
              <button
                  :disabled="!item.inStock"
                  @click="addToCart(item)"
              >
                Add to Cart
              </button>
            </td>
          </tr>
          </tbody>
        </table>
      </div>
      <div v-else>
        <p>Your wishlist is empty.</p>
      </div>
    </div>
  </div>
</template>

<script>
import { getWishList } from "@/services/wishlistService";
import { addToCartService } from "@/services/cartService";
import CartSummary from './CartSummary.vue';
import WishlistSummary from './WishlistSummary.vue';

export default {
  components: {
    CartSummary,
    WishlistSummary
  },
  data() {
    return {
      wishlistItems: [],
      cartItemCount: 0,
      wishListItemCount: 0,
      wishListId: '1',
      isCartVisible: false,
      isWishlistVisible: false,
      themeClass: 'dark-theme'
    };
  },
  methods: {
    formatCurrency(amount) {
      return 'R ' + amount.toFixed(2);
    },
    async fetchWishlist() {
      try {
        const response = await getWishList(2);
        const wishList = response.data;

        if (wishList.comicBooks.length > 0) {
          const randomIndex = Math.floor(Math.random() * wishList.comicBooks.length);
          wishList.comicBooks.forEach((item, index) => {
            item.inStock = index === randomIndex;
          });
        }

        this.wishlistItems = wishList.comicBooks;
      } catch (error) {
        console.error("Error fetching wishlist:", error);
      }
    },
    removeFromWishlist(item) {
      this.wishlistItems = this.wishlistItems.filter(wishlistItem => wishlistItem.id !== item.id);
    },
    async addToCart(item) {
      try {
        await addToCartService(item.id);
        alert(`${item.name} has been added to your cart!`);
      } catch (error) {
        console.error("Error adding item to cart:", error);
        alert("There was a problem adding the item to your cart.");
      }
    },
    getPhotoUrl(photo) {
      return `data:image/jpeg;base64,${photo}`;
    },
    showCart() {
      this.isCartVisible = true;
    },
    hideCart() {
      this.isCartVisible = false;
    },
    showWishlist() {
      this.isWishlistVisible = true;
    },
    hideWishlist() {
      this.isWishlistVisible = false;
    },
    updateCartCount(count) {
      this.cartItemCount = count;
    },
    updateWishListCount(count) {
      this.wishListItemCount = count;
    },
    toggleTheme() {
      this.themeClass = this.themeClass === 'dark-theme' ? 'light-theme' : 'dark-theme';
    }
  },
  created() {
    this.fetchWishlist();
  }
};
</script>

<style scoped>
/* Navbar Styles */
.navbar {
  display: flex;
  flex-direction: column;
  background-color: #333;
  color: white;
  position: fixed; /* Fix the navbar at the top */
  top: 0;
  width: 100%;
  z-index: 1000; /* Ensure it stays above other content */
}

.navbar .section-divider {
  margin: 0;
  border: 0;
  border-top: 1px solid #575555;
}

/* Ensure content below the navbar starts after the navbar height */
body {
  margin: 0;
  padding-top: 80px; /* Adjust this value based on your navbar height */
}

/* Top Section */
.top-section {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 5px 20px;
  background-color: #444;
  font-size: 0.9rem;
}

.left-side {
  display: flex;
  align-items: center;
  gap: 10px;
}

.slogan {
  margin-left: 10px;
}

.right-side a {
  color: white;
  margin-left: 15px;
  text-decoration: none;
}

/* Social Icons */
.social-icon {
  font-size: 1.2rem;
  cursor: pointer;
}

.social-icon:hover {
  color: #888;
}

/* Middle Section */
.middle-section {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 10px 20px;
}

.logo {
  width: 150px;
  height: 55px;
}

.logo img {
  width: 100%;
  height: auto;
}

.icon-container {
  display: flex;
  align-items: center;
  gap: 30px;
  position: relative;
}

/* Improved Search Input Styles */
.search-container {
  position: relative;
}

#search-input {
  background-color: white;
  width: 0;
  transition: width 0.4s, border-radius 0.4s;
  border-radius: 50%;
  border: 2px solid transparent;
  outline: none;
  padding: 12px 20px;
  color: white;
  cursor: pointer;/* Adjust font size */
}

#search-input:focus {
  border-radius: 20px;
  width: 500px;
  color: black;
}

.icon1 {
  color: #333;
  position: absolute;
  right: 10px;
  top: 50%;
  transform: translateY(-50%);
  font-size: 1rem;
  transition: opacity 0.4s;
}

#search-input:focus + .icon1 {
  opacity: 0;
}

/* Cart & Wishlist Icon Styles */
.cart-icon-wrapper, .wishlist-icon-wrapper {
  position: relative;
}

.cart-badge {
  background-color: red;
  color: white;
  border-radius: 50%;
  padding: 5px 10px;
  position: absolute;
  top: -10px;
  right: -10px;
  font-size: 0.8rem;
}

.icon {
  font-size: 1.5rem;
  cursor: pointer;
}

/* Bottom Section */
.bottom-section {
  padding: 10px 20px;
}

.bottom-nav-links {
  list-style: none;
  display: flex;
  gap: 30px;
  margin: 0;
  padding: 0;
}

.bottom-nav-links a {
  color: white;
  text-decoration: none;
}

.arrow-icon {
  margin-left: 5px;
}

/* Wishlist Styles */
.wishlist {
  padding: 150px;
  background: linear-gradient(135deg, #1e1e1e, #3d0d0d); /* Dark gradient background */
  border-radius: 12px;
  box-shadow: 0 8px 16px rgba(0, 0, 0, 0.6);
  max-width: 1200px;
  margin: 20px auto;
  color: #f5f5f5; /* Light text color */
}

/* Heading */
h2 {
  font-size: 30px;
  color: #ff5722; /* Bright fire-orange color */
  margin-bottom: 20px;
  font-family: 'Roboto', sans-serif;
  font-weight: bold;
}

/* Table Styles */
.wishlist-table {
  width: 100%;
  border-collapse: collapse;
  margin-bottom: 20px;
}

.wishlist-table th {
  background: #212121; /* Dark background for headers */
  padding: 15px;
  font-weight: bold;
  color: #ff5722; /* Fire-orange color */
  border-bottom: 2px solid #ff5722; /* Fire-orange border */
}

.wishlist-table td {
  padding: 15px;
  border-bottom: 1px solid #333; /* Darker border color */
  vertical-align: middle;
}

/* Product Info Styles */
.product-info {
  display: flex;
  align-items: center;
}

.product-image {
  width: 100px;
  height: 100px;
  margin-right: 15px;
  border-radius: 8px;
  object-fit: cover;
  border: 3px solid #ff5722; /* Fire-orange border around image */
}

.product-name {
  font-size: 20px;
  color: #ff5722; /* Fire-orange color */
  font-weight: 500;
  max-width: 320px;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}

/* Button Styles */
button {
  background: #ff5722; /* Fire-orange background */
  color: white;
  padding: 10px 20px;
  border: none;
  border-radius: 6px;
  cursor: pointer;
  margin-right: 10px;
  font-size: 18px;
  transition: background-color 0.3s;
}

button:hover {
  background: #e64a19; /* Darker fire-orange on hover */
}

button:disabled {
  background-color: #777;
  cursor: not-allowed;
}

/* Empty Wishlist Message */
p {
  font-size: 18px;
  color: #f5f5f5;
}

/* Dark Theme */
.dark-theme .wishlist {
  background: linear-gradient(135deg, #1b1b1b, #2c2c2c); /* Darker gradient for dark theme */
}

.dark-theme .wishlist-table th,
.dark-theme .wishlist-table td {
  border-bottom: 1px solid #333;
}

.dark-theme .product-info .product-name {
  color: #ff5722;
}

.dark-theme .wishlist-table td button {
  background-color: #ff5722;
}

.dark-theme .wishlist-table td button:hover {
  background-color: #e64a19;
}
</style>
