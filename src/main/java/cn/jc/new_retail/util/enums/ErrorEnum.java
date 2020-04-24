package cn.jc.new_retail.util.enums;

/**
 * @author ljw
 * @date 2020/1/9 16:47
 */
public enum ErrorEnum {
    /**
     * 错误信息
     */
    E_400("400","请求处理异常，请稍后再试。"),
    E_500("500","请求方式有误，请检查GET/POST"),
    E_10025("10025","参数不能为空"),
    E_501("501","请求路径不存在");
    private String errorCode;
    private String errorMsg;

    ErrorEnum(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
