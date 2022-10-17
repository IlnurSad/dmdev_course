package week4.homework2.task1;

import week4.homework2.task1.comparator.MovieRatingComparator;

import java.util.*;

public class Cinema {
    private final Map<Integer, List<Movie>> moviesInCinema = new LinkedHashMap<>();

    public void addMovie(Movie movie) {
        boolean needAddMovie = true;
        List<Movie> moviesList = moviesInCinema.get(movie.getYearOfPublication());
        if (moviesList != null) {
            for (Movie currentMovie : moviesList) {
                if (currentMovie.equals(movie)) {
                    needAddMovie = false;
                    break;
                }
            }
        } else {
            moviesList = new ArrayList<>();
        }

        if (needAddMovie) {
            moviesList.add(movie);
            moviesInCinema.put(movie.getYearOfPublication(), moviesList);
        }
    }

    public List<Movie> getMoviesByYear(int year) {
        return moviesInCinema.get(year);
    }

    public List<Movie> getMoviesByYearAndMonth(int year, int month) {
        List<Movie> result = moviesInCinema.get(year);
        ListIterator<Movie> listIterator = result.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next().getMonthOfPublication() != month) {
                listIterator.remove();
            }
        }
        return result;
    }

    public List<Movie> getMoviesByGenre(Genre genre) {
        List<Movie> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Movie>> entry : moviesInCinema.entrySet()){
            for (Movie currentMovie : entry.getValue()) {
                if (currentMovie.getGenre().equals(genre)) {
                    result.add(currentMovie);
                }
            }
        }
        return result;
    }

    public List<Movie> getTOP10MoviesByRating() {
        List<Movie> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Movie>> entry : moviesInCinema.entrySet()){
            result.addAll(entry.getValue());
        }
        result.sort(new MovieRatingComparator());
        result.removeAll(result.subList(10, result.size()));
        return result;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "moviesInCinema=" + moviesInCinema +
                '}';
    }
}
