<!--&lt;!&ndash;<template>&ndash;&gt;-->
<!--&lt;!&ndash;  <div class="sidebar">&ndash;&gt;-->
<!--&lt;!&ndash;    <h2>MY ACCOUNT</h2>&ndash;&gt;-->
<!--&lt;!&ndash;    <ul>&ndash;&gt;-->
<!--&lt;!&ndash;      <li :class="{ active: isActive('/dashboard') }" @click="goToPage('/dashboard')">Dashboard</li>&ndash;&gt;-->
<!--&lt;!&ndash;      <li :class="{ active: isActive('/orders') }" @click="goToPage('/orders')">Orders</li>&ndash;&gt;-->
<!--&lt;!&ndash;      <li :class="{ active: isActive('/addresses') }" @click="goToPage('/addresses')">Addresses</li>&ndash;&gt;-->
<!--&lt;!&ndash;      <li :class="{ active: isActive('/account-details') }" @click="goToPage('/account-details')">Account details</li>&ndash;&gt;-->
<!--&lt;!&ndash;      <li :class="{ active: isActive('/wishlist') }" @click="goToPage('/wishlist')">Wishlist</li>&ndash;&gt;-->
<!--&lt;!&ndash;      <li @click="goToPage('/logout')">LogOut</li>&ndash;&gt;-->
<!--&lt;!&ndash;    </ul>&ndash;&gt;-->
<!--&lt;!&ndash;  </div>&ndash;&gt;-->
<!--&lt;!&ndash;</template>&ndash;&gt;-->

<!--&lt;!&ndash;<script>&ndash;&gt;-->
<!--&lt;!&ndash;export default {&ndash;&gt;-->
<!--&lt;!&ndash;  name: 'Sidebar',&ndash;&gt;-->
<!--&lt;!&ndash;  methods: {&ndash;&gt;-->
<!--&lt;!&ndash;    goToPage(path) {&ndash;&gt;-->
<!--&lt;!&ndash;      this.$router.push(path);&ndash;&gt;-->
<!--&lt;!&ndash;    },&ndash;&gt;-->
<!--&lt;!&ndash;    isActive(route) {&ndash;&gt;-->
<!--&lt;!&ndash;      return this.$route.path === route;&ndash;&gt;-->
<!--&lt;!&ndash;    }&ndash;&gt;-->
<!--&lt;!&ndash;  }&ndash;&gt;-->
<!--&lt;!&ndash;};&ndash;&gt;-->
<!--&lt;!&ndash;</script>&ndash;&gt;-->

