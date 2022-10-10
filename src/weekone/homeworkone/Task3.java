package weekone.homeworkone;

/**
 * Задание 3
 *
 * Даны два прямоугольных треугольника.
 * Каждый из них задается двумя целочисленными переменными a и b - стороны треугольника.
 * Написать код, в котором вычисляется площадь каждого треугольника и затем эти площади сравниваются друг с другом.
 * Для этого понадобится написать 2 функции.
 * Первая: по двум сторонам прямоугольного треугольника возвращает его площадь.
 * Вторая: сравнивает переданные площади двух треугольников и выводит на консоль первый треугольник больше, меньше или равен второму.
 * Учитывать, что площадь может быть вещественным числом.
 */

public class Task3 {
    public static void main(String[] args) {
        int a1 = 13, b1 = 18;
        int a2 = 18, b2 = 13;
        double areaOne = areaOfATriangle(a1, b1);
        double areaTwo = areaOfATriangle(a2, b2);
        comparisonOfAreas(areaOne,areaTwo);
    }

    public static double areaOfATriangle(int a, int b) {
        return 0.5 * a * b;
    }

    public static void comparisonOfAreas(double areaOne, double areaTwo) {
        if (areaOne > areaTwo) {
            System.out.println("Первый треугольник больше чем второй");
        } else if (areaOne < areaTwo) {
            System.out.println("Первый треугольник меньше чем второй");
        } else {
            System.out.println("Треугольники равны");
        }
    }
}
