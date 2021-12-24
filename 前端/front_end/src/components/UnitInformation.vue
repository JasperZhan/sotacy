<!--单元信息内容-->
<template>
<div>
  <el-menu class="el-menu-demo"
           background-color="#d9ecff">
    <el-menu-item style="float: right;margin-top: 20px;">
      <el-button type="primary" @click="returnLogin">退出登录</el-button>
    </el-menu-item>
  </el-menu>
</div>
</template>

<script>
export default {
  name: 'UnitInformation',
  methods: {
    returnLogin () {
      this.$router.push('/Login')
    }
  }
}
</script>

<style lang="less" scoped>

</style>
