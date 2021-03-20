package ar.com.eduit.curso.java.web.managed.bean;

import ar.com.eduit.curso.java.web.entities.Cliente;
import ar.com.eduit.curso.java.web.jdbc.connectors.Connector;
import ar.com.eduit.curso.java.web.repositories.interfaces.I_ClienteRepository;
import ar.com.eduit.curso.java.web.repositories.jdbc.ClienteRepository;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * Henrry G.
 */
@Named()
@SessionScoped
public class ClienteMB implements Serializable {

    private I_ClienteRepository cr = new ClienteRepository(Connector.getConnection());
    private Cliente cliente = new Cliente();
    private String mensaje = "";
    private String buscarApellido = "";

    public void save() {
        try {
            if (cliente.getNombre() == null || cliente.getNombre().length() < 4
                    || cliente.getApellido() == null || cliente.getApellido().length() < 4) {
                mensaje = "Datos incorrectos, No se pudo guardar el/la cliente!";
            } else {
                cr.save(cliente);
                mensaje = "Se guardo el cliente, id: " + cliente.getId();
                cliente = new Cliente();
            }
        } catch (Exception e) {
            mensaje = "No se pudo guardar el/la cliente!";
            System.out.println("************************************************");
            System.out.println(e);
            System.out.println("************************************************");
        }

    }

    public List<Cliente> getAll() {
        return cr.getAll();
    }

    public List<Cliente> getLikeApellido() {
        return cr.getLikeApellido(buscarApellido);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getBuscarApellido() {
        return buscarApellido;
    }

    public void setBuscarApellido(String buscarApellido) {
        this.buscarApellido = buscarApellido;
    }

}
