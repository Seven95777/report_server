package com.iron.ncp.service.impl;

import com.iron.ncp.dao.AccountMapper;
import com.iron.ncp.dao.ProjectBaseMapper;
import com.iron.ncp.dao.ProjectDailyMapper;
import com.iron.ncp.dao.ProjectMapper;
import com.iron.ncp.entity.*;
import com.iron.ncp.service.ProjectService;
import com.iron.ncp.utils.BusinessCode;
import com.iron.ncp.utils.RestResult;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Description:
 * User: PengXJ
 * Date: 2020/2/23
 */
@Slf4j
@Service
public class ProjectServiceImpl implements ProjectService {
    @Resource
    private ProjectMapper projectMapper;
    @Resource
    private ProjectBaseMapper projectBaseMapper;
    @Resource
    private ProjectDailyMapper projectDailyMapper;
    @Resource
    private AccountMapper accountMapper;

    static final String TABLE_NAME_1 = "project";
    static final String TABLE_NAME_2 = "project_daily";

    @Override
    public RestResult list(Project info) {
        if (info.getEntryTime() != null) {
            DateTime time = new DateTime(info.getEntryTime());
            info.setSrcTable(TABLE_NAME_1 + time.toString("yyyyMMdd"));
        } else {
            DateTime dateTime = new DateTime();
            info.setSrcTable(TABLE_NAME_1 + dateTime.toString("yyyyMMdd"));
        }
        List<Project> list = projectMapper.selectByTable(info);
        return RestResult.success(list);
    }

    /**
     * 新增只能增加今天的
     */
    @Override
    public RestResult add(List<Project> infos) {
        DateTime dateTime = new DateTime();
        String srcTable = TABLE_NAME_1 + dateTime.toString("yyyyMMdd");
        //删除-公司&日期 去重
        Project check = new Project();
        if (infos.size() == 0 || infos.get(0).getCompanyNum() == null) {
            return RestResult.error(BusinessCode.COMPANY_INFO_EMPTY);
        } else if (infos.size() == 1 && infos.get(0).getDelNum() != null) {
            //设置清空的公司Num
            check.setCompanyNum(infos.get(0).getDelNum());
            check.setSrcTable(srcTable);
            projectMapper.deleteByTable(check);
            return RestResult.success();
        }
        check.setCompanyNum(infos.get(0).getCompanyNum());
        check.setSrcTable(srcTable);
        projectMapper.deleteByTable(check);
        //插入
        for (Project info : infos) {
            if (info == null || info.getCompanyNum() == null) {
                return RestResult.error(BusinessCode.COMPANY_INFO_EMPTY);
            }
            info.setCreated(new Date());
            info.setSrcTable(srcTable);
            projectMapper.insertByTable(info);
        }
        return RestResult.success();
    }

    @Override
    public RestResult baseList(ProjectBase info) {
        List<ProjectBase> list = projectBaseMapper.select(info);
        if (list.size() != 0) {
            for (ProjectBase base : list) {
                //拼日常
                ProjectDaily daily = new ProjectDaily();
                DateTime dateTime = new DateTime();
                daily.setSrcTable(TABLE_NAME_2 + dateTime.toString("yyyyMMdd"));
                daily.setProjectName(base.getProjectName());
                List<ProjectDaily> dailies = projectDailyMapper.selectByTable(daily);
                if (dailies.size()!=0) {
                    base.setReworkFlag(dailies.get(0).getReworkFlag());
                    base.setPeopleCount(dailies.get(0).getPeopleCount());
                    base.setReworkCount(dailies.get(0).getReworkCount());
                    base.setWorkerCount(dailies.get(0).getWorkerCount());
                }
                //拼账户
                Account account = new Account();
                account.setCompany(base.getCompany());
                account.setAccountType("2");
                account.setProjectName(base.getProjectName());
                List<Account> select = accountMapper.select(account);
                if (select.size()!=0) {
                    base.setUsername(select.get(0).getUsername());
                    base.setPassword(select.get(0).getPassword());
                }
            }
        }
        return RestResult.success(list);
    }

    @Override
    public RestResult baseAdd(List<ProjectBase> infos) {
        //删除-by公司
        ProjectBase del = new ProjectBase();
        if (infos.size() == 0 || infos.get(0).getProjectNum() == null) {
            return RestResult.error(BusinessCode.PROJECTE_INFO_EMPTY);
        } else if (infos.size() == 1 && infos.get(0).getDelNum() != null) {
            //设置清空的公司Num
            del.setProjectNum(infos.get(0).getProjectNum());
            projectBaseMapper.delete(del);
            return RestResult.success();
        }
        del.setProjectNum(infos.get(0).getProjectNum());
        projectBaseMapper.delete(del);
        //插入
        for (ProjectBase info : infos) {
            info.setCreated(new Date());
            projectBaseMapper.insert(info);
        }
        return RestResult.success();
    }

