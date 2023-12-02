import java.util.Objects;

public class Lesion {
    private int idLesion;
    private String fechaInicio;
    private String fechaFin;
    private String jugador;

    public Lesion(int idLesion, String fechaInicio, String fechaFin, String jugador) {
        this.idLesion = idLesion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.jugador = jugador;
    }

    public Lesion() {
    }

    public int getIdLesion() {
        return idLesion;
    }

    public void setIdLesion(int idLesion) {
        this.idLesion = idLesion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesion lesion = (Lesion) o;
        return idLesion == lesion.idLesion && Objects.equals(fechaInicio, lesion.fechaInicio) && Objects.equals(fechaFin, lesion.fechaFin) && Objects.equals(jugador, lesion.jugador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLesion, fechaInicio, fechaFin, jugador);
    }

    @Override
    public String toString() {
        return "Lesion{" +
                "idLesion=" + idLesion +
                ", fechaInicio='" + fechaInicio + '\'' +
                ", fechaFin='" + fechaFin + '\'' +
                ", jugador='" + jugador + '\'' +
                '}';
    }
}
