package com.iron.ncp.dao;

import com.iron.ncp.entity.NotReworkInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface NotReworkInfoMapper extends Mapper<NotReworkInfo> {
    List<NotReworkInfo> selectByTable(NotReworkInfo info);

    void insertByTable(NotReworkInfo info);

    void updateByTable(NotReworkInfo info);

    void deleteByTable(NotReworkInfo info);
}