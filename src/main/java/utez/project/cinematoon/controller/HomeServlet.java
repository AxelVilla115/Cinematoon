package utez.project.cinematoon.controller;

import utez.project.cinematoon.model.Movie;
import utez.project.cinematoon.service.MovieService;
import utez.project.cinematoon.structure.LinkedList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    private MovieService movieService;

    @Override
    public void init() throws ServletException {
        movieService = new MovieService();
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        LinkedList<Movie> movies = movieService.getAllMovies();

        request.setAttribute("movies", movies.toList());

        request.getRequestDispatcher("/WEB-INF/views/home.jsp")
                .forward(request, response);
    }
}