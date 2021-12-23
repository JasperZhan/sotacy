package cn.hzu.sotacy.model;

import lombok.Data;


/**
 * 验证码
 * @author Jasper Zhan
 * @date 2021年12月21日 18:21
 */
@Data
public class Code {

    // 验证码
    private String Code;

    // 发送时间
    private Long sendTime;
}
