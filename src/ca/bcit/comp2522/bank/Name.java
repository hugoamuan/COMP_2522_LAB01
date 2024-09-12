package ca.bcit.comp2522.bank;

/**
 * The Name class represents a first and last name with associated methods for retrieval
 * and manipulation of name data.
 *
 * @author Hugo Amuan
 * @version 1.0
 */
public class Name {
    private final String first;
    private final String last;

    private final static int MAX_NAME_LENGTH = 45;

    /**
     * Constructs a Name object with the given first and last names.
     *
     * @param first The first name; must not be null, blank, or contain "admin", and must be fewer than 45 characters.
     * @param last The last name; must not be null, blank, or contain "admin", and must be fewer than 45 characters.
     * @throws IllegalArgumentException if the provided first or last name is invalid.
     */
    public Name(String first, String last) {
        if (first == null || first.isEmpty() || first.isBlank()) {
            throw new IllegalArgumentException("First name is null or blank");
        }
        if (last == null || last.isEmpty() || last.isBlank()) {
            throw new IllegalArgumentException("Last name is null or blank");
        }
        if (first.length() >= MAX_NAME_LENGTH || last.length() >= MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("Length for first or last name is equal to or over 45 characters.");
        }
        if (first.equalsIgnoreCase("admin") || last.equalsIgnoreCase("admin")) {
            throw new IllegalArgumentException("First and last cannot contain the word: Admin");
        }

        this.first = first;
        this.last = last;
    }

    /**
     * Returns the first name.
     *
     * @return the first name.
     */
    public String getFirst() {
        return first;
    }

    /**
     * Returns the last name.
     *
     * @return the last name.
     */
    public String getLast() {
        return last;
    }

    /**
     * Returns the initials of the first and last name (e.g. "Tiger Woods" -> "T.W.").
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
     * Capitalizes the first letter of the provided name and makes the rest lowercase.
     *
     * @param name The name to be capitalized.
     * @return the capitalized name.
     */
    public String capitalizeName(String name) {
        if (name == null || name.isEmpty()) {
            return name; // Return the original name if it's null or empty
        }
        return name.charAt(0) + name.substring(1).toLowerCase();
    }

    public String getReversedName() {
        String fullName = getFullName();
        StringBuilder reversed = new StringBuilder(fullName);
        return reversed.reverse().toString();
    }
}
