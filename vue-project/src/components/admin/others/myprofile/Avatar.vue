<template>
  <section class="p-user-data">
    <img :src="imgSrc">
    <div class="btn" @click="follow">关注</div>
  </section>
</template>

<script>
export default {
  name: 'Avatar',
  data () {
    return {
      imgSrc: 'http://www.luckly-mjw.cn/baseSource/picture-avatar-03.png',
      userInfo: {},
      myUserId: this.$store.state.user.username,
      userId: this.$route.params.username
    }
  },
  methods: {
    follow: function () {
      alert(this.myUserId + ' is going to follow ' + this.userId)
    }
  }
}
</script>

<style lang="scss" scoped>
  .p-user-data {
    background-color: white;
    img {
      display: block;
      margin-left: 200px;
      width: 100px;
      height: 100px;
      background-image: url(../../../../assets/empty.png);
      background-repeat: round;
    }
    .btn {
      display: block;
      float: left;
      margin-left: 200px;
      margin-top: 20px;
      width: 100px;
      height: 20px;
      line-height: 10px;
      font-size: 12px;
      color: white;
      border-radius: 4px;
      text-align: center;
      box-sizing: border-box;
      background-color: #3D8AC7;
    }
  }
</style>
