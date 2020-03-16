package com.iron.ncp.dao;

import com.iron.ncp.entity.Company;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface CompanyMapper extends Mapper<Company> {
}