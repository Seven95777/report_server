package com.iron.ncp.dao;

import com.iron.ncp.entity.GuestInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface GuestInfoMapper extends Mapper<GuestInfo> {
    List<GuestInfo> selectByTable(GuestInfo info);

    void insertByTable(GuestInfo info);

    void updateByTable(GuestInfo info);

    void deleteByTable(GuestInfo info);
}