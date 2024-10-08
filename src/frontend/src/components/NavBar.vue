<template>
  <div class="no-bootstrap-affect">
  <nav class="navbarr">
    <!-- Top Section -->
    <div class="top-section">
      <div class="left-side">
        <font-awesome-icon icon="facebook" class="icon social-icon"/>
        <font-awesome-icon icon="instagram" class="icon social-icon"/>
        <span class="slogan">Best Comic Store in Town</span>
      </div>
      <div class="right-side">
        <a href="#">About Us</a>
        <a href="#">Contact Us</a>
      </div>
    </div>

    <!-- Horizontal Line -->
    <hr class="section-divider"/>

    <!-- Middle Section -->
    <div class="middle-section">
      <div class="logo">
        <router-link to='/'>
          <img :src="require('@/assets/Designer.png')" alt="Comicity Logo"/>
        </router-link>
      </div>

      <div class="icon-container">
        <label for="search-input" class="search-label">
          <input type="search" id="search-input" placeholder="Search..."  @input="handleSearchInput"/>
          <font-awesome-icon icon="search" class="icon1"/>
        </label>

        <!-- Cart Icon Wrapper -->
        <div class="relative cart-icon-wrapper" @click="showCart" @mouseenter="showCart" @mouseleave="hideCart">
          <font-awesome-icon icon="shopping-cart" class="icon cart-icon"/>
          <div class="cart-badge">{{ cartItemCount }}</div>
          <CartSummary v-if="isCartVisible" @update-cart-count="updateCartCount"/>
        </div>

        <!-- Wishlist Icon Wrapper -->
        <div class="relative wishlist-icon-wrapper" @click="showWishlist" @mouseenter="showWishlist" @mouseleave="hideWishlist">
          <font-awesome-icon icon="heart" class="icon wishlist-icon"/>
          <div class="cart-badge">{{ wishListItemCount }}</div>
          <WishlistSummary v-if="isWishlistVisible" @update-wishList-count="updateWishListCount"
                           :wishListId="wishListId"/>
        </div>

        <!-- Conditionally Render User Icon or Login | Sign Up -->
        <div v-if="isAuthenticated">
          <div class="user-info" @click.stop="toggleDropdown">
            <font-awesome-icon icon="user" class="icon"/>
            <span class="user-name">{{ userName }}</span>

            <div v-if="isDropdownVisible" class="dropdown-menu">
              <ul>
                <li><a href="#">Inbox</a></li>
                <li><a href="#">Account</a></li>
                <li><a href="#">Help</a></li>
                <li><a href="#" @click="logout">Logout</a></li>
              </ul>
            </div>
          </div>
        </div>

        <div v-else class="auth-links">
          <button @click="goToLogin" class="nav-button">Login</button>
          <span>|</span>
          <button @click="goToSignup" class="nav-button">Sign Up</button>
        </div>

        <font-awesome-icon icon="sun" class="icon" @click="toggleTheme"/>
      </div>
    </div>

    <!-- Horizontal Line -->
    <hr class="section-divider"/>

    <!-- Bottom Section -->
    <div class="bottom-section">
      <ul class="bottom-nav-links">
        <router-link to="/">
          <li><a href="#">Home
            <font-awesome-icon icon="chevron-up" class="icon arrow-icon"/>
          </a></li>
        </router-link>
        <li><a href="#">Shop by genre

          <font-awesome-icon icon="chevron-up" class="icon arrow-icon"/>
        </a></li>
        <li><a href="#">Shop by publisher
          <font-awesome-icon icon="chevron-up" class="icon arrow-icon"/>
        </a></li>
        <li><a href="#" @click.prevent="navigateToShopAll">Shop all
          <font-awesome-icon icon="chevron-up" class="icon arrow-icon"/>
        </a></li>
      </ul>
    </div>
    <hr class="section-divider"/>
  </nav>
  </div>
</template>

<script>
import CartSummary from './CartSummary.vue';
import WishlistSummary from './WishlistSummary.vue';

