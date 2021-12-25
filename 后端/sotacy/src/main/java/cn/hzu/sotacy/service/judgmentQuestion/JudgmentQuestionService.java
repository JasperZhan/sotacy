package cn.hzu.sotacy.service.judgmentQuestion;

import cn.hzu.sotacy.model.judgmentQuestion.JudgmentQuestion;
import cn.hzu.sotacy.response.ApiRestResponse;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 作者
 * @since 2021-12-23
 */
public interface JudgmentQuestionService extends IService<JudgmentQuestion> {

    /**
     * 添加判断题
     * @author Jasper Zhan
     * @date 2021/12/23 15:19
     * @param request 请求
     * @param response 回复
     * @return cn.hzu.sotacy.response.ApiRestResponse<cn.hzu.sotacy.model.judgmentQuestion.JudgmentQuestion>
     */
    ApiRestResponse<JudgmentQuestion> addJudgmentQuestion(HttpServletRequest request, HttpServletResponse response);

    /**
     * 查询课程单元的所有判断题
     * @author Jasper Zhan
     * @date 2021/12/25 14:09
     * @param request 请求
     * @param response 回复
     * @return cn.hzu.sotacy.response.ApiRestResponse<cn.hzu.sotacy.model.judgmentQuestion.JudgmentQuestion>
     */
    ApiRestResponse<List<JudgmentQuestion>> getAllJudgmentQuestionByCourseUnit(HttpServletRequest request, HttpServletResponse response);
}
