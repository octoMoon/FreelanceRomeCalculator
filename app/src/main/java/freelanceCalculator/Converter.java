package freelanceCalculator;

import freelanceCalculator.exceptions.DifferentNumberSystemsException;
import java.util.HashMap;
import java.util.Map;

public class Converter {

    public int[] convertToArabicNumbers(String a, String b) {
        Map<String, Integer> arabicNombers = new HashMap<>();
        int[] romanNumbers = new int[2];

        arabicNombers.put("I", 1);
        arabicNombers.put("II", 2);
        arabicNombers.put("III", 3);
        arabicNombers.put("IV", 4);
        arabicNombers.put("V", 5);
        arabicNombers.put("VI", 6);
        arabicNombers.put("VII", 7);
        arabicNombers.put("VIII", 8);
        arabicNombers.put("IX", 9);
        arabicNombers.put("X", 10);
        try {
            romanNumbers[0] = arabicNombers.get(a);
            romanNumbers[1] = arabicNombers.get(b);
        } catch (NullPointerException e) {
            throw new DifferentNumberSystemsException("Используются одновременно разные системы счисления ");
        }

        return romanNumbers;
    }

    public String convertToRomanNumber(int number) {

        String numberForString = Integer.toString(number);

        int[] array = new int[numberForString.length()];
        StringBuilder answer = new StringBuilder();
        Map<Integer, String> romanNombers = new HashMap<>();

        romanNombers.put(1, "I");
        romanNombers.put(2, "II");
        romanNombers.put(3, "III");
        romanNombers.put(4, "IV");
        romanNombers.put(5, "V");
        romanNombers.put(6, "VI");
        romanNombers.put(7, "VII");
        romanNombers.put(8, "VIII");
        romanNombers.put(9, "IX");
        romanNombers.put(10, "X");

        romanNombers.put(20, "XX");
        romanNombers.put(30, "XXX");
        romanNombers.put(40, "XL");
        romanNombers.put(50, "L");
        romanNombers.put(60, "LX");
        romanNombers.put(70, "LXX");
        romanNombers.put(80, "LXXX");
        romanNombers.put(90, "XC");
        romanNombers.put(100, "C");

        if (numberForString.length() == 1 || number == 10) {
            return romanNombers.get(number);
        }

        if (numberForString.length() == 3) {
            return romanNombers.get(100);
        }

        if (numberForString.length() > 1 && numberForString.length() != 3 && number != 10) {
            for (int i = 0; i < array.length; i++) {
                array[i] = Character.digit(numberForString.charAt(i), 10);
                if (i == 0) {
                    answer.append(romanNombers.get(array[i] * 10));
                } else {
                    answer.append(romanNombers.get(array[i]));
                }
            }

        }

        return answer.toString().replace("null", "");
    }

}
