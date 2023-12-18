package controlador;

import dao.Contactodao;
import modelo.Conta;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

@WebServlet("/Registroconta")
public class Registroconta extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener datos del formulario
        String nombre = request.getParameter("nombre");
        String mail = request.getParameter("mail");
        String tema = request.getParameter("tema");

        // Crear un objeto Conta con los datos
        Conta conta = new Conta();
        conta.setNombre(nombre);
        conta.setMail(mail);
        conta.setTema(tema);

        // Obtener la fecha actual
        java.util.Date fechaActual = new java.util.Date(); //es una forma de utilizar la clase sin necesitar una declaracion 'import'
        conta.setFechaAlta(new Date(fechaActual.getTime()));

        // Agregar el conta a la base de datos
        Contactodao contactodao = new Contactodao();
        contactodao.agregarConta(conta);

        // Redireccionar a la página de visualización de contacto
        response.sendRedirect(request.getContextPath() + "/vistas/verContacto.jsp");
    }
}

