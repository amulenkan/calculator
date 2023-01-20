
import java.util.Scanner;
import java.util.InputMismatchException;

class Main {
    static String operation;
    static int number1;
    static int number2;
    static int result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        Main.calc(string);
    }

    public static String calc(String inputString) throws IllegalArgumentException {

        String[] strings = inputString.split(" ");
        try {
            if (strings.length != 3) {
                throw new IllegalArgumentException("Некорректный ввод данных");
            }
            operation = strings[1];
            if (isNumeric(strings[0]) && isRoman(strings[2])) {
                throw new IllegalArgumentException("Числа должны быть из одной числовой системы");
            } else if (isRoman(strings[0]) && isNumeric(strings[2])) {
                throw new IllegalArgumentException("Числа должны быть из одной числовой системы");
            } else if (isNumeric(strings[0]) && isNumeric(strings[2])) {
                number1 = Integer.parseInt(strings[0]);
                number2 = Integer.parseInt(strings[2]);
                return String.valueOf(arabianCalc(number1, number2));
            } else if (isRoman(strings[0]) && isRoman(strings[2])) {
                number1 = romanToNumber(strings[0]);
                number2 = romanToNumber(strings[2]);
                return romCalc(number1, number2);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return inputString;
    }

    static boolean isNumeric(String string) {
        if (string.equals("1")) {
            return true;
        } else if (string.equals("2")) {
            return true;
        } else if (string.equals("3")) {
            return true;
        } else if (string.equals("4")) {
            return true;
        } else if (string.equals("5")) {
            return true;
        } else if (string.equals("6")) {
            return true;
        } else if (string.equals("7")) {
            return true;
        } else if (string.equals("8")) {
            return true;
        } else if (string.equals("9")) {
            return true;
        } else if (string.equals("10")) {
            return true;
        } else return false;
    }

    static boolean isRoman(String string) {
        if (string.equals("I")) {
            return true;
        } else if (string.equals("II")) {
            return true;
        } else if (string.equals("III")) {
            return true;
        } else if (string.equals("IV")) {
            return true;
        } else if (string.equals("V")) {
            return true;
        } else if (string.equals("VI")) {
            return true;
        } else if (string.equals("VII")) {
            return true;
        } else if (string.equals("VIII")) {
            return true;
        } else if (string.equals("IX")) {
            return true;
        } else if (string.equals("X")) {
            return true;
        } else return false;
    }

    private static int arabianCalc(int number1, int number2) throws IllegalArgumentException{
        try {
            if ((number1 > 10) || (number1 < 1)) {
                throw new IllegalArgumentException("Число не должно быть меньше 1 и больше 10");

            } else if ((number2 > 10) || (number2 < 1)) {
                throw new IllegalArgumentException("Число не должно быть меньше 1 и больше 10");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        result = calculated(number1, number2, operation);
        System.out.println(result);

        return result;
    }

    private static String romCalc(int number1, int number2) throws IllegalArgumentException {
        try {
            if((number1 > 10) || (number1 < 1)) {
                throw new IllegalArgumentException("Число не должно быть меньше I и больше X");
            } else if((number2 > 10) || (number2 < 1)) {
                throw new IllegalArgumentException("Число не должно быть меньше I и больше X");
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        String resultRoman;
        result = calculated(number1, number2, operation);

            if (result < 1) { throw new IllegalArgumentException();
            }
        
        resultRoman = convertNumToRoman(result);
        System.out.println(resultRoman);
        return resultRoman;

    }

    private static int romanToNumber(String roman) {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Неверный формат данных");
        }
        return -1;
    }

    private static String convertNumToRoman(int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        return roman[numArabian];
    }

    public static int calculated(int num1, int num2, String op) {
        int result = 0;

        switch (op) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                try {
                    result = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {

                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Неверный знак операции");
        }
        return result;
    }
}

