
package Modelo;
/**
 *
 * @author Vespertino
 */
public class Cuidad {

    private int codigoPostal_ID;
    private String nombre;
    private long numero_publacion;

    public Cuidad(int codigoPostal_ID, String nombre, long numero_publacion) {
        this.codigoPostal_ID = codigoPostal_ID;
        this.nombre = nombre;
        this.numero_publacion = numero_publacion;
    }

    public void setNumero_publacion(long numero_publacion) {
        this.numero_publacion = numero_publacion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigoPostal_ID() {
        return codigoPostal_ID;
    }

    public long getNumero_publacion() {
        return numero_publacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigoPostal_ID(int codigoPostal_ID) {
        this.codigoPostal_ID = codigoPostal_ID;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cuidad other = (Cuidad) obj;
        return this.codigoPostal_ID == other.codigoPostal_ID;
    }

    @Override
    public String toString() {
        return "Cuidad{" + "id_Cuidad=" + codigoPostal_ID + ", nombre=" + nombre + ", numero_publacion=" + numero_publacion + '}';
    }

}
