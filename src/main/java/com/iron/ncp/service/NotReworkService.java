package com.iron.ncp.service;

import com.iron.ncp.entity.NotReworkImpt;
import com.iron.ncp.entity.NotReworkInfo;
import com.iron.ncp.utils.RestResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 *
 * @author admin55
 * Date: 2020/2/28
 */
@Service
public interface NotReworkService {
    RestResult list(NotReworkInfo info);

    RestResult add(List<NotReworkInfo> infos);

    RestResult imptList(NotReworkImpt info);

    RestResult imptAdd(List<NotReworkImpt> infos);
}
