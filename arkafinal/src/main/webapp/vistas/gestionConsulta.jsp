<%@page import="dao.Contactodao"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Conta"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Gestión de Consultas</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body style="background-color:rgb(0, 29, 54)">
        <div class="container mt-5">
            <h2 style="color:white">Gestión de Consultas</h2>
            <table style="color:white" class="table table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Mail</th>
                        <th>Tema</th>
                        <th>Fecha Alta</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        Contactodao contactodao = new Contactodao();
                        List<Conta> contacto = contactodao.obtenerTodos();

                        if (contacto != null && !contacto.isEmpty()) {
                            for (Conta conta : contacto) {
                    %>
                    <tr>
                        <td><%= conta.getIdOrador()%></td>
                        <td><%= conta.getNombre()%></td>
                        <td><%= conta.getMail()%></td>
                        <td><%= conta.getTema()%></td>
                        <td><%= conta.getFechaAlta()%></td>
                        <td>
                            <div class="d-flex">
                                <!-- Formulario para actualizar -->
                                <form action="GestionContaServlet" method="post" class="mr-2">
                                    <input type="hidden" name="accion" value="actualizar">
                                    <input type="hidden" name="id" value="<%= conta.getIdOrador()%>">
                                    <button type="submit" class="btn btn-warning btn-block">Actualizar</button>
                                </form>

                                <!-- Formulario para eliminar -->
                                <form action="GestionContaServlet" method="post">
                                    <input type="hidden" name="accion" value="eliminar">
                                    <input type="hidden" name="id" value="<%= conta.getIdOrador()%>">
                                    <button type="submit" class="btn btn-danger btn-block">Eliminar</button>
                                </form>
                            </div>
                        </td>
                    </tr>
                    <%
                        }
                    } else {
                    %>
                    <tr>
                        <td colspan="6">No hay consultas registrados.</td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
            <a href="../" class="btn btn-success">Volver</a>   
        </div>
    </body>
</html>

