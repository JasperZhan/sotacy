package cn.hzu.sotacy.result;


/**
 * 定义异常枚举
 */
public enum CodeResult {

    // 1. 异常 10000
    // 1.1 用户异常 11000

    // 1.1.1 登录异常 11100
    USER_NO_LOGIN(11101,"用户未登录"),
    USER_NO_EXIST(11102, "用户不存在"),
    PASSWORD_ERROR(11102, "密码错误"),

    // 1.1.2 注册异常 11200
    PHONE_REGISTERED(11201, "手机已注册"),


    // 1.1.3 字段处理异常 11300
    EMPTY_PHONE(11301, "手机号为空"),
    EMPTY_PASSWORD(11302, "密码为空"),
    PHONE_LENGTH_ERROR(11303, "手机号码应为11位数"),
    PHONE_FORMAT_ERROR(11304, "手机格式错误"),
    PASSWORD_LENGTH_ERROR(11305, "密码长度应为8-16位"),
    PASSWORD_NO_DIGIT_ERROR(11306, "密码应包含数字"),
    PASSWORD_NO_LETTER_ERROR(11307, "密码应包含字母"),

    // 1.2 Sms 服务异常 12000
    // 1.2.1 验证码异常 12100
    SEND_CODE_FAIL(12101, "发送验证码失败"),
    SEND_CODE_DISABLED(12102, "发送验证码服务无法使用"),
    CODE_OVERDUE(12103, "验证码过期"),
    CODE_ERROR(12104, "验证码错误"),
    SESSION_INVALID(12105, "Session 失效"),
    PHONE_MISMATCH(12106, "与发送验证码的手机号不匹配"),
    CODE_EMPTY(12107, "验证码为空"),

    // 1.3 课程服务异常 13000
    // 1.3.1 管理课程异常 13100
    FAIL_ADD_COURSE(13101, "添加课程失败"),

    // 1.3.2 用户课程异常

    // 1.3.3 课程字段异常
    EMPTY_COURSE_TITLE(13301, "课程标题为空"),
    EMPTY_COURSE_ID(13302, "课程id为空"),
    EMPTY_COURSE_UNIT_ORDER(13303, "课程单元次序为空"),
    EMPTY_COURSE_UNIT_TITLE(13304, "课程单元标题为空"),
    EMPTY_COURSE_UNIT_ID(13305, "课程单元id为空"),

    // 1.4 视频服务异常 14000
    // 1.4.1 管理视频异常 14100
    EMPTY_VIDEO_URL(14101, "视频地址为空"),
    EMPTY_VIDEO_NAME(14102, "视频名字为空"),

    // 1.5 判断题 15000
    // 1.5.1 管理判断题异常 15100
    EMPTY_JUDGMENT_QUESTION_SUBJECT(15101, "判断题题目为空"),
    EMPTY_JUDGMENT_QUESTION_ANSWER(15102, "判断题答案为空"),
    ERROR_FORMAT_JUDGMENT_QUESTION_ANSWER(15103, "判断题答案格式错误（只能为0：错或1：对）"),

    // 1.6 选择题 16000
    // 1.6.1 管理选择题异常 16100
    EMPTY_CHOICE_QUESTION_SUBJECT(16101, "选择题题目为空"),
    EMPTY_CHOICE_QUESTION_ANSWER_OPTION(16102, "选择题答案为空"),
    ERROR_FORMAT_CHOICE_QUESTION_ANSWER_OPTION(16103, "选择题答案格式错误"),
    EMPTY_CHOICE_QUESTION_OPTION(16104, "选择题选项为空"),
    ERROR_CHOICE_QUESTION_ANSWER_OPTION(16105, "选择题答案与选项不符合"),



    // 2. 业务操作成功 20000
    // 2.1 用户操作成功 21000

    // 2.1.1 登录成功 21100
    SUCCESS_LOGIN(21101, "用户登录成功"),
    SUCCESS_LOGOUT(21102, "用户退出登录成功"),

    // 2.1.2 注册成功 21200
    SUCCESS_REGISTER(21201, "用户注册成功"),

    // 2.1.3 字段正常 21300
    PHONE_LEGAL(21301, "手机号合法"),
    PASSWORD_LEGAL(21302, "密码合法"),

    // 2.1.4 密码修改成功 21400
    SUCCESS_CHANGE_PASSWORD(21401, "修改密码成功"),

    // 2.2 Sms 服务正常
    // 2.2.1 验证码操作成功
    SEND_CODE_SUCCESS(22101, "验证码发送成功"),
    CODE_CHECK_SUCCESSFUL(22102, "验证码校验成功"),

    // 2.3 课程服务正常 23000
    // 2.3.1 管理员课程操作正常 23100
    SUCCESS_ADD_COURSE(23101, "添加课程成功"),
    SUCCESS_ADD_COURSE_UNIT(23102, "添加课程单元成功"),

    // 2.4 视频服务正常 24000
    // 2.4.1 管理视频正常 24100
    SUCCESS_ADD_VIDEO(24101, "添加视频成功"),

    // 2.5 判断题 15000
    // 2.5.1 管理判断题成功 15100
    LEGAL_JUDGMENT_QUESTION_ANSWER(25101, "判断题答案格式合法"),
    SUCCESS_ADD_QUESTION_ANSWER(25102, "判断题添加成功"),

    // 2.6 选择题
    // 2.6.1 管理选择题
    SUCCESS_ADD_CHOICE_QUESTION_OPTIONS(26101, "添加选择题选项成功"),
    SUCCESS_ADD_CHOICE_QUESTION(26102, "添加选择题成功");


//    INSERT_FAILED(10005, "插入失败，请重试"),
//    UPDATE_FAILED(10008, "更新失败"),
//    NEED_ADMIN(10009, "无管理员权限"),
//    //系统异常 20000
//    SYSTEM_ERROR(20000, "系统异常");
    /**
     * 异常码 code
     * 异常信息 msg
     */
    Integer code;
    String msg;

    CodeResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}


