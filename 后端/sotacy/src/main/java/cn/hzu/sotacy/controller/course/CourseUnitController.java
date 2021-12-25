package cn.hzu.sotacy.controller.course;


import cn.hzu.sotacy.model.course.CourseUnit;
import cn.hzu.sotacy.response.ApiRestResponse;
import cn.hzu.sotacy.service.course.CourseUnitService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 作者
 * @since 2021-12-23
 */
@RestController
@RequestMapping("/courseUnit")
public class CourseUnitController {

    @Resource
    CourseUnitService courseUnitService;

    @ResponseBody
    @PostMapping("/add")
    ApiRestResponse<CourseUnit> addCourseUnit(HttpServletRequest request, HttpServletResponse response) {
        return courseUnitService.addCourseUnit(request, response);
    }

    @ResponseBody
    @PostMapping("getAllOfCourse")
    ApiRestResponse<List<CourseUnit>> getAllCourseUnitsOfCourse(HttpServletRequest request, HttpServletResponse response) {
        return courseUnitService.getCourseUnitsOFCourse(request, response);
    }
}
