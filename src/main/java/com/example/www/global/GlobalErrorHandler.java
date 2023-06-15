package com.example.www.global;

import com.example.www.response.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

@RestControllerAdvice
public class GlobalErrorHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public Response illegalArgumentExceptionHandler(Exception e) {
        Response response = new Response();
        response.failure(e.getMessage());
        return response;
    }

    @ExceptionHandler(SQLException.class)
    @ResponseBody
    public Response sqlExceptionHandler(Exception e) {
        Response response = new Response();
        response.failure(e.getMessage());
        return response;
    }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseBody
    public Response illegalStateExceptionHandler(Exception e) {
        return Response.failure(e.getMessage());;
    }
}
