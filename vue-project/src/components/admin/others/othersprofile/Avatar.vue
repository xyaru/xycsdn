<template>
  <section class="p-user-data">
    <img :src="imgSrc">
    <div class="btn" v-if="!isFollowed" @click="follow">关注</div>
    <div class="btn1" v-if="isFollowed" @click="unfollow">取消关注</div>
  </section>
</template>

<script>
export default {
  name: 'OthersAvatar',
  data () {
    return {
      imgSrc: 'http://www.luckly-mjw.cn/baseSource/picture-avatar-03.png',
      userInfo: {},
      myUserId: this.$store.state.user.username,
      userId: this.$route.params.username,
      isFollowed: false
    }
  },
  mounted () {
    this.checkFollowed()
  },
  methods: {
    follow: function () {
      var self = this
      self.$axios.post('http://localhost:8443/api/followOne', {
        usernameOne: this.myUserId,
        usernameTwo: this.userId
      })
        .then(function (response) {
          if (response.data.code === 200) {
            self.$message({
              type: 'success',
              message: this.myUserId + ' has just followed ' + this.userId})
          } else {
            alert('code = ' + response.data.code)
          }
        })
        .catch(function (error) {
          alert(error)
        }
        )
    },
    unfollow: function () {
      var self = this
      self.$axios.post('http://localhost:8443/api/dfollowOne', {
        usernameOne: this.myUserId,
        usernameTwo: this.userId
      })
        .then(function (response) {
          if (response.data.code === 200) {
            self.$message({
              type: 'success',
              message: this.myUserId + ' has just stop following ' + this.userId})
          } else {
            alert('code = ' + response.data.code)
          }
        })
        .catch(function (error) {
          alert(error)
        }
        )
    },
    checkFollowed: function () {
      var self = this
      self.$axios.post('http://localhost:8443/api/DoIFollowOne', {
        usernameOne: self.myUserId,
        usernameTwo: self.userId
      })
        .then(function (response) {
          if (response.data.code === 200) {
            self.isFollowed = true
          } else {
            self.isFollowed = false
          }
        })
        .catch(function (error) {
          alert(error)
        }
        )
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
    .btn1 {
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
