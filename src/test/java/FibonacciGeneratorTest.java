import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FibonacciGeneratorTest {

    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource({
            "1,   1 1",
            "2,   1 1 2",
            "3,   1 1 2 3",
            "4,   1 1 2 3 5",
            "5,   1 1 2 3 5 8",
            "6,   1 1 2 3 5 8 13",
            "7,  1 1 2 3 5 8 13 21",
            "8,  1 1 2 3 5 8 13 21 34",
            "9,  1 1 2 3 5 8 13 21 34 55"
    })
    void translate(int first, String expectedResult) {
        FibonacciGenerator generator = new FibonacciGenerator();

        String value = generator.generate(first);

        assertThat(value,is(expectedResult));
    }

}