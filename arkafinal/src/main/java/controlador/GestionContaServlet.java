package controlador;

import dao.Contactodao;
import modelo.Conta;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/vistas/GestionContaServlet")
public class GestionContaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        Contactodao contactodao = new Contactodao();

        // Inicializar idOrador antes del switch para que esté disponible en todos los casos
        int idOrador = Integer.parseInt(request.getParameter("id"));

        switch (accion) {
            case "actualizar":
                Conta conta = contactodao.obtenerPorId(idOrador);
                request.setAttribute("conta", conta); //Esto permite pasar datos del servlet a una vista (como un archivo JSP) o a otro servlet al que se redirige o se reenvía la solicitud
                request.getRequestDispatcher("actualizar.jsp").forward(request, response);
                break;
            case "confirmarActualizacion":
                Conta contaActualizado = new Conta();
                contaActualizado.setIdOrador(idOrador);
                contaActualizado.setNombre(request.getParameter("nombre"));
                contaActualizado.setMail(request.getParameter("mail"));
                contaActualizado.setTema(request.getParameter("tema"));
                // Asume que el método setFechaAlta acepta un java.sql.Date
                contaActualizado.setFechaAlta(java.sql.Date.valueOf(request.getParameter("fechaAlta")));

                contactodao.actualizarConta(contaActualizado);
                response.sendRedirect("gestionConsulta.jsp");
                break;
            case "eliminar":
                contactodao.eliminarConta(idOrador);
                response.sendRedirect("gestionConsulta.jsp");
                break;
            default:
                response.sendRedirect("gestionConsulta.jsp");
                break;
        }
    }
}
