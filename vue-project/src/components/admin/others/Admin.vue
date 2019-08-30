<template>
  <div>
    <el-container>
      <el-aside width="175px">
        <el-menu
          class="categories"
          default-active="activePath"
          background-color="transparent">
          <el-menu-item @click="back()" style="color: indianred">
          <span slot="title" :class="{'textcolor' : activePath === '5'}">返回</span>
          </el-menu-item>
          <el-menu-item @click="gotoList('0', 'othersProfile')" style="color: gray">
            <span slot="title" :class="{'textcolor' : activePath === '0'}">{{this.username}}的资料</span>
          </el-menu-item>
          <el-menu-item @click="gotoList('1', 'othersFavor')" style="color: gray">
            <span slot="title" :class="{'textcolor' : activePath === '1'}">{{this.username}}的收藏</span>
          </el-menu-item>
          <el-menu-item @click="gotoList('2', 'othersFollowing')" style="color: gray">
            <span slot="title" :class="{'textcolor' : activePath === '2'}">{{this.username}}的关注</span>
          </el-menu-item>
          <el-menu-item @click="gotoList('3', 'othersFollower')" style="color: gray">
            <span slot="title" :class="{'textcolor' : activePath === '3'}">{{this.username}}的粉丝</span>
          </el-menu-item>
          <el-menu-item @click="gotoList('4', 'othersBlog')" style="color: gray">
            <span slot="title" :class="{'textcolor' : activePath === '4'}">{{this.username}}的博客</span>
          </el-menu-item>

        </el-menu>
      </el-aside>
      <el-main class="content">
        <router-view></router-view>
      </el-main>
    </el-container>
  </div>
</template>

<script>
export default {
  name: 'Others',
  data () {
    return {
      activePath: '0',
      username: this.$route.params.username
    }
  },
  methods: {
    gotoList: function (active, Type) {
      this.changeActive(active)
      this.$router.push('/user/' + this.username + '/' + Type)
      this.reload()
    },
    changeActive (a) {
      this.activePath = a
    },
    back () {
      this.$router.push('/index/blogList/listRecommend')
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
