package cn.hzu.sotacy.service.impl.sms;


import cn.hzu.sotacy.model.Code;
import cn.hzu.sotacy.response.ApiRestResponse;
import cn.hzu.sotacy.result.CodeResult;
import cn.hzu.sotacy.service.sms.SmsService;
import com.alibaba.fastjson.JSONObject;
import com.zhenzi.sms.ZhenziSmsClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Jasper Zhan
 * @date 2021年12月21日 12:26
 */
@Slf4j
@Service
public class SmsServiceImpl implements SmsService {

    private static final String NUMBER = "0123456789";

    private static String APP_ID;
    private static String APP_KEY;
    private static String TEMPLATE_ID;

    @Value("${spring.project.sms.apiUrl}")
    private String apiUrl;

    @Value("${spring.project.sms.appId}")
    public void setAppId(String appId) {
        APP_ID = appId;
    }

    @Value("${spring.project.sms.appSecret}")
    public void setAppKey(String appKey) {
        APP_KEY = appKey;
    }

    @Value("${spring.project.sms.template-id}")
    public void setTemplateId(String templateId) {
        TEMPLATE_ID = templateId;
    }

    /**
     * 发送验证码
     *
     * @param request 请求
     * @param session 回复
     * @return cn.hzu.dms.response.ApiRestResponse<cn.hzu.dms.model.Code>
     * @author Jasper Zhan
     * @date 2021/12/21 12:26
     */
    @Override
    public ApiRestResponse<Code> sendCode(HttpServletRequest request, HttpSession session) {

        String phone = request.getParameter("phone");

        String codeNum = code(6);

        ZhenziSmsClient client = new ZhenziSmsClient(apiUrl, APP_ID, APP_KEY);

        Map<String, Object> map = new HashMap<>();

        map.put("number", phone);
        map.put("templateId", TEMPLATE_ID);

        // 添加模板参数
        String[] templateParams = new String[2];
        templateParams[0] = codeNum;
        templateParams[1] = "3分钟";
        map.put("templateParams", templateParams);

        try {
            String resultSms = client.send(map);
            JSONObject json = JSONObject.parseObject(resultSms);
            System.out.println(json);

            if (json.getIntValue("code") != 0) {
                //处理服务端错误码
                log.error("验证码发送失败，手机号：{}，错误信息：{}", phone, "发送短信失败");
                return ApiRestResponse.fail(CodeResult.SEND_CODE_FAIL);

            }

            Code code = new Code();
            code.setCode(codeNum);
            code.setSendTime(System.currentTimeMillis() / 1000);

            // 保存手机，发送的验证码，以及发送验证码的时间
            session.setAttribute("phone", phone);
            session.setAttribute("code", code.getCode());
            session.setAttribute("sendTime", code.getSendTime());

            return ApiRestResponse.success(CodeResult.SEND_CODE_SUCCESS, code);

        } catch (Exception e) {
            String error;

            StringWriter stringWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stringWriter));
            error = stringWriter.toString();

            log.error("验证码服务使用出现异常：{}", error);

            return ApiRestResponse.fail(CodeResult.SEND_CODE_DISABLED);
        }
    }

    /**
     * 校验验证码
     * @param request 请求
     * @param session 会话
     * @return cn.hzu.dms.response.ApiRestResponse<cn.hzu.dms.model.Code>
     * @author Jasper Zhan
     * @date 2021/12/21 18:05
     */
    @Override
    public ApiRestResponse<Code> checkCode(HttpServletRequest request, HttpSession session) {

        String phone = request.getParameter("phone");
        String code = request.getParameter("code");

        if (code == null)
            return ApiRestResponse.fail(CodeResult.CODE_EMPTY);

        String sendPhone;
        String sendCode;
        long sendTime;

        try {
            sendPhone = session.getAttribute("phone").toString();
            sendCode = session.getAttribute("code").toString();
            sendTime = Long.parseLong(session.getAttribute("sendTime").toString());
        } catch (NullPointerException nullPointerException) {
            nullPointerException.printStackTrace();
            return ApiRestResponse.fail(CodeResult.SESSION_INVALID);
        }

        if (!phone.equals(sendPhone))
            return ApiRestResponse.fail(CodeResult.PHONE_MISMATCH);

        if (!code.equals(sendCode))
            return ApiRestResponse.fail(CodeResult.CODE_ERROR);

        if ((System.currentTimeMillis() / 1000) - sendTime > 180) {
            session.removeAttribute("code");
            session.removeAttribute("sendTime");
            return ApiRestResponse.fail(CodeResult.CODE_OVERDUE);
        }

        return ApiRestResponse.success(CodeResult.CODE_CHECK_SUCCESSFUL);
    }


    /**
     * 返回固定长度的数字
     */
    private static String code(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(NUMBER.charAt(random.nextInt(NUMBER.length())));
        }
        return sb.toString();
    }
}
