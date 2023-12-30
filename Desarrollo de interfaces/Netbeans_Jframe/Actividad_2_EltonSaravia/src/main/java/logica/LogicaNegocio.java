/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import gestionclientes.dto.Cliente;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Usuario
 */
public class LogicaNegocio {
    private static List<Cliente> listaClientes = new ArrayList<>();
    
    public static void aniadirCliente (Cliente cliente){
            listaClientes.add(cliente);
    }
    
    public static void eliminarCliente (int cliente){
            listaClientes.remove(cliente);
    }
    public static List<Cliente> getListaClientes(){
        
        return listaClientes;
    }
}
