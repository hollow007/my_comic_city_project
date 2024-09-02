import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '@/views/HomePage.vue';
import viewItem from "@/views/viewItem.vue";
import ShoppingCart from "@/components/ShoppingCart.vue";
import ShoppingWishList from "@/components/ShoppingWishList.vue";
import ComicBooksTable from '@/components/ComicBooksTable.vue';
import LoginPage from "@/components/LoginPage.vue";
import EditBook from "@/components/EditBook.vue";
import CreateAccount from "@/components/CreateAccount.vue";
import MainLayout from "@/components/MainLayout.vue";
import AddNewBook from "@/components/AddNewBook.vue";
import AccountSidebar from "@/components/AccountSidebar.vue";
import ordersPage from "@/components/OrdersPage.vue";
import AccountDetails from "@/components/AccountDetails.vue";
import AddressesPage from "@/components/AddressesPage.vue";
import WishListPage from "@/components/WishListPage.vue";
import AdminOrderManagment from "@/components/AdminOrderManagment.vue";

const routes = [
    // Main landing page

    { path: '/home', name: 'HomePage', component: HomePage },

    // MainLayout wrapper for admin-related routes
    {
        path: '/',
        component: MainLayout,
        children: [
            { path: '', redirect: 'comic-books' },
            { path: 'comic-books', name: 'ComicBooks', component: ComicBooksTable },
            { path: 'add-new-book', name: 'AddNewBook', component: AddNewBook },
            { path: 'edit-book/:id', name: 'EditBook', component: EditBook, props: true },
            { path: 'view-orders', name: 'AdminOrdersManagement', component: AdminOrderManagment },

        ],
    },


    // Other standalone routes
    { path: '/viewItem', name: 'ViewItem', component: viewItem },
    { path: '/cart', name: 'ShoppingCart', component: ShoppingCart },
    { path: '/wishList', name: 'ShoppingWishList', component: ShoppingWishList },
    { path: '/login', name: 'LoginPage', component: LoginPage },
    { path: '/createAccount', name: 'CreateAccount', component: CreateAccount },
    {path: '/cartcheckout', name: 'CartCheckout', component: () => import('@/components/CartCheckout.vue'),
        props: route => ({ cartItems: route.params.cartItems }),
    },

    { path: '/customer', name: 'Account', component: AccountSidebar },
    { path: '/orders', name: 'Orders', component: ordersPage },
    { path: '/addresses', name: 'Addresses', component: AddressesPage },
    { path: '/account-details', name: 'Acount-Details', component: AccountDetails },
    { path: '/wishlist', name: 'wishList', component: WishListPage },


];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;
