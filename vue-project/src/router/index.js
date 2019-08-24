import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Login from '../components/Login'
import Regist from '../components/Regist'
import Search from '../components/search/Search'
import Write from '../components/write/Write'
import Admin from '../components/admin/Admin'
import HomeTemplate from '../components/HomeTemplate'
import BlogList from '../components/BlogList'
import Blog from '../components/Blog'
import OtherList from '../components/OtherList'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld,
      children: [
        {
          path: '/search',
          name: 'Search',
          component: Search
        },
        {
          path: '/write',
          name: 'Write',
          component: Write
        }
      ]
    },
    {
      path: '/admin',
      name: 'Admin',
      component: Admin
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/regist',
      name: 'Regist',
      component: Regist
    },
    {
      path: '/home',
      name: 'HomeTemplate',
      component: HomeTemplate,
      children: [
        {
          path: 'blog/list',
          name: 'BlogList',
          component: BlogList
        },
        {
          path: 'blog/:blogNo',
          name: 'blog',
          component: Blog
        },
        {
          path: 'other/list',
          name: 'otherList',
          component: OtherList
        }
      ]
    }
  ]
})
