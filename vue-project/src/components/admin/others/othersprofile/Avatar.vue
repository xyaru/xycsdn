<template>
  <section class="p-user-data">
    <img :src="imgSrc">
    <div class="btn" v-if="!isFollowed" @click="follow">关注</div>
    <div class="btn" v-if="isFollowed" @click="unfollow">取消关注</div>
  </section>
</template>

<script>
export default {
  name: 'OthersAvatar',
  inject: ['reload'],
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
    this.showAvatar()
  },
  methods: {
    showAvatar () {
      var self = this
      self.$axios.post('/api/myHead', {
        username: self.userId
      })
        .then(successResponse => {
          if (successResponse.data.code === 200) {
            self.imgSrc = successResponse.data.data
          } else {
            this.$message({
              type: 'warning',
              message: '接收图片失败'
            })
          }
        })
        .catch(failResponse => {
          this.$message({
            type: 'error',
            message: '服务器未响应'
          })
        })
    },
    follow: function () {
      var self = this
      self.$axios.post('/api/followOne', {
        usernameOne: self.myUserId,
        usernameTwo: self.userId
      })
        .then(function (response) {
          if (response.data.code === 200) {
            self.$message({
              type: 'success',
              message: self.myUserId + ' has just followed ' + self.userId})
            self.reload()
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
      self.$axios.post('/api/dfollowOne', {
        usernameOne: self.myUserId,
        usernameTwo: self.userId
      })
        .then(function (response) {
          if (response.data.code === 200) {
            self.$message({
              type: 'success',
              message: self.myUserId + ' has just stop following ' + self.userId})
            self.reload()
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
      self.$axios.post('/api/DoIFollowOne', {
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
      width: 100px;
      height: 100px;
      background-image: url(../../../../assets/empty.png);
      background-repeat: round;
    }
    .btn {
      display: block;
      float: left;
      margin-top: 40px;
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
