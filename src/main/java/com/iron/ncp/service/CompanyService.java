package com.iron.ncp.service;

import com.iron.ncp.entity.Company;
import com.iron.ncp.entity.CompanyDaily;
import com.iron.ncp.utils.RestResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * User: PengXJ
 * Date: 2020/2/23
 */
@Service
public interface CompanyService {

    RestResult list(Company info);

    RestResult add(Company info);

    RestResult dailyList(CompanyDaily info);

    RestResult dailyAdd(List<CompanyDaily> infos);

    RestResult dailyDel(CompanyDaily info);
}
