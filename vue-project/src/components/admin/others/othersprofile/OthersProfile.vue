<template>
  <div>
    <h3 style="float: left">{{userId}}的资料</h3>
    <div style="clear: both"></div>
    <hr>
    <!--    <p style="color: gray">ID: {{userId}}</p>-->
    <avatar style="float: left"></avatar>
    <section class="box" style="float: left;margin-left: 20px;background-color: white">
      <p style="float: left;color: gray;font-size: small">ID: &nbsp;{{userId}}</p><br>
      <div class="clear"></div>
      <p style="float: left;color: black;">关注: &nbsp;{{following}} &nbsp;&nbsp; 粉丝: &nbsp;{{followers}}</p>
      <div class="clear"></div>
      <hr style="width: 800px">
      <p style="float: left;color: black">昵称: &nbsp;&nbsp;{{nickname}}</p>
      <div class="clear"></div>
      <p style="float: left;color: black">性别: {{gender}}&nbsp;</p>
      <div class="clear"></div>
      <p style="float: left;color: black">生日: &nbsp;{{birth}}</p>
      <div class="clear"></div>
      <p style="float: left;color: black">地区: {{address}}</p>
      <div class="clear"></div>
      <p style="float: left;color: black">行业: &nbsp;{{work}}</p>
      <div class="clear"></div>
      <p style="float: left;color: black">职位: &nbsp;{{position}};</p>
      <div class="clear"></div>
      <p style="float: left;color: black">简介: &nbsp;{{intro}}</p>
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
    if (this.userId === this.$store.state.user.username) {
      this.$router.push('/admin/myProfile')
    } else {
      this.getData()
    }
  },
  methods: {
    getData () {
      var self = this
      self.$axios.post('/api/visitHome', {
        username: this.userId
      })
        .then(response => {
          if (response.data.code === 200) {
            self.nickname = response.data.data.ushm.nickname
            self.gender = response.data.data.ushm.gender
            self.birth = response.data.data.ushm.birth.slice(0, 10)
            self.address = response.data.data.ushm.address
            self.work = response.data.data.ushm.work
            self.position = response.data.data.ushm.position
            self.intro = response.data.data.ushm.intro
            self.followers = response.data.data.fansNumber
            self.following = response.data.data.followNumber
          } else {
            this.$message({
              type: 'info',
              message: '信息缺失'
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
