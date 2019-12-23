package com.bankaccount.services;

import com.bankaccount.clientaccount.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
    Page<Account> list(Pageable page);

    Account listById(String id);

    Account create(Account account);

    Account update(Account account);

    void remove(String id);

}
