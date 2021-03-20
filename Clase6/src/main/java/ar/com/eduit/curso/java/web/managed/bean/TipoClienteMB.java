package ar.com.eduit.curso.java.web.managed.bean;


import ar.com.eduit.curso.java.web.enums.TipoCliente;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
*Henrry G.
 */
@Named()
@SessionScoped
public class TipoClienteMB implements Serializable{
    public List<TipoCliente> getMedioDePago(){
    return Arrays.asList(TipoCliente.values());
    }
    

}
