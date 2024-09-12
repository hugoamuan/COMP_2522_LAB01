package ca.bcit.comp2522.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankClient client;
    private BankAccount openAccount;
    private BankAccount closedAccount;

    @BeforeEach
    void setUp() {
        // Create a Name and Date objects for BankClient
        Name clientName = new Name("John", "Doe");
        Date birthDate = new Date(1990, 5, 15); // Client's birth date
        Date signupDate = new Date(2020, 7, 1); // Signup date for BankClient

        // Create a BankClient
        client = new BankClient(clientName, "12345", signupDate, birthDate);

        // Create a Date object for the account opening date
        Date accountOpened = new Date(2020, 8, 1);

        // Create a new BankAccount (open)
        openAccount = new BankAccount(client, "54321", 1234, accountOpened);

        // Create another BankAccount, this time for a closed account
        Date accountClosed = new Date(2021, 12, 31); // Account closed date
        closedAccount = new BankAccount(client, "54321", 1234, accountOpened, accountClosed);
    }

    @Test
    void testDepositSuccess() {
        openAccount.deposit(500.0, 1234); // Deposit 500
        assertEquals(500.0, openAccount.getBalance(), "Balance after deposit should be 500.0");
    }

    @Test
    void testWithdrawSuccess() {
        openAccount.deposit(500.0, 1234); // Deposit first
        openAccount.withdraw(100.0, 1234); // Withdraw 100
        assertEquals(400.0, openAccount.getBalance(), "Balance after withdrawal should be 400.0");
    }

    @Test
    void testWithdrawInsufficientFunds() {
        openAccount.deposit(100.0, 1234); // Deposit 100
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            openAccount.withdraw(200.0, 1234); // Attempt to withdraw more than balance
        });
        assertEquals("Amount withdrawn cannot be greater than the amount in your account.", exception.getMessage());
    }

    @Test
    void testWithdrawWithIncorrectPin() {
        openAccount.deposit(500.0, 1234); // Deposit first
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            openAccount.withdraw(100.0, 4321); // Wrong PIN
        });
        assertEquals("Incorrect PIN", exception.getMessage());
    }

    @Test
    void testWithdrawFromClosedAccount() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            closedAccount.withdraw(50.0, 1234); // Withdraw from closed account
        });
        assertEquals("Cannot perform operations on a closed account.", exception.getMessage());
    }

    @Test
    void testGetDetailsForOpenAccount() {
        openAccount.deposit(400.0, 1234);
        String expected = "John Doe has $400.00 in account #54321 which he opened on SATURDAY August 1, 2020 and is still open.";
        assertEquals(expected, openAccount.getDetails(client.getName().getFullName(), "$400.00"));
    }

    @Test
    void testGetDetailsForClosedAccount() {
        String expected = "John Doe had $0.00 in account #54321 which he opened on SATURDAY August 1, 2020 and closed on FRIDAY December 31, 2021.";
        assertEquals(expected, closedAccount.getDetails(client.getName().getFullName(), "$0.00"));
    }
}
