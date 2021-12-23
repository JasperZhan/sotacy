import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../components/Login'
import CourseInformation from '../components/CourseInformation'
import CourseManagement from '../components/CourseManagement'
import UnitContent from '../components/UnitContent'
import UnitInformation from '../components/UnitInformation'
import UnitTesting from '../components/UnitTesting'
import CreationCourse from '../components/CreationCourse'

Vue.use(VueRouter)

export default new VueRouter({
  routes: [
    { path: '/', redirect: '/Login' },
    { path: '/Login', component: Login },
    { path: '/CourseInformation', component: CourseInformation },
    { path: '/CourseManagement', component: CourseManagement },
    { path: '/UnitContent', component: UnitContent },
    { path: '/UnitInformation', component: UnitInformation },
    { path: '/UnitTesting', component: UnitTesting },
    { path: '/CreationCourse', component: CreationCourse }
  ]
})
