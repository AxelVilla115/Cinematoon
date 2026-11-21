package utez.project.cinematoon.service;

import utez.project.cinematoon.model.Movie;
import utez.project.cinematoon.storage.CinemaStorage;
import utez.project.cinematoon.structure.LinkedList;

public class MovieService {
    public LinkedList<Movie> getAllMovies() {
        return CinemaStorage.getMovies();
    }

    public LinkedList<Movie> searchMovies(String query) {
        return CinemaStorage.searchMovies(query);
    }
}