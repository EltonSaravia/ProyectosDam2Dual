package modelo;

import java.util.Arrays;

public class Agenda {
    private Cliente[] listaclientes;
    private int contadorId;
    private int cantidadClientes;

    public Agenda() {
        this.listaclientes = new Cliente[0]; // Inicialmente el array está vacío
        this.cantidadClientes = 0;
    }

    public void anadirCliente(String nombre, String telefono, String email) {
        Cliente cliente1 = new Cliente(obtenerId(), nombre, telefono, email);
        expandirArray(); // Expandir el array si es necesario
        this.listaclientes[cantidadClientes] = cliente1;
        cantidadClientes++;
    }

    public int obtenerId() {
        this.contadorId = cantidadClientes + 1;
        return this.contadorId;
    }

    public Cliente[] getListaclientes() {
        return listaclientes;
    }

    public void eliminarCliente(String nombre) throws NoExisteCliente {
        Cliente clienteEliminar = obtenerCliente(nombre);
        int indiceEliminar = -1;
        for (int i = 0; i < cantidadClientes; i++) {
            if (listaclientes[i].equals(clienteEliminar)) {
                indiceEliminar = i;
                break;
            }
        }
        if (indiceEliminar != -1) {
            for (int i = indiceEliminar; i < cantidadClientes - 1; i++) {
                listaclientes[i] = listaclientes[i + 1];
            }
            listaclientes[cantidadClientes - 1] = null;
            cantidadClientes--;
            reducirArray(); // Reducir el array si es necesario
        } else {
            throw new NoExisteCliente();
        }
    }

    public Cliente obtenerCliente(String nombre) throws NoExisteCliente {
        Cliente auxiliar = new Cliente(nombre);
        for (int i = 0; i < cantidadClientes; i++) {
            if (auxiliar.equals(listaclientes[i])) {
                return listaclientes[i];
            }
        }
        throw new NoExisteCliente();
    }

    public void modificarCliente(String nombre, String nombreNuevo) throws NoExisteCliente {
        Cliente clienteModificar = obtenerCliente(nombre);
        clienteModificar.modificarNombre(nombreNuevo);
    }

    public void cargarAgenda(Cliente[] lista) {
        this.listaclientes = lista;
        this.cantidadClientes = lista.length;
    }

    private void expandirArray() {
        if (cantidadClientes == listaclientes.length) {
            int nuevoTamano = cantidadClientes == 0 ? 1 : cantidadClientes * 2;
            listaclientes = Arrays.copyOf(listaclientes, nuevoTamano);
        }
    }

    private void reducirArray() {
        int tamanoMinimo = cantidadClientes == 0 ? 0 : cantidadClientes / 2;
        if (tamanoMinimo <= listaclientes.length / 2) {
            listaclientes = Arrays.copyOf(listaclientes, tamanoMinimo);
        }
    }

    @Override
    public String toString() {
        return formateoDeTexto();

    }

    public String formateoDeTexto() {
        String texto = "";
        texto = String.format("%10s %10s %10s %10s \n", "ID", "NOMBRE", "TELEFONO", "EMAIL");
        for (int i = 0; i < cantidadClientes; i++) {
            texto = texto + listaclientes[i].toString() + "\n";
        }

        return texto;
    }
}

