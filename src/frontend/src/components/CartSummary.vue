<template>
  <div class="cart-summary" v-if="cartItems.length">
    <h2>Cart</h2>
    <div v-for="item in cartItems" :key="item.sku" class="cart-item">
      <!-- Remove Button -->
      <div class="remove-item" @click="removeItem(item.sku)">×</div>

      <!-- Item Image -->
      <div
          class="cart-item-image"
          :style="{ backgroundImage: `url(${getPhotoUrl(item.photo)})` }"
      ></div>

      <!-- Item Details -->
      <div class="cart-item-details">
        <p class="text-base">{{ item.name }}</p>
        <p class="text-sm">{{ item.price }} • {{ item.quantity }}</p>
      </div>
    </div>
    <div class="cart-footer">
      <div>
        <p class="text-sm">Total: R{{ cartTotal }}</p>
        <p class="text-sm">Items: {{ cartItems.length }}</p>
      </div>
      <div class="cart-footer-actions">
        <a href="#" class="view-cart">View Cart</a>
        <button class="checkout">Checkout</button>
      </div>
    </div>
  </div>
</template>

<script>
import {getCart, updateCart} from "@/services/cartService";
export default {
  name: 'CartSummary',
  props: {
    cartId: {
      type: String,
      required: true
    }
  },
  data() {
    return {
      cartItems: [],
      cartTotal: 0,
    };
  },
  async mounted() {
      try {
        const response = await getCart(2);
        const cartData = response.data;

        this.cartItems = cartData.comicBooks;
        this.cart = cartData;
        this.cartTotal = this.cartItems.reduce((total, item) => total + item.price, 0);

        // Emit the cart item count to the parent component
        this.$emit('update-cart-count', this.cartItems.length);
      } catch (error) {
        console.error('Error fetching cart items:', error);
      }
    },
    async removeItem(sku) {
      const isConfirmed = confirm('Are you sure you want to remove this item from the cart?');
      if (isConfirmed) {
        const itemIndex = this.cartItems.findIndex(item => item.sku === sku);
        if (itemIndex > -1) {
          this.cartItems.splice(itemIndex, 1);
          this.cartTotal = this.cartItems.reduce((total, item) => total + item.price, 0);
          this.cart.comicBooks = this.cartItems;
          this.cart.updatedDate = new Date().toISOString().split('T')[0];

          try {
            await updateCart(this.cart);
            this.$emit('update-cart-count', this.cartItems.length); // Emit updated cart count
          } catch (error) {
            console.error('Error updating cart:', error);
          }
        }
      }
    },
    getPhotoUrl(photo) {
      return `data:image/jpeg;base64,${photo}`;
    },
  }
};
</script>


<style scoped>
/* Cart Summary styles */
.cart-summary {
  display: block;
  position: absolute;
  right: 0;
  top: 100%;
  width: 300px;
  background-color: #1e2a38;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.3);
  padding: 1rem;
  z-index: 1000;
}

.cart-item {
  display: flex;
  gap: 1rem;
  background-color: #2a3a4b;
  padding: 0.75rem;
  border-bottom: 1px solid #444;
  position: relative; /* Needed for positioning the remove button */
}

.cart-item:last-child {
  border-bottom: none;
}

.cart-item-image {
  background-size: cover;
  background-position: center;
  width: 70px;
  height: 70px;
  border-radius: 8px;
}

.cart-item-details {
  display: flex;
  flex-direction: column;
  justify-content: center;
}

.text-sm {
  color: #a0b3c2;
}

.text-base {
  color: #e0e0e0;
}

.cart-footer {
  display: flex;
  justify-content: space-between;
  padding: 0.75rem 0;
}

.cart-footer-actions {
  display: flex;
  flex-direction: column;
  gap: 0.5rem;
}

.view-cart {
  background-color: #2c3e50;
  color: white;
  text-align: center;
  font-weight: bold;
  padding: 0.5rem;
  border-radius: 8px;
  text-decoration: none;
}

.checkout {
  background-color: #3498db;
  color: white;
  font-weight: bold;
  padding: 0.5rem;
  border-radius: 8px;
  border: none;
  cursor: pointer;
}

/* Remove Button styles */
.remove-item {
  position: absolute;
  top: -8px;
  right: -8px;
  background-color: red;
  color: white;
  border-radius: 50%;
  width: 20px;
  height: 20px;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 16px;
  cursor: pointer;
}
</style>
