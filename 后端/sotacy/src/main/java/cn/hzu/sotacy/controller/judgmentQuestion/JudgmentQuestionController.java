package cn.hzu.sotacy.controller.judgmentQuestion;


import cn.hzu.sotacy.model.judgmentQuestion.JudgmentQuestion;
import cn.hzu.sotacy.response.ApiRestResponse;
import cn.hzu.sotacy.service.judgmentQuestion.JudgmentQuestionService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 作者
 * @since 2021-12-23
 */
@RestController
@RequestMapping("/judgmentQuestion")
public class JudgmentQuestionController {

    @Resource
    JudgmentQuestionService judgmentQuestionService;

    @ResponseBody
    @RequestMapping("/add")
    ApiRestResponse<JudgmentQuestion> addJudgmentQuestion(HttpServletRequest request, HttpServletResponse response) {
        return judgmentQuestionService.addJudgmentQuestion(request, response);
    }
}