    @Override
    public RestResult baseDel(ProjectBase info) {
        projectBaseMapper.delete(info);
        //删除日常表
        ProjectDaily daily = new ProjectDaily();
        DateTime dateTime = new DateTime();
        String srcTable = TABLE_NAME_2 + dateTime.toString("yyyyMMdd");
        daily.setSrcTable(srcTable);
        daily.setProjectName(info.getProjectName());
        projectDailyMapper.myDeleteById(daily);
        //删除项目账户
        Account account = new Account();
        account.setProjectName(info.getProjectName());
        accountMapper.delete(account);
        return RestResult.success();
    }

    @Override
    public RestResult dailyList(ProjectDaily info) {
        if (info.getEntryTime() != null) {
            DateTime time = new DateTime(info.getEntryTime());
            info.setSrcTable(TABLE_NAME_2 + time.toString("yyyyMMdd"));
        } else {
            DateTime dateTime = new DateTime();
            info.setSrcTable(TABLE_NAME_2 + dateTime.toString("yyyyMMdd"));
        }
        List<ProjectDaily> list = projectDailyMapper.selectByTable(info);
        if (list.size() != 0) {
            for (ProjectDaily daily : list) {
                ProjectBase base = new ProjectBase();
                base.setCompany(daily.getCompany());
                List<ProjectBase> select = projectBaseMapper.select(base);
                daily.setProvince(select.get(0).getProvince());
                daily.setCity(select.get(0).getCity());
                daily.setArea(select.get(0).getArea());
                daily.setImptFlag(select.get(0).getImptFlag());
                //账户信息
                Account account = new Account();
                account.setProjectName(daily.getProjectName());
                try {
                    List<Account> accounts = accountMapper.select(account);
                    daily.setUsername(accounts.get(0).getUsername());
                    daily.setPassword(accounts.get(0).getPassword());
                } catch (Exception e) {
                    log.warn("报错:账户表未查到该项目账户");
                }

            }
        }
        return RestResult.success(list);
    }

    @Override
    public RestResult dailyAdd(List<ProjectDaily> infos) {
        DateTime dateTime = new DateTime();
        String srcTable = TABLE_NAME_2 + dateTime.toString("yyyyMMdd");

        if (infos.size() == 0) {
            return RestResult.error(BusinessCode.PROJECTE_INFO_EMPTY);
        }
        //插入
        for (ProjectDaily info : infos) {
            if (info == null) {
                return RestResult.error(BusinessCode.PROJECTE_INFO_EMPTY);
            }
            //日期-去重
            ProjectDaily check = new ProjectDaily();
            ProjectBase pb = new ProjectBase();
            //校验
            if (info.getProjectNum() != null) {
                check.setProjectNum(info.getProjectNum());
                pb.setProjectNum(info.getProjectNum());
            } else if (info.getProjectName() != null) {
                check.setProjectName(info.getProjectName());
                pb.setProjectName(info.getProjectName());
            } else {
                return RestResult.error(BusinessCode.PROJECTE_INFO_EMPTY);
            }
            check.setSrcTable(srcTable);
            check.setSubFlag(0);
            List<ProjectDaily> select = projectDailyMapper.selectByTable(check);
            info.setCreated(new Date());
            info.setSrcTable(srcTable);
            if (select.size() == 0) {
                projectDailyMapper.insertByTable(info);
            } else {
                info.setId(select.get(0).getId());
                projectDailyMapper.updateByTable(info);
            }
            // 更新基本表信息
            List<ProjectBase> select1 = projectBaseMapper.select(pb);
            pb.setCompany(info.getCompany());
            pb.setCompanyNum(info.getCompanyNum());
            pb.setCreated(new Date());
            pb.setProvince(info.getProvince());
            pb.setCity(info.getCity());
            pb.setArea(info.getArea());
            if (select1.size() == 0) {
                projectBaseMapper.insert(pb);
            } else {
                pb.setId(select1.get(0).getId());
                projectBaseMapper.updateByPrimaryKeySelective(pb);
            }
        }
        return RestResult.success();
    }

    @Override
    public RestResult dailyDel(ProjectDaily info) {
        DateTime dateTime = new DateTime();
        String srcTable = TABLE_NAME_2 + dateTime.toString("yyyyMMdd");
        info.setSrcTable(srcTable);
        projectDailyMapper.myDeleteById(info);
        //删除项目账户
        Account account = new Account();
        account.setProjectName(info.getProjectName());
        accountMapper.delete(account);
        ProjectBase projectBase = new ProjectBase();
        projectBase.setProjectName(info.getProjectName());
        projectBaseMapper.delete(projectBase);
        return RestResult.success();
    }

}
