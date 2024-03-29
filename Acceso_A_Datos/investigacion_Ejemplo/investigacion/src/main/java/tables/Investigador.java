// default package
// Generated 22 ene 2024, 6:41:16 by Hibernate Tools 6.3.1.Final
package tables;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Investigador generated by hbm2java
 */
@Entity
@Table(name="investigador")
public class Investigador implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="INV_ID")
	private Integer invId;
	@Column(name="INV_NOMBRE")
	private String invNombre;
	@Column(name="INV_EXTENSION")
	private Integer invExtension;
	@Column(name="INV_EMAIL")
	private String invEmail;
	@Column(name="INV_SNI")
	private String invSni;
	@Column(name="INV_PRODEP")
	private String invProdep;
	@Column(name="INV_CATEGORIA")
	private String invCategoria;
	@Column(name="INV_CUBICULO")
	private String invCubiculo;
	@Column(name="INV_DESCRIPCION")
	private String invDescripcion;
	@OneToMany(mappedBy="investigador")
	private Set<Proyectos> proyectoses = new HashSet(0);

	public Investigador() {
	}

	public Investigador(String invNombre, Integer invExtension, String invEmail, String invSni, String invProdep,
			String invCategoria, String invCubiculo, String invDescripcion, Set proyectoses) {
		this.invNombre = invNombre;
		this.invExtension = invExtension;
		this.invEmail = invEmail;
		this.invSni = invSni;
		this.invProdep = invProdep;
		this.invCategoria = invCategoria;
		this.invCubiculo = invCubiculo;
		this.invDescripcion = invDescripcion;
		this.proyectoses = proyectoses;
	}

	public Integer getInvId() {
		return this.invId;
	}

	public void setInvId(Integer invId) {
		this.invId = invId;
	}

	public String getInvNombre() {
		return this.invNombre;
	}

	public void setInvNombre(String invNombre) {
		this.invNombre = invNombre;
	}

	public Integer getInvExtension() {
		return this.invExtension;
	}

	public void setInvExtension(Integer invExtension) {
		this.invExtension = invExtension;
	}

	public String getInvEmail() {
		return this.invEmail;
	}

	public void setInvEmail(String invEmail) {
		this.invEmail = invEmail;
	}

	public String getInvSni() {
		return this.invSni;
	}

	public void setInvSni(String invSni) {
		this.invSni = invSni;
	}

	public String getInvProdep() {
		return this.invProdep;
	}

	public void setInvProdep(String invProdep) {
		this.invProdep = invProdep;
	}

	public String getInvCategoria() {
		return this.invCategoria;
	}

	public void setInvCategoria(String invCategoria) {
		this.invCategoria = invCategoria;
	}

	public String getInvCubiculo() {
		return this.invCubiculo;
	}

	public void setInvCubiculo(String invCubiculo) {
		this.invCubiculo = invCubiculo;
	}

	public String getInvDescripcion() {
		return this.invDescripcion;
	}

	public void setInvDescripcion(String invDescripcion) {
		this.invDescripcion = invDescripcion;
	}

	public Set getProyectoses() {
		return this.proyectoses;
	}

	public void setProyectoses(Set proyectoses) {
		this.proyectoses = proyectoses;
	}

}
