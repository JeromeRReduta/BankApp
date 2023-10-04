import exceptions.InsufficientFundsException;
import models.BankAccount;
import models.SimpleBankAccount;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SimpleBankAccountTest {

    final static String mockName = "Bubba";
    final static int mockID = 5;

    final static double startingMoney = 0;

    static BankAccount getMockBankAccount() {
        return new SimpleBankAccount(
                mockName,
                mockID,
                startingMoney);
    }

    @Test
    @DisplayName("First")
    public void initTest() {
        BankAccount mockAccount = getMockBankAccount();
        assertEquals(
                mockID,
                mockAccount.getID().intValue());
        assertEquals(
                mockName,
                mockAccount.getName());
        assertEquals(
                startingMoney,
                mockAccount.getMoney());
    }

    @Test
    @DisplayName("Second")
    public void toStringTest() {
        BankAccount mockAccount = getMockBankAccount();
        String expectedString =
                """
                Bubba [5]:
                $0.00
                """;
        assertEquals(
                expectedString,
                mockAccount.toString());
    }

    @Test
    @DisplayName("Third")
    public void updateMoneyTest() {
        BankAccount mockAccount = getMockBankAccount();
        mockAccount.deposit(500);
        assertEquals(
                500,
                mockAccount.getMoney().intValue()
        );
        mockAccount.deposit(1000);
        assertEquals(
                1500,
                mockAccount.getMoney().intValue()
        );
        assertThrows(
                InsufficientFundsException.class,
                () -> mockAccount.withdraw(1000000000));
    }


}
