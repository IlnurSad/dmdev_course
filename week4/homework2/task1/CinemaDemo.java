package week4.homework2.task1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Задание 1
 * Даны 2 класса:
 * - Фильм с 5-ю полями: Уникальный Целочисленный идентификатор (id), Год издания, Месяц издания, Жанр и Рейтинг;
 * - Кинотеатр, где есть всего лишь одно единственное поле: отсортированный ассоциативный массив, где ключом является год издания,
 * а значением - все фильмы, выпустившиеся в этом году.
 * Добавить функционал в кинотеатр таким образом, чтобы можно было:
 * - добавлять в него новый фильм
 * - получить все фильмы по переданному году
 * - получить все фильмы по переданному году и месяцу
 * - получить все фильмы по переданному жанру
 * - получать ТОП-10 фильмов отсортированные по Рейтингу в порядке убывания
 * Учесть следующее:
 * - в кинотеатре фильмы должны храниться в порядке их добавления в него (т.е. предусмотреть порядок значения ассоциативного массива)
 * - не должен добавляться фильм, если такой уже есть в кинотеатре
 * Продемонстрировать работу кинотеатра в отдельном классе.
 */
public class CinemaDemo {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        cinema.addMovie(new Movie(1, 2000, 10, Genre.ACTION, 8));
        cinema.addMovie(new Movie(2, 2000, 2, Genre.COMEDY, 7));
        cinema.addMovie(new Movie(51, 2000, 2, Genre.ACTION, 8));
        cinema.addMovie(new Movie(51, 2000, 2, Genre.ACTION, 8));
        cinema.addMovie(new Movie(70, 2000, 2, Genre.FANTASY, 9));
        cinema.addMovie(new Movie(1, 2000, 10, Genre.ACTION, 8));

        cinema.addMovie(new Movie(11, 1990, 3, Genre.DRAMA, 9));
        cinema.addMovie(new Movie(2, 1990, 2, Genre.HORROR, 6));
        cinema.addMovie(new Movie(3, 1990, 9, Genre.THRILLER, 8));
        cinema.addMovie(new Movie(11, 1990, 3, Genre.DRAMA, 9));

        cinema.addMovie(new Movie(1, 2011, 4, Genre.COMEDY, 5));
        cinema.addMovie(new Movie(2, 2011, 2, Genre.HORROR, 6));
        cinema.addMovie(new Movie(33, 2011, 9, Genre.FANTASY, 10));
        cinema.addMovie(new Movie(4, 2011, 3, Genre.DRAMA, 9));
        cinema.addMovie(new Movie(4, 2011, 3, Genre.DRAMA, 9));
        cinema.addMovie(new Movie(83, 2011, 2, Genre.HORROR, 6));
        cinema.addMovie(new Movie(1, 2011, 4, Genre.COMEDY, 5));
        cinema.addMovie(new Movie(1, 2011, 4, Genre.COMEDY, 5));
        cinema.addMovie(new Movie(100, 2011, 12, Genre.THRILLER, 10));
        cinema.addMovie(new Movie(15, 2011, 1, Genre.HORROR, 3));

        System.out.println("Список всех фильмов без дубликатов " + "\n " + cinema);
        System.out.println("============================================================================================");
        System.out.println("Список фильмов по переданному году " + "\n " + cinema.getMoviesByYear(2011));
        System.out.println("============================================================================================");
        System.out.println("Список фильмов по переданному году и месяцу " + "\n " + cinema.getMoviesByYearAndMonth(2000, 2));
        System.out.println("============================================================================================");
        System.out.println("Список фильмов по переданному жанру " + "\n " + cinema.getMoviesByGenre(Genre.COMEDY));
        System.out.println("============================================================================================");
        System.out.println("ТОП-10 фильмов отсортированные по Рейтингу в порядке убывания " + "\n " + cinema.getTOP10MoviesByRating());

    }
}
