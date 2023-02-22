package com.bank.service.impl;

import com.bank.BankAccount;
import com.bank.service.BankService;

public class BankServiceImpl implements BankService {
    @Override
    public boolean withdraw(BankAccount bankAccount, double amount) {
        if (amount != 0 && bankAccount.getBalance() >= amount) {
            bankAccount.setBalance(bankAccount.getBalance() - amount);
            bankAccount.setPrevTrans(bankAccount.getPrevTrans() - amount);
            return true;
        } else if (bankAccount.getBalance() < amount) {
            System.out.println("Bank balance insufficient");
        }
        return false;
    }

    @Override
    public boolean deposit(BankAccount bankAccount, double amount) {
        if (amount > 0) {
            bankAccount.setBalance(bankAccount.getBalance() + amount);
            bankAccount.setPrevTrans(amount);
            return true;
        }
        return false;
    }
}
