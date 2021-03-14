<%-- 
    Document   : Test
    Created on : Mar 14, 2021, 10:42:39 AM
    Author     : HenrryG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

        <!--Codigo HTML -->


        <%
            //Codigo JAVA

            //COntrol de session
            session = request.getSession();
            try {
                boolean x = (boolean) session.getAttribute("session");
                if (!x) {
                    response.sendRedirect("logout.html");
                }
            } catch (Exception ex) {
                response.sendRedirect("logout.html");
            }
        %>
        <%
            out.println("<h1>Hola Mundo Servlet</h1>");

            int nro1 = Integer.parseInt(request.getParameter("nro1"));
            int nro2 = Integer.parseInt(request.getParameter("nro2"));
            int suma = nro1 + nro2;
            out.println("<h3>Total: " +suma+ "</h3>");
        %>

    </body>
</html>
