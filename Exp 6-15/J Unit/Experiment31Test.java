package experiments;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class Experiment31Test {
    // EXP 31: Reverse a word.
        static String reverseWord(String word) {
            StringBuilder result = new StringBuilder();
            for (int i = word.length() - 1; i >= 0; i--) result.append(word.charAt(i));
            return result.toString();
        }
    
        @Test @DisplayName("31 - Reverse a word")
        void experiment31() {
            assertEquals("avaJ", reverseWord("Java"));
            assertEquals("olleh", reverseWord("hello"));
        }
}
