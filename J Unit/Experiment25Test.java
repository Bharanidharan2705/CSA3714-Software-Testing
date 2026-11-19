package experiments;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Experiment25Test {
    // EXP 25: Student grade calculation per Saveetha Lab Manual:
    // marks >= 90 -> "A", marks >= 75 -> "B", marks >= 50 -> "C", else -> "F"
    static String calculateGrade(int marks) {
        if (marks >= 90) return "A";
        else if (marks >= 75) return "B";
        else if (marks >= 50) return "C";
        else return "F";
    }

    @Test @DisplayName("25 - Student grade")
    void experiment25() {
        assertEquals("A", calculateGrade(95));
        assertEquals("B", calculateGrade(80));
        assertEquals("F", calculateGrade(40));
    }
}
