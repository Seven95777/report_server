package com.iron.ncp.service;

import com.iron.ncp.entity.GuestInfo;
import com.iron.ncp.entity.GuestProject;
import com.iron.ncp.utils.RestResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 *
 * @author admin55
 * Date: 2020/2/27
 */
@Service
public interface GuestInfoService {

    RestResult list(GuestInfo info);

    RestResult add(List<GuestInfo> infos);

    RestResult projectList(GuestProject info);

    RestResult projectAdd(List<GuestProject> infos);
}
