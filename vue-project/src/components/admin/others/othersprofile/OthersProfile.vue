<template>
  <div>
    <br>
    <h3 style="float: left;margin-left: 200px">{{userId}}的资料</h3>
    <hr style="margin-top: 80px;margin-left: 200px">
    <!--    <p style="color: gray">ID: {{userId}}</p>-->
    <avatar style="float: left"></avatar>
    <section class="box" style="float: left;margin-left: 20px;background-color: white">
      <p style="float: left;color: gray;font-size: small">ID: &nbsp;{{userId}}</p><br>
      <div class="clear"></div>
      <p style="float: left;color: black;">关注: &nbsp;{{following}} &nbsp;&nbsp; 粉丝: &nbsp;{{followers}}</p>
      <div class="clear"></div>
      <hr style="width: 1000px">
      <p style="float: left;color: black">昵称: &nbsp;&nbsp;{{nickname}}</p>
      <div class="clear"></div>
      <p style="float: left;color: black">性别: &nbsp;&nbsp;</p>
      <div class="clear"></div>
      <p style="float: left;color: black">生日: &nbsp;&nbsp;</p>
      <div class="clear"></div>
      <p style="float: left;color: black">地区: &nbsp;&nbsp;</p>
      <div class="clear"></div>
      <p style="float: left;color: black">行业: &nbsp;&nbsp;</p>
      <div class="clear"></div>
      <p style="float: left;color: black">职位: &nbsp;&nbsp;</p>
      <div class="clear"></div>
      <p style="float: left;color: black">简介: &nbsp;&nbsp;</p>
    </section>
  </div>

</template>

<script>
import Avatar from './Avatar'
export default {
  name: 'OthersProfile',
  components: {Avatar},
  data () {
    return {
      userId: this.$route.params.username,
      following: '',
      followers: '',
      nickname: '',
      gender: '',
      birth: '',
      address: '',
      work: '',
      position: '',
      intro: ''
    }
  },
  mounted () {
    this.getData()
  },
  methods: {
    getData () {
      var self = this
      self.$axios.post('http://localhost:8443/api/visitHome', {
        username: this.userId
      })
        .then(response => {
          if (response.data.code === 200) {
            self.nickname = response.data.data.ushm.nickname
            self.gender = response.data.data.ushm.gender
            self.birth = response.data.data.ushm.birth
            self.address = response.data.data.ushm.address
            self.work = response.data.data.ushm.work
            self.position = response.data.data.ushm.position
            self.intro = response.data.data.ushm.intro
            self.followers = response.data.data.fansNumber
            self.following = response.data.data.followNumber
          } else {
            this.$message({
              type: 'error',
              message: '信息错误'
            })
          }
        })
        .catch(response => {
          this.$message({
            type: 'error',
            message: '服务器未响应'
          })
        })
    }
  }
}
</script>

<style lang="scss" scoped>
  .box {
    width: 400px;
    height: 400px;
    background-color: black;
  }
  .clear {
    clear: both;
  }
  .c-avatar-cutter {
    position: fixed;
    display: flex;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    z-index: 3;
    user-select: none;
    justify-content: center;
    .mask {
      position: absolute;
      width: 100%;
      height: 100%;
      opacity: 0.6;
      background-color: rgba(0, 0, 0, 0.6);
    }
    .container {
      position: absolute;
      padding: 20px;
      width: 642px;
      box-sizing: border-box;
      background-color: #ffffff;
    }
    .content {
      display: block;
      height: 350px;
    }
  }
  .c-btn-group {
    display: flex;
    justify-content: center;
    margin-top: 20px;
    input {
      padding: 0;
      margin: 0 12px;
      width: 100px;
      height: 40px;
      color: white;
      line-height: 38px;
      font-size: 16px;
    }
    .btn-cancel {
      background-color: gray;
    }
    .btn-enter {
      background-color: dodgerblue;
    }
  }
</style>
