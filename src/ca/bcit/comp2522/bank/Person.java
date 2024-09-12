package ca.bcit.comp2522.bank;

public class Person {

    private final Name name;
    private final Date birthDate;
    private final Date deathDate;

    // Constructor for deceased person
    public Person(Name name, Date birthDate, Date deathDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    }

    // Constructor for living person
    public Person(Name name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = null;
    }

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

    public String lifeStatus() {
        return (deathDate == null) ? "alive" : "deceased";
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public Date getDeathDate() {
        return this.deathDate;
    }

    public Name getName() {
        return this.name;
    }

    public String toString() {
        return this.getDetails();
    }

}