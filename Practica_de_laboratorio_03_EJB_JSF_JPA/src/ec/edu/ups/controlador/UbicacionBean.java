package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.UbicacionFacade;
import ec.edu.ups.entidades.Ubicacion;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class UbicacionBean implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@EJB
	private UbicacionFacade ejbUbicacionFacade;
	private List<Ubicacion> list;
	
	private String pais;
	private String provincia;
	private String ciudad;
	
	
	public UbicacionBean() {
		
	}

	@PostConstruct
    public void init() {
	list = ejbUbicacionFacade.findAll();
    }
	
	
	
	public Ubicacion[] getList() {
		return list.toArray(new Ubicacion[0]);
	}

	public void setList(List<Ubicacion> list) {
		this.list = list;
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

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
		public String add() {
		ejbUbicacionFacade.create(new Ubicacion(this.pais,this.provincia,this.ciudad));
		list = ejbUbicacionFacade.findAll();
		return null;
	    }

	    public String delete(Ubicacion u) {	
	    	ejbUbicacionFacade.remove(u);
		list = ejbUbicacionFacade.findAll();
		return null;
	    }

	    public String edit(Ubicacion u) {
		u.setEditable(true);
		return null;
	    }

	    public String save(Ubicacion u) {
	    	ejbUbicacionFacade.edit(u);
		u.setEditable(false);
		return null;
	    }
}
