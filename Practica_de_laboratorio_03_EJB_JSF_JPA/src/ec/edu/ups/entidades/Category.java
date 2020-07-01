package ec.edu.ups.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Category implements Serializable{

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;
    private String descripcion;
    @OneToMany(mappedBy = "categoria")
    private List<Product> productos;
    @Transient
    private boolean editable;

    
    public Category() {

    }

    public Category(String descripcion) {
	this.descripcion = descripcion;
    }

    public int getCodigo() {
	return codigo;
    }

    public void setCodigo(int codigo) {
	this.codigo = codigo;
    }

    public String getDescripcion() {
	return descripcion;
    }

    public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
    }

    public List<Product> getProductos() {
	return productos;
    }

    public void setProductos(List<Product> productos) {
	this.productos = productos;
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
	Category other = (Category) obj;
	if (codigo != other.codigo)
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return descripcion;
    }
}
