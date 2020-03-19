package com.iron.ncp.service;

import com.iron.ncp.entity.Account;
import com.iron.ncp.utils.RestResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * User: PengXJ
 * Date: 2020/2/23
 */
@Service
public interface AccountService {
    RestResult login(Account account);

    RestResult add(List<Account> accounts);
}
