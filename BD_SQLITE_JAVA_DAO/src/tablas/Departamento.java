package tablas;

public class Departamento {
    private int idDepartamento;
    private String nombre;
    private String ubicacion;

    /*
     * La clase tiene un constructor que recibe tres parámetros: idDepartamento,
     * nombre y ubicacion.
     * Cuando se crea un objeto de la clase Departamento, estos valores se utilizan
     * para
     * inicializar los atributos correspondientes.
     */
    public Departamento(int idDepartamento, String nombre, String ubicacion) {
        this.idDepartamento = idDepartamento;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
