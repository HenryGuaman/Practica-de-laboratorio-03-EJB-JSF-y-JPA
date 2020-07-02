package ec.edu.ups.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Bodega
 *
 */
@Entity

public class Bodega implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	private String nombre;
	
	@ManyToOne
	private Ubicacion ubicacion;
	
	 @Transient
	 private boolean editable;
	
	
	public int getCodigo() {
		return codigo;
	}




	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public Ubicacion getUbicacion() {
		return ubicacion;
	}




	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
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
		result = prime * result + codigo;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((ubicacion == null) ? 0 : ubicacion.hashCode());
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
		Bodega other = (Bodega) obj;
		if (codigo != other.codigo)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (ubicacion == null) {
			if (other.ubicacion != null)
				return false;
		} else if (!ubicacion.equals(other.ubicacion))
			return false;
		return true;
	}

	


	/**
	 * @param codigo
	 * @param nombre
	 * @param ubicacion
	 */
	public Bodega(int codigo, String nombre, Ubicacion ubicacion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
	}

	
	public Bodega(String nombre) {
		
		this.nombre = nombre;
	}


	/**
	 * @param nombre
	 * @param ubicacion
	 */
	public Bodega(String nombre, Ubicacion ubicacion) {
		super();
		this.nombre = nombre;
		this.ubicacion = ubicacion;
	}




	public Bodega() {
		super();
	}
   
}
