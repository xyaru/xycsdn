<template>
  <div>
    <br>
    <h3 style="float: left;margin-left: 200px">个人资料</h3>
    <hr style="margin-top: 80px;margin-left: 200px">
<!--    <p style="color: gray">ID: {{userId}}</p>-->
    <avatar style="float: left"></avatar>
    <section class="box" style="float: left;margin-left: 20px;background-color: black">
      <p style="float: left;color: gray;font-size: small">ID: {{userId}}</p><br>
      <div class="clear"></div>
      <p style="float: left;color: white;">关注: {{following}} &nbsp;&nbsp; 粉丝: {{followers}}</p>
      <div class="clear"></div>
      <hr style="width: 900px;color: yellow">
    </section>
    <span style="float: left;margin-left: 20px;color: gray;font-size: small;text-align: left">ID: {{userId}}<br/>
      <p style="color: black;margin-top: 7px">关注: {{following}} &nbsp;&nbsp; 粉丝: {{followers}}</p>
      <hr style="width: 1000px">
    </span>
  </div>

</template>

<script>
import Avatar from './Avatar'
export default {
  name: 'MyProfile',
  components: {Avatar},
  data () {
    return {
      userId: 'D_in_D',
      following: '0',
      followers: '0'
    }
  }
}
</script>

<style scoped>
  .box {
    width: 400px;
    height: 400px;
    background-color: black;
  }
  .clear {
    clear: both;
  }
</style>
