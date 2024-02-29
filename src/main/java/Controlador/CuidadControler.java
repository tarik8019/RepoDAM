package Controlador;

import DAO.IPais_Cuidad;
import Modelo.Cuidad;
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
public class CuidadControler implements IPais_Cuidad<Cuidad> {

    private ConexionMongoDB conexion;
    private MongoDatabase database;
    private MongoCollection<Cuidad> coleccion;

    public CuidadControler() {
    try {
        this.conexion = ConexionMongoDB.getInstance();      
        this.database = conexion.getDatabase();
        this.coleccion = database.getCollection("cuidad", Cuidad.class);
    } catch (Exception e) {
        System.err.println("Error al inicializar CuidadControler: " + e.getMessage());
    } 
}

    @Override
    public void crear(Cuidad cuidad) {
        try {      
            coleccion.insertOne(cuidad);
        } catch (Exception e) {
            System.err.println("Error al crear la ciudad: " + e.getMessage());
        } 
    }

    @Override
    public List<Cuidad> obtenerTodos() {
        List<Cuidad> cuidades = new ArrayList<>(); 
        coleccion.find().into(cuidades);    
        return cuidades;
    }

    @Override
    public void actualizar(int objeto_id, long nuevoPublacion) {
        Bson filtro = eq("_id", objeto_id);
        Bson actualizacion = set("numeroPublacion", nuevoPublacion);
        coleccion.updateOne(filtro, actualizacion);

    }

    @Override
    public void borrar(int objeto_id) {
        coleccion.deleteOne(eq("_id", objeto_id));

    }

    @Override
    public Object obtenerPorID(int objeto_id) {
        Cuidad cuidad = (Cuidad) coleccion.find(eq("_id", objeto_id)).first();
       return cuidad;
    }

}
