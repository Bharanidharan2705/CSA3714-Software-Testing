package experiments;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class Experiment19Test {
    // EXP 19: Calculate compound interest.
        static double compoundInterest(double principal, double annualRate, int years) {
            if (principal < 0 || annualRate < 0 || years < 0)
                throw new IllegalArgumentException("Inputs cannot be negative");
            return principal * Math.pow(1 + annualRate / 100.0, years) - principal;
        }
    
        @Test @DisplayName("19 - Compound interest")
        void experiment19() {
            assertEquals(331.00, compoundInterest(1000, 10, 3), 0.01);
            assertEquals(0.00, compoundInterest(1000, 0, 5), 0.01);
        }
}
