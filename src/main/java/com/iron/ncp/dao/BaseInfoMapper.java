package com.iron.ncp.dao;

import com.iron.ncp.entity.BaseInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface BaseInfoMapper extends Mapper<BaseInfo> {
    List<BaseInfo> selectByCompany(BaseInfo info);
}