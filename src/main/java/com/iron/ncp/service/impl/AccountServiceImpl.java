package com.iron.ncp.service.impl;

import com.iron.ncp.dao.AccountMapper;
import com.iron.ncp.dao.ProjectBaseMapper;
import com.iron.ncp.entity.Account;
import com.iron.ncp.entity.ProjectBase;
import com.iron.ncp.service.AccountService;
import com.iron.ncp.service.ProjectService;
import com.iron.ncp.utils.BusinessCode;
import com.iron.ncp.utils.RestResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Description:
 * User: gaoyf
 * Date: 2020/2/23
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;
    @Resource
    private ProjectService projectService;
    @Resource
    private ProjectBaseMapper projectBaseMapper;

    @Override
    public RestResult login(Account account) {
        if (account == null || account.getUsername() == null || account.getPassword() == null) {
            return RestResult.error(BusinessCode.ACCOUNT_NAME_EMPTY);
        }
        Account check = new Account();
        check.setUsername(account.getUsername());
        List<Account> select = accountMapper.select(account);
        //校验用户
        if (select.isEmpty()) {
            return RestResult.error(BusinessCode.ACCOUNT_NOT_EXIST);
        }
        //校验密码
        if (!account.getPassword().equals(select.get(0).getPassword())) {
            return RestResult.error(BusinessCode.ACCOUNT_PW_ERROR);
        } else {
            return RestResult.success(select.get(0));
        }
    }

    @Override
    public RestResult add(List<Account> accounts) {
        for (Account account : accounts) {
            if (account == null) {
                return RestResult.error(BusinessCode.ACCOUNT_NAME_EMPTY);
            }
            Account check = new Account();
            check.setProjectName(account.getProjectName());
            List<Account> select = accountMapper.select(account);
            account.setAccountType("2");
            //校验用户
            // todo 生成项目账户
            ProjectBase projectBase = new ProjectBase();
            if (!select.isEmpty()) {

            } else {
                int i = accountMapper.selectMaxId() + 1;
                if (account.getCompanyNum() != null) {
                    account.setUsername("admin" + account.getCompanyNum() + i);
                } else {
                    account.setUsername("admin" + "0" + i);
                }

                account.setPassword("123456");
                accountMapper.insert(account);
            }
            //更新项目基本信息
            projectBase.setProjectName(select.get(0).getProjectName());
            List<ProjectBase> bases = projectBaseMapper.select(projectBase);
            projectBase.setProvince(account.getProvince());
            projectBase.setCity(account.getCity());
            projectBase.setArea(account.getArea());
            projectBase.setProjectName(account.getProjectName());
            projectBase.setImptFlag(account.getImptFlag());
            projectBase.setCompany(account.getCompany());
            projectBase.setCompanyNum(account.getCompanyNum());
            projectBase.setCreated(new Date());
            if (bases.size() != 0) {
                projectBase.setId(bases.get(0).getId());
                projectBaseMapper.updateByPrimaryKey(projectBase);
            } else {
                projectBaseMapper.insert(projectBase);
            }
        }
        //返回
        ProjectBase info = new ProjectBase();
        info.setCompany(accounts.get(0).getCompany());
        return RestResult.success(projectService.baseList(info).getData());

    }
}
