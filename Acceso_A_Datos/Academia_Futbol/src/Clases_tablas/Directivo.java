
public class Directivo {
    private int id;
    private String cargo, dni,nombre, apellidos;

    // Constructor vacío
    public Directivo() {
    }

    // Constructor con parámetros
    public Directivo( String dni,String nombre,String apellidos, String cargo) {
        this.dni = dni;
        this.cargo = cargo;
        this.nombre = nombre;
        this.cargo = apellidos;
    }
    
    
	// Métodos getter y setter para los atributos
    public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    // Otros métodos según sea necesario
	@Override
	public String toString() {
		return "Directivo [id=" + id + ", cargo=" + cargo + ", dni=" + dni + ", nombre=" + nombre + ", apellidos="
				+ apellidos + "]";
	}
}
