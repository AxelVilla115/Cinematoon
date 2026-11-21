import utez.project.cinematoon.model.Movie;
import utez.project.cinematoon.storage.CinemaStorage;
import utez.project.cinematoon.structure.LinkedList;

public class CinemaStorageTest {

    public static void main(String[] args) {
        testInitialization();
        testMovieList();
        testMovieSearch();
    }

    private static void testInitialization() {
        System.out.println("=== INITIALIZATION ===");

        CinemaStorage.initialize();

        System.out.println("Initialized: " + CinemaStorage.isInitialized());
        System.out.println("Movie count: " + CinemaStorage.getMovies().size());
    }

    private static void testMovieList() {
        System.out.println("\n=== MOVIE LIST ===");

        LinkedList<Movie> movies = CinemaStorage.getMovies();

        for (int i = 0; i < movies.size(); i++) {
            Movie movie = movies.get(i);

            System.out.println(
                    movie.getId() + " - " +
                            movie.getTitle() + " (" +
                            movie.getDuration() + " min)"
            );
        }
    }

    private static void testMovieSearch() {
        System.out.println("\n=== MOVIE SEARCH ===");

        testSearch("Spider-Man");
        testSearch("the");
        testSearch("inter");
        testSearch("xyz");
    }

    private static void testSearch(String query) {
        LinkedList<Movie> results = CinemaStorage.searchMovies(query);

        System.out.println("\nQuery: " + query);
        System.out.println("Results: " + results.size());

        for (int i = 0; i < results.size(); i++) {
            System.out.println("- " + results.get(i).getTitle());
        }
    }
}