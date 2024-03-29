// default package
// Generated 15 ene 2024 17:10:56 by Hibernate Tools 6.3.1.Final
package entidades;
/**
 * TesisRedactadas generated by hbm2java
 */
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * TesisRedactadas generated by hbm2java
 */
@Entity
@Table(name = "tesis_redactadas")
public class TesisRedactadas implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TESIS_ID", unique = true, nullable = false)
    private int tesisId;

    @ManyToOne
    @JoinColumn(name = "INV_ID")
    private Investigador investigador;

    @Column(name = "TESIS_NOMBRE", length = 255)
    private String tesisNombre;

    @Column(name = "TESIS_DESCRIPCION", length = 65535)
    private String tesisDescripcion;

   

	public TesisRedactadas() {
	}

	public TesisRedactadas(int tesisId, Investigador investigador, String tesisNombre, String tesisDescripcion) {
		this.tesisId = tesisId;
		this.investigador = investigador;
		this.tesisNombre = tesisNombre;
		this.tesisDescripcion = tesisDescripcion;
	}

	public int getTesisId() {
		return this.tesisId;
	}

	public void setTesisId(int tesisId) {
		this.tesisId = tesisId;
	}

	public Investigador getInvestigador() {
		return this.investigador;
	}

	public void setInvestigador(Investigador investigador) {
		this.investigador = investigador;
	}

	public String getTesisNombre() {
		return this.tesisNombre;
	}

	public void setTesisNombre(String tesisNombre) {
		this.tesisNombre = tesisNombre;
	}

	public String getTesisDescripcion() {
		return this.tesisDescripcion;
	}

	public void setTesisDescripcion(String tesisDescripcion) {
		this.tesisDescripcion = tesisDescripcion;
	}

}
