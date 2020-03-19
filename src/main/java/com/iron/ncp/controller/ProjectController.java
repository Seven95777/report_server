package com.iron.ncp.controller;

import com.iron.ncp.entity.Project;
import com.iron.ncp.entity.ProjectBase;
import com.iron.ncp.entity.ProjectDaily;
import com.iron.ncp.service.ProjectService;
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
 * User: PengXJ
 * Date: 2020/2/23
 */
@Api(value="项目表",tags="项目接口")
@RestController
@RequestMapping(value = {"api/project"}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ProjectController {

    @Resource
    private ProjectService projectService;

    @PostMapping("list")
    public Object list(@RequestBody Project info) {
        return projectService.list(info);
    }

    @PostMapping("add")
    public Object add(@Validated @RequestBody List<Project> infos) {
        return projectService.add(infos);
    }

    @PostMapping("baseList")
    public Object baseList(@RequestBody ProjectBase info) {
        return projectService.baseList(info);
    }

    @PostMapping("baseAdd")
    public Object baseAdd(@Validated @RequestBody List<ProjectBase> infos) {
        return projectService.baseAdd(infos);
    }
    @PostMapping("baseDel")
    public Object baseDel(@RequestBody ProjectBase info) {
        return projectService.baseDel(info);
    }

    @PostMapping("dailyList")
    public Object dailyList(@RequestBody ProjectDaily info) {
        return projectService.dailyList(info);
    }

    @PostMapping("dailyAdd")
    public Object dailyAdd(@Validated @RequestBody List<ProjectDaily> infos) {
        return projectService.dailyAdd(infos);
    }

    @PostMapping("dailyDel")
    public Object dailyDel(@RequestBody ProjectDaily info) {
        return projectService.dailyDel(info);
    }

}
