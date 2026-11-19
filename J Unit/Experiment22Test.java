package experiments;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class Experiment22Test {
    // EXP 22: Reverse a number.
        static long reverseNumber(long number) {
            long value = Math.abs(number), reversed = 0;
            while (value > 0) {
                reversed = reversed * 10 + value % 10;
                value /= 10;
            }
            return number < 0 ? -reversed : reversed;
        }
    
        @Test @DisplayName("22 - Reverse a number")
        void experiment22() {
            assertEquals(54321L, reverseNumber(12345));
            assertEquals(-321L, reverseNumber(-123));
            assertEquals(21L, reverseNumber(1200));
        }
}
