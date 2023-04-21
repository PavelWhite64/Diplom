package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test
    public void IllegalArgumentExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount savingAccount = new SavingAccount(5, 2, 1, 5);
        });

    }

    @Test
    public void shouldIllegalArgumentExceptionInitialBalanceTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount savingAccount = new SavingAccount(1, 10, 15, 5);
        });

    }

    @Test
    public void shouldIllegalArgumentExceptionMinBalanceTest() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount savingAccount = new SavingAccount(10, 10, 5, 10);
        });

    }

    @Test
    public void shouldIllegalArgumentExceptionRateTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount savingAccount = new SavingAccount(1, 0, 100, -1);
        });
    }

    @Test
    public void shouldIfMinBalanceLessZeroIllegalArgumentExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount savingAccount = new SavingAccount(1, -1_000, 1_000, 10);
        });
    }

    @Test
    public void shouldPayTest() {
        SavingAccount savingAccount = new SavingAccount(500, 0, 1_500, 10);


        boolean expected = true;
        boolean actual = savingAccount.pay(250);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPayLess0Test() {
        SavingAccount savingAccount = new SavingAccount(1_000, 0, 5_000, 10);

        boolean expected = false;
        boolean actual = savingAccount.pay(-1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPayZeroTest() {
        SavingAccount savingAccount = new SavingAccount(100, 0, 500, 10);

        boolean expected = false;
        boolean actual = savingAccount.pay(0);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPayBalanceMinusTest() {
        SavingAccount savingAccount = new SavingAccount(100, 0, 1_500, 10);

        boolean expected = false;
        boolean actual = savingAccount.pay(150);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAddTest() {
        SavingAccount savingAccount = new SavingAccount(100, 80, 1_000, 10);

        boolean expected = true;
        boolean actual = savingAccount.add(90);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSavingAccountIncrease() {
        SavingAccount savingAccount = new SavingAccount(100, 0, 1_000, 50);

        savingAccount.add(500);

        int expected = 600;
        int actual = savingAccount.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAddIncreaseMaxBalance() {
        SavingAccount savingAccount = new SavingAccount(100, 0, 200, 10);

        boolean expected = false;
        boolean actual = savingAccount.add(250);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldYearChange() {
        SavingAccount savingAccount = new SavingAccount(200, 100, 1_000, 15);


        int expected = 30;
        int actual = savingAccount.yearChange();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldYearChange0() {
        SavingAccount savingAccount = new SavingAccount(0, 0, 150, 100);

        int expected = 0;
        int actual = savingAccount.yearChange();

        Assertions.assertEquals(expected, actual);
    }
}


