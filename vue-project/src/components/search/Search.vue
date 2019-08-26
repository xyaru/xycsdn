<template>
  <div>
    <el-input v-model="input" placeholder="请输入内容" style="margin-left: 150px"></el-input>
    <el-button icon="el-icon-search" v-on:click="processClick">全文搜索</el-button>
    <el-button icon="el-icon-search" v-on:click="processClick1">关键字/标签搜索</el-button>
    <el-button icon="el-icon-search" v-on:click="processClickUser">用户搜索</el-button>
    <el-main>
      <router-view></router-view>
    </el-main>
  </div>
</template>

<script>
import BlogListSearch from '../blog/BlogListSearch'
export default {
  components: {BlogListSearch},
  data () {
    return {
      input: ''
    }
  },
  methods: {
    processClick: function () {
      this.$router.push('/search/listSearch/' + this.input)
    },
    processClick1: function () {
      this.$router.push('/search/listSearch1/' + this.input)
    },
    processClickUser: function () {
      this.$router.push('/search/userSearch/' + this.input)
    }
  }
}
</script>

<style scoped>

</style>
