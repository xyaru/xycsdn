<template>
  <div>
    <el-aside>
      <el-menu
        class="categories"
        default-active="0"
        background-color="transparent">
        <el-menu-item @click="changeNo('0')" style="color: gray">
          <span slot="title" :class="{'textcolor' : activePath === '0'}">个人资料</span>
        </el-menu-item>
        <el-menu-item @click="changeNo('1')" style="color: gray">
          <span slot="title" :class="{'textcolor' : activePath === '1'}">我的收藏</span>
        </el-menu-item>
        <el-menu-item @click="changeNo('2')" style="color: gray">
          <span slot="title" :class="{'textcolor' : activePath === '2'}">我的消息</span>
        </el-menu-item>
        <el-menu-item @click="changeNo('3')" style="color: gray">
          <span slot="title" :class="{'textcolor' : activePath === '3'}">我的关注</span>
        </el-menu-item>
        <el-menu-item @click="changeNo('4')" style="color: gray">
          <span slot="title" :class="{'textcolor' : activePath === '4'}">我的粉丝</span>
        </el-menu-item>
        <el-menu-item @click="changeNo('5')" style="color: gray">
          <span slot="title" :class="{'textcolor' : activePath === '5'}">我的博客</span>
        </el-menu-item>
      </el-menu>
    </el-aside>
    <el-main>
      <MyProfile v-if="activePath === '0'"></MyProfile>
      <BlogListFollow v-if="activePath === '1'"></BlogListFollow>
      <MyMessage v-if="activePath === '2'"></MyMessage>
      <MyFollowing v-if="activePath === '3'"></MyFollowing>
      <MyFollower v-if="activePath === '4'"></MyFollower>
      <MyBlog v-if="activePath === '5'"></MyBlog>
    </el-main>
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
    changeNo (a) {
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
