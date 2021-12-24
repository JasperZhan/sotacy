<!--课程管理界面-->
<template>
<div class="body_container">
  <el-menu class="el-menu-demo"
  background-color="#d9ecff">
    <el-menu-item style="float: right;margin-top: 20px;">
      <el-button type="primary" @click="returnLogin">退出登录</el-button>
    </el-menu-item>
  </el-menu>
  <el-row>
    <el-col :span="4" style="height: 100%;margin-top: 10px;">
      <el-radio-group v-model="isCollapse"  style="margin-left: 20%;margin-bottom: 10px" >
        <el-radio-button :label="false" style="max-height: 20px">展开</el-radio-button>
        <el-radio-button :label="true">收起</el-radio-button>
      </el-radio-group>
      <el-menu default-active="1-4-1" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose" :collapse="isCollapse" >
        <el-submenu index="1">
          <template slot="title">
            <i class="el-icon-menu"></i>
            <span slot="title">课程管理</span>
          </template>
            <el-menu-item index="1-1" @click="tip1">全部课程</el-menu-item>
            <el-menu-item index="1-2" @click="enterCreationCourse">新建课程</el-menu-item>
        </el-submenu>
        <el-submenu index="2">
          <template slot="title">
            <i class="el-icon-menu"></i>
            <span slot="title">用户管理</span>
          </template>
            <el-menu-item index="2-1">信息设置</el-menu-item>
            <el-menu-item index="2-2">权限设置</el-menu-item>
        </el-submenu>
        <el-submenu index="3">
          <template slot="title">
            <i class="el-icon-document"></i>
            <span slot="title">数据分析</span>
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
    <el-col :span="19" style="background-color: #2b4b6b;margin-top: 10px;">
      <el-row>
        <el-col v-for="(item,index) in CourseList" :key="index" :span="7" :offset="1" style="background-color: aliceblue;margin: 10px"  >
          <div>
            <el-card @click.native="toCourseInformation">
              <div slot="header" >
                <span>{{ item.CourseName }}</span>
              </div>
              <div>
                <span>{{item.CourseDescribe}}</span>
              </div>
              <el-divider></el-divider>
              <div style="float: right">
                <span>{{ '创建时间：' + item.CourseTime}}</span>
              </div>
            </el-card>
          </div>
        </el-col>
      </el-row>
    </el-col>
  </el-row>
</div>
</template>

<script>
import { post } from '@/common/serviceUtil'
export default {
  name: 'CourseManagement',
  data () {
    return {
      isCollapse: true,
      CourseList: [{ CourseName: '课程1', CourseDescribe: 2, CourseTime: '2021/12/24' },
        { CourseName: '课程2', CourseDescribe: 2, CourseTime: 3 },
        { CourseName: '课程3', CourseDescribe: 2, CourseTime: 3 },
        { CourseName: '课程3', CourseDescribe: 2, CourseTime: 3 }]
    }
  },
  methods: {
    handleOpen (key, keyPath) {
      console.log(key, keyPath)
    },
    handleClose (key, keyPath) {
      console.log(key, keyPath)
    },
    enterCreationCourse () {
      this.$router.push('/CreationCourse')
    }, // 点击进入新建课程界面
    tip1 () {
      alert('当前就是全部课程界面啦！')
    },
    toCourseInformation () {
      this.$router.push('/CourseInformation')
    },
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

.body_container{
  background-color: #ffffff;
  height: 100%;
}
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  min-height: 400px;
}

</style>
