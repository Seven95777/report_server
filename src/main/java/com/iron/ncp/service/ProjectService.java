package com.iron.ncp.service;

import com.iron.ncp.entity.Project;
import com.iron.ncp.entity.ProjectBase;
import com.iron.ncp.entity.ProjectDaily;
import com.iron.ncp.utils.RestResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * User: gaoyf
 * Date: 2020/2/23
 */
@Service
public interface ProjectService {

    RestResult list(Project info);

    RestResult add(List<Project> infos);

    RestResult baseList(ProjectBase info);

    RestResult baseAdd(List<ProjectBase> infos);

    RestResult baseDel(ProjectBase info);

    RestResult dailyList(ProjectDaily info);

    RestResult dailyAdd(List<ProjectDaily> infos);

    RestResult dailyDel(ProjectDaily info);

}
