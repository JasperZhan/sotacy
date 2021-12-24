package cn.hzu.sotacy.service.impl.blankQuestion;

import cn.hzu.sotacy.model.blankQuestion.BlankQuestionItem;
import cn.hzu.sotacy.dao.blankQuestion.BlankQuestionItemDao;
import cn.hzu.sotacy.response.ApiRestResponse;
import cn.hzu.sotacy.result.CodeResult;
import cn.hzu.sotacy.service.blankQuestion.BlankQuestionItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 作者
 * @since 2021-12-25
 */
@Service
public class BlankQuestionItemServiceImpl extends ServiceImpl<BlankQuestionItemDao, BlankQuestionItem> implements BlankQuestionItemService {


    @Resource
    BlankQuestionItemDao blankQuestionItemDao;

    /**
     * 添加填空题选项
     * @param blankQuestionItemList 填空题选项
     * @return cn.hzu.sotacy.response.ApiRestResponse<cn.hzu.sotacy.model.blankQuestion.BlankQuestionItem>
     * @author Jasper Zhan
     * @date 2021/12/24 22:36
     */
    @Override
    public ApiRestResponse<BlankQuestionItem> addBlankQuestionItem(List<BlankQuestionItem> blankQuestionItemList) {

        for (BlankQuestionItem blankQuestionItem: blankQuestionItemList) {
            System.out.println(blankQuestionItem.toString());
            blankQuestionItemDao.save(blankQuestionItem.getOrder(), blankQuestionItem.getContent(), blankQuestionItem.getBlankQuestionId());
        }

        return ApiRestResponse.success(CodeResult.SUCCESS_ADD_BLANK_QUESTION_ITEM);
    }
}
