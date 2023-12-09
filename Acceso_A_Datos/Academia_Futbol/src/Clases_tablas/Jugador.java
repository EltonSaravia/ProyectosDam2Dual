import java.io.Serializable;
import java.util.Objects;

public class Jugador implements Serializable {
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
    

    // Constructor  datos // menos categoria que es foranea para evitar problemas 
    // he modificado cosas pueden afectar al DAO REVISAR>>>>>>>>>>>>>>>>
    //elimino id jugador del constructor
    public Jugador( String nombre, String apellidos, int edad, int dorsal,
            String posicion) {
	 
	 this.nombre = nombre;
	 this.apellidos = apellidos;
	 this.edad = edad;
	 this.dorsal = dorsal;
	 this.posicion = posicion;
	 this.partidosJugados = 0;
	 this.minAcumulados = 0;
	 this.amarillas = 0;
	 this.rojas = 0;
	 this.lesionado = false;
	 this.partidosSancionado = 0;
	 	this.categoria = "ALEVIN";
	;
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



	@Override
	public String toString() {
	    return String.format("Jugador ID: %d  Nombre: '%s'  Apellidos: '%s'  Edad: %d  Dorsal: %d  Posición: '%s'  \nPartidos: %d  Minutos Acumulados: %d  Amarillas: %d  Rojas: %d  Lesionado: %b  Partidos Sancionado: %d  Categoría: '%s'\n\n",
	            idJugador, nombre, apellidos, edad, dorsal, posicion, partidosJugados,
	            minAcumulados, amarillas, rojas, lesionado, partidosSancionado, categoria);
	}
	
}


