<template>
  <section class="p-user-data">
    <img :src="imgSrc">
    <div class="btn" @click="showCutter=true">点击上传图片</div>
    <AvatarCutter v-if="showCutter" @cancel="showCutter = false" return-type="url" @enter="uploadAvatar"></AvatarCutter>
  </section>
</template>

<script>
import AvatarCutter from './AvatarCutter'
export default {
  name: 'Avatar',
  components: {AvatarCutter},
  data () {
    return {
      imgSrc: 'http://www.luckly-mjw.cn/baseSource/picture-avatar-03.png',
      showCutter: false, // 是否显示头像裁剪组件
      userInfo: {}
    }
  },
  methods: {
    // 上传裁剪好的头像
    uploadAvatar (src) {
      this.imgSrc = src
      this.showCutter = false
    }
  }
}
</script>

<style lang="scss" scoped>
  .p-user-data {
    background-color: white;
    img {
      display: block;
      width: 100px;
      height: 100px;
      background-image: url(../../../../assets/empty.png);
      background-repeat: round;
    }
    .btn {
      display: block;
      float: left;
      margin-top: 20px;
      width: 100px;
      height: 20px;
      line-height: 10px;
      font-size: 12px;
      color: white;
      border-radius: 4px;
      text-align: center;
      box-sizing: border-box;
      background-color: #3D8AC7;
    }
  }
</style>
