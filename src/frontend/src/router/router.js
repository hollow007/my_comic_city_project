
import  {createRouter,createWebHistory} from 'vue-router';
import HomePage from '@/views/HomePage.vue';
import viewItem from "@/views/viewItem.vue";


const routes = [
    { path: '/', component: HomePage },
    { path: '/viewItem', component: viewItem} // adding new route for view item

];

const router = createRouter({    history: createWebHistory(),
    routes,

});

export default router;
