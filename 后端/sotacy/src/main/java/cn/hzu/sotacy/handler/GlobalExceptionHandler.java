package cn.hzu.sotacy.handler;

import cn.dev33.satoken.exception.NotLoginException;
import cn.hzu.sotacy.response.ApiRestResponse;
import cn.hzu.sotacy.result.CodeResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Jasper Zhan
 * @date 2021年12月20日 22:00
 */

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotLoginException.class)
    public ApiRestResponse<Object> handlerNotLogin(NotLoginException e){

        System.out.println("用户未登录！抛出异常：" + e.getClass().getName());
        System.out.println(e.getType());
        System.out.println(e.getLoginType());
        return ApiRestResponse.fail(CodeResult.USER_NO_LOGIN);
    }
}
