<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Pagina de Registro de Instrumento</h1>
        <form action="<%= request.getContextPath()%>/MusicaServlet" method="GET">
            <label>Id:</label>
            <input type="text" name="id">
            <br>
            <label>Nombre:</label>
            <input type="text" name="nombre">
            <br>
            <label>Origen:</label>
            <input type="text" name="origen">
            <br>
            <label>Precio:</label>
            <input type="text" name="precio">
            <br>
            <label>Tipo:</label>
            <input type="text" name="tipo">
            <br>
            <input type="submit" value="Registrar">
        </form>
    </body>
</html>
