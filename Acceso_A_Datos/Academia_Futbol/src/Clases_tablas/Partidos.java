import java.util.Objects;

public class Partidos {
    private int idPartido;
    private String equipoLocal;
    private String equipoVisitante;

    public Partidos(int idPartido, String equipoLocal, String equipoVisitante) {
        this.idPartido = idPartido;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
    }

    public Partidos() {
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Partidos partidos = (Partidos) o;
        return idPartido == partidos.idPartido && Objects.equals(equipoLocal, partidos.equipoLocal) && Objects.equals(equipoVisitante, partidos.equipoVisitante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPartido, equipoLocal, equipoVisitante);
    }

    @Override
    public String toString() {
        return "Partidos{" +
                "idPartido=" + idPartido +
                ", equipoLocal='" + equipoLocal + '\'' +
                ", equipoVisitante='" + equipoVisitante + '\'' +
                '}';
    }
}
