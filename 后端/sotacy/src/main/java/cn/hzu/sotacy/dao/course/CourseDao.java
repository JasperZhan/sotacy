package cn.hzu.sotacy.dao.course;

import cn.hzu.sotacy.model.course.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 作者
 * @since 2021-12-23
 */
@Mapper
public interface CourseDao extends BaseMapper<Course> {

    /**
     * 添加课程并且放回主键
     * @author Jasper Zhan
     * @date 2021/12/23 12:16
     * @param course 保存的课程
     * @return java.lang.Integer
     */
    Integer addCourse(Course course);
}
