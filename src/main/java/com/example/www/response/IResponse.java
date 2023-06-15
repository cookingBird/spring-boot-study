package com.example.www.response;

public interface IResponse {
    public static  <T> Response success(T data);
    public static <T> Response success(T data,int code);
    public static <T> Response success(T data,int code,String msg);
    public static <T> Response failure(String msg);
    public static <T> Response failure(String msg,int code);
    public static <T> Response failure(String msg,int code, T data);
}
