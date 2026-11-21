package utez.project.cinematoon.model;

import java.time.LocalDate;

public class Movie {
    private int id;
    private String title;
    private String synopsis;
    private int duration;
    private String genre;
    private String classification;
    private String poster;
    private LocalDate releaseDate;
    private boolean active;

    public Movie(int id, String title, String synopsis, int duration, String genre, String classification, String poster, LocalDate releaseDate, boolean active) {
        this.id = id;
        this.title = title;
        this.synopsis = synopsis;
        this.duration = duration;
        this.genre = genre;
        this.classification = classification;
        this.poster = poster;
        this.releaseDate = releaseDate;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
