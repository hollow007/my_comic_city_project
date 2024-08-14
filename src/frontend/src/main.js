import { createApp } from 'vue'
import App from './App.vue'
import { library } from '@fortawesome/fontawesome-svg-core'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import { faShoppingCart, faUser, faSearch, faHeart, faSun } from '@fortawesome/free-solid-svg-icons'

// Add the icons you need to the library
library.add(faShoppingCart, faUser, faSearch, faHeart, faSun)


createApp(App).component('font-awesome-icon', FontAwesomeIcon).mount('#app')


