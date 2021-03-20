package ar.com.eduit.curso.java.web.services;

import ar.com.eduit.curso.java.web.entities.Articulo;
import ar.com.eduit.curso.java.web.jdbc.connectors.Connector;
import ar.com.eduit.curso.java.web.repositories.interfaces.I_ArticuloRepository;
import ar.com.eduit.curso.java.web.repositories.jdbc.ArticuloRepository;
import ar.com.eduit.curso.java.web.repositories.list.ArticuloRepositoryFactory;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Henrry G.
 */
public class ArticuloAlta extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            
            try {
                I_ArticuloRepository ar = new ArticuloRepository(Connector.getConnection());
                int id = Integer.parseInt(request.getParameter("id"));
                String descripcion = request.getParameter("descripcion");
                float precio = Float.parseFloat(request.getParameter("precio"));
                ar.save(new Articulo(id,descripcion,precio));
                out.println("true");
            } catch (Exception e) {
                out.println("false");
            }
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

    // </editor-fold>
}
