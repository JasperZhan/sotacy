package cn.hzu.sotacy.dao.blankQuestion;

import cn.hzu.sotacy.model.blankQuestion.BlankQuestion;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 作者
 * @since 2021-12-23
 */
@Mapper
public interface BlankQuestionDao extends BaseMapper<BlankQuestion> {

    Integer addRelationToCourseUnit(@Param("courseUnitId") Integer courseUnitId, @Param("blankQuestionId") Integer blankQuestionId);
}
