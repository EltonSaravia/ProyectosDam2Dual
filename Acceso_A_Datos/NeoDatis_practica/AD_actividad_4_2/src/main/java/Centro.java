import java.util.HashSet;
import java.util.Set;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

public class Centro {
    private String cod_centro;
    private String nom_centro;
    private String director; // Asociación a un objeto Profesor como director
    private String direccion;
    private String localidad;
    private String provincia;
    private Set<String> profesores; // Conjunto de profesores asociados con este centro

    public Centro() {
        profesores = new HashSet<>();
    }

    // getters y setters
    // ...
    public void addProfesor(String profesor) {
        profesores.add(profesor);
    }

    public String getCod_centro() {
		return cod_centro;
	}

	public void setCod_centro(String cod_centro) {
		this.cod_centro = cod_centro;
	}

	public String getNom_centro() {
		return nom_centro;
	}

	public void setNom_centro(String nom_centro) {
		this.nom_centro = nom_centro;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Set<String> getProfesores() {
		return profesores;
	}

	public void setProfesores(Set<String> profesores) {
		this.profesores = profesores;
	}

	public void removeProfesor(Profesor profesor) {
        profesores.remove(profesor);
    }
	
	
	public void actualizarCentro() {
        ODB odb = null;
        try {
            // Abrir la conexión con la base de datos
            odb = ODBFactory.open("tuBaseDeDatos.neodatis");

            // Buscar el centro existente por su código
            Objects<Centro> centros = odb.getObjects(Centro.class);
            Centro centroEncontrado = null;
            for (Centro c : centros) {
                if (c.getCod_centro() == this.getCod_centro()) {
                    centroEncontrado = c;
                    break;
                }
            }

            // Si el centro existe, actualiza los datos
            if (centroEncontrado != null) {
                centroEncontrado.setNom_centro(this.getNom_centro());
                centroEncontrado.setDireccion(this.getDireccion());
                centroEncontrado.setLocalidad(this.getLocalidad());
                centroEncontrado.setProvincia(this.getProvincia());
                // Actualiza cualquier otro campo necesario
                odb.store(centroEncontrado);
            }

        } finally {
            // Cerrar la conexión con la base de datos
            if (odb != null) {
                odb.close();
            }
        }
    }
}