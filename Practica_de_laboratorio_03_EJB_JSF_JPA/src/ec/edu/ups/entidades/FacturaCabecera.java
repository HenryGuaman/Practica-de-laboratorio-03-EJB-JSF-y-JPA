package ec.edu.ups.entidades;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: FacturaCabecera
 *
 */
@Entity

public class FacturaCabecera implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;

	@Temporal(TemporalType.DATE)
	private GregorianCalendar fecha;
	private double descuento;
	private double iva;
	private double subtotal;
	private double total;
	private char anulado;

	@Transient
	private boolean editable;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "facturaCabecera")
	private List<FacturaDetalle> listaFacturasDetalles;

	@OneToOne
	private Pedido pedido;

	@ManyToOne
	private Usuario usuario;

	public FacturaCabecera() {
	}

	public FacturaCabecera(GregorianCalendar fecha, char anulado, double descuento, double subtotal, double iva,
			double total, Usuario usuario) {
		this.codigo = codigo;
		this.fecha = fecha;
		this.anulado = anulado;
		this.descuento = descuento;
		this.subtotal = subtotal;
		this.iva = iva;
		this.iva = iva;
		this.total = total;
		this.listaFacturasDetalles = listaFacturasDetalles;
		this.usuario = usuario;
	}

	public FacturaCabecera(GregorianCalendar fecha, char anulado, double descuento, double subtotal, double iva,
			double total, List<FacturaDetalle> listaFacturasDetalles, Usuario usuario, Pedido pedido) {
		this.fecha = fecha;
		this.anulado = anulado;
		this.descuento = descuento;
		this.subtotal = subtotal;
		this.iva = iva;
		this.total = total;
		this.listaFacturasDetalles = listaFacturasDetalles;
		this.usuario = usuario;
		this.pedido = pedido;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}

	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}

	public char getAnulado() {
		return anulado;
	}

	public void setAnulado(char anulado) {
		this.anulado = anulado;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public List<FacturaDetalle> getListaFacturasDetalles() {
		return listaFacturasDetalles;
	}

	public void setListaFacturasDetalles(List<FacturaDetalle> listaFacturasDetalles) {
		this.listaFacturasDetalles = listaFacturasDetalles;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public double calcularTotal() {
		return 0;
	}

	public double calcularIvaTotal() {
		return 0;
	}

	public double calcularSubtotal() {
		return 0;
	}

	public double calcularDescuentoFact() {
		return 0;
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

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public boolean agregarDetalle(FacturaDetalle facturaDetalle) {
		return listaFacturasDetalles.add(facturaDetalle);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof FacturaCabecera))
			return false;
		FacturaCabecera that = (FacturaCabecera) o;
		return codigo == that.codigo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public String toString() {
		return "FacturaCabecera [codigo=" + codigo + ", fecha=" + fecha + ", descuento=" + descuento + ", iva=" + iva
				+ ", subtotal=" + subtotal + ", total=" + total + ", anulado=" + anulado + ", editable=" + editable
				+ ", listaFacturasDetalles=" + listaFacturasDetalles + ", pedido=" + pedido + ", usuario=" + usuario
				+ "]";
	}

}
