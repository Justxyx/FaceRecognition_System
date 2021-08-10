import Vue from "vue";
import Router from "vue-router";
import Login from "../components/Login";
import Home from "../components/Home";
import User from "../components/user/User"
import addUser from '../components/user/addUser'
import welcome from '../components/welcome'
import CameraList from '../components/camera/CameraList'

Vue.use(Router);

// 创建router
const router = new Router({
  routes: [
    {
      path: "/",
      redirect:'login'
    },
    {
      path: "/login",
      component: Login
    },
    {
      path:"/home",
      component:Home,
      redirect:'/welcome',
      children:[
        {path:'/welcome',component:welcome},
        {path:'/userslist',component:User},
        {path:'/addUser',component:addUser},
        {path:'/cameralist',component:CameraList}
      ]
    }
  ]
});

// 挂载路由导航守卫
router.beforeEach((to, from, next) => {
  // to 将要访问的路径
  // from 代表从哪个路径跳转而来
  // next 函数，表示放行
  // next() 放行，  next('login') 强制跳转

  if (to.path === "/login") return next();
  const token = JSON.parse(window.sessionStorage.getItem("user")).token; 
  if (!token) return next("/login");
  next();
});

// 暴露接口
export default router;
