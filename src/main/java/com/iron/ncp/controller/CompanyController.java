package com.iron.ncp.controller;

import com.iron.ncp.entity.Company;
import com.iron.ncp.entity.CompanyDaily;
import com.iron.ncp.service.CompanyService;
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
@Api(value="账户",tags="公司列表接口")
@RestController
@RequestMapping(value = {"api/company"}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CompanyController {

    @Resource
    private CompanyService companyService;

    @PostMapping("list")
    public Object list(@Validated @RequestBody Company info) {
        return companyService.list(info);
    }

//    @PostMapping("add")
//    public Object add(@Validated @RequestBody Company info) {
//        return companyService.add(info);
//    }

    @PostMapping("dailyList")
    public Object dailyList(@RequestBody CompanyDaily info) {
        return companyService.dailyList(info);
    }

    @PostMapping("dailyAdd")
    public Object dailyAdd(@Validated @RequestBody List<CompanyDaily> infos) {
        return companyService.dailyAdd(infos);
    }

    @PostMapping("dailyDel")
    public Object dailyDel(@RequestBody CompanyDaily info) {
        return companyService.dailyDel(info);
    }
}
