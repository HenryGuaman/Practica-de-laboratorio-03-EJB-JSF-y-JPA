package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.RolFacade;
import ec.edu.ups.ejb.UsuarioFacade;
import ec.edu.ups.entidades.Rol;
import ec.edu.ups.entidades.Usuario;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class UsuarioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private UsuarioFacade ejbUsuarioFacade;
	@EJB
	private RolFacade ejbRolFacade;
	private List<Rol> roles;
	private String cargo;
	
	private List<Usuario> list; 
	private List<Usuario> listEmpleados;
	private List<Usuario> listClientes;
	private String nombre;
	private String apellido;
	private String cedula;
	private String correo;
	private String passw;

	public UsuarioBean() {
		
	}
	
	@PostConstruct
	public void init() {
		list = ejbUsuarioFacade.findAll();
		roles=ejbRolFacade.findAll();
		listEmpleados = ejbUsuarioFacade.listarEmpleados(2);
		listClientes = ejbUsuarioFacade.listarClientes(3);
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassw() {
		return passw;
	}

	public void setPassw(String passw) {
		this.passw = passw;
	}
	
	public Usuario[] getlist(){
		return list.toArray(new Usuario[0]);
	}
	
	public void setList(List<Usuario> list) {
		this.list=list;
	}

	
	public Usuario[] getListEmpleados() {
		return listEmpleados.toArray(new Usuario[0]);
	}

	public void setListEmpleados(List<Usuario> listEmpleados) {
		this.listEmpleados = listEmpleados;
	}

	public Usuario[] getListClientes() {
		return listClientes.toArray(new Usuario[0]);
	}

	public void setListClientes(List<Usuario> listClientes) {
		this.listClientes = listClientes;
	}
	

	public UsuarioFacade getEjbUsuarioFacade() {
		return ejbUsuarioFacade;
	}

	public void setEjbUsuarioFacade(UsuarioFacade ejbUsuarioFacade) {
		this.ejbUsuarioFacade = ejbUsuarioFacade;
	}

	public RolFacade getEjbRolFacade() {
		return ejbRolFacade;
	}

	public void setEjbRolFacade(RolFacade ejbRolFacade) {
		this.ejbRolFacade = ejbRolFacade;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public List<Usuario> getList() {
		return list;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	//CRUD
	public String addCliente() {
		
		Rol cliente=ejbRolFacade.readRol(cargo);
		ejbUsuarioFacade.create(new Usuario(this.nombre,this.apellido,this.cedula,this.correo,this.passw,cliente));
		list = ejbUsuarioFacade.findAll();
		return null;
	}
	
	
	public String addEmpleado() {
		Rol empleado=ejbRolFacade.readRol(cargo);
		ejbUsuarioFacade.create(new Usuario(this.nombre,this.apellido,this.cedula,this.correo,this.passw,empleado));
		listEmpleados = ejbUsuarioFacade.listarEmpleados(2);
		return null;
	}
	
	public String addAdmin() {
		Rol admin=ejbRolFacade.readRol(cargo);
		ejbUsuarioFacade.create(new Usuario(this.nombre,this.apellido,this.cedula,this.correo,this.passw,admin));
		list = ejbUsuarioFacade.findAll();
		return null;
	}
	
	
	public String iniciarSesion() {
		Usuario usuario = ejbUsuarioFacade.readCorreo(this.correo, this.passw);
		if(usuario != null) {
			if(usuario.getRol().getCodigo()==1) {
				return "crearEmpleados";
			}
		}
		return null;
	}
	
	public String delete(Usuario usuario) {
		ejbUsuarioFacade.remove(usuario);
		list = ejbUsuarioFacade.findAll();
		return null;
	}
	
	public String deleteEmpleado(Usuario usuario) {
		ejbUsuarioFacade.remove(usuario);
		listEmpleados = ejbUsuarioFacade.listarEmpleados(2);
		return null;
	}
	
	
	
	public String edit (Usuario usuario) {
		usuario.setEditable(true);
		return null;
	}
	
	public String save (Usuario usuario) {
		ejbUsuarioFacade.edit(usuario);
		usuario.setEditable(false);
		return null;
	}
}
