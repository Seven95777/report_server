package com.iron.ncp.dao;

import com.iron.ncp.entity.CompanyDaily;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface CompanyDailyMapper extends Mapper<CompanyDaily> {
    List<CompanyDaily> selectByTable(CompanyDaily daily);

    void insertByTable(CompanyDaily daily);

    void updateByTable(CompanyDaily daily);

    void deleteByTable(CompanyDaily daily);

    void myDeleteById(CompanyDaily daily);
}