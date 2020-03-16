package com.iron.ncp.controller;


import com.iron.ncp.utils.RestResult;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Description:
 *
 * Date: 2018/8/15
 */
@Api(value="通用",tags="通用接口")
@RestController
@RequestMapping(value = {"api/common"}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CommonController {

    @PostMapping("time")
    public Object list() {
        return RestResult.success(new Date());
    }


}
