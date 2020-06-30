package ec.edu.ups.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: FacturaCabecera
 *
 */
@Entity

public class FacturaCabecera implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	private int codigo;
	private Date fecha;
	private double iva;
	private double descuento;
	private double totalFact;
	
	@ManyToOne
	private Usuario usuario;
	@ManyToOne
	private FacturaDetalle facturaDetalle;
	

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}


	public double getDescuento() {
		return descuento;
	}



	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}



	public double getTotalFact() {
		return totalFact;
	}






	public FacturaDetalle getFacturaDetalle() {
		return facturaDetalle;
	}

	public void setFacturaDetalle(FacturaDetalle facturaDetalle) {
		this.facturaDetalle = facturaDetalle;
	}

	public void setTotalFact(double totalFact) {
		this.totalFact = totalFact;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public FacturaCabecera() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		long temp;
		temp = Double.doubleToLongBits(descuento);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((facturaDetalle == null) ? 0 : facturaDetalle.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		temp = Double.doubleToLongBits(iva);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(totalFact);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		FacturaCabecera other = (FacturaCabecera) obj;
		if (codigo != other.codigo)
			return false;
		if (Double.doubleToLongBits(descuento) != Double.doubleToLongBits(other.descuento))
			return false;
		if (facturaDetalle == null) {
			if (other.facturaDetalle != null)
				return false;
		} else if (!facturaDetalle.equals(other.facturaDetalle))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (Double.doubleToLongBits(iva) != Double.doubleToLongBits(other.iva))
			return false;
		if (Double.doubleToLongBits(totalFact) != Double.doubleToLongBits(other.totalFact))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	/**
	 * @param codigo
	 * @param fecha
	 * @param iva
	 * @param descuento
	 * @param totalFact
	 * @param usuario
	 * @param facturaDetalle
	 */
	public FacturaCabecera(int codigo, Date fecha, double iva, double descuento, double totalFact, Usuario usuario,
			FacturaDetalle facturaDetalle) {
		this.codigo = codigo;
		this.fecha = fecha;
		this.iva = iva;
		this.descuento = descuento;
		this.totalFact = totalFact;
		this.usuario = usuario;
		this.facturaDetalle = facturaDetalle;
	}


	
}
