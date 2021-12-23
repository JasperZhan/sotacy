package cn.hzu.sotacy.util;


import cn.hzu.sotacy.response.ApiRestResponse;
import cn.hzu.sotacy.result.CodeResult;

import java.util.regex.Pattern;

/**
 * 格式校验工具类
 *
 * @author Jasper Zhan
 * @date 2021/12/21 9:06
 */
public class FormatCheckUtil {

    private static final String phone_regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
    private static final Pattern phone_pattern = Pattern.compile(phone_regex);

    private static final String password_digit_regex = ".*\\d+.*";
    private static final String password_letter_regex = ".*[a-zA-Z]+.*";
    //private static final String password_symbol_regex = ".*[~!@#$%^&*()_+|<>,.?/:;'\\[\\]{}\"]+.*";

    /**
     * 手机号码格式校验
     * @author Jasper Zhan
     * @date 2021/12/21 9:25
     * @param phone 待校验的手机号码
     * @return cn.hzu.dms.response.ApiRestResponse<cn.hzu.dms.result.CodeResult>
     */
    public static ApiRestResponse<Object> phoneCheck(String phone) {

        if (phone == null)
            return ApiRestResponse.fail(CodeResult.EMPTY_PHONE);

        if (phone.length() != 11)
            return ApiRestResponse.fail(CodeResult.PHONE_LENGTH_ERROR);

        if (!phone_pattern.matcher(phone).matches())
            return ApiRestResponse.fail(CodeResult.PHONE_FORMAT_ERROR);

        return ApiRestResponse.success(CodeResult.PHONE_LEGAL);
    }

    /**
     * 密码格式校验
     * @author Jasper Zhan
     * @date 2021/12/21 10:06
     * @param password 待校验的密码
     * @return cn.hzu.dms.response.ApiRestResponse<cn.hzu.dms.result.CodeResult>
     */
    public static ApiRestResponse<Object> passwordCheck(String password) {

        if (password == null)
            return ApiRestResponse.fail(CodeResult.EMPTY_PASSWORD);

        if (password.length() < 6 || password.length() > 16)
            return ApiRestResponse.fail(CodeResult.PASSWORD_LENGTH_ERROR);

        //判断密码是否包含数字
        if (!password.matches(password_digit_regex))
            return ApiRestResponse.fail(CodeResult.PASSWORD_NO_DIGIT_ERROR);

        //判断密码是否包含字母
        if (!password.matches(password_letter_regex))
            return ApiRestResponse.fail(CodeResult.PASSWORD_NO_LETTER_ERROR);

        //判断密码是否包含特殊符号(~!@#$%^&*()_+|<>,.?/:;'[]{}\)
        //if (!password.matches(password_symbol_regex))
        //    return ApiRestResponse.result(CodeResult.)

        return ApiRestResponse.success(CodeResult.PASSWORD_LEGAL);
    }
}
