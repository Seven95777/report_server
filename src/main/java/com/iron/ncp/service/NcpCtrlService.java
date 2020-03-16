package com.iron.ncp.service;

import com.iron.ncp.entity.HighBack;
import com.iron.ncp.entity.NcpCtrlInfo;
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
public interface NcpCtrlService {

    RestResult ncpList(NcpCtrlInfo info);

    RestResult ncpAdd(List<NcpCtrlInfo> info);

    RestResult highList(HighBack info);

    RestResult highAdd(List<HighBack> info);
}
