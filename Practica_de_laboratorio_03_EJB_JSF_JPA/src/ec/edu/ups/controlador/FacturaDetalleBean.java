package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import ec.edu.ups.ejb.*;
import ec.edu.ups.entidades.FacturaCabecera;
import ec.edu.ups.entidades.FacturaDetalle;
import ec.edu.ups.entidades.Producto;
import ec.edu.ups.entidades.Usuario;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class FacturaDetalleBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	private FacturaCabeceraFacade ejbFacturaCabeceraFacade;
	@EJB
	private FacturaDetalleFacade ejbFacturaDetalleFacade;
	@EJB
	private ProductFacade ejbProductoFacade;
	private UsuarioFacade personaFacade;

	private int cantidad;
	private String nombre1;
	private String descripcion;
	private double pun;
	private double ppu;
	private int stock;
	private String categoria;
	private double subtotal;
	private double total;
	private Producto prod;
	private FacturaCabecera faccabe;
	private FacturaDetalle facdeta;
	private double iva;
	private double descuento;
	private String producto;
	private String persona;
	private String fecha;
	private Set<Producto> listproducto = new HashSet<Producto>();
	private Set<Row> lista = new HashSet<Row>();

	private List<FacturaDetalle> facdetalle;
	private List<FacturaCabecera> faccabecera;

	public FacturaDetalleBean() {

	}

	@PostConstruct
	public void init() {
		this.prod = new Producto();
		this.faccabe = new FacturaCabecera();
		this.facdeta = new FacturaDetalle();

	}

	public ProductFacade getEjbProductoFacade() {
		return ejbProductoFacade;
	}

	public void setEjbProductoFacade(ProductFacade ejbProductoFacade) {
		this.ejbProductoFacade = ejbProductoFacade;
	}

	public UsuarioFacade getPersonaFacade() {
		return personaFacade;
	}

	public void setPersonaFacade(UsuarioFacade personaFacade) {
		this.personaFacade = personaFacade;
	}

	public String getPersona() {
		return persona;
	}

	public void setPersona(String persona) {
		this.persona = persona;
	}

	public FacturaCabeceraFacade getEjbFacturaCabeceraFacade() {
		return ejbFacturaCabeceraFacade;
	}

	public void setProd(Producto prod) {
		this.prod = prod;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public List<FacturaCabecera> getFaccabecera() {
		return faccabecera;
	}

	public void setFaccabecera(List<FacturaCabecera> faccabecera) {
		this.faccabecera = faccabecera;
	}

	public FacturaDetalle getFacdeta() {
		return facdeta;
	}

	public void setFacdeta(FacturaDetalle facdeta) {
		this.facdeta = facdeta;
	}

	public void setEjbFacturaCabeceraFacade(FacturaCabeceraFacade ejbFacturaCabeceraFacade) {
		this.ejbFacturaCabeceraFacade = ejbFacturaCabeceraFacade;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public FacturaCabecera getFaccabe() {
		return faccabe;
	}

	public void setFaccabe(FacturaCabecera faccabe) {
		this.faccabe = faccabe;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public String getNombre() {
		return nombre1;
	}

	public void setNombre(String nombre) {
		this.nombre1 = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPun() {
		return pun;
	}

	public void setPun(double pun) {
		this.pun = pun;
	}

	public double getPpu() {
		return ppu;
	}

	public void setPpu(double ppu) {
		this.ppu = ppu;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getTotalparcial() {
		return total;
	}

	public void setTotalparcial(double totalparcial) {
		this.total = totalparcial;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public FacturaDetalleFacade getEjbFacturaDetalleFacade() {
		return ejbFacturaDetalleFacade;
	}

	public void setEjbFacturaDetalleFacade(FacturaDetalleFacade ejbFacturaDetalleFacade) {
		this.ejbFacturaDetalleFacade = ejbFacturaDetalleFacade;
	}

	public String getNombre1() {
		return nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	public Set<Producto> getListproducto() {
		return listproducto;
	}

	public void setListproducto(Set<Producto> listproducto) {
		this.listproducto = listproducto;
	}

	public Set<Row> getLista() {
		return lista;
	}

	public void setLista(Set<Row> lista) {
		this.lista = lista;
	}

	public List<FacturaDetalle> getFacdetalle() {
		return facdetalle;
	}

	public void setFacdetalle(List<FacturaDetalle> facdetalle) {
		this.facdetalle = facdetalle;
	}

	public String add() {

		faccabe.setFecha(this.fecha);
		faccabe.setFacturacab(buscarPersonanombre());
		;
		faccabe.setEstado("activo");
		ejbFacturaCabeceraFacade.create(faccabe);
		ejbFacturaDetalleFacade.create(new FacturaDetalle(this.cantidad, this.subtotal, this.total, 0, buscarpro()));
		faccabe.addFacturaDetalle(facdeta);
		return null;
	}

	public String edit(Producto p) {
		p.setEditable(true);
		return null;
	}

	public String save(Producto p) {
		ejbProductoFacade.edit(p);
		p.setEditable(false);
		return null;
	}

	public Producto buscarpro() {

		System.out.println(producto);
		prod = ejbFacturaDetalleFacade.buscarProductos(producto);
		String nombre = prod.getNombre();
		listproducto.add(prod);
		System.out.println("EL nombre es:" + nombre);
		return prod;

	}

	public Usuario buscarPersonanombre() {

		System.out.println("recupero la person" + persona);
		Usuario usu = new Usuario();
		usu = ejbFacturaDetalleFacade.buscarpersona(persona);
		System.out.println("Nombre es:" + usu);
		return usu;

	}

	public Producto getProd() {
		return prod;
	}

	public double calcularTotalParcial() {

		if (this.cantidad > 1) {
			if (this.cantidad != 0) {

				this.subtotal = prod.getCostoUnitario() * this.cantidad;
				System.out.println(subtotal);
				System.out.println(this.subtotal);

			}
		}

		return this.subtotal;
	}

	public double calcularIva() {

		if (this.subtotal != 0) {

			this.iva = 0.12 * this.subtotal;
			System.out.println("Subtotal mas Iva es:" + this.iva);
			System.out.println(" Iva es:" + this.iva);
		}
		return this.iva;
	}

	public double calculartotalFinal() {

		double aux = 0;
		this.total = this.subtotal + this.iva;
		System.out.println("El total a pagar es: " + total);

		for (Row lis : lista) {

			System.out.println("Hola " + lis.getSubtotal());
			aux = aux + lis.getSubtotal();
			calcularIva();
		}

		return this.total;
	}

	public void agregar() {

		System.out.println(producto);
		prod = ejbFacturaDetalleFacade.buscarProductos(producto);
		String nombre = prod.getNombre();
		System.out.println("EL nombre es:" + nombre);
		nombre1 = prod.getNombre();
		pun = prod.getCostoUnitario();
		stock = prod.getCantidadStock();
		subtotal = calcularTotalParcial();

		this.nombre1 = prod.getNombre();
		this.pun = prod.getCostoUnitario();
		this.stock = prod.getCantidadStock();

		calcularTotalParcial();
		calcularIva();
		calculartotalFinal();

		if (this.cantidad <= this.stock) {

			this.lista.add(new Row(nombre1, descripcion, pun, stock, this.cantidad));
			this.lista.add(new Row(nombre1, descripcion, pun, stock, this.cantidad, subtotal));
			System.out.println();

			prod.setCantidadStock(this.stock - this.cantidad);
			ejbProductoFacade.edit(prod);
			calcularTotalParcial();
			calculartotalFinal();
			calcularIva();
		} else {
			System.out.println("No hay suficientes productos");
		}
		System.out.println("La Lista de productos es: " + lista);

	}

}