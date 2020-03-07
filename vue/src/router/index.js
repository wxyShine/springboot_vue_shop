import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../components/Login'
import Main from '../components/Main'
import Welcome from '../components/Welcome'
import Users from '../components/user/Users'
import Rights from '../components/power/Rights'
import Roles from '../components/power/Roles'
import Goods from '../components/goods/List'
import Add from '../components/goods/Add'

Vue.use(VueRouter)

const routes = [
  { path: '/', redirect: '/login' },
  { path: '/login', component: Login },
  { path: '/main', component: Main, redirect: '/welcome', children: [
    { path: '/welcome', component: Welcome },
    { path: '/rights', component: Rights },
    { path: '/roles', component: Roles },
    { path: '/users', component: Users },
    { path: '/goods', component: Goods },
    { path: '/goods/add', component: Add }] }

]

const router = new VueRouter({
  routes
})
/* 挂载路由导航守卫 */
router.beforeEach((to, from, next) => {
  if (to.path === '/login') return next()
  let tokenStr = window.sessionStorage.getItem('token')
  /*  本地是否存有token */
  if (tokenStr !== null && tokenStr !== 'undefined') {
    return next()
  } else {
    next('/login')
  }
})
export default router
