package com.iron.ncp.dao;

import com.iron.ncp.entity.NcpCtrlInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface NcpCtrlInfoMapper extends Mapper<NcpCtrlInfo> {
    List<NcpCtrlInfo> selectByCompany(NcpCtrlInfo info);
}