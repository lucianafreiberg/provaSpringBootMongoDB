package com.bankaccount.controllers;

import com.bankaccount.clientaccount.Account;
import com.bankaccount.services.AccountService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/bank/account/")
public class ControllerAccount {

    private final AccountService accountService;

    public ControllerAccount(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<Page<Account>> findAll(Pageable pageable) {
//    public ResponseEntity<Page<Account>> findAll() {
        Page<Account> accounts = accountService.list(pageable);
        //List<Account> accounts = accountService.list();
        return ResponseEntity.ok(accounts);
    }

    @GetMapping(path = {"{id}"})
    public ResponseEntity<Account> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.accountService.listById(id));

    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Account> create(@RequestBody Account account) {
        return ResponseEntity.ok(this.accountService.create(account));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Account> update(@PathVariable(name = "id") String id, @RequestBody Account account) {
        account.setId(id);
        return ResponseEntity.ok(this.accountService.update(account));

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Integer> remove(@PathVariable (name = "id") String id) {
        this.accountService.remove(id);
        return ResponseEntity.ok(1);
    }
}
