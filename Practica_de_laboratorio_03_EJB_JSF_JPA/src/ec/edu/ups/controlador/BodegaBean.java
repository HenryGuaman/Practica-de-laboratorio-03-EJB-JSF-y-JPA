package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ec.edu.ups.ejb.BodegaFacade;
import ec.edu.ups.ejb.UbicacionFacade;
import ec.edu.ups.entidades.Bodega;
import ec.edu.ups.entidades.Ubicacion;

@Named
@SessionScoped
public class BodegaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private BodegaFacade ejbBodegaFacade;
	private List<Bodega> list;
	private String nombre;
	@EJB
	private UbicacionFacade ejbUbicacionFacade;
	private List<Ubicacion> ubicacion;
	private String pais;
	private String provincia;
	private String ciudad;
	
	public BodegaBean() {
		
	}
	
	@PostConstruct
    public void init() {
		System.out.println("Ya entro al init de la bodega");
		
		list = ejbBodegaFacade.findAll();
		ubicacion=ejbUbicacionFacade.findAll();
	}
	
	public String addBodega() {
		Ubicacion ubi=ejbUbicacionFacade.readUbicacion(ciudad);
		ejbBodegaFacade.create(new Bodega(this.nombre,ubi));
		list = ejbBodegaFacade.findAll();
		return null;
	}
	
	/**
	public String add() {
		ejbBodegaFacade.create(new Bodega(this.nombre));
		list = ejbBodegaFacade.findAll();
		return null;
	}**/

	    public String delete(Bodega p) {	
	    ejbBodegaFacade.remove(p);
		list = ejbBodegaFacade.findAll();
		return null;
	    }

	    public String edit(Bodega p) {
		p.setEditable(true);
		return null;
	    }

	    public String save(Bodega p) {
	    	ejbBodegaFacade.edit(p);
		p.setEditable(false);
		return null;
	    }

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public BodegaFacade getEjbBodegaFacade() {
			return ejbBodegaFacade;
		}

		public void setEjbBodegaFacade(BodegaFacade ejbBodegaFacade) {
			this.ejbBodegaFacade = ejbBodegaFacade;
		}

		public UbicacionFacade getEjbUbicacionFacade() {
			return ejbUbicacionFacade;
		}

		public void setEjbUbicacionFacade(UbicacionFacade ejbUbicacionFacade) {
			this.ejbUbicacionFacade = ejbUbicacionFacade;
		}

		public List<Bodega> getList() {
			return list;
		}

		public void setList(List<Bodega> list) {
			this.list = list;
		}

		public List<Ubicacion> getUbicacion() {
			return ubicacion;
		}

		public void setUbicacion(List<Ubicacion> ubicacion) {
			this.ubicacion = ubicacion;
		} 

		public String getCiudad() {
			return ciudad;
		}

		public void setCiudad(String ciudad) {
			this.ciudad = ciudad;
		}

		public String getPais() {
			return pais;
		}

		public void setPais(String pais) {
			this.pais = pais;
		}

		public String getProvincia() {
			return provincia;
		}

		public void setProvincia(String provincia) {
			this.provincia = provincia;
		}

	    
	    
}
