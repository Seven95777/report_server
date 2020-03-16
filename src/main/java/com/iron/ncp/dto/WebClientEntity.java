package com.iron.ncp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description:
 *
 * Date: 2019/11/5
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WebClientEntity {
    private String ip;
    private Integer port;
    private String uri;
    private Object obj;
}
