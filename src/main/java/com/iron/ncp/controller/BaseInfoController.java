package com.iron.ncp.controller;

import com.iron.ncp.entity.BaseInfo;
import com.iron.ncp.service.BaseInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description:
 *
 * @author admin55
 * Date: 2020/2/27
 */
@Api(value="基本信息",tags="基本信息接口")
@RestController
@RequestMapping(value = {"api/base"}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BaseInfoController {
    @Resource
    private BaseInfoService baseInfoService;

    @ApiOperation(value = "xxx数据请求接口", notes = "xx请求数据接口，用于判断当前是否允许报名等")
    @PostMapping("list")
    public Object list(@RequestBody BaseInfo info) {
        return baseInfoService.list(info);
    }

    @PostMapping("add")
    public Object add(@RequestBody List<BaseInfo> infos) {
        return baseInfoService.add(infos);
    }
}
