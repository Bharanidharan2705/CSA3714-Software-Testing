package experiments;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class Experiment16Test {
    // EXP 16: Check whether two strings are anagrams.
        static boolean areAnagrams(String first, String second) {
            if (first == null || second == null) return false;
            char[] a = first.replaceAll("\\s+", "").toLowerCase().toCharArray();
            char[] b = second.replaceAll("\\s+", "").toLowerCase().toCharArray();
            Arrays.sort(a);
            Arrays.sort(b);
            return Arrays.equals(a, b);
        }
    
        @Test @DisplayName("16 - Anagram")
        void experiment16() {
            assertTrue(areAnagrams("listen", "silent"));
            assertFalse(areAnagrams("hello", "world"));
        }
}
