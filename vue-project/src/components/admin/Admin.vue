<template>
  <div id="admin">
    admin ---- {{ getUsername }}
  </div>
</template>

<script>
export default {
  name: 'admin',
  data () {
    return {
    }
  },
  methods: {
    changeUsername: function () {
      this.$store.dispatch('changeUsername', {username: 'qwerty'})
      alert('test3')
    }
  },
  computed: {
    getUsername: function () {
      return this.$store.getters.getUsername()
    }
  }
}
</script>

<style>
  #admin {
    background:url("../../assets/timg.jpg") no-repeat;
    background-position: center;
    height: 100%;
    width: 100%;
    background-size: cover;
    position: fixed;
  }

</style>
