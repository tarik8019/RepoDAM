
package Modelo;

import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author Vespertino
 */
public class Pais {

    private int id_Pais;
    private String nombre;
    private int numero_cuidades;
    private long numero_publacion;
    private List<Cuidad> cuidades;

    public Pais() {
    }

    public Pais(int id_Pais, String nombre, int numero_cuidades, long numero_publacion, List<Cuidad> cuidades) {
        this.id_Pais = id_Pais;
        this.nombre = nombre;
        this.numero_cuidades = numero_cuidades;
        this.numero_publacion = numero_publacion;
        this.cuidades = cuidades;
    }

    public int getId_Pais() {
        return id_Pais;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumero_cuidades() {
        return numero_cuidades;
    }

    public List<Cuidad> getCuidades() {
        return cuidades;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumero_cuidades(int numero_cuidades) {
        this.numero_cuidades = numero_cuidades;
    }

    public void setCuidades(List<Cuidad> cuidades) {
        this.cuidades = cuidades;
    }

    public long getNumero_publacion() {
        return numero_publacion;
    }

    public void setNumero_publacion(long numero_publacion) {
        this.numero_publacion = numero_publacion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id_Pais);
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
        final Pais other = (Pais) obj;
        return this.id_Pais == other.id_Pais;
    }

    @Override
    public String toString() {
        return "Pais{" + "id_Pais=" + id_Pais + ", nombre=" + nombre + ", numero_cuidades=" + numero_cuidades + ", numero_publacion=" + numero_publacion + ", cuidades=" + cuidades + '}';
    }

}
