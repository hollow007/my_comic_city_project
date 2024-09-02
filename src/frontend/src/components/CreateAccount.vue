<template>
  <div class="create-customer-container">
    <h1 class="title">Create a Customer Account</h1>
    <form @submit.prevent="handleSubmit">
      <label for="firstName">First Name:</label>
      <input id="firstName" v-model="customer.firstName" placeholder="First Name" required />

      <label for="middleName">Middle Name:</label>
      <input id="middleName" v-model="customer.middleName" placeholder="Middle Name" />

      <label for="lastName">Last Name:</label>
      <input id="lastName" v-model="customer.lastName" placeholder="Last Name" required />

      <label for="email">Email:</label>
      <input id="email" type="email" v-model="customer.contact.email" placeholder="Email" required />

      <label for="mobile">Mobile:</label>
      <input id="mobile" v-model="customer.contact.mobile" placeholder="Mobile" />

      <label for="billingAddress">Billing Address:</label>
      <input id="billingAddress" v-model="customer.contact.billingAddress" placeholder="Billing Address" />

      <label for="shippingAddress">Shipping Address:</label>
      <input id="shippingAddress" v-model="customer.contact.shippingAddress" placeholder="Shipping Address" />

      <label for="password">Password:</label>
      <input id="password" type="password" v-model="customer.password" placeholder="Password" required />

      <button type="submit" :disabled="!isValidForm">Create Account</button>
    </form>
    <p v-if="errorMessage" class="error-message">{{ errorMessage }}</p>
  </div>
</template>

<script>
import CustomerService from '@/services/CustomerService'; // Ensure you have this service to handle the API calls

export default {
  data() {
    return {
      customer: {
        firstName: '',
        middleName: '',
        lastName: '',
        password: '',
        contact: {
          email: '',
          mobile: '',
          billingAddress: '',
          shippingAddress: ''
        }
      },
      errorMessage: ''
    };
  },
  computed: {
    isValidForm() {
      return this.customer.firstName && this.customer.lastName && this.customer.contact.email && this.customer.password;
    }
  },
  methods: {
    async handleSubmit() {
      if (!this.isValidForm) {
        this.errorMessage = 'Please fill out all required fields.';
        return;
      }

      const customerData = {
        name: {
          firstName: this.customer.firstName,
          middleName: this.customer.middleName || '',
          lastName: this.customer.lastName
        },
        password: this.customer.password,
        contact: {
          email: this.customer.contact.email,
          mobile: this.customer.contact.mobile,
          shippingAddress: {
            time: "09:52", // Ensure you have the correct time format
            streetAddress: "34 Batersea Drive2",
            suburb: "Kibbler Park",
            postalCode: "2092",
            city: "Johannesburg"
          },
          billingAddress: {
            paymentMethod: "card", // Add the payment method
            streetAddress: "34 Batersea Drive3",
            suburb: "Kibbler Park",
            postalCode: "2090",
            city: "Johannesburg"
          }
        }
      };


      console.log('Customer Data Being Submitted:', customerData);

      try {
        let response = await CustomerService.createCustomer(customerData);

        console.log('Customer saved successfully:', response);
        alert('Account created successfully!');
        this.$router.push('/login');
      } catch (error) {
        console.error('Error saving customer:', error);
        this.errorMessage = 'Failed to create account.';
      }
    }
  }
};
</script>

<style scoped>
.create-customer-container {
  max-width: 600px;
  margin: 0 auto;
  padding: 20px;
  background-color: #fff;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.title {
  font-size: 24px;
  margin-bottom: 20px;
}

form {
  display: flex;
  flex-direction: column;
}

label {
  margin: 10px 0 5px;
}

input {
  padding: 10px;
  margin-bottom: 15px;
  border-radius: 4px;
  border: 1px solid #ddd;
}

button {
  background-color: #007bff;
  color: white;
  padding: 10px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button:disabled {
  background-color: #6c757d;
}

.error-message {
  color: red;
  margin-top: 15px;
}
</style>
