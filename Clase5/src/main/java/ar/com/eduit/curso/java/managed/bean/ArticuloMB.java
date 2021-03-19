
package ar.com.eduit.curso.java.managed.bean;

import ar.com.eduit.curso.java.web.entities.Articulo;
import ar.com.eduit.curso.java.web.jdbc.connectors.Connector;
import ar.com.eduit.curso.java.web.repositories.interfaces.I_ArticuloRepository;
import ar.com.eduit.curso.java.web.repositories.jdbc.ArticuloRepository;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
*Henrry G.
 */
@Named()
@SessionScoped
public class ArticuloMB implements Serializable {
    
    private Articulo articulo = new Articulo();
    private String mensaje = "";
    private I_ArticuloRepository ar = new ArticuloRepository(Connector.getConnection());
    
    public void save(){
        try {
            if(articulo.getId()<=0 || articulo.getDescripcion()==null 
                    || articulo.getDescripcion().length()<3
                    || articulo.getPrecio()<=0){
            mensaje="Datos incorrectos, No se pudo guardar el articulo!";
            }else{
                ar.save(articulo);
                mensaje="Se guardo el articulo!";
                articulo = new Articulo();
            }
        } catch (Exception e) {
            mensaje="No se pudo guardar el articulo!";
            System.out.println("************************************************");
            System.out.println(e);
            System.out.println("************************************************");
        }
    }

    public List<Articulo> getAll(){
    return ar.getAll();
    }
    
    public List<Articulo> getLikeDescripcion(){
    return ar.getLikeDescripcion("");
    }
    
    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    
    

}
