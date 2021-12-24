package cn.hzu.sotacy.dao.blankQuestion;

import cn.hzu.sotacy.model.blankQuestion.BlankQuestionItem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 作者
 * @since 2021-12-25
 */
@Mapper
public interface BlankQuestionItemDao extends BaseMapper<BlankQuestionItem> {
    void save(@Param("order") Integer order, @Param("content") String content, @Param("blankQuestionId") Integer blankQuestionId);
}
