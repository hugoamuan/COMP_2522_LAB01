package ca.bcit.comp2522.bank;

/**
 * Name Class representing
 *
 * @author Hugo Amuan
 * @version 1.0
 */
public class Name {

    // Private instance variable for first and last
    private final String first;
    private final String last;

    // Final: must not be altered.
    // Belongs to the class itself (static: helps save memory)
    // Only one copy of the variable in memory regardless of how many instances of the Name class are made.
    private final static int MAX_NAME_LENGTH = 45;

    /**
     * Constructs a Name object with the given first and last names.
     * Must not contain the word "admin", be null or blank and must be fewer than 45 chars.
     *
     * @param first The first name
     * @param last The last name;
     * @throws IllegalArgumentException if the provided first or last name is invalid.
     */
    public Name(String first, String last) {
        nameValidator(first, last);
        this.first = first;
        this.last = last;
    }

    /**
     * nameValidator method to verify Name object satisfies the requirements of the constructor.
     * @param first The first string of the Name object
     * @param last The second string of the Name object
     */
    private static void nameValidator(String first, String last) {
        if (first == null || first.isEmpty() || first.isBlank()) {
            throw new IllegalArgumentException("First name is null or blank");
        }
        if (last == null || last.isEmpty() || last.isBlank()) {
            throw new IllegalArgumentException("Last name is null or blank");
        }
        if (first.length() >= MAX_NAME_LENGTH || last.length() >= MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("Length for either first or last name must be under 45 characters.");
        }
        if (first.equalsIgnoreCase("admin") || last.equalsIgnoreCase("admin")) {
            throw new IllegalArgumentException("First name and last name cannot contain the word: Admin");
        }
    }

    /**
     * Getter for instance variable "first".
     *
     * @return the first name.
     */
    public String getFirst() {
        return first;
    }

    /**
     * Getter for instance variable "last".
     *
     * @return the last name.
     */
    public String getLast() {
        return last;
    }

    /**
     * Returns the first letter from first and last concatenated and capitalized.
     *
     * @return the initials of the name.
     */
    public String getInitials() {
        return first.substring(0, 1).toUpperCase() + "." + last.substring(0, 1).toUpperCase();
    }

    /**
     * Returns the full name with the first letter of both first and last names capitalized.
     *
     * @return the capitalized full name.
     */
    public String getFullName() {
        return capitalizeName(first) + " " + capitalizeName(last);
    }

    /**
     * Capitalization method to format Name as a proper noun.
     *
     * @param name The name to be capitalized.
     * @return the capitalized name.
     */
    public String capitalizeName(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        return name.charAt(0) + name.substring(1).toLowerCase();
    }

    /**
     * Reverse each letter's position in a full name.
     * Utilizes StringBuilder's reverse() method.
     * @return the reversed name using
     */
    public String getReversedName() {
        String fullName = getFullName();
        StringBuilder reversed = new StringBuilder(fullName);
        return reversed.reverse().toString();
    }
}
