
document.addEventListener("DOMContentLoaded", () => {
    const searchInput = document.getElementById("movieSearchInput");
    const movieGrid = document.getElementById("movieGrid");

    const searchUrl = movieGrid.dataset.searchUrl;
    const contextPath = movieGrid.dataset.contextPath;

    let debounceTimer;

    searchInput.addEventListener("input", () => {
        clearTimeout(debounceTimer);

        const query = searchInput.value.trim();

        debounceTimer = setTimeout(() => {
            searchMovies(query);
        }, 300);
    });

    async function searchMovies(query) {
        try {
            const url = `${searchUrl}?q=${encodeURIComponent(query)}`;

            const response = await fetch(url);

            if (!response.ok) {
                throw new Error(`HTTP error: ${response.status}`);
            }

            const movies = await response.json();

            renderMovies(movies);

        } catch (error) {
            console.error("Error searching movies:", error);
            showMessage("No fue posible cargar las películas.");
        }
    }

    function renderMovies(movies) {
        movieGrid.replaceChildren();

        if (movies.length === 0) {
            showMessage("No se encontraron películas.");
            return;
        }

        movies.forEach(movie => {
            movieGrid.appendChild(createMovieCard(movie));
        });
    }

    function createMovieCard(movie) {
        const column = document.createElement("div");
        column.className = "col";

        const article = document.createElement("article");
        article.className = "movie-card";

        const poster = document.createElement("img");
        poster.className = "movie-card__poster";
        poster.src = `${contextPath}/${movie.poster}`;
        poster.alt = `Póster de ${movie.title}`;
        poster.loading = "lazy";

        const overlay = document.createElement("div");
        overlay.className = "movie-card__overlay";

        const title = document.createElement("h3");
        title.className = "movie-card__title";
        title.textContent = movie.title;

        overlay.appendChild(title);
        article.append(poster, overlay);
        column.appendChild(article);

        return column;
    }

    function showMessage(message) {
        movieGrid.replaceChildren();

        const column = document.createElement("div");
        column.className = "col-12 text-center";

        const text = document.createElement("p");
        text.className = "text-muted";
        text.textContent = message;

        column.appendChild(text);
        movieGrid.appendChild(column);
    }
});
