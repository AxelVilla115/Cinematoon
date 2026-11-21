package utez.project.cinematoon.dto;

import utez.project.cinematoon.model.Movie;

public class MovieDTO {
    private int id;
    private String title;
    private String poster;
    private int duration;
    private String genre;
    private String classification;

    public MovieDTO(Movie movie) {
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.poster = movie.getPoster();
        this.duration = movie.getDuration();
        this.genre = movie.getGenre();
        this.classification = movie.getClassification();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPoster() {
        return poster;
    }

    public int getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }

    public String getClassification() {
        return classification;
    }
}