package org.luo.core.handler;

import org.luo.core.exception.ServiceException;
import org.luo.core.domain.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e)
    {
        log.error(e.getMessage(), e);
        return Result.error(e.getMessage());
    }

    @ExceptionHandler(ServiceException.class)
    public Result serviceException(ServiceException e){
        log.error(e.getMsg());
        return Result.error(e.getCode(),e.getMsg());
    }

}
