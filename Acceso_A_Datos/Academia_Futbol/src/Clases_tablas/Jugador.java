import java.util.Objects;

public class Jugador {
    private int idJugador;
    private String nombre;
    private String apellidos; // Nueva columna para apellidos
    private int edad;
    private int dorsal;
    private String posicion;
    private int partidosJugados;
    private int minAcumulados;
    private int amarillas;
    private int rojas;
    private boolean lesionado;
    private int partidosSancionado;
    private String categoria;
    private String equipoNombre;

    // Constructor con todos los datos
    public Jugador(int idJugador, String nombre, String apellidos, int edad, int dorsal,
            String posicion, int partidosJugados, int minAcumulados, int amarillas,
            int rojas, boolean lesionado, int partidosSancionado, String categoria,
            String equipoNombre) {
	 this.idJugador = idJugador;
	 this.nombre = nombre;
	 this.apellidos = apellidos;
	 this.edad = edad;
	 this.dorsal = dorsal;
	 this.posicion = posicion;
	 this.partidosJugados = partidosJugados;
	 this.minAcumulados = minAcumulados;
	 this.amarillas = amarillas;
	 this.rojas = rojas;
	 this.lesionado = lesionado;
	 this.partidosSancionado = partidosSancionado;
	 this.categoria = categoria;
	 this.equipoNombre = equipoNombre;
}

    public Jugador() {
       
    }

    // Getters y setters
    public int getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public int getPartidosJugados() {
		return partidosJugados;
	}

	public void setPartidosJugados(int partidosJugados) {
		this.partidosJugados = partidosJugados;
	}

	public int getMinAcumulados() {
		return minAcumulados;
	}

	public void setMinAcumulados(int minAcumulados) {
		this.minAcumulados = minAcumulados;
	}

	public int getAmarillas() {
		return amarillas;
	}

	public void setAmarillas(int amarillas) {
		this.amarillas = amarillas;
	}

	public int getRojas() {
		return rojas;
	}

	public void setRojas(int rojas) {
		this.rojas = rojas;
	}

	public boolean isLesionado() {
		return lesionado;
	}

	public void setLesionado(boolean lesionado) {
		this.lesionado = lesionado;
	}

	public int getPartidosSancionado() {
		return partidosSancionado;
	}

	public void setPartidosSancionado(int partidosSancionado) {
		this.partidosSancionado = partidosSancionado;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getEquipoNombre() {
		return equipoNombre;
	}

	public void setEquipoNombre(String equipoNombre) {
		this.equipoNombre = equipoNombre;
	}
    // hashCode, equals y toString
    // ...

    @Override
    public String toString() {
        return "Jugador{" +
                "idJugador=" + idJugador +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                ", dorsal=" + dorsal +
                ", posicion='" + posicion + '\'' +
                ", partidosJugados=" + partidosJugados +
                ", minAcumulados=" + minAcumulados +
                ", amarillas=" + amarillas +
                ", rojas=" + rojas +
                ", lesionado=" + lesionado +
                ", partidosSancionado=" + partidosSancionado +
                ", categoria='" + categoria + '\'' +
                ", equipoNombre='" + equipoNombre + '\'' +
                '}';
    }

	
}


