package experiments;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class Experiment32Test {
    // EXP 32: String comparison.
        static int compareStrings(String first, String second) {
            return first.compareTo(second);
        }
    
        @Test @DisplayName("32 - String comparison")
        void experiment32() {
            assertEquals(0, compareStrings("Java", "Java"));
            assertTrue(compareStrings("Apple", "Banana") < 0);
            assertTrue(compareStrings("Zoo", "Apple") > 0);
        }
}
