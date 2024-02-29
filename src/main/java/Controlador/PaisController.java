
package Controlador;

import DAO.IPais_Cuidad;
import Modelo.Pais;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;
import conexion.ConexionMongoDB;
import java.util.ArrayList;
import java.util.List;
import org.bson.conversions.Bson;
/**
 *
 * @author Vespertino
 */
public class PaisController implements IPais_Cuidad<Pais> {

    private  ConexionMongoDB conexion;
    private  MongoDatabase database;
    private  MongoCollection<Pais> coleccion;

  public PaisController() {
    try {
        conexion = ConexionMongoDB.getInstance();
        conexion.conectar();
        database = conexion.getDatabase();
        this.coleccion = database.getCollection("pais", Pais.class);
    } catch (Exception e) {  
        System.err.println("Error al inicializar PaisController: " + e.getMessage());
    } 
}

    @Override
   public void crear(Pais objeto) {
    try {   
        coleccion.insertOne(objeto);

    } catch (Exception e) {
        System.err.println("Error al crear el país: " + e.getMessage());
    }
}

    @Override
    public List<Pais> obtenerTodos() {
        ArrayList<Pais> paises = new ArrayList<>();
        coleccion.find().into(paises);
        return paises;
    }
    @Override
    public void actualizar(int objeto_id, long nuevoPublacion) {
        Bson filtro = eq("_id", objeto_id);
        Bson actualizacion = set("numero_cuidades", nuevoPublacion);
        coleccion.updateOne(filtro, actualizacion);
    }

    @Override
    public void borrar(int objeto_id) {
        coleccion.deleteOne(eq("_id", objeto_id));

    }

    @Override
    public Object obtenerPorID(int objeto_id) {
        Pais pais = (Pais) coleccion.find(eq("_id", objeto_id)).first();
        return pais;
    }

}
