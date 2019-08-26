import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Login from '../components/Login'
import Regist from '../components/Regist'
import Search from '../components/search/Search'
import Write from '../components/write/Write'
import Index from '../components/index/index'
import Admin from '../components/admin/me/Admin'
import AdminOthers from '../components/admin/others/Admin'
import Blog from '../components/blog/Blog'
import BlogListRecommend from '../components/blog/BlogListRecommend'
import BlogListFollow from '../components/blog/BlogListFollow'
import BlogListSearch from '../components/blog/BlogListSearch'
import BlogListSearch1 from '../components/blog/BlogListSearch1'
import UserSearch from '../components/user/UserSearch'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld,
      redirect: '/index',
      children: [
        {
          path: '/index',
          name: 'Index',
          component: Index,
          children: [
            {
              path: 'blog/listRecommend',
              name: 'BlogListRecommend',
              component: BlogListRecommend
            },
            {
              path: 'blog/listFollow',
              name: 'BlogListFollow',
              component: BlogListFollow
            },
            {
              path: 'blog/:blogNo',
              name: 'blog',
              component: Blog
            }
          ]
        },
        {
          path: '/search',
          name: 'Search',
          component: Search,
          children: [
            {
              path: 'listSearch/:input',
              name: 'BloglistSearch',
              component: BlogListSearch
            },
            {
              path: 'listSearch1/:input',
              name: 'BloglistSearch1',
              component: BlogListSearch1
            },
            {
              path: 'userSearch/:input',
              name: 'UserSearch',
              component: UserSearch
            }
          ]
        },
        {
          path: '/write',
          name: 'Write',
          component: Write,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/admin',
          name: 'Admin',
          component: Admin,
          meta: {
            requireAuth: true
          }
        }
      ]
    },
    {
      path: '/admin/:username',
      name: 'AdminUser',
      component: AdminOthers,
      meta: {
        requireAuth: false
      }
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
    }
  ]
})
