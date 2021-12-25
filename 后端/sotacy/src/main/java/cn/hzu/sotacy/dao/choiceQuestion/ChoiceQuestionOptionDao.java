package cn.hzu.sotacy.dao.choiceQuestion;

import cn.hzu.sotacy.model.choiceQuestion.ChoiceQuestionOption;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

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
public interface ChoiceQuestionOptionDao extends BaseMapper<ChoiceQuestionOption> {

    List<ChoiceQuestionOption> getChoiceQuestionOptionsByChoiceQuestionId(Integer choiceQuestionId);
}
