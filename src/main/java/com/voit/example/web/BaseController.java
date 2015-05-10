package com.voit.example.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;

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
        LOGGER.error("handle error", ex.getCause());
        return new ErrorResponse(500, ex.getCause().getClass().getName());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request, HttpServletResponse response) {
        LOGGER.error("handle illegal argument", ex.getCause());
        return new ErrorResponse(500, ex.getCause().getClass().getName());
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
