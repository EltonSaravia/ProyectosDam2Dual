import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Profesor {
    private String cod_prof;
    private String nombre_ape;
    private String especialidad;
    private Date fecha_nac;
    private char sexo;
    private Set<Asignatura> asignaturas; // Conjunto de asignaturas que enseña este profesor
	private HashSet<String> centros;
    
    
    public Profesor() {
        asignaturas = new HashSet<>();
        this.centros = new HashSet<>();
    }

    // getters y setters

   

    // Este método copia el profesor a un nuevo centro
    public void copiarA(String nuevoCentro) {
        this.addCentro(nuevoCentro);
    }


    public void addAsignatura(Asignatura asignatura) {
        asignaturas.add(asignatura);
    }
    
    public void addCentro(String centroDestino) {
        if (!centros.contains(centroDestino)) {
            centros.add(centroDestino);
        }
    }

    public void removeCentro(String centro) {
        centros.remove(centro);
    }

    
    public Set<String> getCentros() {
        return (Set<String>) centros;
    }

    public void setCentros(String centroAnadir) {
        this.centros.add(centroAnadir) ;
    }
    
    public void deletearUnCentro(String centroAnadir) {
        this.centros.remove(centroAnadir) ;
    }
    
    
//////////
    public String getCod_prof() {
		return cod_prof;
	}

	public void setCod_prof(String cod_prof) {
		this.cod_prof = cod_prof;
	}

	public String getNombre_ape() {
		return nombre_ape;
	}
//nuevo metodo porque el aterior fallaba
	public void setNombre_ape(String nombre_ape) {
		this.nombre_ape = nombre_ape;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public Date getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(Date fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public Set<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(Set<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	public void removeAsignatura(Asignatura asignatura) {
        asignaturas.remove(asignatura);
    }
}