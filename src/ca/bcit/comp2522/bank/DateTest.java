package ca.bcit.comp2522.bank;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class DateTest {

    Date d1 = new Date(1853, 5, 18); // Leap Year
    Date d2 = new Date(1936, 5, 28); // Leap Year

    Date d3 = new Date(1912, 1, 1); // Non-Leap

    //    Date d4 = new Date(1901, 4, 17);
    Date d5 = new Date(1759, 10, 12);

    Date d6 = new Date(1152, 7,  7);

    Date d7 = new Date(969, 1, 22 );

    @Test
    void testValidLeapYear2() {
        assertTrue(d1.isLeapYear(2024));
    }
    @Test
    void testValidLeapYear1(){
        assertTrue(d2.isLeapYear(1936));
    }

    @Test
    void testInvalidLeapYear(){
        assertFalse(d3.isLeapYear(2001));
    }
//    @Test
//    void testInvalidLeapYear2(){
//        assertFalse(d4.isLeapYear(1807));
//    }

    @Test
    void testDayOfWeek1() {
        Date d5 = new Date(2024, 9, 5);
        assertEquals("THURSDAY", d5.getDayOfWeek());
    }

    @Test
    void testDayOfWeek2() {
        assertEquals("WEDNESDAY", d1.getDayOfWeek());
        assertEquals("THURSDAY", d2.getDayOfWeek());
        assertEquals("MONDAY", d3.getDayOfWeek());
        assertEquals("FRIDAY", d5.getDayOfWeek());
        assertEquals("MONDAY", d6.getDayOfWeek());
        assertEquals("SUNDAY", d7.getDayOfWeek());

    }
}