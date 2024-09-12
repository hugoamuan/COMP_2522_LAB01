package ca.bcit.comp2522.bank;

public class BankAccount {
    private final BankClient client;
    private double balance;
    private int pin;
    private final String accountNumber;
    private final boolean isClosed; // Flag to determine if the account is closed

    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 6;
    private final Date accountOpened;
    private Date accountClosed;

    // Constructor for an open account
    public BankAccount(BankClient client, String accountNumber, int pin, Date accountOpened) {
        validateAccountNumber(accountNumber);
        this.client = client;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.accountOpened = accountOpened;
        this.isClosed = false; // Account is open
    }

    // Constructor for a closed account
    public BankAccount(BankClient client, String accountNumber, int pin, Date accountOpened, Date accountClosed) {
        validateAccountNumber(accountNumber);
        this.client = client;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.accountOpened = accountOpened;
        this.accountClosed = accountClosed;
        this.isClosed = true; // Account is closed
    }

    public void withdraw(final double amount) {
        if (isClosed) {
            throw new IllegalStateException("Cannot perform operations on a closed account.");
        }
        fundCheck(amount);
        this.balance -= amount;
    }

    private void fundCheck(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Amount withdrawn cannot be greater than the amount in your account.");
        }
    }

    // Overloaded withdraw method with PIN verification
    public void withdraw(final double amount, final int pinToMatch) {
        if (isClosed) {
            throw new IllegalStateException("Cannot perform operations on a closed account.");
        }
        doesPinMatch(pinToMatch);
        fundCheck(amount);
        this.balance -= amount;
    }

    public void deposit(final double amount, final int pinToMatch) {
        if (isClosed) {
            throw new IllegalStateException("Cannot perform operations on a closed account.");
        }
        doesPinMatch(pinToMatch);
        this.balance += amount;

    }

    private void validateAccountNumber(String accountNumber) {
        if (accountNumber.length() < MIN_LENGTH || accountNumber.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("Invalid account number");
        }
    }

    private void doesPinMatch(int pinToMatch) {
        if (this.pin != pinToMatch) {
            throw new IllegalArgumentException("Incorrect PIN");
        }
    }

    public String getDetails(String clientName, String balanceFormatted) {
        String openedDate = accountOpened.dateFormatter();
        if (isClosed) {
            String closedDate = accountClosed.dateFormatter();
            return String.format("%s had %s in account #%s which he opened on %s and closed on %s.",
                    clientName, balanceFormatted, accountNumber, openedDate, closedDate);
        } else {
            return String.format("%s has %s in account #%s which he opened on %s and is still open.",
                    clientName, balanceFormatted, accountNumber, openedDate);
        }
    }

    public double getBalance() {
        return balance;
    }
}

    // Additional methods like getters, setters, etc. can be added as needed

