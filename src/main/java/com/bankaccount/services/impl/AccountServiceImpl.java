package com.bankaccount.services.impl;

import com.bankaccount.clientaccount.Account;
import com.bankaccount.repositories.RepositoryAccount;
import com.bankaccount.services.AccountService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private final RepositoryAccount repositoryAccount;

    public AccountServiceImpl(RepositoryAccount repositoryAccount) {
        this.repositoryAccount = repositoryAccount;
    }

    @Override
    public Page<Account> list(Pageable page) {
        return repositoryAccount.findAll(page);
    }

    @Override
    public Account listById(String id) {
        Optional<Account> account = repositoryAccount.findById(id);
        if (account.isPresent()) {
            return account.get();
        } else {
            return null;
        }
    }

    @Override
    public Account create(Account account) {
        account.setDataCreation(LocalDateTime.now());
        return this.repositoryAccount.save(account);
    }

    @Override
    public Account update(Account account) {
        account.setDataUpdate(LocalDateTime.now());
        return this.repositoryAccount.save(account);
    }

    @Override
    public void deleteAccount(String id) {
        this.repositoryAccount.deleteById(id);

    }


}
