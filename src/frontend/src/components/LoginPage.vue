<template>
  <div class="app-container">
    <h1 class="title">Welcome to the city of comics!</h1>
    <p class="subtitle">Sign in or create an account to access our comic books.</p>
    <div class="input-group">
      <label class="input-label" for="email">
        <input
            id="email"
            type="email"
            v-model="email"
            placeholder="Email"
            class="input-field"
            required
            aria-label="Email address"
        />
      </label>
      <label class="input-label" for="password">
        <input
            id="password"
            placeholder="Password"
            type="password"
            class="input-field"
            v-model="password"
            required
            aria-label="Password"
        />
      </label>
    </div>
    <div class="button-group">
      <button class="login-button" @click="login">
        <span class="button-text">Log In</span>
      </button>
      <button class="create-account-button" @click="createAccount">
        <span class="button-text">Create Account</span>
      </button>
    </div>
    <p v-if="loginError" class="error-message">{{ loginError }}</p>
  </div>
</template>

<script>



import {getCustomerWishList} from "@/services/wishlistService";
import {getCustomerCart} from "@/services/cartService";

export default {
  data() {
    return {
      email: '',
      password: '',
      loginError: '',
      isLoading: false
    };
  },
  methods: {
    async login() {
      this.loginError = '';
      if (!this.email || !this.password) {
        this.loginError = 'Please enter both email and password.';
        return;
      }
      this.isLoading = true;

      try {
        const response = await fetch(`/api/comiccity/Customer/login/${encodeURIComponent(this.email)}/${encodeURIComponent(this.password)}`, {
          method: 'GET',
          headers: {
            'Content-Type': 'application/json',
          }
        });

        if (response.ok) {
          const data = await response.text();
          if (data === 'Login successful') {
            localStorage.setItem('userEmail', this.email); // Store user email or another identifier
            try {
              const cartResponse = await getCustomerCart(this.email);
              this.$emit('update-cart-count', cartResponse.data.comicBooks.length);
               const wishlistResponse = await getCustomerWishList(this.email);
              this.$emit('update-wishList-count', wishlistResponse.data.comicBooks.length);

            } catch (error) {
              console.error('Error fetching data:', error);
            }
            this.$router.push('/');
          } else {
            this.loginError = 'Invalid email or password.';
            alert(this.loginError)
          }
        } else {
          const data = await response.json();
          this.loginError = data.error || 'Invalid email or password.';
        }
      } catch (error) {``
        this.loginError = 'Invalid email or password.';
        console.error('There was a problem with the fetch operation:', error);
      } finally {
        this.isLoading = false;
      }
    },
    createAccount() {
      this.$router.push('/signUp');
    }
  }
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Be+Vietnam+Pro:wght@400;500;700;900&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans:wght@400;500;700;900&display=swap');

body {
  font-family: "Be Vietnam Pro", "Noto Sans", sans-serif;
  margin: 0;
  padding: 0;
}

.app-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  min-height: 100vh;
  background-color: #101a23;
}

.title {
  color: white;
  font-size: 24px;
  font-weight: bold;
  text-align: center;
  margin-bottom: 16px;
}

.subtitle {
  color: #90adcb;
  font-size: 16px;
  text-align: center;
  margin-bottom: 32px;
}

.input-group {
  display: flex;
  flex-direction: column;
  width: 100%;
  max-width: 400px;
  margin-bottom: 24px;
}

.input-label {
  display: flex;
  flex-direction: column;
}

.input-field {
  width: 100%;
  border-radius: 8px;
  padding: 12px;
  margin-bottom: 12px;
  font-size: 16px;
  border: none;
  background-color: #223649;
  color: white;
}

.input-field::placeholder {
  color: #90adcb;
}

.button-group {
  display: flex;
  flex-direction: column;
  width: 100%;
  max-width: 200px;
}

.login-button, .create-account-button {
  display: flex;
  align-items: center;
  justify-content: center;
  height: 48px;
  border-radius: 8px;
  font-size: 16px;
  font-weight: bold;
  color: white;
  border: none;
  margin-bottom: 16px;
  cursor: pointer;
}

.login-button {
  background-color: yellow;
}

.create-account-button {
  background-color: darkgoldenrod;
}

.error-message {
  color: red;
  font-size: 14px;
  text-align: center;
}
</style>
