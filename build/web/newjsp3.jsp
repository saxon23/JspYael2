<%-- 
    Document   : newjsp3
    Created on : 20 mar 2023, 21:04:59
    Author     : PC
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.yael.Datos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="css3.css">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String nombre = null;
            String calif = null;
            String guardar = null;
            String id = null;
            String editar = null;
            String accion = "guardar";
            String actualizar = "guardar";
            Datos datos = null;
            Integer idx = null;
            List<Datos> lista = null;

            session = request.getSession(true);
            if (session != null) {
                if (session.getAttribute("lista") == null) {
                    session.setAttribute("lista", new ArrayList<Datos>());
                }
                lista = (List) session.getAttribute("lista");
            }
            nombre = request.getParameter("nombre");
            calif = request.getParameter("calif");
            guardar = request.getParameter("guardar");
            id = request.getParameter("id");
            editar = request.getParameter("editar");
            actualizar = request.getParameter("actualizar");

            if ("Submit".equals(editar)) {
                idx = Integer.parseInt(id);
                if (idx < lista.size()) {
                    datos = lista.get(idx);
                }
                accion = "actualizar";
            }

            if ("Submit".equals(guardar) || "Submit".equals(actualizar)) {
                if ("Submit".equals(guardar)) {
                    datos = new Datos();
                } else {
                    datos = lista.get(Integer.parseInt(id));
                }
                datos.setNombre(nombre);
                datos.setCalf(Float.parseFloat(calif));
                if ("Submit".equals(guardar)) {
                    lista.add(datos);
                }
        %>
        <h1>EXITO!</h1>
        <script>
            console.log("Exito");
        </script>
        <a href="newjsp2.jsp">Ir a jsp2 </a>
        <%
            }
            if (datos == null) {
                datos = new Datos();
                datos.setNombre("");
                datos.setCalf(0f);

            }
            if (!"Submit".equals(guardar) && !"Submit".equals(actualizar)) {
        %>  
        <div class="container"> 
            <form id="form1" class="container">
                <div class="form-group">
                    <label for="nombre">Nombre</label>
                    <input id="nombre" name="nombre" value="<%=datos.getNombre()%>" type="text" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="calif">Calificación</label>
                    <input id="calif" name="calif" value="<%=datos.getCalf()%>" type="number" class="form-control" />
                    <% if ("Submit".equals(editar)) {%>
                    <input type="hidden" name="id" id="id" value="<%=id%>" />
                    <% }%>
                </div>
               
                    <input type="submit" id="Guardar" name="<%=accion%>" class="btn btn-primary" />
               
            </form>
        </div>
        <%
            }
        %>
    </body>
</html>
