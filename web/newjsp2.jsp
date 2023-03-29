<%-- 
    Document   : newjsp2
    Created on : 15 mar 2023, 23:44:09
    Author     : PC
--%>

<%@page import="java.util.List"%>
<%@page import="org.yael.Datos"%>
<%@page import="org.yael.Negocio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- add Bootstrap stylesheet link -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <h1>My jsp2!</h1>
            <%
                int i = 0;
                List<Datos> lista = null;
                String id = null;
                String borrar = null;
                session = request.getSession( true );
                
                if( session != null )
                {
                    if( session.getAttribute("lista") != null )
                    {
                        lista = (List)session.getAttribute( "lista" );
                    }
                }
                id = request.getParameter( "id" );
                borrar = request.getParameter( "borrar" );
                if( "Submit".equals( borrar ) )
                {
                    lista.remove( Integer.parseInt(id) );
                }
            %>
            <a href="newjsp1.jsp" class="btn btn-secondary">Regresar a jsp1 v1</a>
            <a href="newjsp3.jsp" class="btn btn-primary">ir a jsp3</a>
            <table class="table table-striped table-bordered mt-4">
                <thead class="thead-dark">
                    <tr>
                        <th>#</th>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Cal</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <% if( lista != null && !lista.isEmpty() ) {
                        for( Datos datos : lista) {
                    %>
                    <tr>
                        <td><%=i + 1%></td>
                        <td><%=i%></td>
                        <td><%=datos.getNombre( )%></td>
                        <td><%=datos.getCalf()%></td>
                        <td>
                            <a href="newjsp2.jsp?id=<%=i%>&borrar=Submit" class="btn btn-danger">Borrar</a> 
                            <a href="newjsp3.jsp?id=<%=i++%>&editar=Submit" class="btn btn-warning">Editar</a> 
                        </td>
                    </tr>
                    <% } } %>
                </tbody>
            </table>
        </div>
        <!-- add Bootstrap JS scripts -->
            </body>
</html>
