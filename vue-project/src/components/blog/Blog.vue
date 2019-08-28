<template>
  <div id="blog">
    <h3 id="c" style="float: left"></h3>
    <div style="clear: both"></div>
    <p id="d" style="font-size: smaller;color: gray;float: left">作者:&nbsp;</p>
    <p id="e" style="font-size: smaller;color: gray;float: left;margin-left: 200px">收藏数:&nbsp;</p>
    <el-button type='text' v-if="me" @click="rewrite">编辑文章</el-button>
    <el-button type="warning" icon="el-icon-star-off" circle v-if="!me"></el-button>
    <hr>
    <div>
      <div id="a">
        <input type="hidden" id="b" name="b">
      </div>
    </div>
    <div>
      <comment-write></comment-write>
      <comment-list></comment-list>
    </div>
  </div>

</template>

<script>
import $ from 'jquery'
import CommentList from '../comment/CommentList'
import CommentWrite from '../comment/CommentWrite'
export default {
  name: 'blog',
  components: {CommentWrite, CommentList},
  data () {
    return {
      blogId: this.$route.params.blogNo,
      me: false,
      title: '',
      content: ''
    }
  },
  mounted () {
    var self = this
    self.$axios
      .post('http://localhost:8443/api/forOne', {
        _id: self.blogId
      })
      .then(response => {
        this.title = response.data.data.title
        this.content = response.data.data.content
        $('#a').append(this.content)
        $('#c').append(this.title)
        $('#d').append(response.data.data.username)
        $('#e').append(response.data.data.collectedTimes)
        if (response.data.data.username === self.$store.state.user.username) {
          this.me = true
          window.localStorage.setItem('bid', this.blogId)
        }
      }
      )
      .catch(failResponse => {
        this.$message({
          type: 'error',
          message: '服务器错误'
        })
      })
  },
  methods: {
    favor: function () {

    },
    rewrite () {
      window.localStorage.setItem('draft', this.content)
      window.localStorage.setItem('draft_t', this.title)
      this.$router.push('/write')
    }
  }
}
</script>

<style scoped>

</style>
