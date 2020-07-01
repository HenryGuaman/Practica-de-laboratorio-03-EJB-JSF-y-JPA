package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.event.AjaxBehaviorEvent;
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
	private List<String> listProvincia = new ArrayList<String>();
	private List<String> listCiudad = new ArrayList<String>();
	
	
	public UbicacionBean() {
		
	}

	@PostConstruct
    public void init() {
	ejbUbicacionFacade.create(new Ubicacion("Ecuador","Azuay","Cuenca"));
	ejbUbicacionFacade.create(new Ubicacion("Colombia","Cali","Barranquilla"));
	
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

	public List<String> getListProvincia() {
		return listProvincia;
	}

	public void setListProvincia(List<String> listProvincia) {
		this.listProvincia = listProvincia;
	}

	public List<String> getListCiudad() {
		return listCiudad;
	}

	public void setListCiudad(List<String> listCiudad) {
		this.listCiudad = listCiudad;
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
	
	
	public void cargarProvincia(AjaxBehaviorEvent event) {
		System.out.println("Entrando a provincias");
		if (this.pais == "Ecuador") {
			listProvincia.add("Pichincha");
    		listProvincia.add("Azuay");
		}else if (this.pais == "Ecuador") {
			listProvincia.add("Pichincha");
    		listProvincia.add("Azuay");
		}
		
    }
	
	/**
    public void cargarProvincias(AjaxBehaviorEvent event) {
    	switch (codPais) {
    	case "1":
    		//Ecuador
    		listProvincia.add("Pichincha");
    		listProvincia.add("Azuay");
    		break;
    	case "2":
    		//Colombia
    		listProvincia.add("Antioquia");
    		listProvincia.add("Atlantico");
    		
    	break;
    	}
    }**/
}
