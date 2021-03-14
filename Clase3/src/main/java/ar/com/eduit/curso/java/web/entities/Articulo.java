package ar.com.eduit.curso.java.web.entities;

/**
 * Henrry G.
 */
public class Articulo {

    int id;
    String descripcion;
    float precio;

    public Articulo(int id, String descripcion, float precio) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Articulo{" + "id=" + id + ", descripcion=" + descripcion + ", precio=" + precio + '}';
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    
}
