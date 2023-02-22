package com.bank;

import com.bank.service.BankService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

@ExtendWith(MockitoExtension.class)
public class BankMenuTest {

    @Mock
    private BankService bankService;

    @Mock
    private BankAccount account;

    @Test
    public void testDeposit() {
        BankMenu bankMenu = new BankMenu(bankService, account);

        String input = "b 100 e";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Mockito.when(account.getCustomerName()).thenReturn("Test Testson");
        Mockito.when(account.getCustomerId()).thenReturn("TestID");

        bankMenu.menu();

        Mockito.verify(bankService, Mockito.times(1)).deposit(Mockito.any(), Mockito.anyDouble());
    }

    @Test
    public void testWithdraw() {
        BankMenu bankMenu = new BankMenu(bankService, account);

        String input = "c 100 e";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Mockito.when(account.getCustomerName()).thenReturn("Test Testson");
        Mockito.when(account.getCustomerId()).thenReturn("TestID");

        bankMenu.menu();

        Mockito.verify(bankService, Mockito.times(1)).withdraw(Mockito.any(), Mockito.anyDouble());
    }

    @Test
    public void testWithdrawThrowsRuntimeExceptionShouldBeHandled() {
        BankMenu bankMenu = new BankMenu(bankService, account);

        String input = "c 100 e";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Mockito.when(account.getCustomerName()).thenReturn("Test Testson");
        Mockito.when(account.getCustomerId()).thenReturn("TestID");

        Mockito.when(bankService.withdraw(Mockito.any(), Mockito.anyDouble())).thenThrow(RuntimeException.class);

        bankMenu.menu();
    }
}
