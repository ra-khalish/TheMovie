package com.talian.themovie.model;

public class Movie {
    private String movieTitle, movieDate, moviePoster;

    public Movie(String movieTitle, String movieDate, String moviePoster) {
        this.movieTitle = movieTitle;
        this.movieDate = movieDate;
        this.moviePoster = moviePoster;
    }

    public Movie() {
    }

    @Override
    public String toString() {
        return "movieTitle='" + movieTitle +
                ", movieDate='" + movieDate +
                ", moviePoster='" + moviePoster;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieDate() {
        return movieDate;
    }

    public void setMovieDate(String movieDate) {
        this.movieDate = movieDate;
    }

    public String getMoviePoster() {
        return moviePoster;
    }

    public void setMoviePoster(String moviePoster) {
        this.moviePoster = moviePoster;
    }
}
