import Vue from 'vue'
import App from './App.vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

import VueRouter from 'vue-router'
import Routes from './router.js'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import { library } from '@fortawesome/fontawesome-svg-core'
import { faArrowLeft, faPenToSquare, faTrash, faUserPlus } from '@fortawesome/free-solid-svg-icons'

Vue.config.productionTip = false

const router = new VueRouter({
  routes: Routes,
  mode: "history"
})

Vue.use(VueRouter)

Vue.component('font-awesome-icon', FontAwesomeIcon)
library.add(faUserPlus, faPenToSquare, faTrash, faArrowLeft)

new Vue({
  render: h => h(App),
  router: router
}).$mount('#app')
