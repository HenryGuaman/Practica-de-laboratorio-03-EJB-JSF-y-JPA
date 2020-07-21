package ec.edu.ups.controlador;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import ec.edu.ups.ejb.FacturaCabeceraFacade;
import ec.edu.ups.ejb.UsuarioFacade;
import ec.edu.ups.entidades.Usuario;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class FacturaCabeceraBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private UsuarioFacade ejbUsuarioFacade;
	@EJB
	private FacturaCabeceraFacade ejbFacturaCabeceraFacade;
	private Usuario usuario;
	private String cedula;
	private String mensaje;
	private String nombre;
	private String apellido;
	private String correo;

	public FacturaCabeceraBean(){
	    }

	@PostConstruct

	public void init() {

	}

	

	public String getCedula() {
		return cedula;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
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

	public FacturaCabeceraFacade getEjbFacturaCabeceraFacade() {
		return ejbFacturaCabeceraFacade;
	}

	public void setEjbFacturaCabeceraFacade(FacturaCabeceraFacade ejbFacturaCabeceraFacade) {
		this.ejbFacturaCabeceraFacade = ejbFacturaCabeceraFacade;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void mensaje() {
		usuario = ejbUsuarioFacade.find(this.cedula);
		if ("".equals(this.cedula) || !this.cedula.equals(usuario.getCedula())) {
			this.mensaje = "no se encontro ningun usuario ";
		} else {
			this.mensaje = "usuario encontrado";
			this.nombre = usuario.getNombre();
			this.apellido = usuario.getApellido();
			this.correo = usuario.getCorreo();
		}
	}

	// metodo para registrar una usuario a facturar
	public void crearUsuario() {
		System.out.println("ha llegado a crear una usuario");
		System.out.println(cedula + nombre + apellido + correo);
		ejbUsuarioFacade.create(new Usuario(this.cedula, this.nombre, this.apellido, this.correo, null));
		this.mensaje = "usuario registrado exitosamente";
	}

}