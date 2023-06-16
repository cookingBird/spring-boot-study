package com.example.www.response;

/**
 * @Description 抽象类约定了类的方法
 * 上层代码只定义规范（例如：abstract class Person）；
 *
 * 不需要子类就可以实现业务逻辑（正常编译）；
 *
 * 具体的业务逻辑由不同的子类实现，调用者并不关心。
 */
public abstract class AbstractResponse {
    protected String msg = "";
    protected int code = -1;
    protected Object data = null;

    protected AbstractResponse(String msg, int code, Object data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    protected AbstractResponse() {
    }


    protected String getMsg() {
        return msg;
    }

    protected void setMsg(String msg) {
        this.msg = msg;
    }

    protected int getCode() {
        return code;
    }

    protected void setCode(int code) {
        this.code = code;
    }

    protected Object getData() {
        return data;
    }

    protected void setData(Object data) {
        this.data = data;
    }
}
