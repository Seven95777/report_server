package com.iron.ncp.service.impl;

import com.iron.ncp.dao.HighBackMapper;
import com.iron.ncp.dao.NcpCtrlInfoMapper;
import com.iron.ncp.entity.HighBack;
import com.iron.ncp.entity.NcpCtrlInfo;
import com.iron.ncp.service.NcpCtrlService;
import com.iron.ncp.utils.BusinessCode;
import com.iron.ncp.utils.RestResult;
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
public class NcpCtrlServiceImpl implements NcpCtrlService {

    @Resource
    NcpCtrlInfoMapper ncpCtrlInfoMapper;
    @Resource
    HighBackMapper highBackMapper;

    @Override
    public RestResult ncpList(NcpCtrlInfo info) {
        return RestResult.success(ncpCtrlInfoMapper.select(info));
    }

    @Override
    public RestResult ncpAdd(List<NcpCtrlInfo> infos) {
        //删除-by公司
        NcpCtrlInfo del = new NcpCtrlInfo();
        if (infos.size() == 0 || infos.get(0).getCompanyNum() == null) {
            return RestResult.error(BusinessCode.COMPANY_INFO_EMPTY);
        }else if (infos.size() == 1 && infos.get(0).getDelNum() != null) {
            //设置清空的公司Num
            del.setCompanyNum(infos.get(0).getDelNum());
            ncpCtrlInfoMapper.delete(del);
            return RestResult.success();
        }
        del.setCompanyNum(infos.get(0).getCompanyNum());
        ncpCtrlInfoMapper.delete(del);
        //插入
        for (NcpCtrlInfo info : infos) {
            info.setCreated(new Date());
            ncpCtrlInfoMapper.insert(info);
        }
        return RestResult.success();
    }

    @Override
    public RestResult highList(HighBack info) {
        return RestResult.success(highBackMapper.select(info));
    }

    @Override
    public RestResult highAdd(List<HighBack> infos) {
        //删除-by公司
        HighBack del = new HighBack();
        if (infos.size() == 0 || infos.get(0).getCompanyNum() == null) {
            return RestResult.error(BusinessCode.COMPANY_INFO_EMPTY);
        }else if (infos.size() == 1 && infos.get(0).getDelNum() != null) {
            //设置清空的公司Num
            del.setCompanyNum(infos.get(0).getDelNum());
            highBackMapper.delete(del);
            return RestResult.success();
        }
        del.setCompanyNum(infos.get(0).getCompanyNum());
        highBackMapper.delete(del);
        //插入
        for (HighBack info : infos) {
            info.setCreated(new Date());
            highBackMapper.insert(info);
        }
        return RestResult.success();
    }
}
