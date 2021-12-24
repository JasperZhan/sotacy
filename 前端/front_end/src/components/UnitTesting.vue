<!--单元测试界面-->
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
import { post } from '@/common/serviceUtil'

export default {
  name: 'UnitTesting',
  methods: {
    returnLogin () {
      post('//localhost:8088/admin/logout').then((response) => {
        console.log(response)
        if (response.data.isSuccess) {
          this.$router.push('/Login')
        } else {
          alert('呀！退出失败，请稍后再试！')
        }
      })
    }
  }
}
</script>

<style lang="less" scoped>

</style>
