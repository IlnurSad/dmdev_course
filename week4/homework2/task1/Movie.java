package week4.homework2.task1;

import java.util.Objects;

public class Movie {
    private int id;
    private int yearOfPublication;
    private int monthOfPublication;
    private Genre genre;
    private int rating;

    public Movie(int id, int yearOfPublication, int monthOfPublication, Genre genre, int rating) {
        this.id = id;
        this.yearOfPublication = yearOfPublication;
        this.monthOfPublication = monthOfPublication;
        this.genre = genre;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public int getMonthOfPublication() {
        return monthOfPublication;
    }

    public void setMonthOfPublication(int monthOfPublication) {
        this.monthOfPublication = monthOfPublication;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", yearOfPublication=" + yearOfPublication +
                ", monthOfPublication=" + monthOfPublication +
                ", genre=" + genre +
                ", rating=" + rating +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id && yearOfPublication == movie.yearOfPublication && monthOfPublication == movie.monthOfPublication && rating == movie.rating && genre == movie.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, yearOfPublication, monthOfPublication, genre, rating);
    }
}
