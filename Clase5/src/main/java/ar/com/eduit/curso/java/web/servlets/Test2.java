package ar.com.eduit.curso.java.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Test2 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Test2</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Test2 at " + request.getContextPath() + "</h1>");

            try {
                HttpSession session = request.getSession();

                String curso = session.getAttribute("curso").toString();
                String profe = session.getAttribute("profe").toString();

                out.println("<h3>Curso: " + curso + "</h3>");
                out.println("                         ");
                out.println("<h3>Profe: " + profe + "</h3>");
            }catch (Exception ex){
                out.println("<h3>No se inicio la Session </h3>");
            }
                out.println("</body>");
                out.println("</html>");
            }
        }

        // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
        @Override
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
            processRequest(request, response);
        }

        @Override
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
            processRequest(request, response);
        }

        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
