package ar.com.eduit.curso.java.web.repositories.list;

/**
*Henrry G.
 */
public class ArticuloRepositoryFactory {
    
    private static ArticuloRepository ar = new ArticuloRepository();
    public static ArticuloRepository getRepository(){
        return ar;
    }
}
