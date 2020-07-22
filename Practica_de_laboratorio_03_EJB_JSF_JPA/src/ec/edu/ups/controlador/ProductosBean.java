package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.BodegaFacade;
import ec.edu.ups.ejb.CategoriaFacade;
import ec.edu.ups.ejb.ProductoFacade;
import ec.edu.ups.entidades.Bodega;
import ec.edu.ups.entidades.Categoria;
import ec.edu.ups.entidades.Producto;



@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class ProductosBean implements Serializable{
	
	 private static final long serialVersionUID = 1L;

	    @EJB
	    private ProductoFacade ejbProductFacade;
	    
	    @EJB 
	    private CategoriaFacade ejbCategoryFacade;
	    
	    
	    @EJB
	    private BodegaFacade ejbBodegaFacade;
	    
	    
	    private List<Producto> list;
	    
	    private List<Categoria> categorias;
	    private List<Bodega> bodegas;
	    
	    
	    
	    private String nombre;
	    private String nombreBodega;
	    
	    private String nombreCategoria;
	    private double costoUnitario;
	    private int cantidadStock;
	    
	    public ProductosBean() {

	    }    
	    
	    @PostConstruct
	    public void init() {
	  //  ejbProductFacade.create(new Product("Papel Higenico",0.20,10));
	   // ejbProductFacade.create(new Product("cepillo",0.20,10));
	    categorias=ejbCategoryFacade.findAll();
		list = ejbProductFacade.findAll();
		bodegas = ejbBodegaFacade.findAll();
		
	    }
	        
	    

	    /**
		 * @return the list
		 */
		public List<Producto> getList() {
			return list;
		}

		/**
		 * @param list the list to set
		 */
		public void setList(List<Producto> list) {
			this.list = list;
		}

		public String getnombre() {
		return nombre;
	    }

	    
	    public void setnombre(String nombre) {
		this.nombre = nombre;
	    }
	    

		public String getNombreBodega() {
			return nombreBodega;
		}

		public void setNombreBodega(String nombreBodega) {
			this.nombreBodega = nombreBodega;
		}

		public ProductoFacade getEjbProductFacade() {
			return ejbProductFacade;
		}

		/**
		 * @param ejbProductFacade the ejbProductFacade to set
		 */
		public void setEjbProductFacade(ProductoFacade ejbProductFacade) {
			this.ejbProductFacade = ejbProductFacade;
		}

		/**
		 * @return the ejbCategoryFacade
		 */
		public CategoriaFacade getEjbCategoryFacade() {
			return ejbCategoryFacade;
		}

		/**
		 * @param ejbCategoryFacade the ejbCategoryFacade to set
		 */
		public void setEjbCategoryFacade(CategoriaFacade ejbCategoryFacade) {
			this.ejbCategoryFacade = ejbCategoryFacade;
		}

		/**
		 * @return the categorias
		 */
		public List<Categoria> getCategorias() {
			return categorias;
		}

		/**
		 * @param categorias the categorias to set
		 */
		public void setCategorias(List<Categoria> categorias) {
			this.categorias = categorias;
		}

		/**
		 * @return the nombre
		 */
		public String getNombre() {
			return nombre;
		}

		/**
		 * @param nombre the nombre to set
		 */
		public void setNombre(String nombre) {
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

		public BodegaFacade getEjbBodegaFacade() {
			return ejbBodegaFacade;
		}

		public void setEjbBodegaFacade(BodegaFacade ejbBodegaFacade) {
			this.ejbBodegaFacade = ejbBodegaFacade;
		}

		public List<Bodega> getBodegas() {
			return bodegas;
		}

		public void setBodegas(List<Bodega> bodegas) {
			this.bodegas = bodegas;
		}
		

		public String getNombreCategoria() {
			return nombreCategoria;
		}

		public void setNombreCategoria(String nombreCategoria) {
			this.nombreCategoria = nombreCategoria;
		}

		public String add() {
		Categoria cat=ejbCategoryFacade.readCategory(nombreCategoria);
		Bodega bodeg=ejbBodegaFacade.readBodega(nombreBodega);
	    ejbProductFacade.create(new Producto(this.nombre,this.costoUnitario,this.cantidadStock,cat,bodeg));
		list = ejbProductFacade.findAll();
		return null;
	    }

	    public String delete(Producto p) {	
	    ejbProductFacade.remove(p);
		list = ejbProductFacade.findAll();
		return null;
	    }

	    public String edit(Producto p) {
		p.setEditable(true);
		return null;
	    }

	    public String save(Producto p) {
	    	ejbProductFacade.edit(p);
		p.setEditable(false);
		return null;
	    }
	    
	    


}
