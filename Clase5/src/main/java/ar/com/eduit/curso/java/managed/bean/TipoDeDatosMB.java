package ar.com.eduit.curso.java.managed.bean;

import ar.com.eduit.curso.java.web.enums.MedioDePago;
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
public class TipoDeDatosMB implements Serializable{
    public List<MedioDePago> getMedioDePago(){
    return Arrays.asList(MedioDePago.values());
    }
    

}
