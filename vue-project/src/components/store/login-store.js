
import vue from 'vue'
export default {
  state: {
    login: false,
    user: {
      username: 'g'
    }
  },
  mutations: {
    login (state, payload) {
      sessionStorage.setItem('username', payload.username)
      sessionStorage.setItem('login', true)
      state.login = true
      state.user.username = payload.username
    }
  },
  actions: {
    login (context, payload) {
      return new Promise((resolve, reject) => {
        vue.prototype.$axios.post('/api/login', payload)
          .then(function (successResponse) {
            if (successResponse.data.code === 200) {
              resolve(successResponse)
              context.commit('login', payload)
            } else {
              reject(successResponse)
            }
          })
          .catch(function (failResponse) {
            reject(failResponse)
          })
      })
    }
  },
  getters: {
    getLoginState (state) {
      return state.login
    },
    getUsername (state) {
      return state.user.username
    }
  }
}
