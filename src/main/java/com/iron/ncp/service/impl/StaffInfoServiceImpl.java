package com.iron.ncp.service.impl;

import com.iron.ncp.dao.StaffInfoMapper;
import com.iron.ncp.entity.StaffInfo;
import com.iron.ncp.service.StaffInfoService;
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
public class StaffInfoServiceImpl implements StaffInfoService {
    @Resource
    StaffInfoMapper staffInfoMapper;

    static final String TABLE_NAME_1 = "staff_info";

    @Override
    public RestResult list(StaffInfo info) {
        //todo 查询日期
        if (info.getEntryTime() != null) {
            DateTime time = new DateTime(info.getEntryTime());
            info.setSrcTable(TABLE_NAME_1 + time.toString("yyyyMMdd"));
        } else {
            DateTime dateTime = new DateTime();
            info.setSrcTable(TABLE_NAME_1 + dateTime.toString("yyyyMMdd"));
        }
        List<StaffInfo> list = staffInfoMapper.selectByTable(info);
        return RestResult.success(list);
    }

    @Override
    public RestResult add(List<StaffInfo> infos) {
        DateTime dateTime = new DateTime();
        String srcTable = TABLE_NAME_1 + dateTime.toString("yyyyMMdd");
        //删除-公司&日期 去重
        StaffInfo check = new StaffInfo();
        if (infos.size()==0 || infos.get(0).getCompanyNum()==null) {
            return RestResult.error(BusinessCode.COMPANY_INFO_EMPTY);
        }else if (infos.size() == 1 && infos.get(0).getDelNum() != null) {
            //设置清空的公司Num
            check.setCompanyNum(infos.get(0).getDelNum());
            check.setSrcTable(srcTable);
            staffInfoMapper.deleteByTable(check);
            return RestResult.success();
        }
        check.setCompanyNum(infos.get(0).getCompanyNum());
        check.setSrcTable(srcTable);
        staffInfoMapper.deleteByTable(check);
        //插入
        for (StaffInfo info : infos) {
            if (info == null || info.getCompanyNum() == null) {
                return RestResult.error(BusinessCode.COMPANY_INFO_EMPTY);
            }
            info.setCreated(new Date());
            info.setSrcTable(srcTable);
            staffInfoMapper.insertByTable(info);
        }
        return RestResult.success();
    }
}
