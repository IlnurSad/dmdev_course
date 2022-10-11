package weekone.homeworktwo;

/**
 * Задание 1
 *
 * Посчитать четные и нечетные цифры целого числа и вывести их на консоль.
 * Для решения написать 2 функции, которые будут принимать введенное целое число,
 * а возвращать количество четных цифр (вторая функция - нечетных).
 * Например: если введено число 228910, то у него 4 четные цифры (2, 2, 8, 0) и 2 нечетные (9, 1).
 */

public class Task1 {
    public static void main(String[] args) {
        System.out.println(countEvenNumbers(112078303));
        System.out.println(countOddNumbers(1231230089));
    }

    public static int countEvenNumbers(int number) {
        int result = 0;
        for (int currentNumber = number; currentNumber != 0 ; currentNumber /= 10) {
            if (currentNumber % 2 == 0) {
                result++;
            }
        }
        return result;
    }

    public static int countOddNumbers(int number) {
        int result = 0;
        for (int currentNumber = number; currentNumber != 0 ; currentNumber /= 10) {
            if (currentNumber % 2 != 0) {
                result++;
            }
        }
        return result;
    }
}
