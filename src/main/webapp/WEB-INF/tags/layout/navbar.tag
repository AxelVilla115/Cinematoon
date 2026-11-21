<%@ tag pageEncoding="UTF-8" %>

<nav class="navbar navbar-expand-lg cinema-navbar">
    <div class="container-fluid px-4">

        <a class="navbar-brand cinema-navbar__brand"
           href="${pageContext.request.contextPath}/home">
            Cinematoon
        </a>

        <button
                class="navbar-toggler"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#cinemaNavbar"
                aria-controls="cinemaNavbar"
                aria-expanded="false"
                aria-label="Abrir navegación"
        >
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="cinemaNavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link"
                       href="${pageContext.request.contextPath}/home">
                        Inicio
                    </a>
                </li>
            </ul>
        </div>

    </div>
</nav>
