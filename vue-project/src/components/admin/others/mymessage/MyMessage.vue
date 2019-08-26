<template>
  <div>
    <br>
    <h3 style="float: left;margin-left: 200px">我的消息</h3>
    <hr style="margin-top: 80px;margin-left: 200px">
    <div v-if="messages==='0'">
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
  name: 'MyMessage',
  data () {
    return {
      messages: '0'
    }
  }
}
</script>

<style scoped>

</style>
