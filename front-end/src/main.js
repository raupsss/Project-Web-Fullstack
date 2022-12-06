import Vue from 'vue'
import App from './App.vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

import VueRouter from 'vue-router'
import Routes from './router.js'

Vue.config.productionTip = false

const router = new VueRouter({
  routes: Routes,
  mode: "history"
})

Vue.use(VueRouter)

new Vue({
  render: h => h(App),
  router: router
}).$mount('#app')
