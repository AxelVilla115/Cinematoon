package utez.project.cinematoon.storage;

import utez.project.cinematoon.model.Movie;
import utez.project.cinematoon.structure.BinarySearchTree;
import utez.project.cinematoon.structure.LinkedList;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Locale;

public class CinemaStorage {
    private static LinkedList<Movie> movies;
    private static BinarySearchTree<Movie> movieSearchTree;
    private static boolean initialized = false;

    private CinemaStorage() {
    }

    public static synchronized void initialize() {
        if (isInitialized()) return;

        LinkedList<Movie> movieList = new LinkedList<>();

        BinarySearchTree<Movie> searchTree =
                new BinarySearchTree<>(
                        Comparator.comparing(
                                movie -> movie.getTitle().toLowerCase(Locale.ROOT)
                        ),
                        Movie::getTitle
                );

        initializeMovies(movieList, searchTree);

        movies = movieList;
        movieSearchTree = searchTree;
        initialized = true;
    }

    private static void initializeMovies(
            LinkedList<Movie> movieList,
            BinarySearchTree<Movie> searchTree) {

        addMovie(movieList, searchTree, new Movie(
                1,
                "Interstellar",
                "Un grupo de exploradores viaja a través de un agujero de gusano para buscar un nuevo hogar para la humanidad.",
                169,
                "Ciencia ficción",
                "B",
                "assets/posters/interstellar.jpg.jpg",
                LocalDate.of(2014, 11, 7),
                true
        ));

        addMovie(movieList, searchTree, new Movie(
                2,
                "Inception",
                "Un especialista en infiltrarse en los sueños recibe la misión de implantar una idea en la mente de una persona.",
                148,
                "Ciencia ficción",
                "B",
                "assets/posters/inception.jpg.jpg",
                LocalDate.of(2010, 7, 16),
                true
        ));

        addMovie(movieList, searchTree, new Movie(
                3,
                "Spider-Man: Into the Spider-Verse",
                "Miles Morales descubre sus poderes y conoce a otros Spider-Man provenientes de diferentes dimensiones.",
                117,
                "Animación",
                "A",
                "assets/posters/spider-man-into-the-spider-verse.jpg.jpg",
                LocalDate.of(2018, 12, 14),
                true
        ));

        addMovie(movieList, searchTree, new Movie(
                4,
                "Spider-Man: Across the Spider-Verse",
                "Miles Morales se embarca en una aventura a través del multiverso y conoce nuevas versiones de Spider-Man.",
                140,
                "Animación",
                "B",
                "assets/posters/spider-man-across-the-spider-verse.jpg.jpg",
                LocalDate.of(2023, 6, 2),
                true
        ));

        addMovie(movieList, searchTree, new Movie(
                5,
                "Your Name",
                "Dos adolescentes comienzan a intercambiar cuerpos misteriosamente y desarrollan una conexión inesperada.",
                106,
                "Anime",
                "A",
                "assets/posters/your-name.jpg.jpg",
                LocalDate.of(2016, 8, 26),
                true
        ));

        addMovie(movieList, searchTree, new Movie(
                6,
                "A Silent Voice",
                "Un joven busca redimirse después de haber acosado a una compañera con discapacidad auditiva durante su infancia.",
                130,
                "Anime",
                "B",
                "assets/posters/a-silent-voice.jpg.jpg",
                LocalDate.of(2016, 9, 17),
                true
        ));

        addMovie(movieList, searchTree, new Movie(
                7,
                "The Boy and the Heron",
                "Un joven descubre un mundo misterioso después de conocer a una extraña garza que lo guía hacia una nueva aventura.",
                124,
                "Anime",
                "B",
                "assets/posters/the-boy-and-the-heron.jpg.jpg",
                LocalDate.of(2023, 7, 14),
                true
        ));

        addMovie(movieList, searchTree, new Movie(
                8,
                "Puss in Boots: The Last Wish",
                "El Gato con Botas emprende un viaje para encontrar la Estrella de los Deseos y recuperar sus vidas perdidas.",
                102,
                "Animación",
                "A",
                "assets/posters/puss-in-boots-the-last-wish.jpg.jpg",
                LocalDate.of(2022, 12, 21),
                true
        ));

        addMovie(movieList, searchTree, new Movie(
                9,
                "The Batman",
                "Batman investiga una serie de asesinatos que revelan una red de corrupción en Ciudad Gótica.",
                176,
                "Acción",
                "B",
                "assets/posters/the-batman.jpg.jpg",
                LocalDate.of(2022, 3, 4),
                true
        ));

        addMovie(movieList, searchTree, new Movie(
                10,
                "Ready Player One",
                "Un joven participa en una competencia dentro de un universo virtual para encontrar un tesoro que cambiará el futuro.",
                140,
                "Ciencia ficción",
                "B",
                "assets/posters/ready-player-one.jpg.jpg",
                LocalDate.of(2018, 3, 29),
                true
        ));
    }

    public static LinkedList<Movie> getMovies() {
        return movies.copy();
    }

    public static LinkedList<Movie> searchMovies(String query) {
        return movieSearchTree.search(query);
    }

    public static boolean isInitialized() {
        return initialized;
    }

    private static void addMovie(
            LinkedList<Movie> movieList,
            BinarySearchTree<Movie> searchTree,
            Movie movie) {

        movieList.add(movie);
        searchTree.insert(movie);
    }
}
