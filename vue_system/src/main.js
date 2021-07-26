// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

// ElementUI配置
import ElementUI, { Message } from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
Vue.use(ElementUI)

// axios 配置
import axios from 'axios'
// import VueAxios from 'vue-axios'
// Vue.use(VueAxios,axios)  不知道为啥， 加这一行运行就报错
axios.defaults.baseURL = 'http://127.0.0.1:8888/api/private/v1/'
//全局挂载
Vue.prototype.$http = axios

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
