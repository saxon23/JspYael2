/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.yael;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alumno
 */
@WebServlet(name = "ClienteList", urlPatterns = {"/ClienteList"})
public class ClienteList extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int i = 0;
            List<Cliente> clientes = null;
            HttpSession session = null;

            session = request.getSession();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ClienteList</title>");
            out.println("<title>Servlet ClienteList</title>\n"
                    + "    <!-- Referencia a los archivos CSS de Bootstrap -->\n"
                    + "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n"
                    + "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css\">\n"
                    + "    <!-- Referencia a los archivos JS de jQuery y Bootstrap -->\n"
                    + "    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n"
                    + "    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>"
            );
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<table class=\"table\" border=\"1\">");
            out.println("<tr>");
            out.println("<td>Nombre</td>");
            out.println("<td>Apellido Paterno</td>");
            out.println("<td>Apellido Materno</td>");
            out.println("<td>Edad</td>");
            out.println("<td>Acciones</td>");
            out.println("</tr>");
            clientes = (List<Cliente>) session.getAttribute("clientes");
            String id = null;
            String borrar = null;
            id = request.getParameter("id");
            if ("submit".equals(borrar)) {
                clientes.remove(Integer.parseInt(id));
            }
            if (clientes != null && !clientes.isEmpty()) {
                int j = 0;
                for (Cliente cliente : clientes) {
                    out.println("<tr>");
                    out.println(String.format("<td>%s</td>", cliente.getNombre()));
                    out.println(String.format("<td>%s</td>", cliente.getApellidoP()));
                    out.println(String.format("<td>%s</td>", cliente.getApellidoM()));
                    out.println(String.format("<td>%d</td>", cliente.getEdad()));
                    out.println("<td>");
                    out.println("<form method=\"post\" action=\"ClienteList\">");
                    out.println(String.format("<input type=\"hidden\" name=\"id\" value=\"%d\"/>", j));
                    out.println("<button class=\"btn btn-danger\" type=\"submit\">");
                    out.println("<span class=\"glyphicon glyphicon-trash\"></span>");
                    out.println("<a href=\\\"ClienteList)id=\" + j + \"&borrar=submit\\\">Borrar</a>\"");
                    out.println("</button>");
                    out.println("</form>");
                    out.println("</td>");

                    out.println("</tr>");
                    j++;
                }
            }
            out.println("</table>");
            out.println("<a href=\"AgregaCliente\" class=\"btn btn-primary\">Nuevo cliente</a>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
