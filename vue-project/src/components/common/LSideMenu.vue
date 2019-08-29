<template>
  <el-menu
    class="categories"
    default-active="activeIndex"
    background-color="white"
    active-text-color="red">
    <el-menu-item index="0" style="color: gray" v-on:click="gotoList('0', 'listRecommend')">
      <i class="el-icon-menu"></i>
      <span slot="title">推荐</span>
    </el-menu-item>
    <el-menu-item index="1" style="color: gray" v-on:click="gotoList('1', 'listFollow')">
      <i class="el-icon-menu"></i>
      <span slot="title">收藏</span>
    </el-menu-item>
    <el-menu-item index="2" style="color: gray" v-on:click="gotoList('2', 'Vue')">
      <i class="el-icon-menu"></i>
      <span slot="title">Vue</span>
    </el-menu-item>
    <el-menu-item index="3" style="color: gray" v-on:click="gotoList('3', 'Springboot')">
      <i class="el-icon-menu"></i>
      <span slot="title">Springboot</span>
    </el-menu-item>
    <el-menu-item index="4" style="color: gray" v-on:click="gotoList('3', 'MongoDB')">
      <i class="el-icon-menu"></i>
      <span slot="title">MongoDB</span>
    </el-menu-item>
    <el-menu-item index="5" style="color: gray" v-on:click="gotoList('3', 'HTML')">
      <i class="el-icon-menu"></i>
      <span slot="title">HTML</span>
    </el-menu-item>
    <el-menu-item index="6" style="color: gray" v-on:click="gotoList('3', 'Others')">
      <i class="el-icon-menu"></i>
      <span slot="title">杂项</span>
    </el-menu-item>
  </el-menu>
</template>

<script>
export default {
  name: 'SideMenu',
  inject: ['reload'],
  data () {
    return {
      activeIndex: '0'
    }
  },
  methods: {
    gotoList: function (active, Type) {
      this.changeActive(active)
      this.$router.push('/index/blogList/' + Type)
      this.reload()
    },
    changeActive: function (index) {
      this.activeIndex = index
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
