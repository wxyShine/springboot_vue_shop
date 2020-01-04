import Vue from 'vue'
import App from './App.vue'
import router from './router'
import './plugins/element.js'
/* 导入全局样式 */
import './assets/css/global.css'
/* 图标库 */
import './assets/fonts/iconfont.css'
import axios from 'axios'
axios.defaults.baseURL = 'http://localhost:1106'
/* 请求拦截器,设置发送请求时携带token */
axios.interceptors.request.use(config => {
  config.headers.Authorization = window.sessionStorage.getItem('token')
  return config
})
Vue.prototype.$axios = axios
Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
