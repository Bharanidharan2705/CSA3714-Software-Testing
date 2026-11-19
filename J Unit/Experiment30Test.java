package experiments;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class Experiment30Test {
    // EXP 30: String length without calling String.length().
        static int findStringLength(String input) {
            int count = 0;
            for (char ignored : input.toCharArray()) count++;
            return count;
        }
    
        @Test @DisplayName("30 - String length without length()")
        void experiment30() {
            assertEquals(5, findStringLength("Hello"));
            assertEquals(0, findStringLength(""));
        }
}
