package ca.bcit.comp2522.bank;

public class BankClient extends Person{

    // Strings start @ index 0
    private static final int MIN_DIGITS = 5;
    private static final int MAX_DIGITS = 6;

    private final String clientID;
    private final Date signupDate;

    // For dead person
    public BankClient(Name name, String clientID, Date signupDate, Date birthDate, Date deathDate) {
        super(name, birthDate, deathDate);
        validateClientID(clientID);
        this.clientID = clientID;
        this.signupDate = signupDate;

    }

    // For alive person
    public BankClient(Name name, String clientID, Date signupDate, Date birthDate) {
        this(name, clientID, signupDate, birthDate, null);
    }


    // For an already existing person
    public BankClient (Person person, String clientID, Date signupDate, Date birthdate) {
        this(person.getName(), clientID, signupDate, person.getBirthDate(), person.getDeathDate());
    }

    private void validateClientID(String clientID) {
        if (clientID.length() < MIN_DIGITS || clientID.length() > MAX_DIGITS) {
            throw new IllegalArgumentException("Client ID must be between " + MIN_DIGITS + " and " + MAX_DIGITS +
                    " digits.");
        }
    }

    @Override
    public String getDetails() {
        StringBuilder clientDetails = new StringBuilder();
        clientDetails.append(getClientIdentification())
                .append(getLifeStatusDetails())
                .append(getSignupDateDetails());

        return clientDetails.toString();
    }

    private String getClientIdentification() {
        return getName().getFullName() + " client #" + clientID + " (" + lifeStatus() + ") ";
    }

    private String getLifeStatusDetails() {
        if (lifeStatus().equals("alive")) {
            return "";
        } else {
            return "died on " + formatDate(getDeathDate()) + ". Born on " + signupDate.dateFormatter() + ".";
        }
    }

    private String getSignupDateDetails() {
        if (lifeStatus().equals("alive")) {
            return "joined the bank on " + signupDate.dateFormatter() + ".";
        }
        return "";
    }

    private String formatDate(Date date) {
        return date.getDayOfWeek() + ", " +
                date.getMonthName() + " " + date.getDay() + ", " +
                date.getYear();
    }
}