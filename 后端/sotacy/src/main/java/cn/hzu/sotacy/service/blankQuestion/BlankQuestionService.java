package cn.hzu.sotacy.service.blankQuestion;

import cn.hzu.sotacy.model.blankQuestion.BlankQuestion;
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
public interface BlankQuestionService extends IService<BlankQuestion> {

    /**
     * 添加填空题
     * @author Jasper Zhan
     * @date 2021/12/24 14:38
     * @param request 请求
     * @param response 回复
     * @return cn.hzu.sotacy.response.ApiRestResponse<cn.hzu.sotacy.model.blankQuestion.BlankQuestion>
     */
    ApiRestResponse<BlankQuestion> addBlankQuestion(HttpServletRequest request, HttpServletResponse response);
}
