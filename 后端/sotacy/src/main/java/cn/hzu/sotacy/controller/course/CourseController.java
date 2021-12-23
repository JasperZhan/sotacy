package cn.hzu.sotacy.controller.course;


import cn.hzu.sotacy.model.course.Course;
import cn.hzu.sotacy.response.ApiRestResponse;
import cn.hzu.sotacy.service.course.CourseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 作者
 * @since 2021-12-23
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    @Resource
    CourseService courseService;

    @ResponseBody
    @PostMapping("/add")
    ApiRestResponse<Course> add(HttpServletRequest request, HttpServletResponse response) {
        return courseService.addCourse(request, response);
    }
}
