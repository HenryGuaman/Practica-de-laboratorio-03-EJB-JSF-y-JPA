package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.ProductFacade;
import ec.edu.ups.entidades.Product;



@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class ProductosBean implements Serializable{
	
	 private static final long serialVersionUID = 1L;

	    @EJB
	    private ProductFacade ejbProductFacade;
	    private List<Product> list;
	    
	    private String nombre;
	    private double costoUnitario;
	    private int cantidadStock;

	    public ProductosBean() {

	    }    
	    
	    @PostConstruct
	    public void init() {
	    ejbProductFacade.create(new Product("Papel Higenico",0.20,10));
	    ejbProductFacade.create(new Product("cepillo",0.20,10));
	    
		list = ejbProductFacade.findAll();
	    }
	        
	    public Product[] getList() {
		return list.toArray(new Product[0]);
	    }

	    public void setList(List<Product> list) {
		this.list = list;
	    }

	    public String getnombre() {
		return nombre;
	    }

	    
	    public void setnombre(String nombre) {
		this.nombre = nombre;
	    }
	    

	    
		public double getCostoUnitario() {
			return costoUnitario;
		}

		/**
		 * @param costoUnitario the costoUnitario to set
		 */
		public void setCostoUnitario(double costoUnitario) {
			this.costoUnitario = costoUnitario;
		}

		/**
		 * @return the cantidad
		 */
		public int getCantidadStock() {
			return cantidadStock;
		}

		/**
		 * @param cantidad the cantidad to set
		 */
		public void setCantidadStock(int cantidad) {
			this.cantidadStock = cantidad;
		}

		/**
		 * @return the serialversionuid
		 */
		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		public String add() {
	    ejbProductFacade.create(new Product(this.nombre,this.costoUnitario,this.cantidadStock));
		list = ejbProductFacade.findAll();
		return null;
	    }

	    public String delete(Product p) {	
	    	ejbProductFacade.remove(p);
		list = ejbProductFacade.findAll();
		return null;
	    }

	    public String edit(Product p) {
		p.setEditable(true);
		return null;
	    }

	    public String save(Product p) {
	    	ejbProductFacade.edit(p);
		p.setEditable(false);
		return null;
	    }


}