package conexion;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

public class ConexionMongoDB {

    private static ConexionMongoDB instancia;
    private MongoClient cliente;
    private MongoDatabase database;
    private final String uri = "mongodb://localhost:57017";
   

    private ConexionMongoDB() {
    }

    public static ConexionMongoDB getInstance() {
        if (instancia == null) {
            instancia = new ConexionMongoDB();
        }
        return instancia;
    }

    public MongoClient conectar() {
        try {
            if (cliente == null) {
                   PojoCodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
                   CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(
            MongoClientSettings.getDefaultCodecRegistry(),
            CodecRegistries.fromProviders(pojoCodecProvider));
                cliente = MongoClients.create(uri);
                database = cliente.getDatabase("paises").withCodecRegistry(pojoCodecRegistry);
                System.out.println("Conexión establecida con MongoDB");
            } else {
                System.out.println("Ya existe una conexión activa con MongoDB");
            }
            return cliente;
        } catch (MongoException e) {
            System.err.println("Error al conectar con MongoDB: " + e.getMessage());
            return null;
        }
    }

    public void desconectar() {
        if (cliente != null) {
            cliente.close();
            cliente = null;
            System.out.println("Conexión cerrada con MongoDB");
        } else {
            System.out.println("No hay conexión activa con MongoDB");
        }
    }

    public MongoDatabase getDatabase() {
        return database;
    }
}
