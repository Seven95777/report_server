package com.iron.ncp.service;

import com.iron.ncp.entity.StaffInfo;
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
public interface StaffInfoService {
    RestResult list(StaffInfo info);

    RestResult add(List<StaffInfo> infos);

}
