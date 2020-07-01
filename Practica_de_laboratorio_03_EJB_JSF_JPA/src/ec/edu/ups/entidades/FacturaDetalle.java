package ec.edu.ups.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: FacturaDetalle
 *
 */
@Entity

public class FacturaDetalle implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int numDetalle;
	private int cantidad;
	private double total;

	@ManyToOne
	private FacturaCabecera facturaCabecera;

	@ManyToOne
	private Producto producto;

	public FacturaDetalle() {

	}

	public FacturaDetalle(int numDetalle, int cantidad, double total, Producto producto) {
		this.numDetalle = numDetalle;
		this.cantidad = cantidad;
		this.total = total;
		this.producto = producto;
	}

	public int getNumDetalle() {
		return numDetalle;
	}

	public void setNumDetalle(int numDetalle) {
		this.numDetalle = numDetalle;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidad;
		result = prime * result + numDetalle;
		result = prime * result + ((producto == null) ? 0 : producto.hashCode());
		long temp;
		temp = Double.doubleToLongBits(total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		FacturaDetalle other = (FacturaDetalle) obj;
		if (cantidad != other.cantidad)
			return false;
		if (numDetalle != other.numDetalle)
			return false;
		if (producto == null) {
			if (other.producto != null)
				return false;
		} else if (!producto.equals(other.producto))
			return false;
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FacturaDetalle{" + "numDetalle=" + numDetalle + ", cantidad=" + cantidad + ", total=" + total
				+ ", facturaCabecera=" + facturaCabecera + ", producto=" + producto + '}';
	}
}
