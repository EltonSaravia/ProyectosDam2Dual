import java.util.Objects;

public class Gol {
    private int idGol;
    private String jugador;
    private int dorsal;
    private String equipo;
    private int partido;
    private int min;

    public Gol(int idGol, String jugador, int dorsal, String equipo, int partido, int min) {
        this.idGol = idGol;
        this.jugador = jugador;
        this.dorsal = dorsal;
        this.equipo = equipo;
        this.partido = partido;
        this.min = min;
    }

    public Gol() {
    }

    public int getIdGol() {
        return idGol;
    }

    public void setIdGol(int idGol) {
        this.idGol = idGol;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public int getPartido() {
        return partido;
    }

    public void setPartido(int partido) {
        this.partido = partido;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gol gol = (Gol) o;
        return idGol == gol.idGol && dorsal == gol.dorsal && partido == gol.partido && min == gol.min && Objects.equals(jugador, gol.jugador) && Objects.equals(equipo, gol.equipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGol, jugador, dorsal, equipo, partido, min);
    }

    @Override
    public String toString() {
        return "Gol{" +
                "idGol=" + idGol +
                ", jugador='" + jugador + '\'' +
                ", dorsal=" + dorsal +
                ", equipo='" + equipo + '\'' +
                ", partido=" + partido +
                ", min=" + min +
                '}';
    }
}
