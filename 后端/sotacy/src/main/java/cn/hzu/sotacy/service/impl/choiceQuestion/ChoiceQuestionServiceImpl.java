package cn.hzu.sotacy.service.impl.choiceQuestion;
import cn.hzu.sotacy.dao.choiceQuestion.ChoiceQuestionOptionDao;
import cn.hzu.sotacy.model.choiceQuestion.ChoiceQuestion;
import cn.hzu.sotacy.dao.choiceQuestion.ChoiceQuestionDao;
import cn.hzu.sotacy.model.choiceQuestion.ChoiceQuestionOption;
import cn.hzu.sotacy.response.ApiRestResponse;
import cn.hzu.sotacy.result.CodeResult;
import cn.hzu.sotacy.service.choiceQuestion.ChoiceQuestionOptionService;
import cn.hzu.sotacy.service.choiceQuestion.ChoiceQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
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
public class ChoiceQuestionServiceImpl extends ServiceImpl<ChoiceQuestionDao, ChoiceQuestion> implements ChoiceQuestionService {

    @Resource
    ChoiceQuestionOptionService choiceQuestionOptionService;

    @Resource
    ChoiceQuestionDao choiceQuestionDao;

    @Resource
    ChoiceQuestionOptionDao choiceQuestionOptionDao;

    /**
     * 添加选择题
     * @param request  请求
     * @param response 回复
     * @return cn.hzu.sotacy.response.ApiRestResponse<cn.hzu.sotacy.model.choiceQuestion.ChoiceQuestion>
     * @author Jasper Zhan
     * @date 2021/12/23 23:50
     */
    @Override
    public ApiRestResponse<ChoiceQuestion> addChoiceQuestion(HttpServletRequest request, HttpServletResponse response) {

        String subject = request.getParameter("subject");
        String answerOption = request.getParameter("answerOption");
        String[] option = request.getParameterValues("option");
        String courseUnitId = request.getParameter("courseUnitId");

        ChoiceQuestion choiceQuestion = new ChoiceQuestion();

        if (courseUnitId == null)
            return ApiRestResponse.fail(CodeResult.EMPTY_COURSE_UNIT_ID);

        if (subject == null)
            return ApiRestResponse.fail(CodeResult.EMPTY_CHOICE_QUESTION_SUBJECT);
        choiceQuestion.setSubject(subject);

        save(choiceQuestion);
        System.out.println(choiceQuestion.getId());
        request.getSession().setAttribute("choiceQuestionId", choiceQuestion.getId());

        if (answerOption == null)
            return ApiRestResponse.fail(CodeResult.EMPTY_JUDGMENT_QUESTION_ANSWER);

        int answerOptionId;

        try {
            answerOptionId = Integer.parseInt(answerOption);
        } catch (NumberFormatException e) {
            return ApiRestResponse.fail(CodeResult.ERROR_FORMAT_CHOICE_QUESTION_ANSWER_OPTION);
        }

        if (option == null)
            return ApiRestResponse.fail(CodeResult.EMPTY_CHOICE_QUESTION_OPTION);

        if (answerOptionId >= option.length)
            return ApiRestResponse.fail(CodeResult.ERROR_CHOICE_QUESTION_ANSWER_OPTION);

        request.getSession().setAttribute("answerOptionId", answerOptionId);

        ApiRestResponse<ChoiceQuestionOption> apiRestResponse;
        // 保存选择题选项
        apiRestResponse = choiceQuestionOptionService.addChoiceQuestionOptions(request, response);

        if (!apiRestResponse.isSuccess())
            return ApiRestResponse.fail(apiRestResponse.getCodeResult());

        answerOptionId = apiRestResponse.getData().getId();
        choiceQuestion.setAnswerOptionId(answerOptionId);
        updateById(choiceQuestion);

        choiceQuestionDao.addRelationToCourseUnit(Integer.valueOf(courseUnitId), choiceQuestion.getId());
        System.out.println(answerOptionId);

        return ApiRestResponse.success(CodeResult.SUCCESS_ADD_CHOICE_QUESTION, choiceQuestion);
    }

    /**
     * 查询课程单元的全部选择题
     * @param request  请求
     * @param response 回复
     * @return cn.hzu.sotacy.response.ApiRestResponse<java.util.List < cn.hzu.sotacy.model.choiceQuestion.ChoiceQuestion>>
     * @author Jasper Zhan
     * @date 2021/12/25 10:30
     */
    @Override
    public ApiRestResponse<List<ChoiceQuestion>> getAllChoiceQuestionByCourseUnit(HttpServletRequest request, HttpServletResponse response) {

        String sCourseUnitId = request.getParameter("courseUnitId");

        if (sCourseUnitId == null)
            return ApiRestResponse.fail(CodeResult.EMPTY_COURSE_UNIT_ID);

        int courseUnitId;

        try {
            courseUnitId = Integer.parseInt(sCourseUnitId);
        } catch (NumberFormatException e) {
            return ApiRestResponse.fail(CodeResult.ERROR_FORMAT_COURSE_UNIT_ID);
        }

        List<ChoiceQuestion> list = choiceQuestionDao.getChoiceQuestions(courseUnitId);

        if (list == null || list.size() == 0)
            return ApiRestResponse.fail(CodeResult.EMPTY_CHOICE_QUESTION);

        for (ChoiceQuestion choiceQuestion: list) {
            choiceQuestion.setChoiceQuestionOptions(
                    choiceQuestionOptionDao.getChoiceQuestionOptionsByChoiceQuestionId(choiceQuestion.getId()));
        }

        return ApiRestResponse.success(CodeResult.SUCCESS_GET_CHOICE_QUESTION, list);
    }
}
