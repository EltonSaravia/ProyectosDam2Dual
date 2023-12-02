import java.util.Objects;

public class Tarjeta {
    private int idTarjeta;
    private boolean roja;
    private boolean amarilla;
    private String jugador;

    public Tarjeta(int idTarjeta, boolean roja, boolean amarilla, String jugador) {
        this.idTarjeta = idTarjeta;
        this.roja = roja;
        this.amarilla = amarilla;
        this.jugador = jugador;
    }

    public Tarjeta() {
    }

    public int getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(int idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public boolean isRoja() {
        return roja;
    }

    public void setRoja(boolean roja) {
        this.roja = roja;
    }

    public boolean isAmarilla() {
        return amarilla;
    }

    public void setAmarilla(boolean amarilla) {
        this.amarilla = amarilla;
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
        Tarjeta tarjeta = (Tarjeta) o;
        return idTarjeta == tarjeta.idTarjeta && roja == tarjeta.roja && amarilla == tarjeta.amarilla && Objects.equals(jugador, tarjeta.jugador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTarjeta, roja, amarilla, jugador);
    }

    @Override
    public String toString() {
        return "Tarjeta{" +
                "idTarjeta=" + idTarjeta +
                ", roja=" + roja +
                ", amarilla=" + amarilla +
                ", jugador='" + jugador + '\'' +
                '}';
    }
}
