package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import ec.edu.ups.ejb.*;
import ec.edu.ups.entidades.FacturaCabecera;
import ec.edu.ups.entidades.FacturaDetalle;
import ec.edu.ups.entidades.Product;
import ec.edu.ups.entidades.Usuario;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class FacturaDetalleBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Set<Row> list = new HashSet<Row>();

	private int id;
	private String name;
	private int quantity;
	private double precio;
	private double subtotal;
	private String busqueda;
	private int disminuir;

	@EJB
	private ProductFacade ejbProductoFacade;

	private Product producto;
	private Double subtotalcabecera;
	private int fila;
	private double descuento;
	private double iva;
	private double totalpagar;

	@EJB
	private UsuarioFacade ejbUsuarioFacade;
	@EJB
	private FacturaCabeceraFacade ejbFacturaCabeceraFacade;

	@EJB
	private FacturaDetalleFacade ejbFacturaDetalleFacade;

	private Usuario usuario;
	private String cedula;
	private String mensaje;
	private String nombre;
	private String apellido;
	private String direccion;
	private String celular;
	private String correo;

	public FacturaDetalleBean() {
		this.fila = 1;
	}

	@PostConstruct
	public void init() {
	}

	public String add() {
		producto = ejbProductoFacade.buscarProducto(name);
		if (producto.getCantidadStock() != 0) {
			this.id = producto.getCodigo();
			this.name = producto.getNombre();
			this.precio = producto.getCostoUnitario();
			this.subtotal = this.quantity * producto.getCostoUnitario();
			this.busqueda = "producto encontrado : stock : " + producto.getCantidadStock();
			this.list.add(new Row(id, name, quantity, precio, subtotal));
			this.subtotalcabecera = 0.0;
			for (Row p : list) {
				subtotalcabecera = subtotalcabecera + p.getSubtotal();
			}
			this.descuento = 0.00;
			this.iva = subtotalcabecera * 0.12;
			this.totalpagar = this.iva + subtotalcabecera;
		} else
			this.busqueda = "producto no encontrado : sin stock : ";
		{

		}
		return null;
	}

	public String getBusqueda() {
		return busqueda;
	}

	public void setBusqueda(String busqueda) {
		this.busqueda = busqueda;
	}

	public int getDisminuir() {
		return disminuir;
	}

	public void setDisminuir(int disminuir) {
		this.disminuir = disminuir;
	}

	public ProductFacade getEjbProductoFacade() {
		return ejbProductoFacade;
	}

	public void setEjbProductoFacade(ProductFacade ejbProductoFacade) {
		this.ejbProductoFacade = ejbProductoFacade;
	}

	public Product getProducto() {
		return producto;
	}

	public void setProducto(Product producto) {
		this.producto = producto;
	}

	public UsuarioFacade getEjbUsuarioFacade() {
		return ejbUsuarioFacade;
	}

	public void setEjbUsuarioFacade(UsuarioFacade ejbUsuarioFacade) {
		this.ejbUsuarioFacade = ejbUsuarioFacade;
	}

	public FacturaCabeceraFacade getEjbFacturaCabeceraFacade() {
		return ejbFacturaCabeceraFacade;
	}

	public void setEjbFacturaCabeceraFacade(FacturaCabeceraFacade ejbFacturaCabeceraFacade) {
		this.ejbFacturaCabeceraFacade = ejbFacturaCabeceraFacade;
	}

	public FacturaDetalleFacade getEjbFacturaDetalleFacade() {
		return ejbFacturaDetalleFacade;
	}

	public void setEjbFacturaDetalleFacade(FacturaDetalleFacade ejbFacturaDetalleFacade) {
		this.ejbFacturaDetalleFacade = ejbFacturaDetalleFacade;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String edit(Row t) {
		t.setEditable(true);
		return null;
	}

	public Row[] getList() {
		return list.toArray(new Row[0]);
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public void setList(Set<Row> list) {
		this.list = list;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public Double getSubtotalcabecera() {
		return subtotalcabecera;
	}

	public void setSubtotalcabecera(Double subtotalcabecera) {
		this.subtotalcabecera = subtotalcabecera;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public double getTotalpagar() {
		return totalpagar;
	}

	public void setTotalpagar(double totalpagar) {
		this.totalpagar = totalpagar;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	// metodo para presentar si se encuentra la persona
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
	public void crearPersona() {
		System.out.println("ha llegado a crear una persona");
		System.out.println(cedula + nombre + apellido + direccion + celular);
		Usuario usuario = new Usuario(this.cedula, this.nombre, this.apellido, this.correo, null);
		System.out.println("--->" + usuario.toString());
		ejbUsuarioFacade.create(usuario);
		this.mensaje = "usuario registrado exitosamente";
	}

	public void crearFactura() {

		System.out.println("Esta es la persona a registar cedula :: " + this.cedula);
		GregorianCalendar c1 = (GregorianCalendar) GregorianCalendar.getInstance();
		FacturaCabecera facturaCabecera = new FacturaCabecera(c1, 'N', this.descuento, this.subtotalcabecera, this.iva,
				this.totalpagar, this.usuario);
		ejbFacturaCabeceraFacade.create(facturaCabecera);
		System.out.println("Se ha creado una factura cabecera");

		for (Row p : list) {
			producto = ejbProductoFacade.find(p.getId());
			disminuir = 0;
			disminuir = producto.getCantidadStock() - p.getQuantity();
			producto.setCantidadStock(disminuir);
			ejbProductoFacade.edit(producto);
			ejbFacturaDetalleFacade
					.create(new FacturaDetalle(p.getQuantity(), p.getSubtotal(), facturaCabecera, producto));
		}
		System.out.println("Se creo todos los detalles y se disminuyo el stock");

		this.mensaje = "se ha creado exitosamente la factura";
	}

	public String save(Row t) {
		t.setEditable(false);
		this.subtotalcabecera = 0.0;
		for (Row p : list) {
			subtotalcabecera = subtotalcabecera + p.getSubtotal();
		}
		this.descuento = 0.00;
		this.iva = subtotalcabecera * 0.12;
		this.totalpagar = this.iva + subtotalcabecera;
		return null;
	}

	public String delete(Row t) {
		this.list.remove(t);
		this.subtotalcabecera = 0.0;
		for (Row p : list) {
			subtotalcabecera = subtotalcabecera + p.getSubtotal();
		}
		this.descuento = 0.00;
		this.iva = subtotalcabecera * 0.12;
		this.totalpagar = this.iva + subtotalcabecera;
		return null;
	}

}