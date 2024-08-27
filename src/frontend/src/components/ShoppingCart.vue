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

    <!-- Shopping Cart -->
    <div class="shopping-cart dark-theme">
      <h2>Your Shopping Cart</h2>
      <div v-if="cartItems.length">
        <table class="cart-table">
          <thead>
          <tr>
            <th>Product</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Subtotal</th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="item in cartItems" :key="item.id">
            <td>
              <div class="product-info">
                <img :src="getPhotoUrl(item.photo)" class="product-image" />
                <div class="product-name">{{ item.name }}</div>
              </div>
            </td>
            <td>{{ formatCurrency(item.price) }}</td>
            <td>
              <div class="quantity-controls">
                <button @click="decreaseQuantity(item)">-</button>
                <input type="number" v-model="item.quantity" min="1" class="quantity-input" />
                <button @click="increaseQuantity(item)">+</button>
              </div>
            </td>
            <td>{{ formatCurrency(item.price * item.quantity) }}</td>
          </tr>
          </tbody>
        </table>

        <div class="cart-summary">
          <div class="cart-totals">
            <p><strong>Subtotal:</strong> {{ formatCurrency(cartTotal) }}</p>
            <p><strong>Shipping:</strong></p>
            <div>
              <label><input type="radio" value="Collection" v-model="shippingOption"> Collection from Comic Warehouse Bedfordview Johannesburg</label><br>
              <label><input type="radio" value="Courier" v-model="shippingOption"> Nationwide Courier: R149.00</label>
            </div>
            <p><strong>Total:</strong> {{ formatCurrency(cartTotal + shippingCost) }}</p>
          </div>
          <div class="cart-actions">
            <button class="checkout-button">Checkout</button>
          </div>
        </div>
      </div>
      <div v-else>
        <p>Your cart is empty.</p>
      </div>
    </div>
  </div>
</template>

<script>
import { getCart } from "@/services/cartService";
import CartSummary from './CartSummary.vue';
import WishlistSummary from './WishlistSummary.vue';

export default {
  components: {
    CartSummary,
    WishlistSummary
  },
  data() {
    return {
      cartItems: [],
      shippingOption: 'Collection',
      shippingCost: 0,
      isCartVisible: false,
      isWishlistVisible: false,
      cartItemCount: 0,
      wishListItemCount: 0,
      wishListId: '1',
      themeClass: 'dark-theme'
    };
  },
  computed: {
    cartTotal() {
      return this.cartItems.reduce((total, item) => total + (item.price * item.quantity), 0);
    },
    totalWithShipping() {
      return this.cartTotal + this.shippingCost;
    }
  },
  watch: {
    shippingOption(newVal) {
      this.shippingCost = newVal === 'Courier' ? 149 : 0;
    }
  },
  methods: {
    formatCurrency(amount) {
      return 'R ' + amount.toFixed(2);
    },
    async fetchCart() {
      try {
        const response = await getCart(2);
        const cartData = response.data || { comicBooks: [] };
        this.cartItems = cartData.comicBooks.map(item => ({
          ...item,
          quantity: 1,
        }));
      } catch (error) {
        console.error("Error fetching cart:", error);
      }
    },
    increaseQuantity(item) {
      item.quantity++;
    },
    decreaseQuantity(item) {
      if (item.quantity > 1) {
        item.quantity--;
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
    },
  },
  created() {
    this.fetchCart();
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

/* Shopping Cart Styles */
.shopping-cart {
  padding: 20px;
  background-color: #2c2c2c; /* Darker background for contrast */
  color: #f0f0f0; /* Lighter text color for readability */
  max-width: 1000px;
  margin: 0 auto;
  border-radius: 8px;
  margin-top: 120px;
}

.cart-table {
  width: 100%;
  margin-bottom: 20px;
  border-collapse: collapse;
}

.cart-table th, .cart-table td {
  padding: 15px;
  border-bottom: 1px solid #444; /* Darker border for table rows */
  text-align: left;
}

.product-info {
  display: flex;
  align-items: center;
}

.product-image {
  width: 70px;
  height: 100px;
  margin-right: 10px;
}

.quantity-controls {
  display: flex;
  align-items: center;
}

.quantity-controls button {
  background-color: #ff5722; /* Orange button background */
  color: white;
  border: none;
  padding: 5px;
  cursor: pointer;
}

.quantity-controls input {
  width: 50px;
  text-align: center;
  margin: 0 5px;
}

.cart-summary {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.cart-totals p {
  margin: 10px 0;
}

.checkout-button {
  background-color: #ff5722; /* Orange button background */
  color: white;
  padding: 10px 20px;
  border: none;
  cursor: pointer;
  font-size: 1rem;
}

.checkout-button:hover {
  background-color: #e64a19; /* Darker orange for hover effect */
}

/* Dark Theme Adjustments */
.dark-theme .shopping-cart {
  background-color: #1b1b1b;
  color: white;
}

.dark-theme .quantity-controls button,
.dark-theme .checkout-button {
  background-color: #ff5722;
}

.dark-theme .quantity-controls button:hover,
.dark-theme .checkout-button:hover {
  background-color: #e64a19;
}

.dark-theme .cart-table th,
.dark-theme .cart-table td {
  border-bottom: 1px solid #333;
}

.dark-theme .cart-summary {
  color: #f0f0f0;
}

.dark-theme {
  background-color: #1b1b1b;
  color: white;
}

.dark-theme .navbar {
  background-color: #333;
  color: white;
}

.dark-theme .top-section {
  background-color: #444;
}

.dark-theme .middle-section {
  background-color: #333;
}

.dark-theme .bottom-section {
  background-color: #444;
}
</style>
