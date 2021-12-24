package cn.hzu.sotacy.service.impl.course;

import cn.hzu.sotacy.model.course.Course;
import cn.hzu.sotacy.dao.course.CourseDao;
import cn.hzu.sotacy.response.ApiRestResponse;
import cn.hzu.sotacy.result.CodeResult;
import cn.hzu.sotacy.service.course.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 作者
 * @since 2021-12-23
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseDao, Course> implements CourseService {

    @Resource
    CourseDao courseDao;

    /**
     * 新建课程
     *
     * @param request  请求
     * @param response 回复
     * @return cn.hzu.sotacy.response.ApiRestResponse<cn.hzu.sotacy.model.course.Course>
     * @author Jasper Zhan
     * @date 2021/12/23 11:48
     */
    @Override
    public ApiRestResponse<Course> addCourse(HttpServletRequest request, HttpServletResponse response) {

        String title = request.getParameter("title");
        String describe = request.getParameter("describe");

        if (title == null) {
            return ApiRestResponse.fail(CodeResult.EMPTY_COURSE_TITLE);
        }

        Course course = new Course();
        course.setTitle(title);
        course.setDescribe(describe);

        try {
            courseDao.addCourse(course);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ApiRestResponse.fail(CodeResult.FAIL_ADD_COURSE);
        }

        if (course.getId() == null)
            return ApiRestResponse.fail(CodeResult.EMPTY_COURSE_ID);

        return ApiRestResponse.success(CodeResult.SUCCESS_ADD_COURSE, course);
    }
    /**
     *
     * @author young
     * @date 2021/12/25 00:35
     * @version 1.0
     */
    @Override
    public ApiRestResponse<List<Course>> getAllCourse(HttpServletRequest request, HttpServletResponse response) {
        List<Course> courses=new ArrayList<>();
        try {
            courses=courseDao.getAll();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        if (courses==null) return ApiRestResponse.success(CodeResult.FAIL_GET_COURSE);
        else return ApiRestResponse.success(CodeResult.SUCCESS_GET_COURSE, courses);
    }
}
