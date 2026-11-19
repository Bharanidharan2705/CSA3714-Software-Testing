package experiments;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class Experiment18Test {
    // EXP 18: Check even or odd.
        static boolean isEven(int number) { return number % 2 == 0; }
    
        @Test @DisplayName("18 - Even or odd")
        void experiment18() {
            assertTrue(isEven(24));
            assertFalse(isEven(17));
        }
}
