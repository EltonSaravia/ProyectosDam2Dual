import java.io.Serializable;
import java.util.Objects;

public class Equipo implements Serializable {
    private int codEquipo;
    private String estadio;
    private int entrenador;
    private String categoria;

    // Constructor con todos los datos
    public Equipo(String estadio, int entrenador, String categoria) {
       
        this.estadio = estadio;
        this.entrenador = entrenador;
        this.categoria = categoria;
    }
    
    public Equipo() {
        
    }

    // Getters y setters
    public int getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(int codEquipo) {
        this.codEquipo = codEquipo;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public int getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(int entrenador) {
        this.entrenador = entrenador;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

 

    @Override
    public String toString() {
        return String.format("Equipo Codigo de Equipo: %d	estadio: '%s'	entrenador: '%s'	categoria: '%s'}", codEquipo, estadio, entrenador, categoria);
    }


}
