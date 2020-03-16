package com.iron.ncp.service.impl;

import com.iron.ncp.dao.BaseInfoMapper;
import com.iron.ncp.entity.BaseInfo;
import com.iron.ncp.service.BaseInfoService;
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
public class BaseInfoServiceImpl implements BaseInfoService {
    @Resource
    BaseInfoMapper baseInfoMapper;

    @Override
    public RestResult list(BaseInfo info) {
        return RestResult.success(baseInfoMapper.selectByCompany(info));
    }

    @Override
    public RestResult add(List<BaseInfo> infos) {
        //删除-by公司
        BaseInfo del = new BaseInfo();
        if (infos.size() == 0 || infos.get(0).getCompanyNum() == null) {
            return RestResult.error(BusinessCode.COMPANY_INFO_EMPTY);
        } else if (infos.size() == 1 && infos.get(0).getDelNum() != null) {
            del.setCompanyNum(infos.get(0).getDelNum());
            baseInfoMapper.delete(del);
            return RestResult.success();
        }
        del.setCompanyNum(infos.get(0).getCompanyNum());
        baseInfoMapper.delete(del);
        //插入
        for (BaseInfo info : infos) {
            info.setPersonType(0);
            info.setCreated(new Date());
            baseInfoMapper.insert(info);
        }
        return RestResult.success();
    }

}
