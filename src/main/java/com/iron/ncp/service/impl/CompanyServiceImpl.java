package com.iron.ncp.service.impl;

import com.iron.ncp.dao.CompanyDailyMapper;
import com.iron.ncp.dao.CompanyMapper;
import com.iron.ncp.entity.Company;
import com.iron.ncp.entity.CompanyDaily;
import com.iron.ncp.service.CompanyService;
import com.iron.ncp.utils.BusinessCode;
import com.iron.ncp.utils.RestResult;
import org.joda.time.DateTime;
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
public class CompanyServiceImpl implements CompanyService {

    @Resource
    private CompanyMapper companyMapper;
    @Resource
    private CompanyDailyMapper companyDailyMapper;

    static final String TABLE_NAME_1 = "company_daily";

    @Override
    public RestResult list(Company info) {
        List<Company> list = companyMapper.select(info);
        return RestResult.success(list);
    }

    @Override
    public RestResult add(Company info) {
        if (info == null || info.getCompany() == null) {
            return RestResult.error(BusinessCode.COMPANY_INFO_EMPTY);
        }
        info.setCreated(new Date());
        Company check = new Company();
        check.setCompany(info.getCompany());
        List<Company> select = companyMapper.select(check);
        if (select.size() > 0) {
            info.setId(select.get(0).getId());
            companyMapper.updateByPrimaryKey(info);
        } else {
            companyMapper.insert(info);
        }
        return RestResult.success();
    }

    @Override
    public RestResult dailyList(CompanyDaily info) {
        if (info.getEntryTime() != null) {
            DateTime time = new DateTime(info.getEntryTime());
            info.setSrcTable(TABLE_NAME_1 + time.toString("yyyyMMdd"));
        } else {
            DateTime dateTime = new DateTime();
            info.setSrcTable(TABLE_NAME_1 + dateTime.toString("yyyyMMdd"));
        }
        List<CompanyDaily> list = companyDailyMapper.selectByTable(info);
        for (CompanyDaily daily : list) {
            Company company = new Company();
            company.setCompany(daily.getCompany());
            List<Company> select = companyMapper.select(company);
            daily.setProvince(select.get(0).getProvince());
            daily.setCity(select.get(0).getCity());
            daily.setArea(select.get(0).getArea());
            daily.setSuperNum(select.get(0).getSuperNum());
            Company c = new Company();
            c.setCompanyNum(select.get(0).getSuperNum());
            List<Company> select1 = companyMapper.select(c);
            if (select1.size()!=0) {
                daily.setSuperName(select1.get(0).getCompany());
            }
        }
        return RestResult.success(list);
    }

    @Override
    public RestResult dailyAdd(List<CompanyDaily> infos) {
        DateTime dateTime = new DateTime();
        String srcTable = TABLE_NAME_1 + dateTime.toString("yyyyMMdd");

        if (infos.size() == 0) {
            return RestResult.error(BusinessCode.COMPANY_INFO_EMPTY);
        }
        //插入
        for (CompanyDaily info : infos) {
            if (info == null) {
                return RestResult.error(BusinessCode.COMPANY_INFO_EMPTY);
            }
            //日期-去重
            CompanyDaily check = new CompanyDaily();
            Company company = new Company();
            //校验
            if (info.getCompanyNum()!=null) {
                check.setCompanyNum(info.getCompanyNum());
                company.setCompanyNum(info.getCompanyNum());
            }else if (info.getCompany()!=null) {
                check.setCompany(info.getCompany());
                company.setCompany(info.getCompany());
            }else {
                return RestResult.error(BusinessCode.COMPANY_INFO_EMPTY);
            }
            check.setSrcTable(srcTable);
            check.setSubFlag(0);
            List<CompanyDaily> select = companyDailyMapper.selectByTable(check);
            //复工总数
//            int s = info.getReworkCount()+info.getDutyCount()+info.getOperateCount();
            info.setReworkSum(info.getReworkSum());
            info.setCreated(new Date());
            info.setSrcTable(srcTable);
            if (select.size()==0) {
                companyDailyMapper.insertByTable(info);
            }else {
                info.setId(select.get(0).getId());
                companyDailyMapper.updateByTable(info);
            }
            //更新基本表公司的位置信息
            List<Company> select1 = companyMapper.select(company);
            company.setProvince(info.getProvince());
            company.setCity(info.getCity());
            company.setArea(info.getArea());
//            company.setSuperNum(info.getSuperNum());
            if (select1.size()!=0) {
                company.setId(select1.get(0).getId());
                companyMapper.updateByPrimaryKeySelective(company);
            }
        }
        return RestResult.success();
    }

    @Override
    public RestResult dailyDel(CompanyDaily info) {
        DateTime dateTime = new DateTime();
        String srcTable = TABLE_NAME_1 + dateTime.toString("yyyyMMdd");
        info.setSrcTable(srcTable);
        companyDailyMapper.myDeleteById(info);
        return RestResult.success();
    }

}
