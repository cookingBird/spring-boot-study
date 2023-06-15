package com.example.www.response;

public interface IResponse {
    public  <T> Response success(T data);
    public <T> Response success(T data,int code);
    public <T> Response success(T data,int code,String msg);
    public <T> Response failure(String msg);
    public <T> Response failure(String msg,int code);
    public <T> Response failure(String msg,int code, T data);
}
