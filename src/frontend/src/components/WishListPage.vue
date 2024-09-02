<template>
  <div class="wishlist-page">
    <div class="main-content">
      <div class="wishlist-header">
        <h1>My Wishlist</h1>
      </div>
      <div class="wishlist-body">
        <font-awesome-icon :icon="['fas', 'heart']" />
        <p>No products added to wishlist</p>
        <button class="browse-button" @click="browseComics">Browse and shop for comics</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'WishlistPage',
  methods: {
    browseComics() {
      // Logic to navigate to the comics browsing page
      this.$router.push('/comics'); // Updated logic to navigate to the comics page
    }
  }
};
</script>

<style scoped>
.wishlist-page {
  display: flex;
  padding: 20px;
}

.main-content {
  width: 100%; /* Full-width adjustment */
  padding-left: 20px;
}

.wishlist-header {
  display: flex;
  align-items: center;
  margin-bottom: 20px;
}

.wishlist-header h1 {
  font-size: 24px;
  margin: 0;
}

.wishlist-body {
  text-align: center;
  padding: 40px 0;
}

.wishlist-body .fa-icon {
  font-size: 50px;
  color: #000;
  margin-bottom: 20px;
}

.wishlist-body p {
  font-size: 18px;
  margin-bottom: 20px;
}

.browse-button {
  padding: 10px 20px;
  background-color: #0000FF;
  color: #fff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.browse-button:hover {
  background-color: #000099;
}
</style>
