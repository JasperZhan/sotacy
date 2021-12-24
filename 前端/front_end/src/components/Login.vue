<template>
  <div class="login_container">
    <div class="lizi">
      <vue-particles
        color="#409efe"
      :particleOpacity="0.7"
      :particlesNumber="80"
      shapeType="circle"
      :particleSize="4"
      linesColor="#fff"
      :linesWidth="1"
      :lineLinked="true"
      :lineOpacity="0.4"
      :linesDistance="150"
      :moveSpeed="2"
      :hoverEffect="true"
      hoverMode="grab"
      :clickEffect="true"
      clickMode="push"
      class="lizi"
      ></vue-particles>
    </div>
    <div class="login_box">
      <!--头像区域-->
      <div class="avatar_box">
        <img src="../assets/icon_login.png" alt="">
      </div>
      <!--登陆表单区域-->
      <el-form ref="loginFormRef" :model='loginForm' :rules="loginFormRules" label-width="0px" class="login_form">
        <!--用户名-->
        <el-form-item prop="phone">
          <el-input v-model="loginForm.phone" prefix-icon="el-icon-s-custom"></el-input>
        </el-form-item>
        <!--密码-->
        <el-form-item prop='password'>
          <el-input v-model="loginForm.password" prefix-icon="el-icon-s-goods"></el-input>
        </el-form-item>
        <!--按钮-->
        <el-form-item class="btns" >
          <el-button type="primary" plain @click="login">登录</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
// eslint-disable-next-line no-unused-vars
import { post, get } from '@/common/serviceUtil'
export default {
  data () {
    return {
      imgSrc: require('../assets/icon_login.png'),
      loginForm: {
        phone: '13202182025',
        password: '123456bb'
      },
      loginFormRules: {
        phone: [
          {
            require: true,
            message: '请输入登录名称',
            trigger: 'blur'
          },
          {
            min: 11,
            max: 11,
            message: '请输入正确的手机号',
            trigger: 'blur'
          }
        ],
        // 验证密码是否合法
        password: [
          {
            require: true,
            message: '请输入登录密码',
            trigger: 'blur'
          },
          {
            min: 6,
            max: 16,
            message: '长度在6到16个字符',
            trigger: 'blur'
          }
        ]
      }
    }
  },
  methods: {
    login () {
      post('//localhost:8088/admin/login', this.loginForm).then(
        function (response) {
          if (response.data.status === 21101) {
            this.$router.replace('/CourseManagement')
          }
        }).catch(function (a) {
        alert('fuck')
      })
    }
  }
}
</script>

<style lang="less" scoped>
.login_container{
  background-color: #2b4b6b;
  height: 100%;
}
.login_box{
  width: 450px;
  height: 300px;
  background-color: #fff;
  border-radius: 3px;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%,-50%);
  .avatar_box{
    height: 130px;
    width: 130px;
    border: 1px solid #eee;
    border-radius: 50%;
    padding: 10px;
    box-shadow: 0 0 10px #ddd;
    position: absolute;
    left: 50%;
    transform: translate(-50%,-50%);
    background-color: #eeeeee;
    img{
      width: 100%;
      height: 100%;
      border-radius: 50%;
      background-color: #eee;
    }
  }
}

.login_form{
  position: absolute;
  bottom: 0;
  width: 100%;
  padding: 0 20px;
  box-sizing: border-box;
}

.btns{
  display: flex;
  justify-content: flex-end;
}

.lizi{
  width: 100%;
  height: 108%;
  position:absolute;
  left:0;
  top:0;
  /* z-index: -1; */
  background-image:radial-gradient(#002953, #041222); //添加渐变背景颜色
}
</style>
