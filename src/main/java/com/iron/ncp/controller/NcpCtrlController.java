package com.iron.ncp.controller;

import com.iron.ncp.entity.HighBack;
import com.iron.ncp.entity.NcpCtrlInfo;
import com.iron.ncp.service.NcpCtrlService;
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
 * Date: 2020/2/28
 */
@Api(value="疫情表",tags="疫情相关信息接口")
@RestController
@RequestMapping(value = {"api/ncp"}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class NcpCtrlController {
    @Resource
    private NcpCtrlService ncpCtrlService;

    @ApiOperation(value="疫情防控列表",notes="疫情防控列表")
    @PostMapping("list")
    public Object list(@RequestBody NcpCtrlInfo info) {
        return ncpCtrlService.ncpList(info);
    }

    @ApiOperation(value="疫情防控add",notes="疫情防控add")
    @PostMapping("add")
    public Object add(@RequestBody List<NcpCtrlInfo> infos) {
        return ncpCtrlService.ncpAdd(infos);
    }

    @ApiOperation(value="疫情人员列表",notes="疫情人员列表，高发地返蓉")
    @PostMapping("high/list")
    public Object highList(@RequestBody HighBack info) {
        return ncpCtrlService.highList(info);
    }

    @ApiOperation(value="疫情人员add",notes="疫情人员add，高发地返蓉")
    @PostMapping("high/add")
    public Object highAdd(@RequestBody List<HighBack> infos) {
        return ncpCtrlService.highAdd(infos);
    }
}
