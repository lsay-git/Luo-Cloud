package org.luo.core.exception;

import org.luo.core.constant.Constants;

/**
 * @Date 16:14 2021/4/27
 * @Description {
 *   自定义异常
 * }
 * @Author lsay
 **/
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private Integer code;

    private String msg;

    public ServiceException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ServiceException(String msg){
        this(Constants.ERROR_CODE,msg);
    }

    public ServiceException(){
        this(Constants.ERROR_CODE,Constants.ERROR_MSG);
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
