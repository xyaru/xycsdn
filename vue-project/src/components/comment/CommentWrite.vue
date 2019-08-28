<template>
  <div>
    <el-input
      type="textarea"
      :autosize="{ minRows: 4}"
      placeholder="请输入评论"
      v-model="textarea">
    </el-input>
    <el-button type="primary" @click="handleClick">发表评论</el-button>
  </div>
</template>
<script>
export default {
  name: 'CommentWrite',
  data () {
    return {
      textarea: '',
      username: this.$store.state.user.username,
      blog: this.$route.params.blogNo
    }
  },
  methods: {
    handleClick: function () {
      var self = this
      if (self.textarea === '') {
        alert('评论不得为空')
      } else {
        self.$axios.post('http://localhost:8443/api/postReview', {
          content: self.textarea,
          username: self.username,
          bid: self.blog
        })
          .then(function (response) {
            alert('成功发送评论')
            self.textarea = ''
          })
          .catch(function (error) {
            alert(error)
          })
      }
    }
  }
}
</script>

<style scoped>

</style>
