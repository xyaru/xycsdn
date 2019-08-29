<template>
  <div id="blog-list">
    <h1>我的关注</h1>

    <el-row :gutter="0" type="flex" justify="center">
      <!-- 单个的卡片列 -->
      <div class="container">
        <el-table style="width: 100%;"
                  :data="blogList.slice((currentPage-1)*pagesize,currentPage*pagesize)"
        >
          <el-table-column type="index" width="50">
          </el-table-column>
          <el-table-column label="user" prop="username" width="180">
          </el-table-column>
          <el-table-column label="password" prop="password" width="180">
          </el-table-column>
          <el-table-column label="操作" width="180">
            <template slot-scope="scope">
              <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
            </template>
          </el-table-column>
        </el-table>
        <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="currentPage"
          :page-sizes="[5, 10, 20, 40]"
          :page-size="pagesize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="blogList.length">    //这是显示总共有多少数据，
        </el-pagination>
      </div>
    </el-row>
  </div>
</template>

<script>
export default {
  name: 'UserSearch',
  data () {
    return {
      currentPage: 1,
      pagesize: 10,
      blogList: [],
      username: this.$store.state.user.username
    }
  },
  created: function () {
    this.handleBlogList()
  },
  methods: {
    handleSizeChange: function (size) {
      this.pagesize = size
      console.log(this.pagesize)
    },
    handleCurrentChange: function (currentPage) {
      this.currentPage = currentPage
      console.log(this.currentPage)
    },
    handleBlogList () {
      var self = this
      self.$axios.post('http://localhost:8443/api/returnMyfollow', {
        username: this.username
      })
        .then(function (response) {
          if (response.data.code === 200) {
            self.blogList = response.data.data
          } else {
            self.$message({
              type: 'warning',
              message: 'no following'})
          }
        })
        .catch(function (error) {
          alert(error)
        })
    },
    handleClick (row) {
      this.$router.push('/admin/' + row.username)
    }

  }

}
</script>

<style scoped>

</style>
