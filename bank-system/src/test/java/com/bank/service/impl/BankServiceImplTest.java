package com.bank.service.impl;


import com.bank.BankAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BankServiceImplTest {

    @Mock
    private BankAccount account;

    BankServiceImpl bankService = new BankServiceImpl();

    @Test
    public void testWithdrawBestCase() {
        Mockito.when(account.getBalance()).thenReturn(1000d);

        Assertions.assertTrue(bankService.withdraw(account, 100d));

        Mockito.verify(account, Mockito.times(1)).setBalance(Mockito.anyDouble());
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        Mockito.when(account.getBalance()).thenReturn(100d);

        Assertions.assertFalse(bankService.withdraw(account, 1000d));

        Mockito.verify(account, Mockito.times(0)).setBalance(Mockito.anyDouble());
    }

    @Test
    public void testDepositBestCase() {
        Assertions.assertTrue(bankService.deposit(account, 100d));

        Mockito.verify(account, Mockito.times(1)).setBalance(Mockito.anyDouble());
    }

    @Test
    public void testDepositNegativeAmount() {
        Assertions.assertFalse(bankService.deposit(account, -100d));

        Mockito.verify(account, Mockito.times(0)).setBalance(Mockito.anyDouble());
    }
}
