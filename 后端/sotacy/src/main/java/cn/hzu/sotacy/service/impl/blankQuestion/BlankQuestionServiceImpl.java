package cn.hzu.sotacy.service.impl.blankQuestion;

import cn.hzu.sotacy.model.blankQuestion.BlankQuestion;
import cn.hzu.sotacy.dao.blankQuestion.BlankQuestionDao;
import cn.hzu.sotacy.model.blankQuestion.BlankQuestionItem;
import cn.hzu.sotacy.response.ApiRestResponse;
import cn.hzu.sotacy.result.CodeResult;
import cn.hzu.sotacy.service.blankQuestion.BlankQuestionItemService;
import cn.hzu.sotacy.service.blankQuestion.BlankQuestionService;
import cn.hzu.sotacy.util.GetRequestJsonUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 作者
 * @since 2021-12-23
 */
@Service
public class BlankQuestionServiceImpl extends ServiceImpl<BlankQuestionDao, BlankQuestion> implements BlankQuestionService {

    private final static String blank = "[:question]";

    @Resource
    BlankQuestionItemService blankQuestionItemService;

    @Resource
    BlankQuestionDao blankQuestionDao;

    /**
     * 添加填空题
     * @param request 请求
     * @param response 回复
     * @return cn.hzu.sotacy.response.ApiRestResponse<cn.hzu.sotacy.model.blankQuestion.BlankQuestion>
     * @author Jasper Zhan
     * @date 2021/12/24 14:38
     */
    @Override
    public ApiRestResponse<BlankQuestion> addBlankQuestion(HttpServletRequest request, HttpServletResponse response) {

        JSONObject jsonObject;

        try {
            jsonObject = GetRequestJsonUtils.getRequestJsonObject(request);
        } catch (IOException e) {
            e.printStackTrace();
            return ApiRestResponse.fail(CodeResult.ERROR_TRANSFORM_JSON);
        }

        BlankQuestion blankQuestion = JSON.toJavaObject(jsonObject, BlankQuestion.class);

        if (blankQuestion.getCourseUnitId() == null)
            return ApiRestResponse.fail(CodeResult.EMPTY_COURSE_UNIT_ID);
        System.out.println(blankQuestion.getCourseUnitId());

        if (blankQuestion.getSubject() == null)
            return ApiRestResponse.fail(CodeResult.EMPTY_BLANK_QUESTION_SUBJECT);

        int counter;
        counter = blankNumber(blankQuestion.getSubject(), 0);
        if (counter == 0)
            return ApiRestResponse.fail(CodeResult.EMPTY_BLANK_QUESTION_ITEM);

        save(blankQuestion);

        List<BlankQuestionItem> blankQuestionItemList = blankQuestion.getBlankQuestionItemList();
        if (blankQuestionItemList == null || blankQuestionItemList.size() == 0)
            return ApiRestResponse.fail(CodeResult.EMPTY_BLANK_QUESTION_ITEM_ANSWER);

        for (BlankQuestionItem blankQuestionItem: blankQuestionItemList) {

            if (blankQuestionItem.getOrder() < 1 || blankQuestionItem.getOrder() > counter)
                return ApiRestResponse.fail(CodeResult.ERROR_BLANK_QUESTION_ITEM_ORDER);

            if (blankQuestionItem.getContent() == null)
                return ApiRestResponse.fail(CodeResult.EMPTY_BLANK_QUESTION_ITEM_CONTENT);

            blankQuestionItem.setBlankQuestionId(blankQuestion.getId());

            System.out.println(blankQuestionItem);
        }

        ApiRestResponse<BlankQuestionItem> apiRestResponse = blankQuestionItemService.addBlankQuestionItem(blankQuestionItemList);
        if (!apiRestResponse.isSuccess())
            return ApiRestResponse.fail(apiRestResponse.getCodeResult());

        //System.out.println(blankQuestion.toString());

        blankQuestionDao.addRelationToCourseUnit(blankQuestion.getCourseUnitId(), blankQuestion.getId());

        return ApiRestResponse.success(CodeResult.SUCCESS_ADD_BLANK_QUESTION);
    }

    private static int blankNumber(String str, int counter) {

        if (!str.contains(blank)) {
            return 0;
        } else if (str.contains(blank)) {
            counter++;
            counter += blankNumber(str.substring(str.indexOf(blank)+blank.length()), counter);
            return counter;
        }
        return 0;
    }
}
