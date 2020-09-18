package com.hjf.utils;

/**
 * 功能 :只是一个包装类的作用,在controller层少写几行代码而已
 * 比如这里的成功
 */
public class ResultUtil {

    public static Result success(Object object){
        Result result=new Result();
        result.setCode(0);
        result.setMag("成功");
        result.setData(object);
        return result;
    }

    //这个方法很巧妙
    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code, String msg){
        Result result=new Result();
        result.setCode(code);
        result.setMag(msg);
        return result;
    }

}
