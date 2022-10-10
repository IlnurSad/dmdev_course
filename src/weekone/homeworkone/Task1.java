package weekone.homeworkone;

/**
 * Задание 1
 *
 * В переменной minutes лежит число от 0 до 59.
 * Написать функцию, которая принимает в качестве параметра значение переменной minutes и выводит на консоль
 * в какую четверть часа попадает это число (в первую, вторую, третью или четвертую).
 * Протестировать функцию в main.
 */

public class Task1 {
    public static void main(String[] args) {
        int minutes = 59;
        quarterOfHour(minutes);
    }

    public static void quarterOfHour(int minutes) {
        if (minutes >= 0 && minutes < 15) {
            System.out.println("Первая четверть часа");
        } else if (minutes >= 15 && minutes < 30) {
            System.out.println("Вторая четверть часа");
        } else if (minutes >= 30 && minutes < 45) {
            System.out.println("Третья четверть часа");
        } else if (minutes >= 45 && minutes < 60) {
            System.out.println("Четвертая четверть часа");
        } else {
            System.out.println("Не верное значение, введите число от 0 до 59");
        }
    }
}
