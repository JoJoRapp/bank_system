package com.bank.service;

import com.bank.BankAccount;

public interface BankService {
    boolean withdraw(final BankAccount bankAccount, final double amount);

    boolean deposit(final BankAccount bankAccount, double amount);

}
