// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import Vuex from 'vuex'

import axios from 'axios'
Vue.prototype.$axios = axios

Vue.use(ElementUI)
Vue.use(Vuex)
/* eslint-disable no-new */

const store = new Vuex.Store({
  state: {
    username: 'xyaru'
  },
  mutations: {
    changeUsername (state, payload) {
      state.username = payload.username
    }
  },
  actions: {
    changeMyUsername (context, payload) {
      context.commit('changeUsername', payload)
    }
  },
  getters: {
    getUsername (state) {
      return state.username
    }
  }
})
new Vue({
  el: '#app',
  render: h => h(App),
  router,
  store,
  components: { App },
  template: '<App/>'
})
