package cn.hzu.sotacy.response;


import cn.hzu.sotacy.result.CodeResult;
import lombok.Data;

@Data
public class ApiRestResponse<T> {
    private CodeResult codeResult;
    private T data;
    private Boolean isSuccess;

    private static final int SUCCESS_CODE = 1;
    private static final int FALSE_CODE = 0;
    private static final String SUCCESS_MSG = "SUCCESS";
    private static final String FALSE_MSG = "FALSE";

    public ApiRestResponse(boolean isSuccess, CodeResult codeResult, T data) {
        this.codeResult = codeResult;
        this.data = data;
        this.isSuccess = isSuccess;
    }

    public ApiRestResponse(boolean isSuccess, CodeResult codeResult) {
        this.codeResult = codeResult;
        this.isSuccess = isSuccess;
    }

    //成功的时候调用的方法
    public static <T> ApiRestResponse<T> success(CodeResult codeResult, T data) {
        return new ApiRestResponse<>(Boolean.TRUE, codeResult, data);
    }

    public static <T> ApiRestResponse<T> fail(CodeResult codeResult) {
        return  new ApiRestResponse<>(Boolean.FALSE, codeResult);
    }

    public static <T> ApiRestResponse<T> success(CodeResult codeResult) {
        return new ApiRestResponse<>(Boolean.TRUE, codeResult);
    }

    public Integer getCode() {
        return codeResult.getCode();
    }


    public String getMsg() {
        return codeResult.getMsg();
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    @Override
    public String toString() {
        return "------------------------------------" +
                "ApiRestResponse = {\n" +
                "codeResult = { code = '" + codeResult.getCode() + "', msg = '" + codeResult.getMsg() + "'\n" +
                "data = " + data.toString() + "'\n" +
                "}\n" +
                "------------------------------------";
    }

}
