<!--&lt;!&ndash;&lt;!&ndash; src/frontend/src/layouts/DefaultLayout.vue &ndash;&gt;&ndash;&gt;-->
<!--&lt;!&ndash;<template>&ndash;&gt;-->
<!--&lt;!&ndash;  <div class="layout">&ndash;&gt;-->
<!--&lt;!&ndash;    <AccountSidebar />&ndash;&gt;-->
<!--&lt;!&ndash;    <div class="content">&ndash;&gt;-->
<!--&lt;!&ndash;      <router-view />&ndash;&gt;-->
<!--&lt;!&ndash;    </div>&ndash;&gt;-->
<!--&lt;!&ndash;  </div>&ndash;&gt;-->
<!--&lt;!&ndash;</template>&ndash;&gt;-->

<!--&lt;!&ndash;<script>&ndash;&gt;-->
<!--&lt;!&ndash;import AccountSidebar from '@/components/AccountSidebar.vue';&ndash;&gt;-->

<!--&lt;!&ndash;export default {&ndash;&gt;-->
<!--&lt;!&ndash;  components: {&ndash;&gt;-->
<!--&lt;!&ndash;    AccountSidebar,&ndash;&gt;-->
<!--&lt;!&ndash;  },&ndash;&gt;-->
<!--&lt;!&ndash;};&ndash;&gt;-->
<!--&lt;!&ndash;</script>&ndash;&gt;-->

<!--&lt;!&ndash;<style scoped>&ndash;&gt;-->
<!--&lt;!&ndash;.layout {&ndash;&gt;-->
<!--&lt;!&ndash;  display: flex;&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->

<!--&lt;!&ndash;.content {&ndash;&gt;-->
<!--&lt;!&ndash;  flex: 1;&ndash;&gt;-->
<!--&lt;!&ndash;  padding-left: 20px;&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->
<!--&lt;!&ndash;</style>&ndash;&gt;-->
<!--<template>-->
<!--  <div class="layout">-->
<!--    &lt;!&ndash; Navbar at the top &ndash;&gt;-->
<!--    <NavBar />-->

<!--    <div class="layout-main">-->
<!--      &lt;!&ndash; Sidebar on the left &ndash;&gt;-->
<!--      <AccountSidebar />-->

<!--      &lt;!&ndash; Main content area where routed components will be displayed &ndash;&gt;-->
<!--      <div class="content">-->
<!--        <router-view />-->
<!--      </div>-->
<!--    </div>-->

<!--    &lt;!&ndash; Footer at the bottom &ndash;&gt;-->
<!--    <FooterSection />-->
<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--import NavBar from '@/components/NavBar.vue';-->
<!--import AccountSidebar from '@/components/AccountSidebar.vue';-->
<!--import FooterSection from '@/components/FooterSection.vue';-->

<!--export default {-->
<!--  components: {-->
<!--    NavBar,-->
<!--    AccountSidebar,-->
<!--    FooterSection,-->
<!--  },-->
<!--};-->
<!--</script>-->

<!--<style scoped>-->
<!--/* Container for the entire layout */-->
<!--.layout {-->
<!--  display: flex;-->
<!--  flex-direction: column;-->
<!--  height: 100vh; /* Full viewport height to cover the screen */-->
<!--}-->

<!--/* Main section, including sidebar and content */-->
<!--.layout-main {-->
<!--  display: flex;-->
<!--  flex: 1; /* Allows this section to expand and take up remaining space */-->
<!--}-->

<!--/* Sidebar styling */-->
<!--.account-sidebar {-->
<!--  width: 250px; /* Adjust width as needed */-->
<!--  padding: 20px;-->
<!--  background-color: #f4f4f4; /* Sidebar background color */-->
<!--}-->

<!--/* Content area styling */-->
<!--.content {-->
<!--  flex: 1; /* Takes up remaining width */-->
<!--  padding: 20px;-->
<!--  background-color: #fff; /* Content background color */-->
<!--}-->

<!--/* Footer positioning at the bottom */-->
<!--footer-section {-->
<!--  padding: 20px;-->
<!--  background-color: #f8f8f8; /* Footer background color */-->
<!--}-->
<!--</style>-->
<template>
  <div class="layout">
    <!-- Navbar at the top -->
    <NavBar />

    <div class="layout-main">
      <!-- Sidebar on the left -->
      <AccountSidebar />

      <!-- Main content area where routed components will be displayed -->
      <div class="content">
        <router-view />
      </div>
    </div>

    <!-- Footer at the bottom -->
    <FooterSection />
  </div>
</template>

<script>
import NavBar from '@/components/NavBar.vue';
import AccountSidebar from '@/components/AccountSidebar.vue';
import FooterSection from '@/components/FooterSection.vue';

export default {
  components: {
    NavBar,
    AccountSidebar,
    FooterSection,
  },
};
</script>

<style scoped>
/* Container for the entire layout */
.layout {
  display: flex;
  flex-direction: column;
  height: 100vh; /* Full viewport height to cover the screen */
}

/* Main section, including sidebar and content */
.layout-main {
  display: flex;
  flex: 1; /* Allows this section to expand and take up remaining space */
}

/* Sidebar styling */
.account-sidebar {
  width: 250px; /* Adjust width as needed */
  padding: 20px;
  background-color: #f4f4f4; /* Sidebar background color */
}

/* Content areastyling */
.content {
  flex: 1; /* Takes up remaining width */
  padding: 20px;
  background-color: #fff; /* Content background color */
}

/* Footer positioning at the bottom */
footer-section {
  padding: 20px;
  background-color: #f8f8f8; /* Footer background color */
}
</style>
