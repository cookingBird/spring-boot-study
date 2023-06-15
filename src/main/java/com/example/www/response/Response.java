package com.example.www.response;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */
@Component()
@Scope("prototype")
public class Response extends AbstractResponse {
    private String msg = "";
    private int code = -1;
    private Object data = null;

    public Response(String msg, int code, Object data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public Response() {
    }


    public void setMsg(String msg) {
        this.msg = msg;
    }


    public void setCode(int code) {
        this.code = code;
    }


    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public Object getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
}
