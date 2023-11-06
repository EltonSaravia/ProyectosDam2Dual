package tablas;

public class Proyecto {
    private int idProyecto;
    private String nombre;
    private int idDepartamento;

    public Proyecto(int idProyecto, String nombre, int idDepartamento) {
        this.idProyecto = idProyecto;
        this.nombre = nombre;
        this.idDepartamento = idDepartamento;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
}
