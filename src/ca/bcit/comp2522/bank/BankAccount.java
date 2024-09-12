package ca.bcit.comp2522.bank;

public class BankAccount {
    /**
     * Instance variable for a registered client.
     */
    private final BankClient client;
    /**
     * Instance var for balance.
     */
    private double balance;
    /**
     * Instance var for pin
     */
    private int pin;
    /**
     * Instance var for account number
     */
    private final String accountNumber;
    /**
     * var to determine if an account is terminated.
     */
    private final boolean isClosed;

    /**
     *  Var holding the min length for accountNumber
     */
    private static final int MIN_LENGTH = 5;
    /**
     *  Var holding the min length for accountNumber
     */
    private static final int MAX_LENGTH = 6;
    /**
     * Date object holding the day,month and year of registration.
     */
    private final Date accountOpened;
    /**
     * Date object holding the day, month and year of termination.
     */
    private Date accountClosed;

    /**
     * Constructor for a current client.
     * @param client A person object
     * @param accountNumber The account's ID
     * @param pin The account's password
     * @param accountOpened Date the account was opened.
     */
    public BankAccount(BankClient client, String accountNumber, int pin, double currentBalance, Date accountOpened) {
        validateAccountNumber(accountNumber);
        this.client = client;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = currentBalance; // Set initial balance
        this.accountOpened = accountOpened;
        this.accountClosed = null; // Account is open
        this.isClosed = false; // Account is open
    }

    /**
     * Constructor for a client that has terminated their account.
     * @param client A person object
     * @param accountNumber the account's ID
     * @param pin The account's password
     * @param accountOpened Date the account was opened
     * @param accountClosed Date the account was closed.
     */
    public BankAccount(BankClient client, String accountNumber, int pin, double currentBalance, Date accountOpened, Date accountClosed) {
        validateAccountNumber(accountNumber);
        this.client = client;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = currentBalance; // Set initial balance
        this.accountOpened = accountOpened;
        this.accountClosed = accountClosed;
        this.isClosed = true; // Account is closed
    }


    /**
     * Method to validate that the amount withdrawn does not exceed the user's balance.
     * @param amount amount to be withdrawn
     */
    private void fundCheck(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Amount withdrawn cannot be greater than the amount in your account.");
        }
    }

    /**
     * Withdraw method
     * @param amount How much money to be withdrawn
     * @param pinToMatch The pin requiring to be matched for access.
     */
    public void withdraw(final double amount, final int pinToMatch) {
        if (isClosed) {
            throw new IllegalStateException("Cannot perform operations on a closed account.");
        }
        doesPinMatch(pinToMatch);
        fundCheck(amount);
        this.balance -= amount;
    }

    /**
     * Deposit method
     * @param amount The number of money to be added into an account.
     * @param pinToMatch The pin requiring to be matched for access.
     */
    public void deposit(final double amount, final int pinToMatch) {
        if (isClosed) {
            throw new IllegalStateException("Cannot perform operations on a closed account.");
        }
        doesPinMatch(pinToMatch);
        this.balance += amount;

    }

    /**
     * Validates that the account number follows regulation. Min 6, Max 8 (Chars)
     * @param accountNumber ID to be verified.
     */
    private void validateAccountNumber(String accountNumber) {
        if (accountNumber.length() < MIN_LENGTH || accountNumber.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("Invalid account number");
        }
    }

    /**
     * Validates if the user enters the correct pin for the given account.
     * @param pinToMatch the password given by the user.
     */
    private void doesPinMatch(int pinToMatch) {
        if (this.pin != pinToMatch) {
            throw new IllegalArgumentException("Incorrect PIN");
        }
    }

    /**
     * String representation of a client's banking details.
     * @return s
     */
    public String getDetails() {
        String openedDate = accountOpened.dateFormatter();

        if (isClosed) {
            String closedDate = accountClosed.dateFormatter();
            return String.format("%s had $%s in account #%s which was opened on %s and closed on %s.",
                    this.client, this.balance, this.accountNumber, openedDate, closedDate);
        } else {
            return String.format("%s has $%s in account #%s which was opened on %s and is still open.",
                    this.client, this.balance, this.accountNumber, openedDate);
        }
    }

    public double getBalance() {
        return balance;
    }
}

//    /**
//     * Withdraw method
//     * @param amount to be removed from balance.
//     */
//    public void withdraw(final double amount) {
//        if (isClosed) {
//            throw new IllegalStateException("Cannot perform operations on a closed account.");
//        }
//        fundCheck(amount);
//        this.balance -= amount;
//    }

//    public BankAccount(BankClient client, String accountNumber, int pin, Date accountOpened, Date accountClosed) {
//        validateAccountNumber(accountNumber);
//        this.client = client;
//        this.accountNumber = accountNumber;
//        this.pin = pin;
//        this.accountOpened = accountOpened;
//        this.accountClosed = accountClosed;
//        this.isClosed = true; // Account is closed
//    }

