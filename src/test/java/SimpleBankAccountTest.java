import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SimpleBankAccountTest {
    String firstName = "John";
    String lastName = "Doe";
    Number id = 100;
    Number age = 101;
    Number funds = 102;
    Number creditScore = 103;
    public SimpleBankAccount getMockAccount() {

        return new SimpleBankAccount(
                firstName,
                lastName,
                id,
                age,
                funds,
                creditScore);
    }


    @Test
    @DisplayName("Getter Test")
    public void getterTest() {
        BankAccount mockAccount = getMockAccount();
        assertEquals(firstName + " " + lastName,
                mockAccount.getFirstName() + " " + mockAccount.getLastName());
        assertEquals(id,
                mockAccount.getID());
        assertEquals(age,
                mockAccount.getAge());
        assertEquals(funds,
                mockAccount.getFunds());
        assertEquals(creditScore,
                mockAccount.getCreditScore());

    }

    @Test
    @DisplayName("Setter Test")
    public void setterTest() {
        /* TODO - write hte following tests:
            set first name
            set last name
            est id
            set funds
            set credit score
         */
    }

    @Test
    @DisplayName("Add and subtract money test")
    public void updateMoneyTest() {
        /*
        TODO - write the following tests/asserts:
        add $100
        subtract $1000
         */

    }

}
