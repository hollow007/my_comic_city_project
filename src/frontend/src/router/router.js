import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '@/views/HomePage.vue';
//import viewItem from "@/views/viewItem.vue";
import ShoppingCart from "@/components/ShoppingCart.vue";
import ShoppingWishList from "@/components/ShoppingWishList.vue";
import ComicBooksTable from '@/components/ComicBooksTable.vue';
import LoginPage from "@/components/LoginPage.vue";
import EditBook from "@/components/EditBook.vue";
import CreateAccount from "@/components/CreateAccount.vue";

import AddNewBook from "@/components/AddNewBook.vue";
import AccountSidebar from "@/components/AccountSidebar.vue";
import ordersPage from "@/components/OrdersPage.vue";
import AccountDetails from "@/components/AccountDetails.vue";
import AddressesPage from "@/components/AddressesPage.vue";
import WishListPage from "@/components/WishListPage.vue";
import ViewItem from "@/views/viewItem.vue";
import MainLayout from "@/components/MainLayout.vue";
import AdminOrderManagment from "@/components/AdminOrderManagment.vue";
import PublishersTable from "@/components/PublishersTable.vue";
import AuthorsTable from "@/components/AuthorsTable.vue";
import EditAuthor from "@/components/EditAuthor.vue";
import AddNewAuthor from "@/components/AddNewAuthor.vue";
import AddNewPublisher from "@/components/AddNewPublisher.vue";
import EditPublisher from "@/components/EditPublisher.vue";
import GenreManagment from "@/components/GenreManagment.vue";

const routes = [

    { path: '/home', name: 'HomePage', component: HomePage },

    {
        path: '/',
        component: MainLayout,
        children: [
            { path: '', redirect: 'comic-books' },
            { path: 'comic-books', name: 'ComicBooks', component: ComicBooksTable },
            { path: 'add-new-book', name: 'AddNewBook', component: AddNewBook },
            { path: 'edit-book/:id', name: 'EditBook', component: EditBook, props: true },
            { path: 'view-orders', name: 'AdminOrdersManagement', component: AdminOrderManagment },

            { path: 'publishers', name: 'publishers', component: PublishersTable },
            { path: 'add-new-publisher', name: 'AddNewPublisher', component: AddNewPublisher },
            { path: 'edit-publisher/:id', name: 'EditPublisher', component: EditPublisher, props: true },

            { path: 'authors', name: 'Authors', component: AuthorsTable },
            { path: 'add-new-author', name: 'AddNewAuthor', component: AddNewAuthor },
            { path: 'edit-author/:id', name: 'EditAuthor', component: EditAuthor, props: true },

            { path: 'genres', name: 'genres', component: GenreManagment },



        ],
    },


    // Other standalone routes

    {
        path: '/comic/:sku', // Dynamic parameter
        name: 'view-item',
        component: ViewItem,
        props: true // Allows passing route params as props
    },
    { path: '/cart', name: 'ShoppingCart', component: ShoppingCart },
    { path: '/wishList', name: 'ShoppingWishList', component: ShoppingWishList },
    { path: '/login', name: 'LoginPage', component: LoginPage },

    {path: '/cartcheckout', name: 'CartCheckout', component: () => import('@/components/CartCheckout.vue'),
        props: route => ({ cartItems: route.params.cartItems }),
    },

    { path: '/customer', name: 'Account', component: AccountSidebar },
    { path: '/orders', name: 'Orders', component: ordersPage },
    { path: '/addresses', name: 'Addresses', component: AddressesPage },
    { path: '/account-details', name: 'Acount-Details', component: AccountDetails },
    { path: '/wishlist', name: 'wishList', component: WishListPage },



    { path: '/signUp', name: 'CreateAccount', component: CreateAccount },

];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;
