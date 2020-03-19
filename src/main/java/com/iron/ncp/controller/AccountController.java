package com.iron.ncp.controller;

import com.iron.ncp.entity.Account;
import com.iron.ncp.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

@Api(value="账户",tags="账户相关信息接口")
@RestController
@RequestMapping(value = {"api/account"}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping("login")
    @ApiOperation("用户登陆系统")
    public Object list(@Validated @RequestBody Account account) {
        return accountService.login(account);
    }

    @PostMapping("add")
    @ApiOperation("创建系统用户信息")
    public Object add(@Validated @RequestBody List<Account> accounts) {
        return accountService.add(accounts);
    }

}