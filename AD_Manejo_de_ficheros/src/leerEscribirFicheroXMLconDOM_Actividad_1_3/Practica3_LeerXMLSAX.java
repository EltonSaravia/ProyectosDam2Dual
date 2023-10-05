package leerEscribirFicheroXMLconDOM_Actividad_1_3;
/*
 * En esta sección, 
 * se importan las clases necesarias de la API SAX 
 * que se utilizarán en la clase.
 */
import java.io.File;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class Practica3_LeerXMLSAX {

    public static void main(String[] args) {
        try {
            /*
             * Se crea un XMLReader utilizando XMLReaderFactory.createXMLReader(). 
             * Este objeto se utiliza para leer y analizar el documento XML.
             */
            XMLReader lectorXML = XMLReaderFactory.createXMLReader();

            /*
             *  crea un XMLReader, establece el GestorContenido 
             *  como el ContentHandler, define 
             *  la fuente de entrada como el archivo "alumnos.xml" 
             *  y realiza el análisis del documento XML.
             */
            GestorContenido gestor = new GestorContenido();
            lectorXML.setContentHandler(gestor);

            /*
             * Se crea un objeto File que representa el archivo XML que se va a leer ("alumnos.xml"). 
             * Luego, se crea un objeto InputSource que utiliza la URI del archivo
             *  XML como fuente de entrada
             */
            File archivoXML = new File("alumnos.xml");
            InputSource fuente = new InputSource(archivoXML.toURI().toString());

            /*
             * Se llama al método parse() del lectorXML, pasando el InputSource como parámetro. 
             *  Esto inicia el proceso de análisis del documento XML utilizando el manejador de contenido personalizado GestorContenido
             */
            lectorXML.parse(fuente);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}