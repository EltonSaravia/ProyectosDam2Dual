// default package
// Generated 15 ene 2024 17:10:56 by Hibernate Tools 6.3.1.Final
package entidades;
/**
 * ExperienciaLaboral generated by hbm2java
 */
public class ExperienciaLaboral implements java.io.Serializable {

	private int elId;
	private Investigador investigador;
	private String elInstituto;
	private String elPeriodo;
	private String elDescripcion;

	public ExperienciaLaboral() {
	}

	public ExperienciaLaboral(int elId, Investigador investigador, String elInstituto, String elPeriodo,
			String elDescripcion) {
		this.elId = elId;
		this.investigador = investigador;
		this.elInstituto = elInstituto;
		this.elPeriodo = elPeriodo;
		this.elDescripcion = elDescripcion;
	}

	public int getElId() {
		return this.elId;
	}

	public void setElId(int elId) {
		this.elId = elId;
	}

	public Investigador getInvestigador() {
		return this.investigador;
	}

	public void setInvestigador(Investigador investigador) {
		this.investigador = investigador;
	}

	public String getElInstituto() {
		return this.elInstituto;
	}

	public void setElInstituto(String elInstituto) {
		this.elInstituto = elInstituto;
	}

	public String getElPeriodo() {
		return this.elPeriodo;
	}

	public void setElPeriodo(String elPeriodo) {
		this.elPeriodo = elPeriodo;
	}

	public String getElDescripcion() {
		return this.elDescripcion;
	}

	public void setElDescripcion(String elDescripcion) {
		this.elDescripcion = elDescripcion;
	}

}
