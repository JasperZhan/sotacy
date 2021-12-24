package cn.hzu.sotacy.service.choiceQuestion;

import cn.hzu.sotacy.model.choiceQuestion.ChoiceQuestion;
import cn.hzu.sotacy.response.ApiRestResponse;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 作者
 * @since 2021-12-23
 */
public interface ChoiceQuestionService extends IService<ChoiceQuestion> {

    /**
     * 添加选择题
     * @author Jasper Zhan
     * @date 2021/12/23 23:50
     * @param request 请求
     * @param response 回复
     * @return cn.hzu.sotacy.response.ApiRestResponse<cn.hzu.sotacy.model.choiceQuestion.ChoiceQuestion>
     */
    ApiRestResponse<ChoiceQuestion> addChoiceQuestion(HttpServletRequest request, HttpServletResponse response);
}
