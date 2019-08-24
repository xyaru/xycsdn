// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import axios from 'axios'
import Vuex from 'vuex'
import modules from './components/store/store-modules'
import qs from 'qs'

Vue.prototype.$axios = axios

Vue.use(ElementUI)
Vue.use(router)
Vue.use(axios)
Vue.use(Vuex)
Vue.use(qs)

const store = new Vuex.Store({
  modules: modules
})

Vue.prototype.$store = store

/* eslint-disable no-new */
new Vue({
  el: '#app',
  render: h => h(App),
  router,
  store,
  components: { App },
  template: '<App/>'
})
