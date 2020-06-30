package ec.edu.ups.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Producto
 *
 */
@Entity

public class Producto implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	private String nombrePro;
	private double valorUni;
	private int cantidadStock;
	
	@ManyToOne
	private Categoria categoria;
	@ManyToOne
	private Bodega bodega;
	
	
	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNombrePro() {
		return nombrePro;
	}


	public void setNombrePro(String nombrePro) {
		this.nombrePro = nombrePro;
	}


	public double getValorUni() {
		return valorUni;
	}


	public void setValorUni(double valorUni) {
		this.valorUni = valorUni;
	}


	public int getCantidadStock() {
		return cantidadStock;
	}


	public void setCantidadStock(int cantidadStock) {
		this.cantidadStock = cantidadStock;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public Bodega getBodega() {
		return bodega;
	}


	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bodega == null) ? 0 : bodega.hashCode());
		result = prime * result + cantidadStock;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + codigo;
		result = prime * result + ((nombrePro == null) ? 0 : nombrePro.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valorUni);
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
		Producto other = (Producto) obj;
		if (bodega == null) {
			if (other.bodega != null)
				return false;
		} else if (!bodega.equals(other.bodega))
			return false;
		if (cantidadStock != other.cantidadStock)
			return false;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (codigo != other.codigo)
			return false;
		if (nombrePro == null) {
			if (other.nombrePro != null)
				return false;
		} else if (!nombrePro.equals(other.nombrePro))
			return false;
		if (Double.doubleToLongBits(valorUni) != Double.doubleToLongBits(other.valorUni))
			return false;
		return true;
	}


	
	
	/**
	 * @param codigo
	 * @param nombrePro
	 * @param valorUni
	 * @param cantidadStock
	 * @param categoria
	 * @param bodega
	 */
	public Producto(int codigo, String nombrePro, double valorUni, int cantidadStock, Categoria categoria,
			Bodega bodega) {
		super();
		this.codigo = codigo;
		this.nombrePro = nombrePro;
		this.valorUni = valorUni;
		this.cantidadStock = cantidadStock;
		this.categoria = categoria;
		this.bodega = bodega;
	}


	public Producto() {
		super();
	}
   
}
