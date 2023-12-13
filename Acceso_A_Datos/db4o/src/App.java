import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import models.*;

public class App {

    static String dbName = "prueba.yap";


    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), dbName);

        Persona p1 = new Persona("Paco", "Porras");
        db.store(p1);
        db.close();
        
        consultaPrueba.getPersona();
    }
}
