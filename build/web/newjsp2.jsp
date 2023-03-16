<%-- 
    Document   : newjsp2
    Created on : 15 mar 2023, 23:44:09
    Author     : PC
--%>

<%@page import="org.yael.Datos"%>
<%@page import="org.yael.Negocio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>My Jsp2</h1>
        <%
            Negocio negocio = new Negocio();
        %>
        <table >
            <thead>
                <tr>
                    <th >Nombre</th>
                    <th >Calificaci&oacute;n</th>
                </tr>
            </thead>
            <tbody >
                <%
                    if (negocio.getLista() != null && !negocio.getLista().isEmpty()) {
                        for (Datos datos : negocio.getLista()) {
                %>
                <tr>
                    <td><%=datos.getNombre()%></td>
                    <td><%=datos.getCalf()%></td>
                </tr>
                <%
                        }
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
