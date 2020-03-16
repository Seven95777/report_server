package com.iron.ncp.dao;

import com.iron.ncp.entity.StaffInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface StaffInfoMapper extends Mapper<StaffInfo> {
    List<StaffInfo> selectByTable(StaffInfo info);

    void insertByTable(StaffInfo info);

    void updateByTable(StaffInfo info);

    void deleteByTable(StaffInfo info);
}