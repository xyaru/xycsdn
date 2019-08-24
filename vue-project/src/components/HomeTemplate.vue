<template>
  <div id="home-template">
    <el-container>
      <el-header>
        <div class="main-menu">
          <a href="/">logo(返回首页)</a>
          <el-menu :default-active="$route.path" mode="horizontal" router>
            <el-menu-item index="/home/blog/list">博客列表</el-menu-item>
            <el-menu-item index="/home/other/list">另一个列表</el-menu-item>
          </el-menu>
        </div>
        <div id="user-setting">
          <!--<i class="el-icon-setting" />-->
          <el-menu :default-active="activeIndex" mode="horizontal">
            <el-submenu index="1">
              <template slot="title">用户名</template>
              <el-menu-item index="1-1" >退出</el-menu-item>
            </el-submenu>
          </el-menu>
        </div>
      </el-header>
      <el-main>
        <div class="my-container">
          <router-view></router-view>
        </div>
      </el-main>
      <el-footer>
        我是底部
      </el-footer>
    </el-container>
  </div>
</template>

<script>
export default {
  name: 'HomeTemplate',
  data () {
    return {
    }
  }
}
</script>

<style scoped>

</style>
