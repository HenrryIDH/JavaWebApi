
package ar.com.eduit.curso.java.web.repositories.list;

import ar.com.eduit.curso.java.web.entities.Articulo;
import ar.com.eduit.curso.java.web.repositories.interfaces.I_ArticuloRepository;
import java.util.ArrayList;
import java.util.List;

/**
*Henrry G.
 */
public class ArticuloRepository implements I_ArticuloRepository{
    private List<Articulo>list = new ArrayList();
    
    
    @Override
    public void save(Articulo articulo) {
        list.add(articulo);
    }

    @Override
    public void remove(Articulo articulo) {
        list.remove(articulo);
    }

    @Override
    public List<Articulo> getAll() {
        return list;
        
    }

}
