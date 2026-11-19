package experiments;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class Experiment17Test {
    // EXP 17: Find maximum of three numbers.
        static int maximumOfThree(int a, int b, int c) {
            return Math.max(a, Math.max(b, c));
        }
    
        @Test @DisplayName("17 - Maximum of three numbers")
        void experiment17() {
            assertEquals(90, maximumOfThree(45, 90, 12));
            assertEquals(-2, maximumOfThree(-8, -2, -5));
        }
}
