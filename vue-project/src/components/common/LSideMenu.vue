<template>
  <el-menu
    class="categories"
    default-active="0"
    background-color="white"
    active-text-color="red">
    <el-menu-item index="0" style="color: gray" v-on:click="gotoRecommand">
      <i class="el-icon-menu"></i>
      <span slot="title">推荐</span>
    </el-menu-item>
    <el-menu-item index="1" style="color: gray" v-on:click="gotoFowllow">
      <i class="el-icon-menu"></i>
      <span slot="title">关注</span>
    </el-menu-item>
    <el-menu-item index="2" style="color: gray">
      <i class="el-icon-menu"></i>
      <span slot="title">Python</span>
    </el-menu-item>
    <el-menu-item index="3" style="color: gray">
      <i class="el-icon-menu"></i>
      <span slot="title">Java</span>
    </el-menu-item>
    <el-menu-item index="4" style="color: gray">
      <i class="el-icon-menu"></i>
      <span slot="title">前端</span>
    </el-menu-item>
    <el-menu-item index="5" style="color: gray">
      <i class="el-icon-menu"></i>
      <span slot="title">架构</span>
    </el-menu-item>
    <el-menu-item index="6" style="color: gray">
      <i class="el-icon-menu"></i>
      <span slot="title">区块链</span>
    </el-menu-item>
  </el-menu>
</template>

<script>
export default {
  name: 'SideMenu',
  methods: {
    gotoRecommand: function () {
      this.$router.push('/index/blog/listRecommend')
    },
    gotoFowllow: function () {
      this.$router.push('/index/blog/listFollow')
    }
  }
}
</script>

<style scoped>
  .categories {
    position: fixed;
    width: 150px;
  }
</style>
