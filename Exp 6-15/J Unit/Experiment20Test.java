package experiments;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class Experiment20Test {
    // EXP 20: Count vowels and consonants; returns {vowels, consonants}.
        static int[] countVowelsAndConsonants(String input) {
            int vowels = 0, consonants = 0;
            for (char ch : input.toLowerCase().toCharArray()) {
                if (ch >= 'a' && ch <= 'z') {
                    if ("aeiou".indexOf(ch) >= 0) vowels++;
                    else consonants++;
                }
            }
            return new int[] { vowels, consonants };
        }
    
        @Test @DisplayName("20 - Count vowels and consonants")
        void experiment20() {
            int[] result = countVowelsAndConsonants("Hello World");
            assertEquals(3, result[0]);
            assertEquals(7, result[1]);
        }
}
