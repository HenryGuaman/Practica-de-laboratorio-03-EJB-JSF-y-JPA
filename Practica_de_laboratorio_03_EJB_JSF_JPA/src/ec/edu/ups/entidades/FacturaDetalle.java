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
	private Product product;

	public FacturaDetalle(){}

    public FacturaDetalle(int cantidad, double total, FacturaCabecera facturaCabecera, Product product) {

        this.cantidad = cantidad;
        this.total = total;
        this.facturaCabecera = facturaCabecera;
        this.product = product;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidad;
		result = prime * result + numDetalle;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FacturaDetalle{" + "numDetalle=" + numDetalle + ", cantidad=" + cantidad + ", total=" + total
				+ ", facturaCabecera=" + facturaCabecera + ", product=" + product + '}';
	}
}
