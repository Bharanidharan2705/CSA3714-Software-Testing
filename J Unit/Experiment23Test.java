package experiments;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class Experiment23Test {
    // EXP 23: Sum of digits.
        static int sumOfDigits(int number) {
            int value = Math.abs(number), sum = 0;
            while (value > 0) {
                sum += value % 10;
                value /= 10;
            }
            return sum;
        }
    
        @Test @DisplayName("23 - Sum of digits")
        void experiment23() {
            assertEquals(15, sumOfDigits(12345));
            assertEquals(6, sumOfDigits(-123));
            assertEquals(0, sumOfDigits(0));
        }
}
