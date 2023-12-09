import java.io.Serializable;

public class Directivo implements Serializable {
    private int id;
    private String  dni,nombre, apellidos ,cargo;

    // Constructor vacío
    public Directivo() {
    }

    // Constructor con parámetros
    public Directivo( String dni,String nombre,String apellidos, String cargo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cargo = cargo;
       
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

   
    @Override
    public String toString() {
        return String.format("Directivo ID: %d  Cargo: '%s'  DNI: '%s'  Nombre: '%s'  Apellidos: '%s'",
                id, cargo, dni, nombre, apellidos);
    }
}
