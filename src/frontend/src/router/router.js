import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '@/views/HomePage.vue';
import viewItem from "@/views/viewItem.vue";
import ShoppingCart from "@/components/ShoppingCart.vue";
import ShoppingWishList from "@/components/ShoppingWishList.vue";
import ComicBooksTable from '@/components/ComicBooksTable.vue';
import LoginPage from "@/components/LoginPage.vue";
import EditBook from "@/components/EditBook.vue";
import AddNewBook from "../../../../../comic_city_project45/src/frontend/src/components/AddNewBook.vue";
import CreateAccount from "@/components/CreateAccount.vue";
import MainLayout from "@/components/MainLayout.vue";

const routes = [
    // Main landing page
    { path: '/', name: 'HomePage', component: HomePage },

    // MainLayout wrapper for admin-related routes
    {
        path: '/admin',
        component: MainLayout,
        children: [
            { path: '', redirect: 'comic-books' },
            { path: 'comic-books', name: 'ComicBooks', component: ComicBooksTable },
            { path: 'add-new-book', name: 'AddNewBook', component: AddNewBook },
            { path: 'edit-book/:id', name: 'EditBook', component: EditBook, props: true },
        ],
    },

    // Other standalone routes
    { path: '/viewItem', name: 'ViewItem', component: viewItem },
    { path: '/cart', name: 'ShoppingCart', component: ShoppingCart },
    { path: '/wishList', name: 'ShoppingWishList', component: ShoppingWishList },
    { path: '/login', name: 'LoginPage', component: LoginPage },
    { path: '/createAccount', name: 'CreateAccount', component: CreateAccount },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;
