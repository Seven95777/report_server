package com.iron.ncp.dao;

import com.iron.ncp.entity.HighBack;
import com.iron.ncp.entity.NcpCtrlInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface HighBackMapper extends Mapper<HighBack> {
    List<NcpCtrlInfo> selectByCompany(NcpCtrlInfo info);
}