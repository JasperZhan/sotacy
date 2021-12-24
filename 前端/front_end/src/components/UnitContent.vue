<!--单元内容界面-->
<template>
<div>
  <el-menu class="el-menu-demo"
           background-color="#d9ecff">
    <el-menu-item style="float: right;margin-top: 20px;">
      <el-button type="primary" @click="returnLogin">退出登录</el-button>
    </el-menu-item>
  </el-menu>
  <el-row>
    <el-col :span="4" style="height: 100%;margin-top: 10px">
      <el-radio-group v-model="isCollapse"  style="margin-left: 20%;margin-bottom: 10px" >
        <el-radio-button :label="false" style="max-height: 20px">展开</el-radio-button>
        <el-radio-button :label="true">收起</el-radio-button>
      </el-radio-group>
      <el-menu default-active="1-4-1" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose" :collapse="isCollapse" >
        <el-menu-item index="1">
          <i class="el-icon-menu"></i>
          <span slot="title">课程信息</span>
        </el-menu-item>
        <el-submenu index="2">
          <template slot="title">
            <i class="el-icon-menu"></i>
            <span slot="title">单元内容</span>
          </template>
          <el-menu-item index="2-1">全部单元</el-menu-item>
          <el-menu-item index="2-2" @click="toUnitInformation">添加单元</el-menu-item>
        </el-submenu>
        <el-submenu index="3">
          <template slot="title">
            <i class="el-icon-document"></i>
            <span slot="title">用户管理</span>
          </template>
          <el-menu-item index="3-1">暂未开发</el-menu-item>
        </el-submenu>
        <el-submenu index="4">
          <template slot="title">
            <i class="el-icon-setting"></i>
            <span slot="title">系统管理</span>
          </template>
          <el-menu-item index="4-1">暂未开发</el-menu-item>
        </el-submenu>
        <el-submenu index="5">
          <template slot="title">
            <i class="el-icon-setting"></i>
            <span slot="title">管理员管理</span>
          </template>
          <el-menu-item index="5-1">暂未开发</el-menu-item>
        </el-submenu>
      </el-menu>
    </el-col>
    <el-col :span="20">
      <el-row style="background-color: blueviolet">
        <el-col :span="24" style="margin-top: 20px;background-color: aquamarine">
          <el-breadcrumb separator-class="el-icon-arrow-right" >
            <el-breadcrumb-item style="font-size: large" :to="{ path: 'CourseManagement' }">课程管理</el-breadcrumb-item>
            <el-breadcrumb-item style="font-size: large" >单元内容</el-breadcrumb-item>
            <el-breadcrumb-item style="font-size: large" >全部单元</el-breadcrumb-item>
          </el-breadcrumb>
        </el-col>
      </el-row>
      <el-row style="background-color: #2b4b6b">
        新建课程的主体组件写在这里啦宝，写的时候这句话记得删掉
      </el-row>
    </el-col>
  </el-row>
</div>
</template>

<script>
export default {
  name: 'UnitContent',
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
    },
    toUnitInformation () {
      this.$router.push('/UnitInformation')
    },
    returnLogin () {
      this.$router.push('/Login')
    }
  }
}
</script>

<style lang="less" scoped>

</style>
