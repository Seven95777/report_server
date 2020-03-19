package com.iron.ncp.dto;

import lombok.Data;

/**
 * Description:
 * User: PengXJ
 * Date: 2020/2/23
 */
@Data
public class ReqInfo {
    /**
     * 姓名
     */
    private String name;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * 表
     */
    private String srcTable;
}
