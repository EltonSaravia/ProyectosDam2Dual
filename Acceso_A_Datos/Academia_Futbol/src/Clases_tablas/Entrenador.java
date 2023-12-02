
import java.util.Objects;

public class Entrenador {
    private int idEntrenador;
    private String nombre;
    private int partidos;
    private int mesesExp;

    // Constructor con todos los datos
    public Entrenador(int idEntrenador, String nombre, int partidos, int mesesExp) {
        this.idEntrenador = idEntrenador;
        this.nombre = nombre;
        this.partidos = partidos;
        this.mesesExp = mesesExp;
    }

    // Constructor vacío
    public Entrenador() {
    }

    // Getters y setters
    public int getIdEntrenador() {
        return idEntrenador;
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

   

    @Override
    public String toString() {
        return "Entrenador{" +
                "idEntrenador=" + idEntrenador +
                ", nombre='" + nombre + '\'' +
                ", partidos=" + partidos +
                ", mesesExp=" + mesesExp +
                '}';
    }

    // Puedes implementar hashCode, equals y otros métodos según tus necesidades
}
