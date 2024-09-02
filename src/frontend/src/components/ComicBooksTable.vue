
<template>
  <div class="table-container">
    <h2>Comic Book Inventory</h2>

    <!-- Filter Section -->
    <div class="filters card p-3 mb-4">
      <div class="row g-3">
        <!-- Filter by Name -->
        <div class="col-md-4">
          <input
              v-model="searchName"
              @input="fetchBooksByName"
              type="text"
              class="form-control strong-border"
              placeholder="Search by Name"
          />
        </div>

        <!-- Filter by Release Date Range -->
        <div class="col-md-3">
          <input
              v-model="startDate"
              type="date"
              class="form-control strong-border"
              placeholder="Start Date"
          />
        </div>
        <div class="col-md-3">
          <input
              v-model="endDate"
              type="date"
              class="form-control strong-border"
              placeholder="End Date"
          />
        </div>
        <div class="col-md-2">
          <button @click="fetchBooksByReleaseDate" class="btn btn-primary w-100 strong-border">
            Filter by Date
          </button>
        </div>

        <!-- Filter by Genres -->
        <div class="col-md-12">
          <div class="form-check form-check-inline " v-for="genre in genres" :key="genre">
            <input
                class="form-check-input strong-border"
                type="checkbox"
                :value="genre"
                v-model="selectedGenres"
            />
            <label class="form-check-label">{{ genre }}</label>
          </div>
          <button @click="fetchBooksByGenres" class="btn btn-secondary mt-2 strong-border">
            Filter by Genres
          </button>
        </div>
      </div>
    </div>

    <!-- Loading and Error Messages -->
    <p v-if="loading" class="loading-message">Loading...</p>
    <p v-if="errorMsg" class="error-message">{{ errorMsg }}</p>

    <!-- Comic Book Table with Original Theme -->
    <table v-if="!loading && books.length > 0">
      <thead>
      <tr>
        <th>Title</th>
        <th>Book ID</th>
        <th>ISBN</th>
        <th>Published Date</th>
        <th>Price (R)</th>
        <th>Genre</th>
        <th>Quantity</th>
        <th>Actions</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="book in books" :key="book.sku">
        <td>{{ book.name }}</td>
        <td>{{ book.sku }}</td>
        <td>{{ book.isbn }}</td>
        <td>{{ book.releaseDate }}</td>
        <td>{{ book.price.toFixed(2) }}</td>
        <td>{{ book.genres.join(', ') }}</td>
        <td>{{ book.quantity }}</td>
        <td class="actions">
          <button @click="editBook(book.sku)">Edit</button>
          <button @click="confirmDelete(book.sku)" class="delete">Delete</button>
        </td>
      </tr>
      <tr v-if="books.length === 0">
        <td colspan="8" class="no-data">No books available.</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap';

