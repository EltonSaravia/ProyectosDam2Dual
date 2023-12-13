package leerEscribirFicheroXMLconDOM_Actividad_1_3;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GestorContenido extends DefaultHandler {
	/*
	 * Estas variables se utilizan para llevar un seguimiento de lo que se está 
	 * leyendo en el documento XML. leyendoNombre se establece en true 
	 * cuando se está leyendo el contenido del elemento <nombre> 
	 * y leyendoEdad se establece en true cuando se está leyendo 
	 * el contenido del elemento <edad>.
	 */
    private boolean leyendoNombre; // Indica si estamos leyendo el contenido del elemento "nombre"
    private boolean leyendoEdad;   // Indica si estamos leyendo el contenido del elemento "edad"

    /* Este método se llama al inicio del documento XML.
     *  En este caso, simplemente muestra un mensaje que indica 
     *  el comienzo del documento.
     * */
     
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Comienzo del documento XML"); 
    }
    
    // Se llama al final del documento XML
    @Override
    public void endDocument() throws SAXException {
        System.out.println("Fin del documento XML"); 
    }
/*
 * Se llama cuando se encuentra un elemento de inicio en el documento XML. 
 * En este método, se comprueba si el nombre del elemento es "nombre" o "edad"
 *  y se establecen las variables leyendoNombre o leyendoEdad en true, 
 *  respectivamente, para indicar que se va a leer el contenido de esos 
 *  elementos.
 */
    @Override
    public void startElement(String uri, String nombre, String nombres, Attributes atts) throws SAXException {
        if (nombre.equalsIgnoreCase("nombre")) {
            leyendoNombre = true; // Comenzamos a leer el contenido del elemento "nombre"
        } else if (nombre.equalsIgnoreCase("edad")) {
            leyendoEdad = true; // Comenzamos a leer el contenido del elemento "edad"
        }
    }
    /*
     * Se llama cuando se encuentra un elemento de cierre en el documento XML. 
     * Si el elemento es "alumno", se muestra un separador. 
     * Si el elemento es "nombre" o "edad", se establecen las variables 
     * correspondientes en false para indicar que se ha terminado de leer 
     * el contenido de esos elementos.
     * 
     */
    @Override
    public void endElement(String uri, String nombre, String nombres) throws SAXException {
        if (nombre.equalsIgnoreCase("alumno")) {
            System.out.println("___________________________"); // Se llama cuando se cierra el elemento "alumno"
        } else if (nombre.equalsIgnoreCase("nombre")) {
            leyendoNombre = false; // Dejamos de leer el contenido del elemento "nombre"
        } else if (nombre.equalsIgnoreCase("edad")) {
            leyendoEdad = false; // Dejamos de leer el contenido del elemento "edad"
        }
    }

    /*
     * Se llama cuando se encuentra contenido dentro de un elemento. 
     * Aquí leemos y mostramos el contenido de "nombre" y "edad" si estam 
     * True.
     */
    @Override
    public void characters(char[] ch, int inicio, int longitud) throws SAXException {
        if (leyendoNombre) {
            String nombre = new String(ch, inicio, longitud).trim();
            System.out.println("Nombre: " + nombre); // Leemos y mostramos el contenido del elemento "nombre"
        } else if (leyendoEdad) {
            String edad = new String(ch, inicio, longitud).trim();
            System.out.println("Edad: " + edad); // Leemos y mostramos el contenido del elemento "edad"
        }
    }
}

