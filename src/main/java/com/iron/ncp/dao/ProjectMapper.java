package com.iron.ncp.dao;

import com.iron.ncp.entity.Project;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface ProjectMapper extends Mapper<Project> {
    List<Project> selectByTable(Project project);

    void insertByTable(Project project);

    void updateByTable(Project project);

    void deleteByTable(Project project);
}