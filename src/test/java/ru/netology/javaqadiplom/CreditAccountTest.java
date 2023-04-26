package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldAddToPositiveBalanceMoreLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(6_000);

        Assertions.assertEquals(5_000, account.getBalance());
    }

    @Test
    public void shouldAddToPositiveBalanceEqualsLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(5_000);

        Assertions.assertEquals(5_000, account.getBalance());
    }

    @Test
    public void shouldAddToNegativeBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(-1_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldAddToPositiveBalanceInitialBalance1_000() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.add(1_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldAddToPositiveBalanceInitialBalanceMinus1_000() {
        CreditAccount account = new CreditAccount(
                -1_000,
                5_000,
                15
        );

        account.add(1_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void pay1_000InitialBalance1_000() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.pay(1_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void pay1_000InitialBalance0() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(1_000);

        Assertions.assertEquals(-1_000, account.getBalance());
    }

    @Test
    public void pay1_000InitialBalanceMinus1_000() {
        CreditAccount account = new CreditAccount(
                -1_000,
                5_000,
                15
        );

        account.pay(1_000);

        Assertions.assertEquals(-2_000, account.getBalance());
    }

    @Test
    public void creditLimitMinus() {

        Assertions.assertThrows(IllegalAccessError.class, () -> {
            CreditAccount account = new CreditAccount(0, -5_000, 15
            );
        });
    }

    @Test
    public void creditLimit0() {
        Assertions.assertThrows(IllegalAccessError.class, () -> {
            CreditAccount account = new CreditAccount(0, 0, 15
            );
        });
    }

    @Test
    public void rateMinus() {
        Assertions.assertThrows(IllegalAccessError.class, () -> {
            CreditAccount account = new CreditAccount(0, 5_000, -15
            );
        });
    }

    @Test
    public void rate0() {
        Assertions.assertThrows(IllegalAccessError.class, () -> {
            CreditAccount account = new CreditAccount(0, 5_000, 0
            );
        });
    }

    @Test
    public void yearChange200() {
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );
        account.yearChange();

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void yearChangeMinus200() {
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );
        account.yearChange();

        Assertions.assertEquals(30, account.yearChange());
    }

    @Test
    public void yearChange0() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        account.yearChange();

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void yearChange1() {
        CreditAccount account = new CreditAccount(
                1,
                5_000,
                15
        );
        account.yearChange();

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void yearChangeMinus1() {
        CreditAccount account = new CreditAccount(
                -1,
                5_000,
                15
        );
        account.yearChange();

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void addBull1_000() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15

        );

        Assertions.assertTrue(account.add(1_000));
    }

    @Test
    public void addBullMinus1_000() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15

        );

        Assertions.assertFalse(account.add(-1_000));
    }

    @Test
    public void addBull0() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15

        );

        Assertions.assertFalse(account.add(0));
    }

    @Test
    public void addBull1() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15

        );

        Assertions.assertTrue(account.add(1));
    }

    @Test
    public void addBullMinus1() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15

        );

        Assertions.assertFalse(account.add(-1));
    }

    @Test
    public void payBull1_000() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15

        );

        Assertions.assertTrue(account.pay(1_000));
    }

    @Test
    public void payBull1() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15

        );

        Assertions.assertTrue(account.pay(1));
    }

    @Test
    public void payBull0() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15

        );

        Assertions.assertFalse(account.pay(0));
    }

    @Test
    public void payBullMinus1() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15

        );

        Assertions.assertFalse(account.pay(-1));
    }

    @Test
    public void payBullMinus1_000() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15

        );

        Assertions.assertFalse(account.pay(-1_000));
    }
}
