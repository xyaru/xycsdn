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
import BlogListRecommend from '../components/blog/BlogListRecommend'
import BlogListFollow from '../components/blog/BlogListFollow'
import BlogListSearch from '../components/blog/BlogListSearch'
import BlogListSearch1 from '../components/blog/BlogListSearch1'
import UserSearch from '../components/user/UserSearch'
import Blog from '../components/blog/Blog'
import BlogListType from '../components/blog/BlogListType'
import MyBlog from '../components/admin/me/myblog/MyBlog'
import MyFollower from '../components/admin/me/myfollower/MyFollower'
import MyFollowing from '../components/admin/me/myfollowing/MyFollowing'
import MyProfile from '../components/admin/me/myprofile/MyProfile'
import OthersBlog from '../components/admin/others/othersblog/OthersBlog'
import OthersFavor from '../components/admin/others/othersfavor/OthersFavor'
import OthersProfile from '../components/admin/others/othersprofile/OthersProfile'
import OthersFollowing from '../components/admin/others/othersfollowing/OthersFollowing'
import OthersFollower from '../components/admin/others/othersfollower/OthersFollower'

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
              path: 'blogList/listRecommend',
              name: 'BlogListRecommend',
              component: BlogListRecommend
            },
            {
              path: 'blogList/listFollow',
              name: 'BlogListFollow',
              component: BlogListFollow
            },
            {
              path: 'blogList/:blogType',
              name: 'BlogListType',
              component: BlogListType
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
          },
          children: [
            {
              path: 'myBlog',
              name: 'MyBlog',
              component: MyBlog
            },
            {
              path: 'myFollower',
              name: 'MyFollower',
              component: MyFollower
            },
            {
              path: 'myFollowing',
              name: 'MyFollowing',
              component: MyFollowing
            },
            {
              path: 'myProfile',
              name: 'MyProfile',
              component: MyProfile
            },
            {
              path: 'myFavor',
              name: 'MyFavor',
              component: BlogListFollow
            }
          ]
        }
      ]
    },
    {
      path: '/user/:username',
      name: 'AdminUser',
      component: AdminOthers,
      meta: {
        requireAuth: false
      },
      children: [
        {
          path: 'othersBlog',
          name: 'OthersBlog',
          component: OthersBlog
        },
        {
          path: 'othersFollower',
          name: 'OthersFollower',
          component: OthersFollower
        },
        {
          path: 'othersFollowing',
          name: 'OthersFollowing',
          component: OthersFollowing
        },
        {
          path: 'othersProfile',
          name: 'OthersProfile',
          component: OthersProfile
        },
        {
          path: 'othersFavor',
          name: 'OthersFavor',
          component: OthersFavor
        }
      ]
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
