package com.example.www.response;

/**
 * @author dengtao
 */
public class AbstractResponse implements IResponse {
    @Override
    public static <T> Response success(T data) {
        Response response = new Response();
        response.setCode(200);
        response.setData(data);
        response.setMsg("success");
        return response;
    }

    @Override
    public static <T> Response success(T data, int code) {
        Response response = new Response();
        response.setCode(code);
        response.setData(data);
        response.setMsg("success");
        return response;
    }

    @Override
    public static <T> Response success(T data, int code, String msg) {
        Response response = new Response();
        response.setCode(code);
        response.setData(data);
        response.setMsg(msg);
        return response;
    }

    @Override
    public static Response failure(String msg) {
        Response response = new Response();
        response.setCode(500);
        response.setMsg(msg);
        response.setData(null);
        return response;
    }

    @Override
    public static Response failure(String msg, int code) {
        Response response = new Response();
        response.setCode(code);
        response.setMsg(msg);
        response.setData(null);
        return response;
    }

    @Override
    public static <T> Response failure(String msg, int code, T data) {
        Response response = new Response();
        response.setCode(code);
        response.setData(data);
        response.setMsg(msg);
        return response;
    }
}
