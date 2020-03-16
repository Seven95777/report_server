package com.iron.ncp.service.impl;

import com.iron.ncp.dao.NotReworkImptMapper;
import com.iron.ncp.dao.NotReworkInfoMapper;
import com.iron.ncp.entity.NotReworkImpt;
import com.iron.ncp.entity.NotReworkInfo;
import com.iron.ncp.service.NotReworkService;
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
 * Date: 2020/2/28
 */
@Service
public class NotReworkServiceImpl implements NotReworkService {
    @Resource
    NotReworkInfoMapper infoMapper;
    @Resource
    NotReworkImptMapper imptMapper;

    static final String TABLE_NAME_1 = "not_rework_info";

    static final String TABLE_NAME_2 = "not_rework_impt";


    @Override
    public RestResult list(NotReworkInfo info) {
        //todo 查询日期
        if (info.getEntryTime() != null) {
            DateTime time = new DateTime(info.getEntryTime());
            info.setSrcTable(TABLE_NAME_1 + time.toString("yyyyMMdd"));
        } else {
            DateTime dateTime = new DateTime();
            info.setSrcTable(TABLE_NAME_1 + dateTime.toString("yyyyMMdd"));
        }
        return RestResult.success(infoMapper.selectByTable(info));
    }

    @Override
    public RestResult add(List<NotReworkInfo> infos) {
        DateTime dateTime = new DateTime();
        String srcTable = TABLE_NAME_1 + dateTime.toString("yyyyMMdd");
        //删除-公司&日期 去重
        NotReworkInfo check = new NotReworkInfo();
        if (infos.size() == 0 || infos.get(0).getCompanyNum() == null) {
            return RestResult.error(BusinessCode.COMPANY_INFO_EMPTY);
        } else if (infos.size() == 1 && infos.get(0).getDelNum() != null) {
            //设置清空的公司Num
            check.setCompanyNum(infos.get(0).getDelNum());
            check.setSrcTable(srcTable);
            infoMapper.deleteByTable(check);
            return RestResult.success();
        }
        check.setCompanyNum(infos.get(0).getCompanyNum());
        check.setSrcTable(srcTable);
        infoMapper.deleteByTable(check);
        //插入
        for (NotReworkInfo info : infos) {
            if (info == null || info.getCompanyNum() == null) {
                return RestResult.error(BusinessCode.COMPANY_INFO_EMPTY);
            }
            info.setCreated(new Date());
            info.setSrcTable(srcTable);
            infoMapper.insertByTable(info);
        }
        return RestResult.success();
    }

    @Override
    public RestResult imptList(NotReworkImpt info) {
        //todo 查询日期
        if (info.getEntryTime() != null) {
            DateTime time = new DateTime(info.getEntryTime());
            info.setSrcTable(TABLE_NAME_2 + time.toString("yyyyMMdd"));
        } else {
            DateTime dateTime = new DateTime();
            info.setSrcTable(TABLE_NAME_2 + dateTime.toString("yyyyMMdd"));
        }
        return RestResult.success(imptMapper.selectByTable(info));
    }

    @Override
    public RestResult imptAdd(List<NotReworkImpt> infos) {
        DateTime dateTime = new DateTime();
        String srcTable = TABLE_NAME_2 + dateTime.toString("yyyyMMdd");
        //删除-公司&日期 去重
        NotReworkImpt check = new NotReworkImpt();
        if (infos.size() == 0 || infos.get(0).getCompanyNum() == null) {
            return RestResult.error(BusinessCode.COMPANY_INFO_EMPTY);
        }else if (infos.size() == 1 && infos.get(0).getDelNum() != null) {
            //设置清空的公司Num
            check.setCompanyNum(infos.get(0).getDelNum());
            check.setSrcTable(srcTable);
            imptMapper.deleteByTable(check);
            return RestResult.success();
        }
        check.setCompanyNum(infos.get(0).getCompanyNum());
        check.setSrcTable(srcTable);
        imptMapper.deleteByTable(check);
        //插入
        for (NotReworkImpt info : infos) {
            if (info == null || info.getCompanyNum() == null) {
                return RestResult.error(BusinessCode.COMPANY_INFO_EMPTY);
            }
            info.setCreated(new Date());
            info.setSrcTable(srcTable);
            imptMapper.insertByTable(info);
        }
        return RestResult.success();
    }
}
