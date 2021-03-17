package ar.com.eduit.curso.java.web.repositories.interfaces;

import ar.com.eduit.curso.java.web.entities.Articulo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface I_ArticuloRepository {
    void save(Articulo articulo);
    void remove(Articulo articulo);
    List<Articulo>getAll();
    default List<Articulo>getLikeDescripcion(String descripcion){
        /*
        List<Articulo>list=new ArrayList();
        if(descripcion==null) return list;
        for(Articulo a:getAll()){
            if(a.getDescripcion().toLowerCase().contains(descripcion.toLowerCase()))
                list.add(a);
        }
        return list;
        */
        
        if(descripcion==null) return new ArrayList<Articulo>();
        return getAll()
                .stream()
                .filter(a->a.getDescripcion().toLowerCase().contains(descripcion.toLowerCase()))
                .collect(Collectors.toList());
    }
}

