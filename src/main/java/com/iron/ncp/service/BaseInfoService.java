package com.iron.ncp.service;

import com.iron.ncp.entity.BaseInfo;
import com.iron.ncp.utils.RestResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * User: PengXJ
 * Date: 2020/2/23
 */
@Service
public interface BaseInfoService {

    RestResult list(BaseInfo info);

    RestResult add(List<BaseInfo> infos);
}
