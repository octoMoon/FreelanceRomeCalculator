package freelanceCalculator;

import freelanceCalculator.exceptions.NotMathematicalOperationException;
import freelanceCalculator.exceptions.RomanNegativeNumberException;
import freelanceCalculator.exceptions.WrongFormatException;


public class App {

    public String calc(String input) {

        int[] sum = new int[2];
        int answer;
        boolean isRome = false;
        String[] mathemathic = input.split(" ");

        if (mathemathic.length < 2) {
            throw new NotMathematicalOperationException("Cтрока не является математической операцией");
        }
        if (mathemathic.length > 3) {
            throw new WrongFormatException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        Converter converter = new Converter();

        try {
            sum[0] = Integer.parseInt(mathemathic[0]);
            sum[1] = Integer.parseInt(mathemathic[2]);
        } catch (NumberFormatException e) {
            isRome = true;
            sum = converter.convertToArabicNumbers(mathemathic[0], mathemathic[2]);
        }

        String operand = mathemathic[1];

        switch (operand) {
            case "+":
                answer = sum[0] + sum[1];
                break;
            case "-":
                answer = sum[0] - sum[1];
                break;
            case "*":
                answer = sum[0] * sum[1];
                break;
            case "/":
                answer = sum[0] / sum[1];
                break;
            default:
                return new String("Приммер введен не коректно!");
        }

        if (isRome == false) {
            return Integer.toString(answer);
        }

        if (isRome == true && answer < 1) {
            throw new RomanNegativeNumberException("В римской системе исчисления нет отрицательных чисел");
        }

        return converter.convertToRomanNumber(answer);

    }

    public static void main(String[] args) {

    }
}
