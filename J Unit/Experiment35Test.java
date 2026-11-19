package experiments;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Experiment35Test {
    // EXP 35: Number palindrome.
    static int reverseNumber(int n) {
        int rev = 0;
        while (n != 0) {
            int digit = n % 10;
            rev = rev * 10 + digit;
            n = n / 10;
        }
        return rev;
    }

    static boolean isPalindromeNumber(int number) {
        return number >= 0 && number == reverseNumber(number);
    }

    @Test @DisplayName("35 - Number palindrome")
    void experiment35() {
        assertTrue(isPalindromeNumber(121));
        assertTrue(isPalindromeNumber(0));
        assertFalse(isPalindromeNumber(123));
    }
}
