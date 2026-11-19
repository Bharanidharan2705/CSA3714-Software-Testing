package experiments;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Experiment34Test {
    // EXP 34: Simple interest calculation based on customer type (Senior: 12%, Others: 10%)
    static double calculateSimpleInterest(double principal, int time, boolean isSeniorCitizen) {
        double rate = isSeniorCitizen ? 12.0 : 10.0;
        return (principal * rate * time) / 100.0;
    }

    static double simpleInterest(double principal, int years, String customerType) {
        boolean isSenior = "SENIOR".equalsIgnoreCase(customerType);
        return calculateSimpleInterest(principal, years, isSenior);
    }

    @Test @DisplayName("34 - Simple interest by customer type")
    void experiment34() {
        assertEquals(1200.0, calculateSimpleInterest(10000, 1, true), 0.01);
        assertEquals(1000.0, calculateSimpleInterest(10000, 1, false), 0.01);
        assertEquals(2400.0, calculateSimpleInterest(10000, 2, true), 0.01);
    }
}
