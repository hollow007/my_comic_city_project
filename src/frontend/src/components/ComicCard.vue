<template>
  <div class="comic-card">
    <img :src="comicImage" alt="Comic Cover" class="comic-image" />
    <img src="data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMjQiIGhlaWdodD0iMjQiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgZmlsbC1ydWxlPSJldmVub2RkIiBjbGlwLXJ1bGU9ImV2ZW5vZGQiPjxwYXRoIGQ9Ik0xMiAyMS41OTNjLTUuNjMtNS41MzktMTEtMTAuMjk3LTExLTE0LjQwMiAwLTMuNzkxIDMuMDY4LTUuMTkxIDUuMjgxLTUuMTkxIDEuMzEyIDAgNC4xNTEuNTAxIDUuNzE5IDQuNDU3IDEuNTktMy45NjggNC40NjQtNC40NDcgNS43MjYtNC40NDcgMi41NCAwIDUuMjc0IDEuNjIxIDUuMjc0IDUuMTgxIDAgNC4wNjktNS4xMzYgOC42MjUtMTEgMTQuNDAybTUuNzI2LTIwLjU4M2MtMi4yMDMgMC00LjQ0NiAxLjA0Mi01LjcyNiAzLjIzOC0xLjI4NS0yLjIwNi0zLjUyMi0zLjI0OC01LjcxOS0zLjI0OC0zLjE4MyAwLTYuMjgxIDIuMTg3LTYuMjgxIDYuMTkxIDAgNC42NjEgNS41NzEgOS40MjkgMTIgMTUuODA5IDYuNDMtNi4zOCAxMi0xMS4xNDggMTItMTUuODA5IDAtNC4wMTEtMy4wOTUtNi4xODEtNi4yNzQtNi4xODEiLz48L3N2Zz4=" class="heart-icon">
    <div class="comic-info">
      <div class="title-price">
        <h3 class="book-title">{{ comic.name }}</h3>
        <p class="price">{{ formatPrice(comic.price) }}</p>
      </div>
      <p class="author">{{ authorsList }}</p>
      <div class="star-rating">
        <span v-for="n in 5" :key="n" class="star">★</span>
      </div>


      <button class="add-btn">
        + Add <font-awesome-icon icon="shopping-cart" class="icon" />
      </button>
    </div>
  </div>
</template>

<script>

export default {
  name: 'ComicCard',
  props: ['comic'],
  computed: {
    comicImage() {
      if (this.comic.photo) {

        return `data:image/jpeg;base64,${this.comic.photo}`;
      }
      return 'https://via.placeholder.com/150'; // Fallback image
    },
    authorsList() {
      // Create a formatted list of author initials and last names
      return this.comic.authors.map(author => {
        const { firstName, lastName } = author.name;
        const initial = firstName.charAt(0).toUpperCase();
        return `${initial}. ${lastName}`;
      }).join(', ');
    }
  },
  methods: {
    formatPrice(price) {
      // Format the price as a string with the currency symbol
      return `R${price.toFixed(2)}`;
    }
  }
};
</script>

<style scoped>
/* Your styles remain the same */
.comic-card {
  position: relative;
  border: 1px solid #ddd;
  padding: 10px;
  text-align: left;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  width: 300px;
  height: 480px; /* Adjusted height for more space */
  box-sizing: border-box;
  transition: transform 0.3s ease, box-shadow 0.3s ease;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}

.comic-card:hover {
  transform: translateY(-10px);
  box-shadow: 0 6px 12px rgba(0, 0, 0, 0.2);
}

.comic-image {
  width: 100%;
  height: auto;
  border-radius: 8px;
}

.heart-icon {
  position: absolute;
  top: 8px;
  right: 8px;
  font-size: 24px;
  color: black; /* Set the icon color to black */
  background-color: white; /* Transparent background */
 /* Black border */
  border-radius: 50%; /* Circular border */
  padding: 4px; /* Adjust padding for the border */
  box-sizing: content-box;
  cursor: pointer;
  margin-left: 20px;
}

.heart-icon:hover {
  border-color: blue; /* Optional: Change border color on hover */
  color: blue;
}

.comic-info {
  margin-top: 10px;
  flex-grow: 1; /* Makes the info section take up remaining space */
}

.title-price {
  display: flex;
  justify-content: space-between;
  align-items: baseline;
  flex-wrap: wrap;
}

.book-title {
  font-size: 20px;
  font-weight: bold;
  margin: 0;
  flex: 1 1 auto;
  word-wrap: break-word;
  max-width: 70%;
}

.price {
  font-size: 16px;
  margin-left: 10px;
  text-align: right;
  white-space: nowrap;
}

.author {
  font-size: 14px;
  margin: 8px 0;
}

.star-rating {
  font-size: 16px;
  color: #af751c;
  margin: 8px 0;
}

.star {
  margin-right: 2px;
}

.add-btn {
  background-color: #fca311;
  color: white;
  border: none;
  padding: 12px 20px;
  cursor: pointer;
  border-radius: 6px;
  height :40px;
  width:168px;
  font-size: 1.1rem;
  font-weight: bold;
  transition: background-color 0.3s ease;
  align-self: center; /* Center the button horizontally */
  margin-bottom: 20px; /* Add space below the button */
  margin: 20px auto 0 auto; /* Center the button horizontally */
  display: block;
}

.add-btn .icon {
  margin-left: 10px;
}

.add-btn:hover {
  background-color: #af751c;
}
</style>
