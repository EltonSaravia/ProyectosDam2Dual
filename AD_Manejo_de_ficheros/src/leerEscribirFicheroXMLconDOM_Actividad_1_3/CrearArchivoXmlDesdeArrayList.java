package leerEscribirFicheroXMLconDOM_Actividad_1_3;
//Lo primero que necesitamos realizar es importar las librerías necesarias:
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.File;
import java.util.ArrayList;

import org.w3c.dom.DOMImplementation;

public class CrearArchivoXmlDesdeArrayList {

	public static void main(String[] args) {
        try {
            /* DocumentBuilderFactory y DocumentBuilder.
             * A continuación creamos una instacia de DocumentBuilderFactory 
             * (factory) para construir el parser. 
             * */
            DocumentBuilderFactory fabricaDocumentos = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = fabricaDocumentos.newDocumentBuilder();

            // Crear el documento XML
            DOMImplementation implementation = dBuilder.getDOMImplementation();
            Document document = implementation.createDocument(null, "Emplea2", null);
            document.setXmlVersion("1.0");

            // creacion de ArrayList de objetos Empleado
            ArrayList<Empleado> empleados = new ArrayList<>();
            empleados.add(new Empleado(1, "López", "Recursos Humanos", 45000));
            empleados.add(new Empleado(2, "González", "Ventas", 55000));

            // Recorrer la lista de empleados y crear nodos para cada uno
            for (Empleado empleado : empleados) {
                Element empleadoElement = document.createElement("empleado");

                Element idElement = document.createElement("id");
                idElement.appendChild(document.createTextNode(String.valueOf(empleado.getId())));

                Element apellidoElement = document.createElement("apellido");
                apellidoElement.appendChild(document.createTextNode(empleado.getApellido()));

                Element departamentoElement = document.createElement("departamento");
                departamentoElement.appendChild(document.createTextNode(empleado.getDepartamento()));

                Element salarioElement = document.createElement("salario");
                salarioElement.appendChild(document.createTextNode(String.valueOf(empleado.getSalario())));

                empleadoElement.appendChild(idElement);
                empleadoElement.appendChild(apellidoElement);
                empleadoElement.appendChild(departamentoElement);
                empleadoElement.appendChild(salarioElement);

                document.getDocumentElement().appendChild(empleadoElement);
            }

            // Guardar el documento XML en un archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("empleados.xml"));
            transformer.transform(source, result);

            System.out.println("Archivo XML generado exitosamente.");
            //utilizamos la funcion or porque asi si queremos podemos controlar la primera accion
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

}
