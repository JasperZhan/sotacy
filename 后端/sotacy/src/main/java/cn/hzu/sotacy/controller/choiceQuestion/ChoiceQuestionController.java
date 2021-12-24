package cn.hzu.sotacy.controller.choiceQuestion;


import cn.hzu.sotacy.model.choiceQuestion.ChoiceQuestion;
import cn.hzu.sotacy.response.ApiRestResponse;
import cn.hzu.sotacy.service.choiceQuestion.ChoiceQuestionService;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/choiceQuestion")
public class ChoiceQuestionController {

    @Resource
    ChoiceQuestionService choiceQuestionService;

    @ResponseBody
    @PostMapping("/add")
    public ApiRestResponse<ChoiceQuestion> addChoiceQuestion(HttpServletRequest request, HttpServletResponse response){
        return choiceQuestionService.addChoiceQuestion(request, response);
    }
}
