<template>
  <div id="blog-list">
    <h1>推荐博客</h1>

    <el-row :gutter="30">
      <!-- 单个的卡片列 -->
      <div class="container">
<!--        <el-table style="width: 100%;"-->
<!--                  :data="blogList.slice((currentPage-1)*pagesize,currentPage*pagesize)"-->
<!--        >-->
<!--        <el-table-column type="index" width="50">-->
<!--        </el-table-column>-->
<!--        <el-table-column label="username" prop="username" width="180">-->
<!--        </el-table-column>-->
<!--        <el-table-column label="comment" prop="comment" width="180">-->
<!--        </el-table-column>-->
<!--        <el-table-column label="操作" width="180">-->
<!--          <template slot-scope="scope">-->
<!--            <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>-->
<!--          </template>-->
<!--        </el-table-column>-->
<!--        </el-table>-->
<!--        <el-pagination-->
<!--          @size-change="handleSizeChange"-->
<!--          @current-change="handleCurrentChange"-->
<!--          :current-page="currentPage"-->
<!--          :page-sizes="[5, 10, 20, 40]"-->
<!--        :page-size="pagesize"-->
<!--        layout="total, sizes, prev, pager, next, jumper"-->
<!--        :total="blogList.length">    //这是显示总共有多少数据，-->
<!--        </el-pagination>-->
      <el-col :span="24" v-for="(item, index) in blogList"
              :index="index"
              :key="index"
              class=""><!-- 0 == flag || item.courseType == flag ? '' : 'hide' -->
        <!-- card div -->
        <router-link :to="'/index/blog/' + item._id">
          <div class="blog" >
            <!-- info div -->
            <div class="blog-info">
              <!-- class name div -->
              <div class="user">
                {{item.username}}
              </div>
              <!-- teacher name div -->
              <div class="comment">
                {{item.comment}}
              </div>
            </div>
          </div>
        </router-link>
      </el-col>
      </div>
    </el-row>
  </div>
</template>

<script>
export default {
  name: 'CommentList',
  data () {
    return {
      currentPage: 1,
      pagesize: 10,
      commentList: []
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
      self.$axios.get('http://localhost:8443/api/findAllBlog')
        .then(function (response) {
          self.commentList = response.data.data
        })
        .catch(function (error) {
          alert(error)
        })
    }

  }

}
</script>

<style scoped>

</style>
