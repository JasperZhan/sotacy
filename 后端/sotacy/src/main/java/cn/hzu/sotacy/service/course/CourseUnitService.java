package cn.hzu.sotacy.service.course;

import cn.hzu.sotacy.model.course.CourseUnit;
import cn.hzu.sotacy.response.ApiRestResponse;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 作者
 * @since 2021-12-23
 */
public interface CourseUnitService extends IService<CourseUnit> {

    /**
     * 新建课程单元
     * @author Jasper Zhan
     * @date 2021/12/23 14:01
     * @param request 请求
     * @param response 回复
     * @return cn.hzu.sotacy.response.ApiRestResponse<cn.hzu.sotacy.model.course.CourseUnit>
     */
    ApiRestResponse<CourseUnit> addCourseUnit(HttpServletRequest request, HttpServletResponse response);
}
