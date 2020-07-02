package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.RolFacade;
import ec.edu.ups.entidades.Rol;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class RolBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
    @EJB
    private RolFacade ejbRolFacade;
	private List<Rol> list;
	private String cargo;
	
	public RolBean() {
		
	}
	
	@PostConstruct
	public void init() {
		list = ejbRolFacade.findAll();
	}
	
	public Rol[] getList() {
		return list.toArray(new Rol[0]);
	}
	
	public void setList(List<Rol> list) {
		this.list=list;
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public String add() {
		ejbRolFacade.create(new Rol(this.cargo));
		list = ejbRolFacade.findAll();
		return null;
	}
	
	public String delete (Rol rol) {
		ejbRolFacade.remove(rol);
		list = ejbRolFacade.findAll();
		return null;
	}
	
	public String edit(Rol rol) {
		rol.setEditable(true);
		return null;
	}
	
	public String save(Rol rol) {
		ejbRolFacade.edit(rol);
		rol.setEditable(false);
		return null;
	}
}
