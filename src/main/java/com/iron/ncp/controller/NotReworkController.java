package com.iron.ncp.controller;

import com.iron.ncp.entity.NotReworkImpt;
import com.iron.ncp.entity.NotReworkInfo;
import com.iron.ncp.service.NotReworkService;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
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
@Api(value="未复工表",tags="未复工接口")
@RestController
@RequestMapping(value = {"api/notRework"}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class NotReworkController {
    @Resource
    private NotReworkService notReworkService;

    @PostMapping("list")
    public Object list(@RequestBody NotReworkInfo info) {
        return notReworkService.list(info);
    }

    @PostMapping("add")
    public Object add(@Validated @RequestBody List<NotReworkInfo> infos) {
        return notReworkService.add(infos);
    }

    @PostMapping("imptList")
    public Object imptList(@RequestBody NotReworkImpt info) {
        return notReworkService.imptList(info);
    }

    @PostMapping("imptAdd")
    public Object imptAdd(@Validated @RequestBody List<NotReworkImpt> infos) {
        return notReworkService.imptAdd(infos);
    }
}
