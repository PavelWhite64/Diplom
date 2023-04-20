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
    import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqadiplom.SavingAccount;

    public class SavingAccountTest {

        @Test
        public void IllegalArgumentExceptionTest() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                SavingAccount savingAccount = new SavingAccount(5, 2, 1, 5);
            });

        }

        @Test
        public void shouldIllegalArgumentExceptionInitialBalanceTest() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                SavingAccount  savingAccount = new SavingAccount(1, 10, 15, 5);
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
                SavingAccount savingAccount = new SavingAccount(1,0, 100, -1);
            });
        }

        @Test
        public void shouldIfMinBalanceLessZeroIllegalArgumentExceptionTest() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                SavingAccount savingAccount = new SavingAccount(1, -1000, 1000, 10);
            });
        }

        @Test
        public void shouldPayTest() {
            SavingAccount savingAccount = new SavingAccount(500, 0, 1500, 10);


            boolean expected = true;
            boolean actual = savingAccount.pay(250);

            Assertions.assertEquals(expected, actual);
        }


    }

}
