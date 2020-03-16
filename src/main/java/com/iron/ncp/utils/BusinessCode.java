package com.iron.ncp.utils;



public enum BusinessCode implements EnumUtil.CodeEnum {
    /**
     * 账户
     */
    ACCOUNT_NOT_EXIST(100201, "用户不存在"),
    ACCOUNT_NAME_EMPTY(100202, "用户名或密码不能为空"),
    ACCOUNT_PW_ERROR(100203, "密码错误"),
    ACCOUNT_EXIST(100201, "用户名存在"),

    /**
     * 信息
     */
    INFO_EMPTY(100301, "请求信息不得为空"),

    REQUEST_INFO_EMPTY(100301, "请求信息不得为空"),
    REQUEST_PEOPLE_INFO_EMPTY(100302, "姓名及身份证不得为空"),

    COMPANY_INFO_EMPTY(100401, "公司信息不得为空"),
    PROJECTE_INFO_EMPTY(100402, "项目信息不得为空"),

    COMMAND_UNKNOWN_ERROR(300001, "命令下发异常");



    public int code;

    public String msg;

    BusinessCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
