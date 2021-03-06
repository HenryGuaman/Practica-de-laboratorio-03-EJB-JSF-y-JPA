package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.ArrayList;
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
public class ProductosBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	private ProductoFacade ejbProductoFacade;
	private CategoriaFacade ejbCategoriaFacade;
	@EJB
	private StockFacade ejbStockFacade;
	private String nombre;
	private String descripcion;
	private double preciounitario;
	private double preciopublico;
	private String categoria;
	private List<Producto> listaProductos;
	private List<Producto> listaProductos1;
	private Producto producto;
	private Stock stock1;
	private int stock;
	private String bodega;
	private Roww roww;
	
	public ProductosBean() {
			
		}

	@PostConstruct
	public void init() {
		this.producto = new Producto();
		this.stock1 = new Stock();
		listaProductos = ejbProductoFacade.findAll();
		new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}
	
	public ProductoFacade getEjbProductoFacade() {
		return ejbProductoFacade;
	}

	public void setEjbProductoFacade(ProductoFacade ejbProductoFacade) {
		this.ejbProductoFacade = ejbProductoFacade;
	}

	public CategoriaFacade getEjbCategoriaFacade() {
		return ejbCategoriaFacade;
	}

	public void setEjbCategoriaFacade(CategoriaFacade ejbCategoriaFacade) {
		this.ejbCategoriaFacade = ejbCategoriaFacade;
	}

	public StockFacade getEjbStockFacade() {
		return ejbStockFacade;
	}

	public void setEjbStockFacade(StockFacade ejbStockFacade) {
		this.ejbStockFacade = ejbStockFacade;
	}

	public Roww getRow() {
		return roww;
	}

	public void setRow(Roww roww) {
		this.roww = roww;
	}

	public void setList(List<Roww> list) {
	}

	public Stock getStock1() {
		return stock1;
	}

	public void setStock1(Stock stock1) {
		this.stock1 = stock1;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPreciounitario() {
		return preciounitario;
	}

	public void setPreciounitario(double preciounitario) {
		this.preciounitario = preciounitario;
	}

	public double getPreciopublico() {
		return preciopublico;
	}

	public void setPreciopublico(double preciopublico) {
		this.preciopublico = preciopublico;
	}

	public Producto[] getListaProductos() {
		return listaProductos.toArray(new Producto[0]);
	}

	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public String getCategoria() {

		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getBodega() {
		return bodega;
	}

	public void setBodega(String bodega) {
		this.bodega = bodega;
	}

	public String add() {
		try {
			Producto pro = new Producto(this.nombre, this.descripcion, this.preciounitario, this.preciopublico,
					buscar(), this.stock);
			System.out.println(pro);
			ejbProductoFacade.create(pro);

			listaProductos = ejbProductoFacade.findAll();
			Stock sto = new Stock(bode(), pro);
			ejbStockFacade.create(sto);
			listaProductos = ejbProductoFacade.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return null;
	}

	public String delete(Producto p) {
		ejbProductoFacade.remove(p);
		listaProductos = ejbProductoFacade.findAll();
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

	public List<Producto> getListaProductos1() {
		return listaProductos1;
	}

	public void setListaProductos1(List<Producto> listaProductos1) {
		this.listaProductos1 = listaProductos1;
	}

	public Categoria buscar() {
		System.out.println(categoria);
		Categoria ca = new Categoria();
		ca = ejbProductoFacade.validar(categoria);
		System.out.println(ca.toString());
		System.out.println(ca.getId());
		return ca;
	}

	public Categoria buscarProductos() {
		System.out.println(categoria);
		System.out.println("Lllega al metooooodooo");
		Categoria ca = new Categoria();
		ca = ejbProductoFacade.validar(categoria);
		System.out.println(ca.toString());
		int id = ca.getId();
		System.out.println(id);
		listaProductos = ejbProductoFacade.buscarProductos(id);
		System.out.println(listaProductos);
		return ca;

	}

	public Producto buscarProductosnombre() {
		Producto pro = new Producto();
		String nombre = pro.getNombre();
		System.out.println(nombre);
		listaProductos1 = ejbProductoFacade.buscarProductosnombre(nombre);
		System.out.println(listaProductos1);
		return pro;

	}

	public Bodega bode() {
		Bodega bo = new Bodega();
		bo = ejbProductoFacade.nombreBodega(bodega);
		System.out.println(bo);
		return bo;
	}

}