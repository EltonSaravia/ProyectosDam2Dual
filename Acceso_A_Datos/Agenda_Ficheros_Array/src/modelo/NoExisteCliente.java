/*
Implementa una aplicaci�n que permita guardar y recuperar los datos de los clientes de una empresa. 
La informaci�n que guardaremos del cliente ser� su identificador (un entero), nombre,tel�fono y email.
Los objetos se gestionar�n en un array, que se cargar� con la informaci�n que hay en
el fichero al arrancar el programa y se guardar� de nuevo en el fichero al terminar.
El men� que queremos que nos aparezca para realizar las operaciones es:

1. A�adir cliente
2. Eliminar cliente
3. Modificar datos cliente
4. Listar los clientes

 */
package modelo;


public class NoExisteCliente extends Exception {
    
    public String msjError() {
        return "El cliente no existe";
                }
}
