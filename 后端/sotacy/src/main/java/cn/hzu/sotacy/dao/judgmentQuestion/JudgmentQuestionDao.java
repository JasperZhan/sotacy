package cn.hzu.sotacy.dao.judgmentQuestion;

import cn.hzu.sotacy.model.judgmentQuestion.JudgmentQuestion;
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
public interface JudgmentQuestionDao extends BaseMapper<JudgmentQuestion> {

    Integer addRelationToCourseUnit(@Param("courseUnitId") Integer courseUnitId, @Param("judgmentQuestionId") Integer judgmentQuestionId);

    List<JudgmentQuestion> getJudgmentQuestions(@Param("courseUnitId") Integer courseUnitId);
}
