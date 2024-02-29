package Principal;

import Controlador.CuidadControler;
import Controlador.PaisController;
import Modelo.Cuidad;
import Modelo.Pais;
import conexion.ConexionMongoDB;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author salah
 */
public class Principal {

    public static void main(String[] args) {       
        ConexionMongoDB conn = ConexionMongoDB.getInstance(); 
        conn.conectar();  
        
        // Crea instancias 
        CuidadControler cuidadControler = new CuidadControler();
        PaisController paisControler = new PaisController();

        // Insertar una nueva cuidad
        Cuidad logrono = new Cuidad(26000, "logrono", 100000);
        Cuidad barcelona = new Cuidad(37000, "barcelona", 5000000);
        int logronoId = logrono.getCodigoPostal_ID();
        int barcelonaId = barcelona.getCodigoPostal_ID();
        cuidadControler.crear(logrono);

       // Obtener un cuidad por su ID
        Cuidad cuidadRecuperado = (Cuidad) cuidadControler.obtenerPorID(logronoId);
        System.out.println("Cuidad recuperado: " + cuidadRecuperado);

      // Actualizar el numero de publacion de la cuidad
        cuidadControler.actualizar(barcelonaId, 5001000);

      // Eliminar una cuidad
        cuidadControler.borrar(logronoId);

      // Insertar un nuevo pais con las cuidades
      ArrayList<Cuidad> cuidades = new ArrayList<>();
      cuidades.add(logrono);
      cuidades.add(barcelona);
        Pais espana = new Pais(0034, "espana", 55, 60000000, cuidades);
        
        paisControler.crear(espana);

      // Obtener un pais por su ID
        int españaId = espana.getId_Pais();
        Pais paisRecuperado = (Pais) paisControler.obtenerPorID(españaId);
        System.out.println("Pais recuperado: " + paisRecuperado);

      // Actualizar el numero de publacion de un pais 
        paisControler.actualizar(españaId, 60000100);

      // Eliminar un pais
        paisControler.borrar(españaId);

      // Obtener todos los paises
        List<Pais> todosLosPaises = paisControler.obtenerTodos();
        System.out.println("Todos los Paises: " + todosLosPaises);
        conn.desconectar();

    }

}
