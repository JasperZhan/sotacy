package cn.hzu.sotacy.controller.blankQuestion;


import cn.hzu.sotacy.model.blankQuestion.BlankQuestion;
import cn.hzu.sotacy.response.ApiRestResponse;
import cn.hzu.sotacy.service.blankQuestion.BlankQuestionService;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/blankQuestion")
public class BlankQuestionController {

    @Resource
    BlankQuestionService blankQuestionService;

    @ResponseBody
    @PostMapping("/add")
    public ApiRestResponse<BlankQuestion> addBlankQuestion(HttpServletRequest request, HttpServletResponse response){
        return blankQuestionService.addBlankQuestion(request, response);
    }

}
