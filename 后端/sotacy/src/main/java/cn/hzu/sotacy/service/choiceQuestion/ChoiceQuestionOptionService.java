package cn.hzu.sotacy.service.choiceQuestion;

import cn.hzu.sotacy.model.choiceQuestion.ChoiceQuestionOption;
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
public interface ChoiceQuestionOptionService extends IService<ChoiceQuestionOption> {

    /**
     * 添加选择题的所有选项
     * @author Jasper Zhan
     * @date 2021/12/24 1:04
     * @param request 请求
     * @param response 回复
     * @return cn.hzu.sotacy.response.ApiRestResponse<cn.hzu.sotacy.model.choiceQuestion.ChoiceQuestionOption>
     */
    ApiRestResponse<ChoiceQuestionOption> addChoiceQuestionOptions(HttpServletRequest request, HttpServletResponse response);
}
