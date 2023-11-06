package tablas;

public class Cliente {
    private int idCliente;
    private String nombre;
    private String personaContacto;
    private String tfnoContacto;
    private String CIF;
    private String ubicacion;

    public Cliente(int idCliente, String nombre, String personaContacto, String tfnoContacto, String CIF,
            String ubicacion) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.personaContacto = personaContacto;
        this.tfnoContacto = tfnoContacto;
        this.CIF = CIF;
        this.ubicacion = ubicacion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPersonaContacto() {
        return personaContacto;
    }

    public void setPersonaContacto(String personaContacto) {
        this.personaContacto = personaContacto;
    }

    public String getTfnoContacto() {
        return tfnoContacto;
    }

    public void setTfnoContacto(String tfnoContacto) {
        this.tfnoContacto = tfnoContacto;
    }

    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
