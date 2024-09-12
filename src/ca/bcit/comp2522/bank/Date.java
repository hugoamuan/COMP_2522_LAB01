package ca.bcit.comp2522.bank;


public class Date {
    private static final int SEVEN = 7;
    private static final int THIRTEEN = 13;
    private static final int THIRTY_ONE = 31;
    private static final int THIRTY = 30;
    private static final int TWENTY_NINE = 29;
    private static final int TWENTY_EIGHT = 28;
    private int year;
    private int month;
    private int day;

    private static final int CURRENT_YEAR = 2024;

    private static final int MIN_YEAR = 1;

    private static final int MIN_MONTH = 1;
    private static final int MAX_MONTH = 12;

    private static final int JANUARY = 1;
    private static final int FEBRUARY = 2;
    private static final int MARCH = 3;
    private static final int APRIL = 4;
    private static final int MAY = 5;

    private static final int JUNE = 6;

    private static final int JULY = 7;
    private static final int AUGUST = 8;
    private static final int SEPTEMBER = 9;
    private static final int OCTOBER = 10;
    private static final int NOVEMBER = 11;
    private static final int DECEMBER = 12;
    private static final int HUNDRED = 100;
    private static final int TWELVE = 12;

    private static final int FOUR = 4;

    private static final int LEAP_YEAR_DIVISOR = 4;
    private static final int CENTURY_DIVISOR = 100;
    private static final int ALT_CENTURY_DIVISOR = 400;

    private static final int MONTHS_IN_YEAR = 12;
    private static final String[] DAY_OF_WEEK = {
            "SUNDAY",
            "MONDAY",
            "TUESDAY",
            "WEDNESDAY",
            "THURSDAY",
            "FRIDAY",
            "SATURDAY"
    };

    public Date(int year, int month, int day) {
        validateYear(year); // Validates the year and if not valid, will throw an exception.
        validateMonth(month);
        validateDay(year, month, day);
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getYYYYMMDD() {
        return year + "-" + month + "-" + day;
    }


    public void validateYear(int year) {
        if (year > CURRENT_YEAR || year < MIN_YEAR) {
            throw new IllegalArgumentException("Invalid year, must be between 0 - 2024");
        }
    }

    public void validateMonth(int month) {
        if (month < MIN_MONTH || month > MAX_MONTH) {
            throw new IllegalArgumentException("Invalid month, must be input as 0 - 12 (Jan to Dec)");
        }
    }


    public void validateDay(int year, int month, int day) {
        int daysInMonth = getDaysInMonth(year, month);
        if (day < 1 || day > daysInMonth) {
            throw new IllegalArgumentException("Invalid days for the given month. Maximum amount is: "
                    + daysInMonth);
        }
    }

    public int getDaysInMonth(int year, int month) {
        switch (month) {
            case JANUARY:
            case MARCH:
            case MAY:
            case JULY:
            case AUGUST:
            case OCTOBER:
            case DECEMBER:
                return THIRTY_ONE;
            case APRIL:
            case JUNE:
            case SEPTEMBER:
            case NOVEMBER:
                return THIRTY;
            case FEBRUARY:
                return isLeapYear(year) ? TWENTY_NINE : TWENTY_EIGHT; // Review Ternary operators!
        }
        throw new IllegalArgumentException("Invalid month: " + month);
    }

    public String getDayOfWeek() {
        // Use a temporary variable to adjust the month
        int tempMonth = month;
        int tempYear = year;

        // In Zeller's Congruence, Jan and Feb are treated as the 13th and 14th months of the previous year.
        if (tempMonth < Date.MARCH) {
            tempMonth += MONTHS_IN_YEAR;
            tempYear -= 1;
        }

        int lastTwoDigits = tempYear % HUNDRED;
        int j = tempYear / HUNDRED;

        int h = (day + (THIRTEEN * (tempMonth + 1)) / 5 + lastTwoDigits + (lastTwoDigits / FOUR) + (j / FOUR) - 2 * j) % SEVEN;

        // Ensure h is within bounds
        return DAY_OF_WEEK[(h + 6) % 7];
    }


    public boolean isLeapYear(int year) {
        return year % LEAP_YEAR_DIVISOR == 0 || (year % CENTURY_DIVISOR != 0
                && year % ALT_CENTURY_DIVISOR == 0);
    }


    public String getMonthName() {
        switch (month) {
            case JANUARY:
                return "January";
            case FEBRUARY:
                return "February";
            case MARCH:
                return "March";
            case APRIL:
                return "April";
            case MAY:
                return "May";
            case JUNE:
                return "June";
            case JULY:
                return "July";
            case AUGUST:
                return "August";
            case SEPTEMBER:
                return "September";
            case OCTOBER:
                return "October";
            case NOVEMBER:
                return "November";
            case DECEMBER:
                return "December";
            default:
                throw new IllegalArgumentException("Invalid month: " + month);
        }
    }
    public String dateFormatter() {
        return String.format("%s %s %d, %d",
                getDayOfWeek(),
                getMonthName(),
                day,
                year
        );
    }
}


