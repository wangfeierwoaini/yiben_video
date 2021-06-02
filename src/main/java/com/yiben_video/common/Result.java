package com.yiben_video.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 王飞
 * @create 2021/5/31 10:17
 * @emai 936886169@qq.com
 */
@Data
public class Result<T> implements Serializable {

    /**
     * 状态码
     */
    private Integer code;

    /**
     *  信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;


    @Override
    public String toString() {
        return "Result{" +
                " Code='" + code + '\'' +
                ", Msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * 自定义返回
     * @param code
     * @param data
     * @param msg
     * @return
     */
    public Result<T> success(Integer code,Object data ,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setData(data);
        result.setMsg(msg);
        return result;
    }

    /**
     * 成功不带数据
     * @param resultEnum
     * @return
     */
    public Result<T> success(ResultEnum resultEnum){
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        return result;
    }
    /**
     * 成功带数据
     * @param resultEnum
     * @param object
     * @return
     */
    public Result<T> success(ResultEnum resultEnum , Object object){
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        result.setData(object);
        return result;
    }

    /**
     * 请求错误
     * @param resultEnum
     * @return
     */
    public Result<T> error(ResultEnum resultEnum){
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        return result;
    }

    /**
     * 登录授权的异常
     * @param msg
     * @return
     */
    public static Result authorizationFailed(String msg){
        Result ResponseData=new Result();
        ResponseData.setCode(401);
        ResponseData.setMsg(msg);
        ResponseData.setData(null);
        return ResponseData;
    }
}
