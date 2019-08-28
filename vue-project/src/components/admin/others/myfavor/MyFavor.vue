<template>
  <div>
    <br>
    <h3 style="float: left;margin-left: 200px">我的收藏</h3>
    <hr style="margin-top: 80px;margin-left: 200px">
    <div v-if="favors==='0'">
      <br>
      <br>
      <br>
      <img src="../../../../assets/blank.png">
      <br>
      <br>
      <p style="color: gray">空空如也</p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'OthersFavor',
  data () {
    return {
      favors: '0'
    }
  }
}
</script>

<style scoped>

</style>
