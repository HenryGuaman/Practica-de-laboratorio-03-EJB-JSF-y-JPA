package ec.edu.ups.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Rol
 *
 */
@Entity

public class Rol implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	private int codigo;
	private String nombreRol;
	
	
	
	public int getCodigo() {
		return codigo;
	}



	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	public String getNombreRol() {
		return nombreRol;
	}



	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + ((nombreRol == null) ? 0 : nombreRol.hashCode());
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
		Rol other = (Rol) obj;
		if (codigo != other.codigo)
			return false;
		if (nombreRol == null) {
			if (other.nombreRol != null)
				return false;
		} else if (!nombreRol.equals(other.nombreRol))
			return false;
		return true;
	}



	public Rol() {
	}



	/**
	 * @param codigo
	 * @param nombreRol
	 */
	public Rol(int codigo, String nombreRol) {
		this.codigo = codigo;
		this.nombreRol = nombreRol;
	}
	
	
   
}
