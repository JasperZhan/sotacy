package cn.hzu.sotacy.dao.choiceQuestion;

import cn.hzu.sotacy.model.choiceQuestion.ChoiceQuestion;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 作者
 * @since 2021-12-23
 */
@Mapper
public interface ChoiceQuestionDao extends BaseMapper<ChoiceQuestion> {
    Integer addRelationToCourseUnit(@Param("courseUnitId") Integer courseUnitId, @Param("choiceQuestionId") Integer choiceQuestionId);

    List<ChoiceQuestion> getChoiceQuestions(@Param("courseUnitId") Integer courseUnitId);
}
