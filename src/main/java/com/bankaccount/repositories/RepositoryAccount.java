package com.bankaccount.repositories;

import com.bankaccount.clientaccount.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryAccount extends MongoRepository<Account, String> {

}
