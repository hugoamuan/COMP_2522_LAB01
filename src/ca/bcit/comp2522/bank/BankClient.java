package ca.bcit.comp2522.bank;

/**
 * BankClient class with a parent class of Person
 *
 * @author HugoAmuan
 * @version 1.0
 */
public class BankClient extends Person{

    /**
     * Instance Variable representing the minimum digits required for clientID
     */
    private static final int MIN_DIGITS = 5;
    /**
     * Instance variable representing the maximum digits allowed for clientID
     */
    private static final int MAX_DIGITS = 6;
    /**
     * Instance variable to store the client's ID.
     */
    private final String clientID;
    /**
     * Date object to store when a client registers an account.
     */
    private final Date signupDate;

    /**
     * Constructor for a client that has died.
     * @param name The name of the client
     * @param clientID The client's ID
     * @param signupDate The date of registration
     * @param birthDate Birthday
     * @param deathDate Death day
     */
    public BankClient(Name name, String clientID, Date signupDate, Date birthDate, Date deathDate) {
        super(name, birthDate, deathDate);
        validateClientID(clientID);
        this.clientID = clientID;
        this.signupDate = signupDate;

    }

    /**
     * Constructor for a client that is alive.
     * @param name The name of the client
     * @param clientID The client's ID
     * @param signupDate The date of registration
     * @param birthDate Birthday
     */
    public BankClient(Name name, String clientID, Date signupDate, Date birthDate) {
        this(name, clientID, signupDate, birthDate, null);
    }


    /**
     * Method to verify the validity of the client's ID
     * @param clientID
     */
    private void validateClientID(String clientID) {
        if (clientID.length() < MIN_DIGITS || clientID.length() > MAX_DIGITS) {
            throw new IllegalArgumentException("Client ID must be between " + MIN_DIGITS + " and " + MAX_DIGITS +
                    " digits.");
        }
    }

    /**
     * Method to print-out a client's details
     * @return clientDetails
     */
    @Override
    public String getDetails() {
        StringBuilder clientDetails = new StringBuilder();
        clientDetails.append(getClientIdentification())
                .append(getLifeStatusDetails())
                .append(getSignupDateDetails());

        return clientDetails.toString();
    }

    /**
     * Identifies the status of the client
     * @return Clients ID
     */
    private String getClientIdentification() {
        return getName().getFullName() + " client #" + clientID + " (" + lifeStatus() + ") ";
    }

    /**
     * Establishing proof of life.
     * @return day of birth and death, if Person is alive returns "" and does not affect the string.
     */
    private String getLifeStatusDetails() {
        if (lifeStatus().equals("alive")) {
            return "";
        } else {
            return "died on " + formatDate(getDeathDate()) + ". Born on " + getBirthDate().dateFormatter() + ".";
        }
    }

    /**
     * Retrieves the client's registration date.
     * @return a string representing the signup details.
     */
    private String getSignupDateDetails() {

        return "joined the bank on " + signupDate.dateFormatter() + ".";
    }

    /**
     * Date Formatter
     * @param date Date object to be formatted
     * @return string
     */
    private String formatDate(Date date) {
        return date.getDayOfWeek() + ", " +
                date.getMonthName() + " " + date.getDay() + ", " +
                date.getYear();
    }

}

//        private String getSignupDateDetails() {
//            if (lifeStatus().equals("alive")) {
//                return "joined the bank on " + signupDate.dateFormatter() + ".";
//                return "";
//            }

//    /**
//     * Constructor utilizing the Person Class to create a new client.
//     * @param person The name of the client
//     * @param clientID The client's ID
//     * @param signupDate The date of registration
//     * @param birthdate Birthday
//     */
//    public BankClient (Person person, String clientID, Date signupDate, Date birthdate) {
//        this(person.getName(), clientID, signupDate, person.getBirthDate(), person.getDeathDate());
//    }