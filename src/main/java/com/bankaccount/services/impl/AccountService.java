package com.bankaccount.services.impl;

import com.bankaccount.clientaccount.Account;
import com.bankaccount.repositories.RepositoryAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AccountService {

    private final RepositoryAccount repositoryAccount;

    public AccountService(RepositoryAccount repositoryAccount) {
        this.repositoryAccount = repositoryAccount;
    }


    public Page<Account> list(Pageable page) {
        return repositoryAccount.findAll(page);
    }

    public Account listById(String id) {
        Optional<Account> account = repositoryAccount.findById(id);
        if (account.isPresent()) {
            return account.get();
        } else {
            return null;
        }
    }


    public Account create(Account account) {
        account.setDataCreation(LocalDateTime.now());
        return this.repositoryAccount.save(account);
    }


    public Account update(Account account) {
        account.setDataUpdate(LocalDateTime.now());
        return this.repositoryAccount.save(account);
    }

    public Account findById(String id) {
        Optional<Account> account = repositoryAccount.findById(id);
        return account.get();
    }

    public Account delete(String id) {
        Account account = findById(id);
        account.setStatus(false);
        return repositoryAccount.save(account);

    }
}

