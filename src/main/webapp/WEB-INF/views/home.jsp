
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="movie" tagdir="/WEB-INF/tags/movie" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>

<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <title>Cinematoon | Cartelera</title>

  <link
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
  >

  <link
          rel="stylesheet"
          href="${pageContext.request.contextPath}/assets/css/components.css"
  >

  <link
          rel="stylesheet"
          href="${pageContext.request.contextPath}/assets/css/home.css"
  >
</head>
<body>

<layout:navbar />

<main class="home">
  <section class="home__header">
    <h1>Cartelera</h1>
    <p>Descubre las películas disponibles.</p>
    <div class="movie-search">
      <input
              type="search"
              id="movieSearchInput"
              class="form-control"
              placeholder="Buscar películas..."
              aria-label="Buscar películas"
              autocomplete="off"
      >
    </div>
  </section>

  <section class="movie-grid">
    <div
            id="movieGrid"
            class="row row-cols-2 row-cols-md-3 row-cols-lg-5 g-4"
            data-search-url="${pageContext.request.contextPath}/movies/search"
            data-context-path="${pageContext.request.contextPath}"
    >
      <c:forEach var="item" items="${movies}">
        <div class="col">
          <movie:movie-card movie="${item}" />
        </div>
      </c:forEach>
    </div>
  </section>
</main>

<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        defer
></script>
<script
        src="${pageContext.request.contextPath}/assets/js/movie-search.js"
        defer
></script>

</body>
</html>
