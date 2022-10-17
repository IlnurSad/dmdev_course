package week4.homework2.task1.comparator;

import week4.homework2.task1.Movie;

import java.util.Comparator;

public class MovieRatingComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie o1, Movie o2) {
        return Integer.compare(o2.getRating(), o1.getRating());
    }
}
