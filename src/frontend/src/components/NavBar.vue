<template>
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
      cartItemCount: 0,
      wishListItemCount: 0,
      wishListId: '1',
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
      // Handle theme toggle logic here
    },
  },
};
</script>

<style scoped>
/* Navbar Styles */
.navbar {
  display: flex;
  flex-direction: column;
  background-color: #333;
  color: white;
}

/* Section Divider */
.section-divider {
  margin: 0;
  border: 0;
  border-top: 1px solid #575555;
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
  justify-content: space-between; /* Spacing between logo and icon container */
  align-items: center;
padding:10px 20px;
}

.logo {
  width: 150px; /* Set the width of the logo */
  height: 55px; /* Set the height of the logo */
}

.logo img {
  width: 100%; /* Ensure the image fits the logo container */
  height: auto; /* Maintain aspect ratio */
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

.icon-container {
  display: flex;
  align-items: center;
  gap: 30px;
  position: relative;
}
/* Search Input */
.search-label {
  position: relative;
}

input[type="search"] {
  background-color: white;
  width: 0;
  transition: width 0.4s, border-radius 0.4s;
  border-radius: 50%;
  border: 2px solid transparent;
  outline: none;
  padding: 12px 20px;
  color: white;
  cursor: pointer;
}

input[type="search"]:focus {
  border-radius: 20px;
  width: 500px;
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

/* Bottom Section */
.bottom-section {
  display: flex;
  justify-content: flex-start;
  padding: 1px 20px;
  background-color: #444;
}

.bottom-nav-links {
  display: flex;
  list-style: none;
}

.bottom-nav-links li {
  margin-right: 20px;
}

.bottom-nav-links a {
  color: white;
  text-decoration: none;
  display: flex;
  align-items: center;
}

/* Arrow Icon for Dropdown */
.arrow-icon {
  margin-left: 5px;
  font-size: 0.8rem;
  transition: transform 0.3s;
}

.arrow-icon.rotate {
  transform: rotate(180deg);
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
