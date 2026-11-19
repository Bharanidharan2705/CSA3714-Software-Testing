package experiments;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class Experiment29Test {
    // EXP 29: Celsius to Fahrenheit.
        static double celsiusToFahrenheit(double celsius) {
            return celsius * 9.0 / 5.0 + 32;
        }
    
        @Test @DisplayName("29 - Celsius to Fahrenheit")
        void experiment29() {
            assertEquals(32.0, celsiusToFahrenheit(0), 0.001);
            assertEquals(212.0, celsiusToFahrenheit(100), 0.001);
        }
}
