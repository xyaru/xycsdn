<template>
  <el-menu
    :default-active="$route.path"
    router
    mode="horizontal"
    background-color="white"
    text-color="#222"
    active-text-color="red"
    style="width: 100%">
    <el-menu-item index="/index">
      <router-link :to="{ path: '/index'}" style="color: dodgerblue;"><p>首页</p></router-link>
    </el-menu-item>
    <el-menu-item index="/search">
      <router-link :to="{ path: '/search'}" style="color: dodgerblue;"><p>搜索</p></router-link>
    </el-menu-item>
    <el-menu-item index="/write">
      <p @click="showWarn('/write')" style="color: dodgerblue;">写博客</p>
    </el-menu-item>
    <el-menu-item index="/admin">
      <p @click="showWarn('/admin')" style="color: dodgerblue;">个人中心</p>
    </el-menu-item>
    <!--    -->
    <!--    -->
    <!--    -->
    <!--    -->
    <router-link v-if="!username" :to="{ path: '/login' }" style="color: dodgerblue;float: right;padding: 20px;">登录</router-link>
    <router-link v-if="!username" :to="{ path: '/regist' }" style="color: dodgerblue;float: right;padding: 20px;">注册</router-link>
    <el-button v-if="username" type="text" @click="open" style="color: dodgerblue;float: right;padding: 22px">注销</el-button>
    <router-link v-if="username" :to="{ path: '/admin' }"  @click="showWarn('/admin')" style="color: dodgerblue;float: right;padding: 20px">{{username}}</router-link>
    <i class="el-icon-menu" style="float:right;font-size: 45px;color: #222;padding-top: 8px;color: dodgerblue"></i>
<!--    <span style="position: absolute;padding-top: 20px;right: 43%;font-size: 20px;font-weight: bold;color: cornflowerblue">技术分享博客网站</span>-->
  </el-menu>
</template>

<script>
export default {
  inject: ['reload'],
  name: 'NavMenu',
  data () {
    return {
      username: this.$store.state.user.username
    }
  },
  methods: {
    open () {
      this.$confirm('确定登出?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$store.commit('logout', this.$store.state.user)
        this.reload()
        this.$message({
          type: 'success',
          message: '注销成功!'
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消'
        })
      })
    },
    showWarn (s) {
      if (!this.$store.state.user.username) {
        this.$message({
          type: 'error',
          message: '请先登录'
        })
      }
      this.$router.replace({path: s})
    }
  }
}
</script>

<style scoped>
  a{
    text-decoration: none;
  }

  span {
    pointer-events: none;
  }
</style>
