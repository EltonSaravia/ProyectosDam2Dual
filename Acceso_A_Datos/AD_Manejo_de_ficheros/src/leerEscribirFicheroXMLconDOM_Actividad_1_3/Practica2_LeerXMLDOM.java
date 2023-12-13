package leerEscribirFicheroXMLconDOM_Actividad_1_3;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.File;

public class Practica2_LeerXMLDOM {

    public static void main(String[] args) {
        try {
            // Paso 1: Crear un DocumentBuilder para parsear el archivo XML
            DocumentBuilderFactory fabricaDocumentos = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = fabricaDocumentos.newDocumentBuilder();

            // Paso 2: Parsear el archivo XML y obtener un objeto Document
            File archivoXml = new File("empleados.xml");
            Document document = dBuilder.parse(archivoXml);

            // Paso 3: Normalizar el contenido del documento en nodos de un árbol
            document.getDocumentElement().normalize();

            // Paso 4: Obtener la lista de nodos con el tag "empleado"
            NodeList listaEmpleados = document.getElementsByTagName("empleado");

            // Paso 5: Recorrer la lista de empleados y mostrar la información por pantalla
            for (int i = 0; i < listaEmpleados.getLength(); i++) {
                Node nodoEmpleado = listaEmpleados.item(i);

                if (nodoEmpleado.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoEmpleado = (Element) nodoEmpleado;

                    String id = elementoEmpleado.getElementsByTagName("id").item(0).getTextContent();
                    String apellido = elementoEmpleado.getElementsByTagName("apellido").item(0).getTextContent();
                    String departamento = elementoEmpleado.getElementsByTagName("departamento").item(0).getTextContent();
                    String salario = elementoEmpleado.getElementsByTagName("salario").item(0).getTextContent();

                    System.out.println("Empleado #" + id);
                    System.out.println("Apellido: " + apellido);
                    System.out.println("Departamento: " + departamento);
                    System.out.println("Salario: " + salario);
                    System.out.println("------------------------");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
