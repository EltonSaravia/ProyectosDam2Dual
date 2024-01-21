// default package
// Generated 15 ene 2024 17:10:56 by Hibernate Tools 6.3.1.Final
package entidades;
import java.util.HashSet;
import java.util.Set;

/**
 * Investigador generated by hbm2java
 */
public class Investigador implements java.io.Serializable {

	private int invId;
	private String invNombre;
	private Integer invExtension;
	private String invEmail;
	private Integer invSni;
	private Integer invProdep;
	private Integer invCategoria;
	private Integer invCubiculo;
	private String invDescripcion;
	private Set trabajosGradoDirigidoses = new HashSet(0);
	private Set experienciaLaborals = new HashSet(0);
	private Set educacions = new HashSet(0);
	private Set tesisRedactadases = new HashSet(0);

	public Investigador() {
	}

	public Investigador(int invId, String invNombre, Integer invExtension, String invEmail, Integer invSni,
			Integer invProdep, Integer invCategoria, Integer invCubiculo, String invDescripcion,
			Set trabajosGradoDirigidoses, Set experienciaLaborals, Set educacions, Set tesisRedactadases) {
		this.invId = invId;
		this.invNombre = invNombre;
		this.invExtension = invExtension;
		this.invEmail = invEmail;
		this.invSni = invSni;
		this.invProdep = invProdep;
		this.invCategoria = invCategoria;
		this.invCubiculo = invCubiculo;
		this.invDescripcion = invDescripcion;
		this.trabajosGradoDirigidoses = trabajosGradoDirigidoses;
		this.experienciaLaborals = experienciaLaborals;
		this.educacions = educacions;
		this.tesisRedactadases = tesisRedactadases;
	}

	public int getInvId() {
		return this.invId;
	}

	public void setInvId(int invId) {
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

	public Integer getInvSni() {
		return this.invSni;
	}

	public void setInvSni(Integer invSni) {
		this.invSni = invSni;
	}

	public Integer getInvProdep() {
		return this.invProdep;
	}

	public void setInvProdep(Integer invProdep) {
		this.invProdep = invProdep;
	}

	public Integer getInvCategoria() {
		return this.invCategoria;
	}

	public void setInvCategoria(Integer invCategoria) {
		this.invCategoria = invCategoria;
	}

	public Integer getInvCubiculo() {
		return this.invCubiculo;
	}

	public void setInvCubiculo(Integer invCubiculo) {
		this.invCubiculo = invCubiculo;
	}

	public String getInvDescripcion() {
		return this.invDescripcion;
	}

	public void setInvDescripcion(String invDescripcion) {
		this.invDescripcion = invDescripcion;
	}

	public Set getTrabajosGradoDirigidoses() {
		return this.trabajosGradoDirigidoses;
	}

	public void setTrabajosGradoDirigidoses(Set trabajosGradoDirigidoses) {
		this.trabajosGradoDirigidoses = trabajosGradoDirigidoses;
	}

	public Set getExperienciaLaborals() {
		return this.experienciaLaborals;
	}

	public void setExperienciaLaborals(Set experienciaLaborals) {
		this.experienciaLaborals = experienciaLaborals;
	}

	public Set getEducacions() {
		return this.educacions;
	}

	public void setEducacions(Set educacions) {
		this.educacions = educacions;
	}

	public Set getTesisRedactadases() {
		return this.tesisRedactadases;
	}

	public void setTesisRedactadases(Set tesisRedactadases) {
		this.tesisRedactadases = tesisRedactadases;
	}

}