<!--&lt;!&ndash;<style scoped>&ndash;&gt;-->
<!--&lt;!&ndash;.sidebar {&ndash;&gt;-->
<!--&lt;!&ndash;  width: 25%;&ndash;&gt;-->
<!--&lt;!&ndash;  padding-right: 20px;&ndash;&gt;-->
<!--&lt;!&ndash;  border-right: 1px solid #ccc;&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->

<!--&lt;!&ndash;.sidebar h2 {&ndash;&gt;-->
<!--&lt;!&ndash;  font-weight: bold;&ndash;&gt;-->
<!--&lt;!&ndash;  margin-bottom: 10px;&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->

<!--&lt;!&ndash;.sidebar ul {&ndash;&gt;-->
<!--&lt;!&ndash;  list-style-type: none;&ndash;&gt;-->
<!--&lt;!&ndash;  padding: 0;&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->

<!--&lt;!&ndash;.sidebar li {&ndash;&gt;-->
<!--&lt;!&ndash;  margin-bottom: 10px;&ndash;&gt;-->
<!--&lt;!&ndash;  cursor: pointer;&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->

<!--&lt;!&ndash;.sidebar li.active {&ndash;&gt;-->
<!--&lt;!&ndash;  font-weight: bold;&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->

<!--&lt;!&ndash;.sidebar li::after {&ndash;&gt;-->
<!--&lt;!&ndash;  content: "";&ndash;&gt;-->
<!--&lt;!&ndash;  display: block;&ndash;&gt;-->
<!--&lt;!&ndash;  border-bottom: 1px solid #000;&ndash;&gt;-->
<!--&lt;!&ndash;  margin: 5px 0;&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->
<!--&lt;!&ndash;</style>&ndash;&gt;-->
<!--<template>-->
<!--  <div class="account-sidebar">-->
<!--    <h2>MY ACCOUNT</h2>-->
<!--    <ul>-->
<!--      <li :class="{ active: isActive('/') }" @click="goToPage('/')">Dashboard</li>-->
<!--      <li :class="{ active: isActive('/orders') }" @click="goToPage('/orders')">Orders</li>-->
<!--      <li :class="{ active: isActive('/addresses') }" @click="goToPage('/addresses')">Addresses</li>-->
<!--      <li :class="{ active: isActive('/account-details') }" @click="goToPage('/account-details')">Account details</li>-->
<!--      <li :class="{ active: isActive('/wishlist') }" @click="goToPage('/wishlist')">Wishlist</li>-->
<!--      <li @click="goToPage('/logout')">LogOut</li>-->
<!--    </ul>-->
<!--  </div>-->
<!--</template>-->

<!--&lt;!&ndash;<script>&ndash;&gt;-->
<!--&lt;!&ndash;export default {&ndash;&gt;-->
<!--&lt;!&ndash;  name: 'Sidebar',&ndash;&gt;-->
<!--&lt;!&ndash;  methods: {&ndash;&gt;-->
<!--&lt;!&ndash;    goToPage(path) {&ndash;&gt;-->
<!--&lt;!&ndash;      this.$router.push(path);&ndash;&gt;-->
<!--&lt;!&ndash;    },&ndash;&gt;-->
<!--&lt;!&ndash;    isActive(route) {&ndash;&gt;-->
<!--&lt;!&ndash;      return this.$route.path === route;&ndash;&gt;-->
<!--&lt;!&ndash;    }&ndash;&gt;-->
<!--&lt;!&ndash;  }&ndash;&gt;-->
<!--&lt;!&ndash;};&ndash;&gt;-->
<!--&lt;!&ndash;</script>&ndash;&gt;-->
<!--<script>-->
<!--export default {-->
<!--  name: 'AccountSidebar', // Renamed from "Sidebar" to "AccountSidebar"-->
<!--  methods: {-->
<!--    goToPage(path) {-->
<!--      this.$router.push(path);-->
<!--    },-->
<!--    isActive(route) {-->
<!--      return this.$route.path === route;-->
<!--    }-->
<!--  }-->
<!--};-->
<!--</script>-->


<!--<style scoped>-->
<!--.sidebar {-->
<!--  width: 25%;-->
<!--  padding-right: 20px;-->
<!--  border-right: 1px solid #ccc;-->
<!--}-->

<!--.sidebar h2 {-->
<!--  font-weight: bold;-->
<!--  margin-bottom: 10px;-->
<!--}-->

<!--.sidebar ul {-->
<!--  list-style-type: none;-->
<!--  padding: 0;-->
<!--}-->

<!--.sidebar li {-->
<!--  margin-bottom: 10px;-->

<template>
  <div class="account-sidebar">
    <h2>MY ACCOUNT</h2>
    <ul>
      <li :class="{ active: isActive('/') }" @click="goToPage('/')">Dashboard</li>
      <li :class="{ active: isActive('/orders') }" @click="goToPage('/orders')">Orders</li>
      <li :class="{ active: isActive('/addresses') }" @click="goToPage('/addresses')">Addresses</li>
      <li :class="{ active: isActive('/account-details') }" @click="goToPage('/account-details')">Account details</li>
      <li :class="{ active: isActive('/wishlist') }" @click="goToPage('/wishlist')">Wishlist</li>
      <li @click="goToPage('/logout')">LogOut</li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'AccountSidebar',
  methods: {
    goToPage(path) {
      this.$router.push(path);
    },
    isActive(route) {
      return this.$route.path === route;
    }
  }
};
</script>

<style scoped>
.account-sidebar {
  width: 250px;
  padding-right: 20px;
  border-right: 1px solid #ccc;
}

.account-sidebar h2 {
  font-weight: bold;
  margin-bottom: 10px;
}

.account-sidebar ul {
  list-style-type: none;
  padding: 0;
}

.account-sidebar li {
  margin-bottom: 10px;
  cursor: pointer;
  padding: 8px;
  transition: background-color 0.3s ease;
}

.account-sidebar li:hover {
  background-color: #e0e0e0;
}

.account-sidebar li.active {
  font-weight: bold;
  background-color: #d1e7dd; /* Active state background */
}

.account-sidebar li::after {
  content: "";
  display: block;
  border-bottom: 1px solid #000;
  margin: 5px 0;
}
</style>
