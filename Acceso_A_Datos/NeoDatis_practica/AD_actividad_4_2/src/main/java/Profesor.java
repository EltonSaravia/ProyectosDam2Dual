import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Profesor {
    private int cod_prof;
    private String nombre_ape;
    private String especialidad;
    private Date fecha_nac;
    private char sexo;
    private Set<Asignatura> asignaturas; // Conjunto de asignaturas que enseña este profesor
    private Set<Centro> centros;
    
    public Profesor() {
        asignaturas = new HashSet<>();
        this.centros = new HashSet<>();
    }

    // getters y setters

   

    // Este método copia el profesor a un nuevo centro
    public void copiarA(Centro nuevoCentro) {
        this.addCentro(nuevoCentro);
    }


    public void addAsignatura(Asignatura asignatura) {
        asignaturas.add(asignatura);
    }
    
    public void addCentro(Centro centro) {
        if (!centros.contains(centro)) {
            centros.add(centro);
        }
    }

    public void removeCentro(Centro centro) {
        centros.remove(centro);
    }

    // Getters y setters
    public Set<Centro> getCentros() {
        return (Set<Centro>) centros;
    }

    public void setCentros(Set<Centro> centros) {
        this.centros = (Set<Centro>) centros;
    }
    
    
//////////
    public int getCod_prof() {
		return cod_prof;
	}

	public void setCod_prof(int cod_prof) {
		this.cod_prof = cod_prof;
	}

	public String getNombre_ape() {
		return nombre_ape;
	}

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