
package DAO;

import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Vespertino
 * @param <T>
 */
public interface IPais_Cuidad<T> {

    void crear(T objeto);

    List<T> obtenerTodos();

    Object obtenerPorID(int objeto_id);

    void actualizar(int objeto_id, long nuevo);

    void borrar(int id);

}
