package com.iron.ncp.service.impl;

import com.iron.ncp.dao.BaseInfoMapper;
import com.iron.ncp.dao.GuestInfoMapper;
import com.iron.ncp.dao.GuestProjectMapper;
import com.iron.ncp.entity.BaseInfo;
import com.iron.ncp.entity.GuestInfo;
import com.iron.ncp.entity.GuestProject;
import com.iron.ncp.service.GuestInfoService;
import com.iron.ncp.utils.BusinessCode;
import com.iron.ncp.utils.RestResult;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Description:
 *
 * @author admin55
 * Date: 2020/2/27
 */
@Service
public class GuestInfoServiceImpl implements GuestInfoService {
    @Resource
    GuestInfoMapper guestInfoMapper;
    @Resource
    BaseInfoMapper baseInfoMapper;
    @Resource
    GuestProjectMapper guestProjectMapper;

    static final String TABLE_NAME_1 = "guest_info";
    static final String TABLE_NAME_2 = "guest_project";

    @Override
    public RestResult list(GuestInfo info) {
        if (info.getVisitTime() != null) {
            DateTime time = new DateTime(info.getVisitTime());
            info.setSrcTable(TABLE_NAME_1 + time.toString("yyyyMMdd"));
        } else {
            DateTime dateTime = new DateTime();
            info.setSrcTable(TABLE_NAME_1 + dateTime.toString("yyyyMMdd"));
        }
        List<GuestInfo> list = guestInfoMapper.selectByTable(info);
        return RestResult.success(list);
    }

    @Override
    public RestResult add(List<GuestInfo> infos) {
        DateTime dateTime = new DateTime();
        String srcTable = TABLE_NAME_1 + dateTime.toString("yyyyMMdd");
        //删除-公司&日期 去重
        GuestInfo check = new GuestInfo();
        if (infos.size()==0 || infos.get(0).getCompanyNum()==null) {
            return RestResult.error(BusinessCode.COMPANY_INFO_EMPTY);
        } else if (infos.size() == 1 && infos.get(0).getDelNum() != null) {
            //设置清空的公司Num
            check.setCompanyNum(infos.get(0).getDelNum());
            check.setSrcTable(srcTable);
            guestInfoMapper.deleteByTable(check);
            return RestResult.success();
        }
        check.setCompanyNum(infos.get(0).getCompanyNum());
        check.setSrcTable(srcTable);
        guestInfoMapper.deleteByTable(check);
        //插入
        for (GuestInfo info : infos) {
            if (info == null || info.getCompanyNum() == null) {
                return RestResult.error(BusinessCode.COMPANY_INFO_EMPTY);
            }
            info.setCreated(new Date());
            info.setSrcTable(srcTable);
            BaseInfo guestBase = new BaseInfo();
            guestBase.setTel(info.getTel());
            guestBase.setName(info.getName());
            List<BaseInfo> select = baseInfoMapper.select(guestBase);
            guestBase.setCompanyNum(info.getCompanyNum());
            guestBase.setPersonType(1);
            guestBase.setCreated(new Date());
            guestBase.setCompany(info.getCompany());
            guestBase.setIdCard(info.getIdCard());
            guestBase.setAddress(info.getAddress());
            guestBase.setContact(info.getContact());
            guestBase.setContactHb(info.getContactHb());
            guestBase.setFamilyHealth(info.getFamilyHealth());
            if (select.size()>0) {
                guestBase.setId(select.get(0).getId());
                baseInfoMapper.updateByPrimaryKey(guestBase);
            }else {
                baseInfoMapper.insert(guestBase);
            }
            guestInfoMapper.insertByTable(info);
        }
        return RestResult.success();
    }

    @Override
    public RestResult projectList(GuestProject info) {
        if (info.getVisitTime() != null) {
            DateTime time = new DateTime(info.getVisitTime());
            info.setSrcTable(TABLE_NAME_2 + time.toString("yyyyMMdd"));
        } else {
            DateTime dateTime = new DateTime();
            info.setSrcTable(TABLE_NAME_2 + dateTime.toString("yyyyMMdd"));
        }
        List<GuestProject> list = guestProjectMapper.selectByTable(info);
        return RestResult.success(list);
    }

    @Override
    public RestResult projectAdd(List<GuestProject> infos) {
        DateTime dateTime = new DateTime();
        String srcTable = TABLE_NAME_1 + dateTime.toString("yyyyMMdd");
        //删除-公司&日期 去重
        GuestProject check = new GuestProject();
        if (infos.size()==0 || infos.get(0).getProjectNum()==null) {
            return RestResult.error(BusinessCode.PROJECTE_INFO_EMPTY);
        } else if (infos.size() == 1 && infos.get(0).getDelNum() != null) {
            //设置清空的公司Num
            check.setProjectNum(infos.get(0).getDelNum());
            check.setSrcTable(srcTable);
            guestProjectMapper.deleteByTable(check);
            return RestResult.success();
        }
        check.setCompanyNum(infos.get(0).getCompanyNum());
        check.setSrcTable(srcTable);
        guestProjectMapper.deleteByTable(check);
        //插入
        for (GuestProject info : infos) {
            if (info == null || info.getCompanyNum() == null) {
                return RestResult.error(BusinessCode.COMPANY_INFO_EMPTY);
            }
            info.setCreated(new Date());
            info.setSrcTable(srcTable);
            BaseInfo guestBase = new BaseInfo();
            guestBase.setTel(info.getTel());
            guestBase.setName(info.getName());
            List<BaseInfo> select = baseInfoMapper.select(guestBase);
            guestBase.setCompanyNum(info.getCompanyNum());
            guestBase.setPersonType(1);
            guestBase.setCreated(new Date());
            guestBase.setCompany(info.getCompany());
            guestBase.setIdCard(info.getIdCard());
            guestBase.setAddress(info.getAddress());
            guestBase.setContact(info.getContact());
            guestBase.setContactHb(info.getContactHb());
            guestBase.setFamilyHealth(info.getFamilyHealth());
            if (select.size()>0) {
                guestBase.setId(select.get(0).getId());
                baseInfoMapper.updateByPrimaryKey(guestBase);
            }else {
                baseInfoMapper.insert(guestBase);
            }
            guestProjectMapper.insertByTable(info);
        }
        return RestResult.success();
    }
}
