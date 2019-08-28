<template>
  <div>
    <el-menu
      class="categories"
      default-active="0"
      background-color="transparent">
      <el-menu-item @click="changeNo('0')" style="color: gray">
        <span slot="title" :class="{'textcolor' : activePath === '0'}">ta的资料</span>
      </el-menu-item>
      <el-menu-item @click="changeNo('1')" style="color: gray">
        <span slot="title" :class="{'textcolor' : activePath === '1'}">ta的收藏</span>
      </el-menu-item>
      <el-menu-item @click="changeNo('2')" style="color: gray">
        <span slot="title" :class="{'textcolor' : activePath === '3'}">ta的关注</span>
      </el-menu-item>
      <el-menu-item @click="changeNo('3')" style="color: gray">
        <span slot="title" :class="{'textcolor' : activePath === '4'}">ta的粉丝</span>
      </el-menu-item>
      <el-menu-item @click="changeNo('4')" style="color: gray">
        <span slot="title" :class="{'textcolor' : activePath === '5'}">ta的博客</span>
      </el-menu-item>
    </el-menu>
    <OthersProfile v-if="activePath === '0'"></OthersProfile>
    <OthersFavor v-if="activePath === '1'"></OthersFavor>
    <OthersFollowing v-if="activePath === '2'"></OthersFollowing>
    <OthersFollower v-if="activePath === '3'"></OthersFollower>
    <OthersBlog v-if="activePath === '4'"></OthersBlog>
  </div>
</template>

<script>
import OthersProfile from './myprofile/MyProfile'
import OthersFavor from './myfavor/MyFavor'
import OthersMessage from './mymessage/MyMessage'
import OthersFollowing from './myfollowing/MyFollowing'
import OthersFollower from './myfollower/MyFollower'
import OthersBlog from './myblog/MyBlog'
export default {
  name: 'Admin',
  components: {OthersBlog, OthersFollower, OthersFollowing, OthersFavor, OthersProfile, OthersMessage},
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
