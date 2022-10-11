package weekone.homeworktwo;

/**
 * Задание 2
 *
 * Дано целое число.
 * Написать функцию, которая принимает целое число, а возвращает целое число обратное этому (не строку!).
 * Результат вывести на консоль.
 * Например: 4508 -> 8054, 4700 -> 74, 1234567 -> 7654321
 * Примечание: для решения может понадобится функция возведение числа в степень: Math.pow(число, степень)
 */

public class Task2 {
    public static void main(String[] args) {
        System.out.println(reverse(12345670));
    }

    public static int reverse(int number) {
        int result = 0;
        for (int currentNumber = number; currentNumber != 0 ; currentNumber /= 10) {
            result = result * 10 + currentNumber % 10;
        }
        return result;
    }
}
