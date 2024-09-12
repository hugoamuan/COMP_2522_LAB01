package ca.bcit.comp2522.bank;

/**
 * Class representing a Person with a name, birthdate and a death date if valid.
 *
 * @author Hugo Amuan
 * @version 1.0
 */
public class Person {

    /**
     * Instance variable for a Name object which takes first name and last name parameters.
     */
    private final Name name;
    private final Date birthDate;
    private final Date deathDate;

    /**
     * Constructor for a deceased person
     * @param name of the person
     * @param birthDate of the person
     * @param deathDate of the person
     */
    public Person(Name name, Date birthDate, Date deathDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    }

    /**
     * Constructor for a living person
     * @param name of the person
     * @param birthDate of the person
     */public Person(Name name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = null;
    }

    /**
     * Explains a person's information in detail.
     * @return details
     */
    public String getDetails() {
        String status = lifeStatus();
        String birthDayOfWeek = birthDate.getDayOfWeek().toLowerCase();
        String birthMonth = birthDate.getMonthName();

        String details = name.getFullName() + " (" + status + ") was born on " + birthDayOfWeek + ", "
                + birthMonth + " " + birthDate.getDay() + ", " + birthDate.getYear() + "!";

        if (deathDate != null) {
            String deathDayOfWeek = deathDate.getDayOfWeek().toLowerCase();
            String deathMonth = deathDate.getMonthName();

            details = name.getFullName() + " (died " + deathDayOfWeek + ", "
                    + deathMonth + " " + deathDate.getDay() + ", " + deathDate.getYear() + ") was born on "
                    + birthDayOfWeek + ", " + birthMonth + " " + birthDate.getDay() + ", " + birthDate.getYear() + "!";
        }

        return details;
    }

    /**
     * Checking if a person is dead or alive.
     * @return alive or deceased
     */
    public String lifeStatus() {
        return (deathDate == null) ? "alive" : "deceased";
    }

    /**
     * Getter for a person's birthday.
     * @return birthDate
     */
    public Date getBirthDate() {
        return this.birthDate;
    }

    /**
     * Getter for a person's death date.
     * @return deathDate
     */
    public Date getDeathDate() {
        return this.deathDate;
    }

    /**
     * Getter for a person's name
     * @return name
     */
    public Name getName() {
        return this.name;
    }

//    /**
//     *
//     * @return
//     */
//    public String toString() {
//        return this.getDetails();
//    }

}