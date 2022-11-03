package week5.homework1.task1;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Задание 1
 * Дан список студентов с полями:
 * - Имя
 * - Фамилия
 * - Номер курса в университете
 * - Список оценок за учебу
 * Преобразовать этот список студентов в ассоциативный массив, где ключом является номер курса, а значением:
 * 1.Средняя оценка студентов этого курса, количество оценок у которых больше 3-х
 * 2.Список студентов данного курса, но только с полями Имя и Фамилия.
 * Список должен быть отсортированы по этим двум полям
 * 3.Объект с двумя полями:
 * -Отсортированный список студентов с пункта 2
 * -Средняя оценка этих студентов
 * Подумать, как ассоциативный массив можно было представить в коде в виде отсортированного - TreeMap
 */
public class StudentDemo {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Misha", "Sokolov", 3, List.of(5, 5, 4, 3, 5, 4)),
                new Student("Kolya", "Shabanov", 2, List.of(5, 5, 4)),
                new Student("Dasha", "Sokolova", 4, List.of(5, 5, 5, 3, 5, 4, 3, 5)),
                new Student("Oleg", "Morozov", 2, List.of(5, 5, 4, 5, 5, 5, 5)),
                new Student("Masha", "Polatova", 1, List.of(5, 5, 5, 5, 5)),
                new Student("Nikita", "Kirkorov", 3, List.of(3, 3, 4, 3, 3)),
                new Student("Misha", "Popov", 3, List.of(4, 5)),
                new Student("Viktor", "Lavrentev", 5, List.of(4, 4, 3)),
                new Student("Misha", "Anisimov", 3, List.of(3, 5))
        );

        Map<Integer, Double> collect = students.stream()
                .filter(student -> student.getGradesForStudies().size() > 3)
                .collect(Collectors.groupingBy(
                        Student::getCourseNumber,
                        Collectors.averagingDouble(value -> value.getGradesForStudies().stream()
                                .mapToInt(Integer::intValue)
                                .average()
                                .orElse(0.0))));
        System.out.println("task1: \n" + collect + "\n");

        Map<Integer, List<Student>> collect2 = students.stream()
                .sorted()
                .collect(Collectors.groupingBy(
                        Student::getCourseNumber,
                        Collectors.mapping(student -> new Student(student.getFirstName(), student.getLastName()), toList())));
        System.out.println("task2: \n" + collect2 + "\n");

        Map<Integer, StudentInfo> collect3 = students.stream()
                .sorted()
                .collect(Collectors.groupingBy(Student::getCourseNumber, Collectors.collectingAndThen(toList(), list -> {
                                    List<Student> studentsList = list.stream().
                                            map(student -> new Student(student.getFirstName(), student.getLastName())).collect(toList());
                                    Double averageRating = list.stream().
                                            collect(Collectors.averagingDouble(value -> value.getGradesForStudies().stream()
                                                    .mapToInt(Integer::intValue)
                                                    .average()
                                                    .orElse(0.0)));
                                    return new StudentInfo(studentsList, averageRating);
                                })
                        )
                );
        System.out.println("task3: \n" + collect3);
    }
}