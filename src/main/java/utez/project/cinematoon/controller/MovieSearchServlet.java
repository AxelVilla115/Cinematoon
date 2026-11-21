package utez.project.cinematoon.controller;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import utez.project.cinematoon.dto.MovieDTO;
import utez.project.cinematoon.model.Movie;
import utez.project.cinematoon.service.MovieService;
import utez.project.cinematoon.structure.LinkedList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/movies/search")
public class MovieSearchServlet extends HttpServlet {

    private MovieService movieService;
    private Gson gson;

    @Override
    public void init() throws ServletException {
        movieService = new MovieService();
        gson = new Gson();
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        String query = request.getParameter("q");

        LinkedList<Movie> movies;

        if (query == null || query.isBlank()) {
            movies = movieService.getAllMovies();
        } else {
            movies = movieService.searchMovies(query);
        }

        List<MovieDTO> results = new ArrayList<>();

        for (Movie movie : movies.toList()) {
            results.add(new MovieDTO(movie));
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        response.getWriter().write(gson.toJson(results));
    }
}
