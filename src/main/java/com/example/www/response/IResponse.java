package com.example.www.response;

/**
 * @Description 接口应该是约定一个实例的行为
 * 所以接口应该是与实例相对应
 */
public interface IResponse{
    static <P,R> R success(P data){ return null; };

    static <P,R> R success(P data, int code){ return null; };

    static <P,R> R success(P data, int code, String msg){ return null; };

    static <R> R failure(String msg){ return null; };

    static <R> R failure(String msg, int code){ return null; };

    static <P,R> R failure(String msg, int code, P data){ return null; };
}
