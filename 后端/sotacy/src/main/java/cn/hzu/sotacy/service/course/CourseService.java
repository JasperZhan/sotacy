package cn.hzu.sotacy.service.course;

import cn.hzu.sotacy.model.course.Course;
import cn.hzu.sotacy.response.ApiRestResponse;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 作者
 * @since 2021-12-23
 */
public interface CourseService extends IService<Course> {

    /**
     * 新建课程
     * @author Jasper Zhan
     * @date 2021/12/23 11:48
     * @param request 请求
     * @param response 回复
     * @return cn.hzu.sotacy.response.ApiRestResponse<cn.hzu.sotacy.model.course.Course>
     */
    ApiRestResponse<Course> addCourse (HttpServletRequest request, HttpServletResponse response);
    /**
     *
     * @author young
     * @date 2021/12/25 00:35
     * @version 1.0
     */
    ApiRestResponse<List<Course>> getAllCourse(HttpServletRequest request, HttpServletResponse response);
}