export default {

  data() {
    return {
      books: [],
      searchName: '',
      startDate: '',
      endDate: '',
      selectedGenres: [],
      loading: false,
      errorMsg: '',
      genres: ['ACTION', 'FANTASY', 'MYSTERY', 'SCI_FI', 'DRAMA'], // Define genres array for the checkboxes
    };
  },
  methods: {
    fetchBooksByName() {
      if (!this.searchName) {
        this.fetchAllBooks();
        return;
      }
      this.loading = true;
      fetch(`/api/comiccity/comic_book/search/name/${this.searchName}`)
          .then((response) => response.json())
          .then((data) => {
            this.books = data;
            this.loading = false;
          })
          .catch((error) => {
            this.errorMsg = 'Error fetching data by name';
            this.loading = false;
            console.error(error);
          });
    },

    fetchBooksByReleaseDate() {
      if (!this.startDate || !this.endDate) {
        this.errorMsg = 'Please enter both start and end dates';
        return;
      }
      if (new Date(this.startDate) > new Date(this.endDate)) {
        this.errorMsg('Start date cannot be later than end date');
        return;
      }
      this.loading = true;
      fetch(`/api/comiccity/comic_book/search/releaseDates?startDate=${this.startDate}&endDate=${this.endDate}`)
          .then((response) => response.json())
          .then((data) => {
            this.books = data;
            this.loading = false;
          })
          .catch((error) => {
            this.errorMsg = 'Error fetching data by release date';
            this.loading = false;
            console.error(error);
          });
    },

    fetchBooksByGenres() {
      if (this.selectedGenres.length === 0) {
        // If no genres are selected, fetch all books
        this.fetchAllBooks();
        return;
      }
      this.loading = true;
      const genresParam = this.selectedGenres.join(',');
      fetch(`/api/comiccity/comic_book/search/genres?genres=${genresParam}`)
          .then((response) => response.json())
          .then((data) => {
            this.books = data;
            this.loading = false;
          })
          .catch((error) => {
            this.errorMsg = 'Error fetching data by genres';
            this.loading = false;
            console.error(error);
          });
    },

    fetchAllBooks() {
      this.loading = true;
      fetch(`/api/comiccity/comic_book/getAll`)
          .then((response) => response.json())
          .then((data) => {
            this.books = data;
            this.loading = false;
          })
          .catch((error) => {
            this.errorMsg = 'Error fetching all books';
            this.loading = false;
            console.error(error);
          });
    },

    editBook(id) {
      this.$router.push(`/edit-book/${id}`);
    },

    confirmDelete(bookId) {
      const confirmed = confirm('Are you sure you want to delete this book?');
      if (confirmed) {
        this.deleteComic(bookId);
      }
    },

    deleteComic(bookId) {
      fetch(`api/comiccity/comic_book/delete/${bookId}`, {
        method: 'DELETE',
      })
          .then((response) => {
            if (!response.ok) {
              throw new Error('Network response was not ok');
            }
            this.books = this.books.filter((book) => book.sku !== bookId);
          })
          .catch((error) => {
            this.errorMsg = 'Error deleting the book';
            console.error('There was a problem with the delete operation:', error);
          });
    },
  },
  mounted() {
    this.fetchAllBooks();
  },
};
</script>

<style scoped>
/* Retained original styles for table and other components */
.table-container {
  width: 100%;
  max-width: 1000px;
  margin: 0 auto;
  padding: 20px;
  background-color: #f9f9f9;
  border-radius: 8px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
  border: 4px solid #333; /* Bold border to mimic comic panels */
}

.table-container h2 {
  text-align: center;
  margin-bottom: 20px;
  font-family: 'Comic Sans MS', sans-serif;
  font-weight: bold;
  font-size: 2rem;
  color: #333;
}

table {
  width: 100%;
  border-collapse: collapse;
  margin-bottom: 20px;
  font-family: 'Comic Sans MS', sans-serif;
}

table th,
table td {
  padding: 12px;
  text-align: left;
  border-bottom: 2px solid #333; /* Thicker border for a comic feel */
}

table th {
  background-color: #f2f2f2;
  font-weight: bold;
  text-transform: uppercase;
  border-top: 4px solid #333;
}

table tr:nth-child(even) {
  background-color: #fff;
}

table tr:nth-child(odd) {
  background-color: #f9f9f9;
}

table tr:hover {
  background-color: #ffcc00;
  transform: scale(1.02); /* Slight zoom effect on hover */
}

.actions {
  display: flex;
  gap: 10px;
}

.actions button {
  padding: 8px 12px;
  border: 2px solid #333;
  border-radius: 4px;
  cursor: pointer;
  font-family: 'Comic Sans MS', sans-serif;
  font-weight: bold;
}

.actions button.edit {
  background-color: #007bff;
  color: white;
  border: 2px solid #333;
}

.actions button.delete {
  background-color: #dc3545;
  color: white;
  border: 2px solid #333;
}

.actions button:hover {
  background-color: #ffcc00; /* Yellow on hover for both buttons */
  color: #333;
  border-color: #333;
}

.error-message,
.loading-message {
  text-align: center;
  margin-top: 20px;
  background-color: #ff0066;
  color: white;
  padding: 10px;
  border-radius: 8px;
  border: 2px solid #333;
  display: inline-block;
}

.no-data {
  text-align: center;
  color: #999;
  font-style: italic;
  font-family: 'Comic Sans MS', sans-serif;
  border: 2px dashed #333;
  padding: 10px;
  border-radius: 10px;
  background-color: #ffcc00;
}

/* Strong Borders for Filter Fields */
.strong-border {
  border: 2px solid #333 !important; /* Stronger, comic-style borders */
  border-radius: 6px;
}

.form-check-input.strong-border {
  border: 2px solid #333 !important; /* Checkbox specific strong borders */
}
</style>
