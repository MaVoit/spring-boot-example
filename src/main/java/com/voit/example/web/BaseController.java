package com.voit.example.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import java.util.stream.Collectors;

/**
 * Exception handler for all controller.
 *
 * @author mark voit
 */
public class BaseController {

    private static Logger LOGGER = LoggerFactory.getLogger(BaseController.class);


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleUncaughtException(Exception ex, WebRequest request, HttpServletResponse response) {
        LOGGER.error("handle error", ex);
        return new ErrorResponse(500, ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request, HttpServletResponse response) {
        LOGGER.error("handle illegal argument", ex.getCause());
        return new ErrorResponse(400, ex.getMessage());
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleBindException(BindException ex, WebRequest request, HttpServletResponse response) {
        LOGGER.error("handle bind error", ex.getCause());
        String message = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(", "));
        return new ErrorResponse(400, message);
    }

    public class ErrorResponse {
        public int code;
        public String message;

        public ErrorResponse(int code, String message) {
            this.message = message;
            this.code = code;
        }
    }
}
