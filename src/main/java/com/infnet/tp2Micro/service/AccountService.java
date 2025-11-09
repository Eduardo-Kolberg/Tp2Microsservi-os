package com.infnet.tp2Micro.service;

import com.infnet.tp2Micro.model.Account;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class AccountService {
    private Map<Long, Account> accounts = new HashMap<>();
    private AtomicLong counter = new AtomicLong();

    public Account createAccount(Account account) {
        long id = counter.incrementAndGet();
        account.setId(id);
        accounts.put(id, account);
        return account;
    }

    public List<Account> getAllAccounts() {
        return new ArrayList<>(accounts.values());
    }

    public Optional<Account> getAccountById(Long id) {
        return Optional.ofNullable(accounts.get(id));
    }


    public Optional<Account> updateBalance(Long id, Double balance) {
        Account acc = accounts.get(id);
        if (acc != null) {
            acc.setBalance(balance);
            return Optional.of(acc);
        }
        return Optional.empty();
    }

    public boolean deleteAccount(Long id) {
        return accounts.remove(id) != null;
    }
}
