package modelo;


import java.io.Serializable;
import java.util.Objects;

public class Cliente implements Serializable{
       private int id;
       private String nombre;
       private String telefono;
       private String email;
 
      public Cliente(int id, String nombre, String telefono, String email){
          this.id=id;
          this.nombre=nombre;
          this.telefono=telefono;
          this.email=email;
      }

      public Cliente (String nombre){
          this.nombre=nombre;
          
      }

      
      
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        return Objects.equals(this.nombre, other.nombre);
    }
      
    
    
    
    
    public int getId() {
		return id;
	}

	public String getNombre() {
        return nombre;
    }

    void modificarNombre(String nombreNuevo) {
        this.nombre=nombreNuevo;
    }

    @Override
    public String toString() {
    	
    	return String.format("%10s %10s %10s %10s ", this.id,this.nombre,this.telefono,this.email);
    }
      
    
      
}