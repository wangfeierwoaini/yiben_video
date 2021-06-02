package com.yiben_video.common;

/**
 * @author 王飞
 * @create 2021/5/31 11:13
 * @emai 936886169@qq.com
 */
public enum ResultEnum {

    UNKNOWN_ERROR(-1,"未知错误"),
    SUCCESS(200,"成功"),
    SUCCESS_USER_LOGIN(2000,"登录成功"),
    USER_NOT_EXIST(404,"用户不存在"),
    USER_IS_EXISTS(201,"用户已存在"),
    DATA_IS_NULL(3,"数据为空"),
    USER_PASSWORD_ERROR(300,"密码错误"),
    SUCCESS_INQUIRE(200,"查询成功"),
    SUCCESS_SAVE(200,"添加成功"),
    SUCCESS_UPDATE(200,"修改成功"),
    SUCCESS_DELETE(410,"删除成功"),
    ERROR_INQUIRE(403,"查询失败"),
    ERROR_SAVE(403,"添加失败"),
    ERROR_UPDATE(403,"修改失败"),
    ERROR_DELETE(403,"删除失败"),
    ERROR_NOT_VIDEO(401,"视频不存在"),
    ERROR_SAVE_VIDEO(401,"视频不能为空")


            ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}

