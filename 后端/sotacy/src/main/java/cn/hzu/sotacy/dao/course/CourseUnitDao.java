package cn.hzu.sotacy.dao.course;

import cn.hzu.sotacy.model.course.CourseUnit;
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
public interface CourseUnitDao extends BaseMapper<CourseUnit> {
    int addCourseUnit(CourseUnit courseUnit);
}
