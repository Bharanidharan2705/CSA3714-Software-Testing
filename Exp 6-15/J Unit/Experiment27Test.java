package experiments;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class Experiment27Test {
    // EXP 27: Average of n numbers using a function.
        static double calculateAverage(double[] values) {
            if (values == null || values.length == 0)
                throw new IllegalArgumentException("At least one number is required");
            double sum = 0;
            for (double value : values) sum += value;
            return sum / values.length;
        }
    
        @Test @DisplayName("27 - Average of n numbers")
        void experiment27() {
            assertEquals(25.0, calculateAverage(new double[] {10, 20, 30, 40}), 0.001);
            assertEquals(5.5, calculateAverage(new double[] {5, 6}), 0.001);
        }
}
