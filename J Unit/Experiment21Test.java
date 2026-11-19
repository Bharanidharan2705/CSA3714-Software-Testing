package experiments;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class Experiment21Test {
    // EXP 21: Check prime number.
        static boolean isPrime(int number) {
            if (number <= 1) return false;
            for (int i = 2; i <= number / i; i++)
                if (number % i == 0) return false;
            return true;
        }
    
        @Test @DisplayName("21 - Prime number")
        void experiment21() {
            assertTrue(isPrime(17));
            assertFalse(isPrime(21));
            assertFalse(isPrime(1));
        }
}
