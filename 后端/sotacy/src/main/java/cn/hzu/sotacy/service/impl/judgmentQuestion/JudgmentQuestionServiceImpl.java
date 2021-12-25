package cn.hzu.sotacy.service.impl.judgmentQuestion;

import cn.hzu.sotacy.model.Code;
import cn.hzu.sotacy.model.choiceQuestion.ChoiceQuestion;
import cn.hzu.sotacy.model.judgmentQuestion.JudgmentQuestion;
import cn.hzu.sotacy.dao.judgmentQuestion.JudgmentQuestionDao;
import cn.hzu.sotacy.response.ApiRestResponse;
import cn.hzu.sotacy.result.CodeResult;
import cn.hzu.sotacy.service.judgmentQuestion.JudgmentQuestionService;
import cn.hzu.sotacy.util.FormatCheckUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class JudgmentQuestionServiceImpl extends ServiceImpl<JudgmentQuestionDao, JudgmentQuestion> implements JudgmentQuestionService {

    @Resource JudgmentQuestionDao judgmentQuestionDao;

    /**
     * 添加判断题
     * @param request  请求
     * @param response 回复
     * @return cn.hzu.sotacy.response.ApiRestResponse<cn.hzu.sotacy.model.judgmentQuestion.JudgmentQuestion>
     * @author Jasper Zhan
     * @date 2021/12/23 15:19
     */
    @Override
    public ApiRestResponse<JudgmentQuestion> addJudgmentQuestion(HttpServletRequest request, HttpServletResponse response) {

        String subject = request.getParameter("subject");
        String answer = request.getParameter("answer");
        String courseUnitId = request.getParameter("courseUnitId");

        JudgmentQuestion judgmentQuestion = new JudgmentQuestion();

        if (courseUnitId == null)
            return ApiRestResponse.fail(CodeResult.EMPTY_COURSE_UNIT_ID);

        if (subject == null)
            return ApiRestResponse.fail(CodeResult.EMPTY_JUDGMENT_QUESTION_SUBJECT);

        judgmentQuestion.setSubject(subject);

        ApiRestResponse<JudgmentQuestion> apiRestResponse = FormatCheckUtil.answerCheck(answer);
        if (!apiRestResponse.isSuccess())
            return apiRestResponse;
        judgmentQuestion.setAnswer(answer);

        save(judgmentQuestion);

        Integer judgmentQuestionId = judgmentQuestion.getId();

        judgmentQuestionDao.addRelationToCourseUnit(Integer.valueOf(courseUnitId), judgmentQuestionId);

        return ApiRestResponse.success(CodeResult.SUCCESS_ADD_QUESTION_ANSWER);
    }

    /**
     * 查询课程单元的所有判断题
     * @param request  请求
     * @param response 回复
     * @return cn.hzu.sotacy.response.ApiRestResponse<cn.hzu.sotacy.model.judgmentQuestion.JudgmentQuestion>
     * @author Jasper Zhan
     * @date 2021/12/25 14:09
     */
    @Override
    public ApiRestResponse<List<JudgmentQuestion>> getAllJudgmentQuestionByCourseUnit(HttpServletRequest request, HttpServletResponse response) {

        String sCourseUnitId = request.getParameter("courseUnitId");

        if (sCourseUnitId == null)
            return ApiRestResponse.fail(CodeResult.EMPTY_COURSE_UNIT_ID);

        int courseUnitId;

        try {
            courseUnitId = Integer.parseInt(sCourseUnitId);
        } catch (NumberFormatException e) {
            return ApiRestResponse.fail(CodeResult.ERROR_FORMAT_COURSE_UNIT_ID);
        }

        List<JudgmentQuestion> list = judgmentQuestionDao.getJudgmentQuestions(courseUnitId);

        if (list == null || list.size() == 0)
            return ApiRestResponse.fail(CodeResult.EMPTY_JUDGMENT_QUESTION);

        return ApiRestResponse.success(CodeResult.SUCCESS_GET_JUDGMENT_QUESTION, list);
    }
}
