package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
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
	
	private UbicacionFacade ejbUbicacionFacade;
	
	private List<Ubicacion> list;

	public UbicacionBean() {
		
	}

	@PostConstruct
    public void init() {
	//ejbCategoryFacade.create(new Category("Hola"));
	//ejbCategoryFacade.create(new Category("1211"));
	list = ejbUbicacionFacade.findAll();
    }
	
	public Ubicacion[] getList() {
		return list.toArray(new Ubicacion[0]);
	}

	public void setList(List<Ubicacion> list) {
		this.list = list;
	}
	

}
