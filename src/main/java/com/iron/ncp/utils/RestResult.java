package com.iron.ncp.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class RestResult<T> {

    private static String SUCCESS_MESSAGE = "操作成功";

    private int code;

    private String resultMsg;

    private T data;

    public RestResult(int code, String resultMsg) {
        this.code = code;
        this.resultMsg = resultMsg;
    }

    public static <T> RestResult<T> success() {
        return new RestResult<>(0, SUCCESS_MESSAGE);
    }

    public static <T> RestResult<T> success(T data) {
        return new RestResult<>(0, SUCCESS_MESSAGE, data);
    }

    public static <T> RestResult<T> error(BusinessCode code) {
        return new RestResult<>(code.code, code.msg);
    }
}
