<%@page  language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>JSP Page</title>
        <link rel="stylesheet" href="<%=request.getContextPath() %>/webjars/bootstrap/5.3.0-alpha3/dist/css/bootstrap.min.css"/>
        <script src="<%= request.getContextPath() %>/webjars/bootstrap/5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"> </script>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">PV</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Musica</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <h1>Pagina de Registro de Instrumento Musical</h1>
        <div class="container">
            <form action="<%= request.getContextPath() %>/MusicaServlet?action=create" method="POST">
                
                <br>
                <div class="mb-3">
                    <label for="nombre" class="form-label">Nombre:</label>
                    <input type="text" class="form-control"  name="nombre" id="nombre" required minlength="1" maxlength="100" placeholder="Introduzca nombre">
                </div>
                <br>
                <div class="mb-3">
                    <label for="origen" class="form-label">Origen:</label>
                    <input type="text" class="form-control"  name="origen" id="origen" required minlength="1" maxlength="100" placeholder="Introduzca origen">
                </div>
                <br>
                <div class="mb-3">
                    <label for="precio" class="form-label">Precio:</label>
                    <input type="text" class="form-control"  name="precio" id="precio" required minlength="1" maxlength="100" placeholder="Introduzca precio">
                </div>
                <br>
                <div class="mb-3">
                    <label for="tipo" class="form-label">Tipo:</label>
                    <input type="text" class="form-control"  name="tipo" id="tipo" required minlength="1" maxlength="100" placeholder="Introduzca tipo">
              <br><br>
                    <button type="submit" class="btn btn-primary"> Registrar</button>
               </form>
        </div>
    </body>
    
</html>