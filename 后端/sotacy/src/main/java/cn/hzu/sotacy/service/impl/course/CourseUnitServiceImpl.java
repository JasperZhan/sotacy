package cn.hzu.sotacy.service.impl.course;
import cn.hzu.sotacy.model.course.CourseUnit;
import cn.hzu.sotacy.dao.course.CourseUnitDao;
import cn.hzu.sotacy.response.ApiRestResponse;
import cn.hzu.sotacy.result.CodeResult;
import cn.hzu.sotacy.service.course.CourseUnitService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 作者
 * @since 2021-12-23
 */
@Service
public class CourseUnitServiceImpl extends ServiceImpl<CourseUnitDao, CourseUnit> implements CourseUnitService {

    @Resource
    CourseUnitDao courseUnitDao;

    /**
     * 新建课程单元
     * @param request  请求
     * @param response 回复
     * @return cn.hzu.sotacy.response.ApiRestResponse<cn.hzu.sotacy.model.course.CourseUnit>
     * @author Jasper Zhan
     * @date 2021/12/23 14:01
     */
    @Override
    public ApiRestResponse<CourseUnit> addCourseUnit(HttpServletRequest request, HttpServletResponse response) {

        String courseId = request.getParameter("courseId");
        String order = request.getParameter("order");
        String title = request.getParameter("title");
        String describe = request.getParameter("describe");

        CourseUnit courseUnit = new CourseUnit();

        if (courseId == null)
            return ApiRestResponse.fail(CodeResult.EMPTY_COURSE_ID);

        courseUnit.setCourseId(Integer.valueOf(courseId));

        if (order == null)
            return ApiRestResponse.fail(CodeResult.EMPTY_COURSE_UNIT_ORDER);

        courseUnit.setOrder(Integer.valueOf(order));

        if (title == null)
            return ApiRestResponse.fail(CodeResult.EMPTY_COURSE_UNIT_TITLE);

        courseUnit.setTitle(title);

        courseUnit.setDescribe(describe);

        courseUnitDao.addCourseUnit(courseUnit);

        return ApiRestResponse.success(CodeResult.SUCCESS_ADD_COURSE_UNIT, courseUnit);
    }
}
