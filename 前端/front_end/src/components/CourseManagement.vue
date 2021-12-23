<!--课程管理界面-->
<template>
<div class="body_container">
  <el-menu class="el-menu-demo"
  background-color="#d9ecff">
    <el-menu-item style="float: right;margin-top: 50px;">
      <el-button type="primary" >退出登录</el-button>
    </el-menu-item>
  </el-menu>
  <el-row>
    <el-col :span="2" style="background-color: #d9ecff;height: 100%;">
      <el-radio-group v-model="isCollapse"  style="margin-left: 20%;margin-bottom: 10px" >
<!--        <el-radio-button :label="isLeft" @click="ifOpen">侧面导航栏</el-radio-button>-->
        <el-radio-button :label="false" style="max-height: 20px">展开</el-radio-button>
        <el-radio-button :label="true">收起</el-radio-button>
      </el-radio-group>
      <el-menu default-active="1-4-1" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose" :collapse="isCollapse" >
        <el-submenu index="1">
          <template slot="title">
            <i class="el-icon-menu"></i>
            <span slot="title">课程管理</span>
          </template>
          <el-menu-item-group>
            <el-menu-item index="1-1">全部课程</el-menu-item>
          </el-menu-item-group>
          <el-menu-item-group>
            <el-menu-item index="1-2">部分课程</el-menu-item>
          </el-menu-item-group>
        </el-submenu>
        <el-menu-item index="2">
          <i class="el-icon-menu"></i>
          <span slot="title">用户管理</span>
        </el-menu-item>
        <el-menu-item index="3">
          <i class="el-icon-document"></i>
          <span slot="title">数据分析</span>
        </el-menu-item>
        <el-menu-item index="4">
          <i class="el-icon-setting"></i>
          <span slot="title">系统管理</span>
        </el-menu-item>
        <el-menu-item index="5">
          <i class="el-icon-setting"></i>
          <span slot="title">管理员管理</span>
        </el-menu-item>
      </el-menu>
    </el-col>
  </el-row>
</div>
</template>

<script>
export default {
  name: 'CourseManagement',
  data () {
    return {
      isCollapse: true
    }
  },
  methods: {
    handleOpen (key, keyPath) {
      console.log(key, keyPath)
    },
    handleClose (key, keyPath) {
      console.log(key, keyPath)
    }
  }
}
</script>

<style lang="less" scoped>

.body_container{
  background-color: #ffffff;
  height: 100%;
}
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  min-height: 400px;
}

</style>
