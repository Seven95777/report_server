package com.iron.ncp.dao;

import com.iron.ncp.entity.GuestProject;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface GuestProjectMapper extends Mapper<GuestProject> {
    List<GuestProject> selectByTable(GuestProject project);

    void insertByTable(GuestProject project);

    void updateByTable(GuestProject project);

    void deleteByTable(GuestProject project);
}