import org.junit.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

import static org.junit.Assert.*;

public class RomanNumeralGeneratorTest {

    @Test
    public void whenNumberis10ThenIShouldGetX() {
        RomanNumeralGenerator generator = new RomanNumeralGenerator();

        String value = generator.toRoman(10);

        assertThat(value,is("X"));
    }

    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource({
            "1,   I",
            "2,   II",
            "3, III",
            "4, IV",
            "5,  V",
            "6,  VI",
            "7,  VII",
            "8,  VIII",
            "9,  IX",
            "10,  X",
            "11,  XI",
            "12,  XII",
            "21,XXI",
            "55,LV",
            "111,CXI",
            "666,DCLXVI",
            "1994,MCMXCIV",
    })
    void translate(int first, String expectedResult) {
        RomanNumeralGenerator generator = new RomanNumeralGenerator();

        String value = generator.translate(first);

        assertThat(value,is(expectedResult));
    }
}