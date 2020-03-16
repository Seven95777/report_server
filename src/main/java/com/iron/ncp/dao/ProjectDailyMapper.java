package com.iron.ncp.dao;

import com.iron.ncp.entity.ProjectDaily;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface ProjectDailyMapper extends Mapper<ProjectDaily> {
    List<ProjectDaily> selectByTable(ProjectDaily project);

    void insertByTable(ProjectDaily project);

    void updateByTable(ProjectDaily project);

    void deleteByTable(ProjectDaily project);

    void myDeleteById(ProjectDaily project);
}