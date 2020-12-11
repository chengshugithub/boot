package com.example.boot.expection;

import com.example.boot.constant.ResultCode;
import com.example.boot.result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Result MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
//        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
//        return new Result(ResultCode.VALIDATE_FAILED, objectError.getDefaultMessage());
//    }
    @ExceptionHandler(Exception.class)
    public Result APIExceptionHandler(Exception e) {
        e.printStackTrace();
        return new Result(ResultCode.FAILED);
    }
}
