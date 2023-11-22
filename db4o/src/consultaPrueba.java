import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import models.Persona;

public class consultaPrueba {

    static String dbName = "prueba.yap";
    private static Persona p1 = null;
    /**
     * 
     */
    public static void getPersona(){

        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), dbName);


        ObjectSet<Persona> resultado = db.queryByExample(p1);

        While(resultado.hasNext()){

            Persona aux = resultado.next();
            System.out.println("nombre"+ aux.getNombre());
        }
        db.close();
    }
    
}
