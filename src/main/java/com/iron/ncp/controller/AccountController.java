package com.iron.ncp.controller;

import com.iron.ncp.entity.Account;
import com.iron.ncp.service.AccountService;
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

@Api(value="账户",tags="账户相关信息接口")
@RestController
@RequestMapping(value = {"api/account"}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AccountController {

    @Resource
    private AccountService accountService;
    @PostMapping("login")
    public Object list(@Validated @RequestBody Account account) {
        return accountService.login(account);
    }

    @PostMapping("add")
    public Object add(@Validated @RequestBody List<Account> accounts) {
        return accountService.add(accounts);
    }

}