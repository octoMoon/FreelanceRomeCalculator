package freelanceCalculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class MainTest {

    public MainTest() {
    }
    

    @ParameterizedTest
    @CsvSource({"'I + II', 'III'",
                "'4 * 5', '20'",
                "'X / V', 'II'"})
    public void testCalc(String str, String answer) {
        System.out.println("calc");
        App instance = new App();
        String result = instance.calc(str);
        assertEquals(answer, result);
        // fail("The test case is a prototype.");
    }

}
