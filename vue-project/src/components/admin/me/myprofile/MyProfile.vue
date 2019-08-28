<template>
  <div>
    <br>
    <h3 style="float: left;margin-left: 200px">个人资料</h3>
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
    <el-button @click="hide=false" type="text" style="float: right;margin-top: 90px;margin-right: 200px">修改资料</el-button>
    <section v-if="hide===false" class="c-avatar-cutter">
      <div class="mask"></div>
      <div class="container">
        <b class="title" style="float: left;font-size: large">修改资料</b>
        <br>
        <div class="clear"></div>
        <div class="content" style="margin-top: 15px">
          <div>
            <p style="float: left;margin-top: 3px">昵称: &nbsp;</p>
            <el-input v-model="t_nickname" size="mini" style="float: left;margin-left: 10px;width: 200px"></el-input>
          </div>
          <div class="clear"></div>
          <div>
            <p style="float: left;margin-top: 3px">性别: &nbsp;</p>
            <el-select v-model="t_gender" placeholder="请选择" size="mini" style="float: left;margin-left: 10px;width: 100px">
              <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </div>
          <div class="clear"></div>
          <div>
            <p style="float: left;margin-top: 3px">生日: &nbsp;</p>
            <el-date-picker
              size="mini"
              style="float: left;margin-left: 10px;width: 200px"
              v-model="t_birth"
              type="date"
              placeholder="选择日期">
            </el-date-picker>
          </div>
          <div class="clear"></div>
          <div>
            <p style="float: left;margin-top: 3px">地区: &nbsp;</p>
            <el-input v-model="t_address" size="mini" style="float: left;margin-left: 10px;width: 200px"></el-input>
          </div>
          <div class="clear"></div>
          <div>
            <p style="float: left;margin-top: 3px">行业: &nbsp;</p>
            <el-input v-model="t_work" size="mini" style="float: left;margin-left: 10px;width: 200px"></el-input>
          </div>
          <div class="clear"></div>
          <div>
            <p style="float: left;margin-top: 3px">职位: &nbsp;</p>
            <el-input v-model="t_position" size="mini" style="float: left;margin-left: 10px;width: 200px"></el-input>
          </div>
          <div class="clear"></div>
          <div>
            <p style="float: left;margin-top: 3px">简介: &nbsp;</p>
            <el-input v-model="t_intro" type="textarea" style="float: left;margin-left: 10px;width: 400px"></el-input>
          </div>
        </div>
        <div class="c-btn-group">
          <input @click="hide=true;t_nickname=nickname;t_truename=truename;t_gender=gender;t_birth=birth;t_address=address;t_work=work;t_position=position;t_intro=intro" type="button" class="btn-cancel" value="取消">
          <input @click="uploadData" type="button" class="btn-enter" value="确定">
        </div>
      </div>
    </section>
  </div>

</template>

<script>
import Avatar from './Avatar'
export default {
  name: 'MyProfile',
  components: {Avatar},
  data () {
    return {
      hide: true,
      userId: this.$store.state.user.username,
      following: '0',
      followers: '0',
      nickname: 'Dr.Cr',
      t_nickname: 'this.nickname',
      truename: '',
      t_truename: '',
      options: [{
        value: '选项1',
        label: '男'
      }, {
        value: '选项2',
        label: '女'
      }],
      gender: '',
      t_gender: '',
      birth: '',
      t_birth: '',
      address: '',
      t_address: '',
      work: '',
      t_work: '',
      position: '',
      t_position: '',
      intro: '',
      t_intro: ''
    }
  },
  mounted () {
    this.t_nickname = this.nickname
    this.t_gender = this.gender
    this.t_birth = this.birth
    this.t_address = this.address
    this.t_work = this.work
    this.t_position = this.position
    this.t_intro = this.intro
  },
  methods: {
    uploadData () {
      var self = this
      console.log(self.nickname)
      console.log(self.userId)
      console.log(self.gender)
      console.log(self.birth)
      console.log(self.work)
      console.log(self.position)
      console.log(self.intro)
      self.$axios.post('http://localhost:8443/api/editUserHome', {
        nickname: self.nickname,
        username: self.userId,
        gender: self.gender,
        birth: self.birth,
        address: self.address,
        work: self.work,
        position: self.position,
        intro: self.intro
      })
        .then(successResponse => {
          if (successResponse.data.code === 200) {
            this.$message({
              type: 'success',
              message: '修改成功!'
            })
            this.$router.replace({path: '/admin'})
          } else {
            this.$message({
              type: 'error',
              message: '服务器错误'
            })
          }
        })
        .catch(failResponse => {
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
