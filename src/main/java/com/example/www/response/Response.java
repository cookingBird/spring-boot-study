package com.example.www.response;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */
@Component()
public class Response extends AbstractResponse implements IResponse{

    public Response(String msg, int code, Object data) {
        super(msg, code, data);
    }

    private Response() {
        super();
    }

    public static <T> Response success(T data) {
        Response response = new Response();
        response.setCode(200);
        response.setData(data);
        response.setMsg("success");
        return response;
    }

    public static <T> Response success(T data, int code) {
        Response response = new Response();
        response.setCode(code);
        response.setData(data);
        response.setMsg("success");
        return response;
    }

    public static <T> Response success(T data, int code, String msg) {
        Response response = new Response();
        response.setCode(code);
        response.setData(data);
        response.setMsg(msg);
        return response;
    }

    public static Response failure(String msg) {
        Response response = new Response();
        response.setCode(500);
        response.setMsg(msg);
        response.setData(null);
        return response;
    }

    public static Response failure(String msg, int code) {
        Response response = new Response();
        response.setCode(code);
        response.setMsg(msg);
        response.setData(null);
        return response;
    }

    public static <T> Response failure(String msg, int code, T data) {
        Response response = new Response();
        response.setCode(code);
        response.setData(data);
        response.setMsg(msg);
        return response;
    }

    @Override
    public String toString() {
        return "Response{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }

    @Override
    public String getMsg() {
        return super.getMsg();
    }

    @Override
    public void setMsg(String msg) {
        super.setMsg(msg);
    }

    @Override
    public int getCode() {
        return super.getCode();
    }

    @Override
    public void setCode(int code) {
        super.setCode(code);
    }

    @Override
    public Object getData() {
        return super.getData();
    }

    @Override
    protected void setData(Object data) {
        super.setData(data);
    }
}
