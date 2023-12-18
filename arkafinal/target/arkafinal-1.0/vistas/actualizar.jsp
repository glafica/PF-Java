<%@page import="modelo.Conta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Actualizar Consulta</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
     <body style="background-color:rgb(0, 29, 54)">
        <div class="container mt-5">
            <h2 style="color:white">Actualizar Consulta</h2>
            <form action="GestionContaServlet" method="post">
                <input type="hidden" name="accion" value="confirmarActualizacion">
                <input type="hidden" name="id" value="${conta.idOrador}">

                <div class="form-group">
                    <label style="color:white" for="nombre">Nombre:</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" value="${conta.nombre}" required>
                </div>

                <div class="form-group">
                    <label style="color:white" for="mail">Mail:</label>
                    <input type="text" class="form-control" id="mail" name="mail" value="${conta.mail}" required>
                </div>

                <div class="form-group">
                    <label style="color:white" for="tema">Tema:</label>
                    <input type="text" class="form-control" id="tema" name="tema" value="${conta.tema}" required>
                </div>

                <div class="form-group">
                    <label style="color:white" for="fechaAlta">Fecha Alta:</label>
                    <input type="date" class="form-control" id="fechaAlta" name="fechaAlta" value="${conta.fechaAlta}" required>
                </div>

                <button type="submit" class="btn btn-primary">Actualizar</button>
                <a href="gestionConsulta.jsp" class="btn btn-success">Volver</a>

            </form>
        </div>
    </body>
</html>

