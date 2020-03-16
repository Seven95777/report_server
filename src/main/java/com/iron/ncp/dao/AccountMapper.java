package com.iron.ncp.dao;

import com.iron.ncp.entity.Account;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface AccountMapper extends Mapper<Account> {

    int selectMaxId();
}