package com.goumen.xiwan.controller;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author hanguocai
 * @version V1.0
 * @ClassName: ControllerExceptionHandler
 */
@ControllerAdvice
@ResponseBody
public class ControllerExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler()
    public ServiceResponse handleHttpMessageNotReadableException(Exception e) {
        ServiceResponse serviceResponse = new ServiceResponse(1, "错误");
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) e;
            BindingResult bindingResult = methodArgumentNotValidException.getBindingResult();
            String message = null;
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                message += fieldError.getDefaultMessage() + ", ";
            }
            serviceResponse.setCode(1);
            serviceResponse.setMessge(message);
            return serviceResponse;

        }
        return serviceResponse;
    }

    @Data
    private static class ServiceResponse {
        private int code;
        private String messge;

        public ServiceResponse() {}

        public ServiceResponse(int code, String messge) {
            this.code = code;
            this.messge = messge;
        }
    }
}
