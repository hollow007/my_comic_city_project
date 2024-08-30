
import  {createRouter,createWebHistory} from 'vue-router';
import HomePage from '@/views/HomePage.vue';
import viewItem from "@/views/viewItem.vue";
import ShoppingCart from "@/components/ShoppingCart.vue";
import ShoppingWishList from "@/components/ShoppingWishList.vue";
import LoginPage from "@/components/LoginPage.vue";
import CreateAccount from "@/components/CreateAccount.vue";


const routes = [
    { path: '/', component: HomePage },
    { path: '/viewItem', component: viewItem} ,// adding new route for view item
    { path: '/cart', component: ShoppingCart},
    { path: '/wishList', component: ShoppingWishList},
    { path: '/login', component: LoginPage},
    { path: '/createAccount', component: CreateAccount},
    {path: '/cartcheckout', name: 'CartCheckout', component: () => import('@/components/CartCheckout.vue'),
        props: route => ({ cartItems: route.params.cartItems }),
    },

];

const router = createRouter({    history: createWebHistory(),
    routes,

});

export default router;
