<%@ tag pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ attribute name="movie" required="true"
              type="utez.project.cinematoon.model.Movie" %>

<article class="movie-card">

    <img
            class="movie-card__poster"
            src="${pageContext.request.contextPath}/${movie.poster}"
            alt="Póster de ${movie.title}"
            loading="lazy"
    >

    <div class="movie-card__overlay">
        <h3 class="movie-card__title">
            <c:out value="${movie.title}" />
        </h3>
    </div>

</article>
