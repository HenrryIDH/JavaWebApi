package ar.com.eduit.curso.java.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Test extends HttpServlet {
   
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {  // try with resources JDK 7
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Test</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Test at " + request.getContextPath () + "</h1>");
            
            // Esto se renderiza en el cliente http
            out.println("<h3>Hola Mundo Servler</h3>");
            
            String nombre = request.getParameter("nombre");
            if(nombre != null && !nombre.isEmpty()){
            out.println("Hola "+nombre);
            }
            
            // Esto se imprime en la consola del server
            System.out.println("******************");
            System.out.println("Hola mundo!!!");
            System.out.println("*******************");
            
            out.println("</body>");
            
            //Sintaxis de java 8
            List<String> list = new ArrayList();
            list.forEach(System.out::println);
            
            HttpSession session = request.getSession();
            session.setAttribute("curso", "Curso de Java Web");
            out.println(" ");
            session.setAttribute("profe","Carlos Rios");
            
            
            //out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
}
