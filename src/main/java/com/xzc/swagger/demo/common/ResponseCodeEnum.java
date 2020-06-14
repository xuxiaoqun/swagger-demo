package com.xzc.swagger.demo.common;

/**
 * @author xuzhicheng
 * @Description: 异常枚举
 * @date 2020/6/14 16:04
 */
public enum ResponseCodeEnum {

    SUCCESS(200,"正常返回"),
    NOT_LOGIN(401,"未登录"),
    UNAUTHORIZED(402,"未认证"),
    FORBIDDEN(403,"禁止访问"),
    NOT_FOUND(404,"资源无法访问"),
    INTERNAL_SERVER_ERROR(500,"系统异常");

    /**
     * 枚举code
     */
    private Integer code;
    /**
     * 枚举描述
     */
    private String desc;

    private ResponseCodeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return this.code;
    }
}
