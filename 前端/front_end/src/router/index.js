import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../components/Login'
import CourseInformation from '../components/CourseInformation'
import CourseManagement from '../components/CourseManagement'
import UnitContent from '../components/UnitContent'
import UnitInformation from '../components/UnitInformation'
import UnitTesting from '../components/UnitTesting'
// import fa from "element-ui/src/locale/lang/fa";

Vue.use(VueRouter)
// const path = require('path')

export default new VueRouter({
  routes: [
    { path: '/', redirect: '/Login' },
    { path: '/Login', component: Login },
    { path: '/CourseInformation', component: CourseInformation },
    { path: '/CourseManagement', component: CourseManagement },
    { path: '/UnitContent', component: UnitContent },
    { path: '/UnitInformation', component: UnitInformation },
    { path: '/UnitTesting', component: UnitTesting }
  ]
})
module.export = {
  dev: {
    assetsSubDirectory: 'static',
    assetsPublicPath: '/',
    proxyTable: {
      '/api': {
        target: 'http://127.0.0.1:8088',
        changeOrigin: true,
        pathRewrite: {
          '^/api': ''
        }
      },
      host: 'localhost',
      port: 8080,
      autoOpenBrowser: false,
      errorOverlay: true,
      notifyOnErrors: true,
      poll: false,
      devtool: 'cheap-module-eval-source-map',
      cacheBusting: true,
      cssSourceMap: true
    }
  }
}
