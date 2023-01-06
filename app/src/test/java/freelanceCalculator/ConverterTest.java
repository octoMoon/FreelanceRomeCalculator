package freelanceCalculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConverterTest {

    public ConverterTest() {
    }

    @Test
    public void testConvertToArabicNumbers() {
        System.out.println("convertToArabicNumbers");
        String a = "X";
        String b = "IV";
        Converter instance = new Converter();
        int[] expResult = {10, 4};
        int[] result = instance.convertToArabicNumbers(a, b);
        assertArrayEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testConvertToRomanNumber() {
        System.out.println("convertToRomanNumber");
        int number = 66;
        Converter instance = new Converter();
        String expResult = "LXVI";
        String result = instance.convertToRomanNumber(number);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

}
