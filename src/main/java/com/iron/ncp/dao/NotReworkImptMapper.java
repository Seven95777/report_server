package com.iron.ncp.dao;

import com.iron.ncp.entity.NotReworkImpt;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface NotReworkImptMapper extends Mapper<NotReworkImpt> {
    List<NotReworkImpt> selectByTable(NotReworkImpt info);

    void insertByTable(NotReworkImpt info);

    void updateByTable(NotReworkImpt info);

    void deleteByTable(NotReworkImpt info);
}