package ec.edu.ups.entidades;

import java.io.Serializable;

import javax.persistence.*;
@Entity
public class Product  implements Serializable{

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;
    private String nombre;
    private double costoUnitario;
	private int cantidadStock;
    @ManyToOne
    private Category categoria;
    @ManyToOne
	private Bodega bodega;
    
    @Transient
    private boolean editable;

    public Product() {

    }

    public Product(String nombre, double costoUnitario,int cantidad) {
	super();
	this.nombre = nombre;
	this.costoUnitario = costoUnitario;
	this.cantidadStock=cantidad;
    }

    
   

	public Product(String nombre, double costoUnitario, int cantidadStock, Category categoria, Bodega bodega) {
		super();
		this.nombre = nombre;
		this.costoUnitario = costoUnitario;
		this.cantidadStock = cantidadStock;
		this.categoria = categoria;
		this.bodega = bodega;
	}

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

    public double getCostoUnitario() {
	return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
	this.costoUnitario = costoUnitario;
    }

    public Category getCategoria() {
	return categoria;
    }

    public void setCategoria(Category categoria) {
	this.categoria = categoria;
    }
    

	public int getCantidadStock() {
		return cantidadStock;
	}

	public void setCantidadStock(int cantidadStock) {
		this.cantidadStock = cantidadStock;
	}

	public Bodega getBodega() {
		return bodega;
	}

	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
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
		result = prime * result + ((bodega == null) ? 0 : bodega.hashCode());
		result = prime * result + cantidadStock;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + codigo;
		long temp;
		temp = Double.doubleToLongBits(costoUnitario);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Product other = (Product) obj;
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
		if (Double.doubleToLongBits(costoUnitario) != Double.doubleToLongBits(other.costoUnitario))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
    public String toString() {
	return "Producto [nombre=" + nombre + ", costoUnitario=" + costoUnitario + "]";
    }

	
}
