package org.luo.core.handler;

import org.luo.core.exception.ServiceException;
import org.luo.core.domain.R;
import org.luo.core.tool.utils.LogUtils;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Date 16:07 2021/4/27
 * @Description {
 *   全局异常处理器
 * }
 * @Author lsay
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LogUtils.logger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public R handleException(Exception e)
    {
        log.error(e.getMessage(), e);
        return R.error(e.getMessage());
    }

    @ExceptionHandler(ServiceException.class)
    public R serviceException(ServiceException e){
        log.error(e.getMsg());
        return R.error(e.getCode(),e.getMsg());
    }

}
