package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import ec.edu.ups.ejb.*;
import ec.edu.ups.entidades.*;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class ProvinciaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private ProvinciaFacade ejbProvinciaFacade;
	private List<Provincia> listaProvincia;
	private String nombre;
	private String pais;

	public ProvinciaBean() {

	}

	@PostConstruct
	public void init() {
		listaProvincia = ejbProvinciaFacade.findAll();
	}

	public ProvinciaFacade getEjbProvinciaFacade() {
		return ejbProvinciaFacade;
	}

	public void setEjbProvinciaFacade(ProvinciaFacade ejbProvinciaFacade) {
		this.ejbProvinciaFacade = ejbProvinciaFacade;
	}

	public List<Provincia> getListaProvincia() {
		return listaProvincia;
	}

	public void setListaProvincia(List<Provincia> listaProvincia) {
		this.listaProvincia = listaProvincia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String process() {
		System.out.println("--->" + this.pais);
		return null;
	}
}
