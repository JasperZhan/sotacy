package cn.hzu.sotacy.service.impl.choiceQuestion;

import cn.hzu.sotacy.model.choiceQuestion.ChoiceQuestionOption;
import cn.hzu.sotacy.dao.choiceQuestion.ChoiceQuestionOptionDao;
import cn.hzu.sotacy.response.ApiRestResponse;
import cn.hzu.sotacy.result.CodeResult;
import cn.hzu.sotacy.service.choiceQuestion.ChoiceQuestionOptionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
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
public class ChoiceQuestionOptionServiceImpl extends ServiceImpl<ChoiceQuestionOptionDao, ChoiceQuestionOption> implements ChoiceQuestionOptionService {

    /**
     * 添加选择题的所有选项
     * @param request  请求
     * @param response 回复
     * @return cn.hzu.sotacy.response.ApiRestResponse<cn.hzu.sotacy.model.choiceQuestion.ChoiceQuestionOption>
     * @author Jasper Zhan
     * @date 2021/12/24 1:04
     */
    @Override
    public ApiRestResponse<ChoiceQuestionOption> addChoiceQuestionOptions(HttpServletRequest request, HttpServletResponse response) {

        String[] options = request.getParameterValues("option");
        Integer choiceQuestionId = (Integer) request.getSession().getAttribute("choiceQuestionId");
        Integer answerOptionId = (Integer) request.getSession().getAttribute("answerOptionId");

        List<ChoiceQuestionOption> optionList = new ArrayList<>();

        ChoiceQuestionOption choiceQuestionOption = new ChoiceQuestionOption();
        choiceQuestionOption.setContent(options[answerOptionId]);
        choiceQuestionOption.setChoiceQuestionId(choiceQuestionId);
        save(choiceQuestionOption);
        System.out.println(choiceQuestionOption.getId());

        for (int i = 0; i < options.length; i++) {

            if (i == answerOptionId)
                continue;

            ChoiceQuestionOption option = new ChoiceQuestionOption();
            option.setChoiceQuestionId(choiceQuestionId);
            option.setContent(options[i]);
            optionList.add(option);
        }

        saveBatch(optionList);

        return ApiRestResponse.success(CodeResult.SUCCESS_ADD_CHOICE_QUESTION_OPTIONS, choiceQuestionOption);
    }
}
