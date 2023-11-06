package tablas;

public class Departamento {
    private int idDepartamento;
    private String nombre;
    private String ubicacion;

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
