package experiments;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class Experiment24Test {
    // EXP 24: String equality ignoring case.
        static boolean equalsIgnoringCase(String a, String b) {
            if (a == null) return b == null;
            return a.equalsIgnoreCase(b);
        }
    
        @Test @DisplayName("24 - Case-insensitive string equality")
        void experiment24() {
            assertTrue(equalsIgnoringCase("Java", "JAVA"));
            assertFalse(equalsIgnoringCase("Java", "Python"));
        }
}
