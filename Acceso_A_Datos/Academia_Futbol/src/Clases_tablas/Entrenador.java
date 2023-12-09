import java.io.Serializable;
import java.util.Objects;



public class Entrenador implements Serializable{
    private int idEntrenador;
    private String nombre, apellidos;
    private int partidos;
    private int mesesExp;
    private int idEquipo; // Nuevo atributo para representar la asociación con el equipo

    // Constructor con todos los datos, incluyendo idEquipo
    public Entrenador(String nombre,String apellidos, int mesesExp, int idEquipo) {
        this.nombre = nombre;
        this.apellidos= apellidos;
        this.partidos = 0;
        this.mesesExp = mesesExp;
        this.idEquipo = idEquipo;
    }

    // Constructor vacío
    public Entrenador() {
    }



	// Getters y setters
    public int getIdEntrenador() {
        return idEntrenador;
    }

    public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setIdEntrenador(int idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPartidos() {
        return partidos;
    }

    public void setPartidos(int partidos) {
        this.partidos = partidos;
    }

    public int getMesesExp() {
        return mesesExp;
    }

    public void setMesesExp(int mesesExp) {
        this.mesesExp = mesesExp;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    @Override
    public String toString() {
        return "		" +
                "idEntrenador=" + idEntrenador +
                ", nombre='" + nombre + '\'' +
                ", Apellidos=" + apellidos +
                ", partidos=" + partidos +
                ", mesesExp=" + mesesExp +
                ", idEquipo=" + idEquipo ;
    }

    
}
