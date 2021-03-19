package ar.com.eduit.curso.java.web.test;

import ar.com.eduit.curso.java.web.entities.Articulo;
import ar.com.eduit.curso.java.web.jdbc.connectors.Connector;
import ar.com.eduit.curso.java.web.repositories.interfaces.I_ArticuloRepository;
import ar.com.eduit.curso.java.web.repositories.jdbc.ArticuloRepository;
import ar.com.eduit.curso.java.web.repositories.list.ArticuloRepositoryFactory;

public class TestRepository {
    public static void main(String[] args) {
        //I_ArticuloRepository ar=ArticuloRepositoryFactory.getRepository();
        I_ArticuloRepository ar=new ArticuloRepository(Connector.getConnection());
        ar.save(new Articulo(1,"Mouse",20));
        ar.save(new Articulo(2,"Teclado",30));
        ar.save(new Articulo(3,"Monitor",40));
        ar.save(new Articulo(4,"Parlante USB",50));
        ar.save(new Articulo(5,"PadMouse",60));
        ar.save(new Articulo(6,"gaseosa lata",60));
        ar.save(new Articulo(7,"gaseosa bot.",60));
        
        
        //ar.remove(new Articulo(1, "", 0));
        
        ar.getAll().forEach(System.out::println);
        System.out.println("");
        System.out.println("****************************************************");
        ar.getLikeDescripcion("pa").forEach(System.out::println);
    }
}
    