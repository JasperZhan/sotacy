package cn.hzu.sotacy.service.blankQuestion;

import cn.hzu.sotacy.model.blankQuestion.BlankQuestionItem;
import cn.hzu.sotacy.response.ApiRestResponse;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 作者
 * @since 2021-12-25
 */
public interface BlankQuestionItemService extends IService<BlankQuestionItem> {

    /**
     * 添加填空题选项
     * @author Jasper Zhan
     * @date 2021/12/24 22:36
     * @param blankQuestionItemList 填空题选项
     * @return cn.hzu.sotacy.response.ApiRestResponse<cn.hzu.sotacy.model.blankQuestion.BlankQuestionItem>
     */
    ApiRestResponse<BlankQuestionItem> addBlankQuestionItem(List<BlankQuestionItem> blankQuestionItemList);
}
