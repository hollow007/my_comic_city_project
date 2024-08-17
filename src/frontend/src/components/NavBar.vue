<template>
  <nav class="navbar">
    <div class="logo">COMICITY</div>
    <ul class="nav-links">
      <li><a href="#">Franchises</a></li>
      <li><a href="#">Graphic Novels</a></li>
      <li><a href="#">Manga</a></li>
      <li><a href="#">More</a></li>
    </ul>

    <div class="icon-container">
      <label for="search-input" class="search-label">
        <input type="search" id="search-input" placeholder="Search..." />
        <font-awesome-icon icon="search" class="icon1" />
      </label>

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
  </nav>
</template>

<script>
import CartSummary from './CartSummary.vue';
import WishlistSummary from './WishlistSummary.vue';

export default {
  name: 'NavBar',
  components: {
    CartSummary,
    WishlistSummary
  },
  data() {
    return {
      isCartVisible: false,
      isWishlistVisible: false,
      cartItemCount: 0, // Initialize with a default value of 0
      wishListItemCount:0,
      wishListId: '1', // Replace with actual user ID
    };
  },
  methods: {
    showCart() {
      this.isCartVisible = true;
    },
    hideCart() {
      this.isCartVisible = false;
    },
    showWishlist() {
      console.log('Wishlist hovered');
      this.isWishlistVisible = true;
    },
    hideWishlist() {
      console.log('Wishlist hover exited');
      this.isWishlistVisible = false;
    },
    updateCartCount(count) {
      this.cartItemCount = count; // Update cart item count
    },
    updateWishListCount(count) {
      this.wishListItemCount = count; // Update cart item count
    },
    toggleTheme() {
      // Handle theme toggle logic here
    },
  },
};
</script>

<style scoped>
/* Navbar Styles */
.navbar {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 10px 20px;
  background-color: #333;
  color: white;
}

.logo {
  font-size: 1.5rem;
  font-weight: bold;
}

.nav-links {
  display: flex;
  list-style: none;
}

.nav-links li {
  margin: 0 15px;
}

.nav-links a {
  color: white;
  text-decoration: none;
}

/* Icon Container */
.icon-container {
  display: flex;
  align-items: center;
  gap: 15px;
  position: relative;
}

/* Search Input */
.search-label {
  position: relative;
}

input[type="search"] {
  background-color: #dddddd;
  width: 0;
  transition: width 0.4s, border-radius 0.4s;
  border-radius: 50%;
  border: 2px solid transparent;
  outline: none;
  padding: 12px 20px;
  color: #dddddd;
  cursor: pointer;
}

input[type="search"]:focus {
  border-radius: 20px;
  width: 200px;
  color: black;
}

/* Icon Styles */
.icon1 {
  color: #333;
  position: absolute;
  right: 10px;
  top: 50%;
  transform: translateY(-50%);
  font-size: 1rem;
  transition: opacity 0.4s;
}

input[type="search"]:focus + .icon1 {
  opacity: 0;
}

.icon {
  color: white;
  font-size: 1.5rem;
  cursor: pointer;
}

.icon:hover {
  color: #888;
}

/* Cart Badge Styles */
.cart-badge {
  position: absolute;
  top: -14px;
  right: -14px;
  background-color: #d79007;
  color: white;
  border-radius: 50%;
  width: 20px;
  height: 20px;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 12px;
  font-weight: bold;
}

/* Cart & Wishlist Icon Wrappers */
.cart-icon-wrapper,
.wishlist-icon-wrapper {
  position: relative;
}

/* Mobile responsiveness */
@media (max-width: 768px) {
  .navbar {
    flex-direction: column;
    align-items: flex-start;
  }

  .nav-links {
    flex-direction: column;
    margin-top: 10px;
  }

  .nav-links li {
    margin: 5px 0;
  }

  .icon-container {
    margin-top: 10px;
  }
}
</style>
