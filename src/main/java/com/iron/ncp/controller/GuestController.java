package com.iron.ncp.controller;

import com.iron.ncp.entity.GuestInfo;
import com.iron.ncp.entity.GuestProject;
import com.iron.ncp.service.GuestInfoService;
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
@Api(value="访客表",tags="企业访客接口")
@RestController
@RequestMapping(value = {"api/guest"}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class GuestController {
    @Resource
    private GuestInfoService guestInfoService;

    @PostMapping("list")
    public Object list(@RequestBody GuestInfo info) {
        return guestInfoService.list(info);
    }

    @PostMapping("add")
    public Object add(@RequestBody List<GuestInfo> infos) {
        return guestInfoService.add(infos);
    }

    @PostMapping("projectList")
    public Object projectList(@RequestBody GuestProject info) {
        return guestInfoService.projectList(info);
    }

    @PostMapping("projectAdd")
    public Object guestAdd(@RequestBody List<GuestProject> infos) {
        return guestInfoService.projectAdd(infos);
    }
}
