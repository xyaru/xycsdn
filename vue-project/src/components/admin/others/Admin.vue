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
        <span slot="title" :class="{'textcolor' : activePath === '2'}">ta的勋章</span>
      </el-menu-item>
      <el-menu-item @click="changeNo('3')" style="color: gray">
        <span slot="title" :class="{'textcolor' : activePath === '3'}">ta关注的人</span>
      </el-menu-item>
      <el-menu-item @click="changeNo('4')" style="color: gray">
        <span slot="title" :class="{'textcolor' : activePath === '4'}">ta的粉丝</span>
      </el-menu-item>
      <el-menu-item @click="changeNo('5')" style="color: gray">
        <span slot="title" :class="{'textcolor' : activePath === '5'}">ta的博客</span>
      </el-menu-item>
    </el-menu>
    <MyProfile v-if="activePath === '0'"></MyProfile>
    <MyFavor v-if="activePath === '1'"></MyFavor>
  </div>
</template>

<script>
import MyProfile from './myprofile/MyProfile'
import MyFavor from './myfavor/MyFavor'
export default {
  name: 'Admin',
  components: {MyFavor, MyProfile},
  data () {
    return {
      activePath: '0',
      userId: this.$route.params.username
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
