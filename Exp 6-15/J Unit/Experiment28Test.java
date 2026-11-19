package experiments;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class Experiment28Test {
    // EXP 28: Armstrong number.
        static boolean isArmstrong(int number) {
            if (number < 0) return false;
            String digits = Integer.toString(number);
            int power = digits.length(), sum = 0;
            for (char digit : digits.toCharArray())
                sum += (int) Math.pow(digit - '0', power);
            return sum == number;
        }
    
        @Test @DisplayName("28 - Armstrong number")
        void experiment28() {
            assertTrue(isArmstrong(153));
            assertTrue(isArmstrong(9474));
            assertFalse(isArmstrong(123));
        }
}
