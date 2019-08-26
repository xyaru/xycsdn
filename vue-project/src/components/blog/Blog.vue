<template>
  <div id="blog">
    blog
    <div>
      <div id="a">
        <input type="hidden" id="b" name="b">
      </div>
    </div>
  </div>

</template>

<script>
import $ from 'jquery'
export default {
  name: 'blog',
  data () {
    return {
      blogId: this.$route.params.blogNo
    }
  },
  mounted () {
    var self = this
    self.$axios
      .post('http://localhost:8443/api/forOne', {
        _id: self.blogId
      })
      .then(response => {
        $('#a').append(response.data.data.content)
      }
      )
      .catch(failResponse => {
        this.$message({
          type: 'error',
          message: '服务器错误'
        })
      })
  }
}
</script>

<style scoped>

</style>
