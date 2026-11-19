package experiments;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class Experiment26Test {
    // EXP 26: Largest array element.
        static int largestElement(int[] values) {
            if (values == null || values.length == 0)
                throw new IllegalArgumentException("Array must not be empty");
            int largest = values[0];
            for (int value : values) if (value > largest) largest = value;
            return largest;
        }
    
        @Test @DisplayName("26 - Largest element in array")
        void experiment26() {
            assertEquals(95, largestElement(new int[] {12, 45, 95, 23, 67}));
            assertEquals(-1, largestElement(new int[] {-9, -1, -5}));
        }
}
