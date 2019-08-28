<template>
  <div>
    <el-container>
      <el-aside width="0px">
        <el-menu
          class="categories"
          default-active="0"
          background-color="transparent">
          <el-menu-item @click="gotoList('0', 'myProfile')" style="color: gray">
            <span slot="title" :class="{'textcolor' : activePath === '0'}">个人资料</span>
          </el-menu-item>
          <el-menu-item @click="gotoList('1', 'myFavor')" style="color: gray">
            <span slot="title" :class="{'textcolor' : activePath === '1'}">我的收藏</span>
          </el-menu-item>
          <el-menu-item @click="gotoList('2', 'myMessage')" style="color: gray">
            <span slot="title" :class="{'textcolor' : activePath === '2'}">我的消息</span>
          </el-menu-item>
          <el-menu-item @click="gotoList('3', 'myFollowing')" style="color: gray">
            <span slot="title" :class="{'textcolor' : activePath === '3'}">我的关注</span>
          </el-menu-item>
          <el-menu-item @click="gotoList('4', 'myFollower')" style="color: gray">
            <span slot="title" :class="{'textcolor' : activePath === '4'}">我的粉丝</span>
          </el-menu-item>
          <el-menu-item @click="gotoList('5', 'myBlog')" style="color: gray">
            <span slot="title" :class="{'textcolor' : activePath === '5'}">我的博客</span>
          </el-menu-item>
        </el-menu>
      </el-aside>
      <el-main class="content">
        <router-view style="float: left;margin-left: 150px;width: 70%"></router-view>
<!--        <MyProfile v-if="activePath === '0'"></MyProfile>-->
<!--        <BlogListFollow v-if="activePath === '1'" style="float: left;margin-left: 150px;width: 70%"></BlogListFollow>-->
<!--        <MyMessage v-if="activePath === '2' " style="float: left;margin-left: 150px;width: 70%"></MyMessage>-->
<!--        <MyFollowing v-if="activePath === '3'" style="float: left;margin-left: 150px;width: 70%"></MyFollowing>-->
<!--        <MyFollower v-if="activePath === '4'" style="float: left;margin-left: 150px;width: 70%"></MyFollower>-->
<!--        <MyBlog v-if="activePath === '5'" style="float: left;margin-left: 150px;width: 70%"></MyBlog>-->
      </el-main>
    </el-container>
  </div>
</template>

<script>
import MyProfile from './myprofile/MyProfile'
import MyMessage from './mymessage/MyMessage'
import MyFollowing from './myfollowing/MyFollowing'
import MyFollower from './myfollower/MyFollower'
import MyBlog from './myblog/MyBlog'
import BlogListFollow from '../../blog/BlogListFollow'
export default {
  name: 'Admin',
  components: {BlogListFollow, MyBlog, MyFollower, MyFollowing, MyProfile, MyMessage},
  data () {
    return {
      activePath: '0'
    }
  },
  methods: {
    gotoList: function (active, Type) {
      this.changeActive(active)
      this.$router.push('/admin/' + Type)
      this.reload()
    },
    changeActive (a) {
      this.activePath = a
    }
  }
}
</script>

<style scoped>
  .categories {
    position: fixed;
    width: 150px;
  }
  .textcolor {
      color: dodgerblue;
  }
</style>
