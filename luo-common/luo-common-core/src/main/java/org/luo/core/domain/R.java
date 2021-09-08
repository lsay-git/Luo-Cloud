package org.luo.core.domain;

import org.luo.core.constant.Constants;

import java.io.Serializable;

/**
 * @Date 15:56 2021/4/27
 * @Description {
 *   响应消息主体
 * }
 * @Author lsay
 **/
public class R<T> implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 成功 */
    private static final int SUCCESS_CODE = Constants.SUCCESS_CODE;

    /** 成功描述 */
    private static final String SUCCESS_MSG = Constants.SUCCESS_MSG;

    /** 异常 */
    private static final int ERROR_CODE = Constants.ERROR_CODE;

    /** 异常描述 */
    private static final String ERROR_MSG = Constants.ERROR_MSG;

    /** 失败 */
    private static final int FAIL_CODE = Constants.FAIL_CODE;

    /** 失败描述 */
    private static final String FAIL_MSG = Constants.FAIL_MSG;

    private int code;

    private String msg;

    private T data;

    public static <T> R<T> ok()
    {
        return restResult(null, SUCCESS_CODE, SUCCESS_MSG);
    }

    public static <T> R<T> ok(T data)
    {
        return restResult(data, SUCCESS_CODE, SUCCESS_MSG);
    }

    public static <T> R<T> ok(T data, String msg)
    {
        return restResult(data, SUCCESS_CODE, msg);
    }

    public static <T> R<T> fail()
    {
        return restResult(null, FAIL_CODE, FAIL_MSG);
    }

    public static <T> R<T> fail(String msg)
    {
        return restResult(null, FAIL_CODE, msg);
    }

    public static <T> R<T> fail(T data)
    {
        return restResult(data, FAIL_CODE, null);
    }

    public static <T> R<T> fail(T data, String msg)
    {
        return restResult(data, FAIL_CODE, msg);
    }

    public static <T> R<T> fail(int code, String msg)
    {
        return restResult(null, code, msg);
    }

    public static <T> R<T> error(int code, String msg){
        return restResult(null,code,msg);
    }

    public static <T> R<T> error(String msg){
        return restResult(null,ERROR_CODE,msg);
    }

    public static <T> R<T> error(){
        return restResult(null,ERROR_CODE,ERROR_MSG);
    }

    private static <T> R<T> restResult(T data, int code, String msg)
    {
        R<T> apiResult = new R<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }
}
