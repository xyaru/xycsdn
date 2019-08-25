<template>
  <div>
    <el-container>
      <el-aside>
        <LSideMenu></LSideMenu>
      </el-aside>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </div>
</template>

<script>
import LSideMenu from '../common/LSideMenu'
export default {
  name: 'index',
  components: {
    LSideMenu
  }
}
</script>

<style scoped>

</style>
