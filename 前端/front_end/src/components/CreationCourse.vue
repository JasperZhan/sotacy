<!--新建课程界面-->
<template>
<div>
  <el-menu class="el-menu-demo"
           background-color="#d9ecff">
    <el-menu-item style="float: right;margin-top: 20px;">
      <el-button type="primary" >退出登录</el-button>
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
          <el-menu-item index="2-2">添加单元</el-menu-item>
        </el-submenu>
        <el-submenu index="3">
          <template slot="title">
            <i class="el-icon-document"></i>
            <span slot="title">课程证书</span>
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
        <el-col :span="19" style="margin-top: 20px;background-color: aquamarine">
          <el-breadcrumb separator-class="el-icon-arrow-right" >
            <el-breadcrumb-item style="font-size: large" :to="{ path: 'CourseManagement' }">课程管理</el-breadcrumb-item>
            <el-breadcrumb-item style="font-size: large" >新建课程</el-breadcrumb-item>
          </el-breadcrumb>
        </el-col>
        <el-col :span="5" style="margin-top: 10px;background-color: bisque">
          <el-button style="float: right;margin-right: 20px;" type="primary">保存</el-button>
        </el-col>
      </el-row>
      <el-row style="background-color: #2b4b6b"><div>
        <el-form ref="form"  label-width="80px">
          <el-form-item label="课程名称:">
            <el-input style="width: 500px;" maxlength="30"></el-input>
          </el-form-item>
          <el-form-item label="课程描述:">
            <el-input type="textarea" style="width: 500px;" :rows="4"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" >创建</el-button>
          </el-form-item>
        </el-form>
      </div>
      </el-row>
    </el-col>
  </el-row>
</div>
</template>

<script>
export default {
  name: 'CreationCourse',
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

<style scoped>

</style>
