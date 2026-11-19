package experiments;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class Experiment33Test {
    // EXP 33: Voting eligibility; minimum age assumed to be 18.
        static boolean isEligibleToVote(int age) { return age >= 18; }
    
        @Test @DisplayName("33 - Voting eligibility")
        void experiment33() {
            assertTrue(isEligibleToVote(18));
            assertTrue(isEligibleToVote(25));
            assertFalse(isEligibleToVote(17));
        }
}
