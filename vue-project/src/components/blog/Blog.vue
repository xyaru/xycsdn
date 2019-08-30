<template>
  <div id="blog">
    <h3 id="c" style="float: left"></h3>
    <div style="clear: both"></div>
    <div>
      <p id="d" style="font-size: smaller;color: gray;float: left">作者:&nbsp;</p>
      <p id="e" style="font-size: smaller;color: gray;float: left;margin-left: 200px">收藏数:&nbsp;</p>
      <div style="clear: both"></div>
      <el-button type='text' v-if="me" @click="rewrite" style="float: left;font-size: smaller">编辑文章</el-button>
      <el-button type="warning" plain v-if="!me && !isFavored" @click="favor" icon="el-icon-star-off" circle style="float: left;"></el-button>
      <el-button type="warning" v-if="!me && isFavored" @click="unfavor" icon="el-icon-star-off" circle style="float: left;"></el-button>
    </div>
    <div style="clear: both"></div>
    <hr>
    <div>
      <el-col :span="18">
        <div style="box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);min-height: 100px" id="a">
          <input type="hidden" id="b" name="b">
        </div>
      </el-col>
    </div>
    <div style="clear: both"></div>
    <div style="margin-top: 50px">
      <comment-write></comment-write>
      <div style="clear: both"></div>
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
  inject: ['reload'],
  data () {
    return {
      blogId: this.$route.params.blogNo,
      me: false,
      title: '',
      content: '',
      isFavored: false,
      username: this.$store.state.user.username
    }
  },
  mounted () {
    var self = this
    self.$axios
      .post('/api/forOne', {
        _id: self.blogId
      })
      .then(response => {
        self.title = response.data.data.title
        self.content = response.data.data.content
        $('#a').append(this.content)
        $('#c').append(this.title)
        $('#d').append(response.data.data.username)
        $('#e').append(response.data.data.collectedTimes)
        if (response.data.data.username === self.username) {
          self.me = true
          window.localStorage.setItem('bid', this.blogId)
        } else {
          self.me = false
          self.checkFavored()
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
      var self = this
      self.$axios.post('/api/collect', {
        username: self.username,
        _id: this.blogId
      })
        .then(function (response) {
          if (response.data.code === 200) {
            self.$message({
              type: 'success',
              message: self.username + ' has just favored ' + self.blogId})
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
    unfavor: function () {
      var self = this
      self.$axios.post('/api/dcollect', {
        username: self.username,
        _id: this.blogId
      })
        .then(function (response) {
          if (response.data.code === 200) {
            self.$message({
              type: 'info',
              message: self.username + ' has just stop favoring ' + self.blogId})
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
    checkFavored: function () {
      var self = this
      self.$axios.post('/api/isCollected', {
        username: self.username,
        _id: this.blogId
      })
        .then(function (response) {
          if (response.data.code === 200) {
            self.isFavored = true
          } else {
            self.isFavored = false
          }
        })
        .catch(function (error) {
          alert(error)
        }
        )
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
