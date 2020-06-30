package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.RolFacade;
import ec.edu.ups.entidades.Rol;
import ec.edu.ups.entidades.Usuario;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class RolBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
    @EJB
    private RolFacade ejbRolFacade;
    private List<Rol> list;
    private List<Usuario> usuarios;

    public RolBean() {
        usuarios = new ArrayList<Usuario>();
    }

    @PostConstruct
    public void init() {
        ejbRolFacade.create(new Rol("Javier", "Rol admin", usuarios));
        list = ejbRolFacade.findAll();
    }

    public void setList(List<Rol> list) {
        this.list = list;
    }

    public Rol[] getList() {
        return list.toArray(new Rol[0]);
    }

}
