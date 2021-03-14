package ar.com.eduit.curso.java.web.repositories.interfaces;

import ar.com.eduit.curso.java.web.entities.Articulo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author HenrryG
 */
public interface I_ArticuloRepository {

    void save(Articulo articulo);  //en una interface no se necesita escribir "public abstract"

    void remove(Articulo articulo);

    List<Articulo> getAll();

    default List<Articulo> getLikeDescription(String descripcion) {//en java 8 un metodo puede contener un codigo dentro.
        /*
        List<Articulo>list=new ArrayList();
        if(descripcion==null) return list;
        for(Articulo a:getAll()){
            if(a.getDescripcion().toLowerCase().contains(descripcion.toLowerCase()))
                list.add(a);
        }
        return list;
        */
        if(descripcion==null)return new ArrayList<Articulo>();
        return getAll()
                .stream()
                .filter(a->a.getDescripcion().toLowerCase().contains(descripcion.toLowerCase()))
                .collect(Collectors.toList());
                
    }
}
