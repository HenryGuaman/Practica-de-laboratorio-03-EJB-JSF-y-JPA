package ec.edu.ups.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Ubicacion
 *
 */
@NamedQuery(name = "getByCiudad", query = "SELECT u FROM Ubicacion u WHERE u.ciudad =:ciudad")
@Entity

public class Ubicacion implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	private String pais;
	private String provincia;
	private String ciudad;
	
	@OneToMany(mappedBy = "ubicacion")
	private List<Bodega> bodegas;
	
	@Transient
    private boolean editable;
	
	public int getCodigo() {
		return codigo;
	}



	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	public String getPais() {
		return pais;
	}



	public void setPais(String pais) {
		this.pais = pais;
	}



	public String getProvincia() {
		return provincia;
	}



	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}



	public String getCiudad() {
		return ciudad;
	}



	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	

	public List<Bodega> getBodegas() {
		return bodegas;
	}



	public void setBodegas(List<Bodega> bodegas) {
		this.bodegas = bodegas;
	}



	public boolean isEditable() {
		return editable;
	}



	public void setEditable(boolean editable) {
		this.editable = editable;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ciudad == null) ? 0 : ciudad.hashCode());
		result = prime * result + codigo;
		result = prime * result + ((pais == null) ? 0 : pais.hashCode());
		result = prime * result + ((provincia == null) ? 0 : provincia.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ubicacion other = (Ubicacion) obj;
		if (ciudad == null) {
			if (other.ciudad != null)
				return false;
		} else if (!ciudad.equals(other.ciudad))
			return false;
		if (codigo != other.codigo)
			return false;
		if (pais == null) {
			if (other.pais != null)
				return false;
		} else if (!pais.equals(other.pais))
			return false;
		if (provincia == null) {
			if (other.provincia != null)
				return false;
		} else if (!provincia.equals(other.provincia))
			return false;
		return true;
	}


	
	
	/**
	 * @param codigo
	 * @param pais
	 * @param provincia
	 * @param ciudad
	 */
	public Ubicacion(int codigo, String pais, String provincia, String ciudad) {
		
		this.codigo = codigo;
		this.pais = pais;
		this.provincia = provincia;
		this.ciudad = ciudad;
	}

	public Ubicacion(String pais, String provincia, String ciudad) {
		
		this.codigo = codigo;
		this.pais = pais;
		this.provincia = provincia;
		this.ciudad = ciudad;
	}

	public Ubicacion() {
	}
   
}
