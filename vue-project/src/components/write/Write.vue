<template>
  <div>
    <el-input
      type="text"
      style="width: 100%"
      placeholder="请输入100字内的标题"
      v-model="title"
      maxlength="100"
      show-word-limit
    >
    </el-input>
    <div style="margin: 20px 0;"></div>
    <div id="summernote"></div>
    <el-button @click="saveTemp" style="float: right; margin-right: 2%">保存草稿</el-button>
    <el-button @click="postMe" style="float: right; margin-right: 2%">发表</el-button>
  </div>

</template>

<script>
import $ from 'jquery'
export default {
  name: 'Write',
  data () {
    return {
      title: window.localStorage.getItem('draft_t')
    }
  },
  mounted () {
    $('#summernote').summernote({
      lang: 'zh-CN',
      height: 300,
      minHeight: 100,
      maxHeight: 590,
      htmlMode: true,
      focus: false,
      toolbar: [
        ['style', ['bold', 'italic', 'underline', 'clear']],
        ['font', ['strikethrough', 'superscript', 'subscript']],
        ['fontsize', ['fontsize']],
        ['fontname', ['fontname']],
        ['color', ['color']],
        ['para', ['ul', 'ol', 'paragraph']],
        ['style', ['style']],
        ['insert', ['table', 'hr', 'picture', 'link']],
        ['view', ['fullscreen', 'codeview', 'help']],
        ['undo', ['undo']],
        ['redo', ['redo']]
      ],
      callbacks: {
        onSubmit: function () {
          this.richContent = $('#summernote').summernote('code')
        }
      }
    })
    $('#summernote').summernote('code', window.localStorage.getItem('draft'))
  },
  methods: {
    saveTemp () {
      this.$confirm('将当前草稿保存到本地, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        window.localStorage.setItem('draft', $('#summernote').summernote('code'))
        window.localStorage.setItem('draft_t', this.title)
        this.$message({
          type: 'success',
          message: '保存成功!'
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '取消保存'
        })
      })
    },
    postMe () {
      if (this.title === '' || this.title == null) {
        if ($('#summernote').summernote('code') === '<br>') {
          this.$message({
            type: 'warning',
            message: '请填写标题和内容'
          })
        } else {
          this.$message({
            type: 'warning',
            message: '请填写标题'
          })
        }
      } else {
        if ($('#summernote').summernote('code') === '<br>') {
          this.$message({
            type: 'warning',
            message: '请填写内容'
          })
        } else {
          // var aa = $('.summernote').summernote('code')
          // console.log(typeof aa)
          // console.log(JSON.parse(aa))
          this.$axios
            .post('http://localhost:8443/api/post', {
              username: this.$store.state.user.username,
              title: this.title,
              content: $('#summernote').summernote('code')
            })
            .then(successResponse => {
              if (successResponse.data.code === 200) {
                this.$message({
                  type: 'success',
                  message: '发表成功!'
                })
                window.localStorage.removeItem('draft')
                window.localStorage.removeItem('draft_t')
                // if (successResponse.data.data === $('#summernote').summernote('code')) {
                //   this.$message({
                //     type: 'success',
                //     message: '回收成功'
                //   })
                // }
                this.$router.replace({path: '/index'})
              } else {
                this.$message({
                  type: 'error',
                  message: '发表失败!已保存为草稿'
                })
                window.localStorage.setItem('draft_t', this.title)
                window.localStorage.setItem('draft', $('#summernote').summernote('code'))
              }
            })
            .catch(failResponse => {
              this.$message({
                type: 'error',
                message: '服务器错误'
              })
            })
        }
      }
    }
  }
}
</script>

<style scoped>
  /*.modal-backdrop.in {
    opacity: 0 !important;
    filter: alpha(opacity=0) !important;
  }*/
  /*.modal-backdrop {
    opacity: 0 !important;
    filter: alpha(opacity=0) !important;
  }*/
</style>
