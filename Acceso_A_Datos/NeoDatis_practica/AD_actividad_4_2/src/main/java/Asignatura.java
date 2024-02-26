import java.util.HashSet;
import java.util.Set;

public class Asignatura {
    private String cod_asig;
    private String nombre_asi;
    private Set<Profesor> profesores; // Conjunto de profesores para esta asignatura

    public Asignatura() {
        profesores = new HashSet<>();
    }

    // getters y setters

    public void addProfesor(Profesor profesor) {
        profesores.add(profesor);
    }
/////////
    public String getCod_asig() {
		return cod_asig;
	}

	public void setCod_asig(String cod_asig) {
		this.cod_asig = cod_asig;
	}

	public String getNombre_asi() {
		return nombre_asi;
	}

	public void setNombre_asi(String nombre_asi) {
		this.nombre_asi = nombre_asi;
	}

	public Set<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(Set<Profesor> profesores) {
		this.profesores = profesores;
	}

	public void removeProfesor(Profesor profesor) {
        profesores.remove(profesor);
    }
}