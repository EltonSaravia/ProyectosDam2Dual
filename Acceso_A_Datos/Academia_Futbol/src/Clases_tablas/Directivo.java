
public class Directivo {
    private int id;
    private String cargo;

    // Constructor vacío
    public Directivo() {
    }

    // Constructor con parámetros
    public Directivo(int id, String cargo) {
        this.id = id;
        this.cargo = cargo;
    }

    // Métodos getter y setter para los atributos
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
}