export default {
  name: 'NavBar',

  components: {
    CartSummary,
    WishlistSummary,
  },


  data() {
    return {
      isCartVisible: false,
      isWishlistVisible: false,
      cartItemCount: 0,
      wishListItemCount: 0,
      isAuthenticated: false,
      userName: '',
      isDropdownVisible: false,
    };
  },

  created() {
    this.checkAuthStatus();
  },

  methods: {
    handleSearchInput(event) {
      this.$emit('search-query', event.target.value);
    },
    toggleDropdown() {
      this.isDropdownVisible = !this.isDropdownVisible;
    },
    handleOutsideClick(event) {
      const profileElement = this.$refs.userProfile;
      if (profileElement && !profileElement.contains(event.target)) {
        this.isDropdownVisible = false;
      }
    },
    checkAuthStatus() {
      const userEmail = localStorage.getItem('userEmail');
      if (userEmail) {
        this.isAuthenticated = true;
        fetch(`/api/comiccity/Customer/getByEmail/${userEmail}`, {
          method: 'GET',
          headers: {
            'Content-Type': 'application/json',
          }
        })
            .then(response => {
              if (!response.ok) {
                throw new Error('Failed to fetch user details');
              }
              return response.json();
            })
            .then(data => {
              this.userName = data.name.firstName;
            })
            .catch(error => {
              console.error('Error fetching user details:', error);
            });
      }
    },
    logout() {
      const isConfirmed = confirm('Are you sure you want to Logout?');
      if (isConfirmed) {
        this.updateWishListCount(0);
        this.updateCartCount(0);
        localStorage.removeItem('userEmail');
        this.isAuthenticated = false;
        this.userName = '';
        this.$router.push('/');
      }
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
      // Handle theme toggle logic here
    },
    goToLogin() {
      this.$router.push('/login');
    },
    goToSignup() {
      this.$router.push('/signUp');
    },
    navigateToShopAll() {
      // Navigate to the HomePage and trigger the shop all view
      this.$router.push({ path: '/', query: { shopAll: true } });
    }
  },

  beforeUnmount() {
    document.removeEventListener('click', this.handleOutsideClick);
  },
};
</script>
<style scoped>

.user-info {
  display: flex;
  align-items: center;
  gap: 5px; /* Adjust this value to control the spacing */
}

.user-name {
  font-size: 16px;
  color: white;
}


/* Navbar Styles */
.navbarr {
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
  padding: 10px 20px;
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
  position: relative; /* For positioning the underline */
}

.bottom-nav-links a {
  color: #e0dbdb;
  text-decoration: none;
  display: flex;
  align-items: center;
  position: relative;
  padding-bottom: 5px; /* Add padding to accommodate the underline */
}

/* Hover effect for links */
.bottom-nav-links a:hover {
  color: white; /* Change the link color on hover */
  font-weight: bold;
}

.bottom-nav-links a::after {
  content: '';
  position: absolute;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 2px; /* Thickness of the underline */
  background-color: transparent; /* Default to transparent */
  transition: background-color 0.3s; /* Smooth transition for the underline */
}

/* Show red underline on hover */
.bottom-nav-links a:hover::after {
  background-color: #ff0000; /* Red underline on hover */
}
/* Arrow Icon for Dropdown */
.arrow-icon {
  margin-left: 5px;
  font-size: 0.5rem;
  transition: transform 0.3s;
}


.bottom-nav-links li:hover .arrow-icon {
  transform: rotate(180deg); /* Rotate the icon */
}

/* Mobile responsiveness */
@media (max-width: 768px) {
  .navbarr {
    flex-direction: column;
    align-items: flex-start;
  }
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

/* Auth Links Styles */
.auth-links {
  display: flex;
  align-items: center;
}

.nav-button {
  background: none;
  border: none;
  color: white;
  cursor: pointer;
  font-size: 16px;
  margin-left: 8px;
}

.nav-button:hover {
  text-decoration: none;
  color: #868080;
}

/* User Info Styles */
.user-info {
  display: flex;
  align-items: center;
}

.user-name {
  margin-left: 10px;
  font-size: 16px;
}
.dropdown-menu {
  position: absolute;
  top: 100%;
  right: 0;
  background-color: white;
  border: 1px solid #ddd;
  border-radius: 4px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
  width: 400px; /* Adjust width as needed */
  z-index: 1000;
  display: block; /* For debugging, ensure the dropdown is visible */
}

.dropdown-menu ul {
  list-style-type: none;
  padding: 0;
  margin: 0;
}


.dropdown-menu li {
  border-bottom: 1px solid #ddd;
}



.dropdown-menu li:last-child {
  border-bottom: none;
}

.dropdown-menu a {
  display: block;
  padding: 14px;
  text-decoration: none;
  color: #333;
}

.dropdown-menu a:hover {
  background-color: #f0f0f0;
  color: darkred;
  font-weight: bold;
}

</style>