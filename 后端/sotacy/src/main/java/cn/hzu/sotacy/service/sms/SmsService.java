package cn.hzu.sotacy.service.sms;



import cn.hzu.sotacy.model.Code;
import cn.hzu.sotacy.response.ApiRestResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Jasper Zhan
 * @date 2021年12月21日 12:25
 */
public interface SmsService {

    /**
     * 发送验证码
     * @author Jasper Zhan
     * @date 2021/12/21 12:26
     * @param request 请求
     * @param session 会话
     * @return cn.hzu.dms.response.ApiRestResponse<cn.hzu.dms.model.Code>
     */
    ApiRestResponse<Code> sendCode(HttpServletRequest request, HttpSession session);

    /**
     * 校验验证码
     * @author Jasper Zhan
     * @date 2021/12/21 18:05
     * @param request 请求
     * @param session 会话
     * @return cn.hzu.dms.response.ApiRestResponse<cn.hzu.dms.model.Code>
     */
    ApiRestResponse<Code> checkCode(HttpServletRequest request, HttpSession session);
}
