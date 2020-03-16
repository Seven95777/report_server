package com.iron.ncp.controller;

import com.iron.ncp.entity.StaffInfo;
import com.iron.ncp.service.StaffInfoService;
import io.swagger.annotations.Api;
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
@Api(value="员工表",tags="员工接口")
@RestController
@RequestMapping(value = {"api/staff"}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class StaffController {
    @Resource
    private StaffInfoService staffInfoService;

    @PostMapping("list")
    public Object list(@RequestBody StaffInfo info) {
        return staffInfoService.list(info);
    }

    @PostMapping("add")
    public Object add(@RequestBody(required = false) List<StaffInfo> infos) {
        return staffInfoService.add(infos);
    }
}
