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
	private double descuentoFact;
	private double ivaFact;
	private double subtotalFact;
	private double totalFact;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "facturaCabecera")
	private List<FacturaDetalle> listaFacturasDetalles;

	@ManyToOne
	private Usuario usuario;

	public FacturaCabecera() {
	}

	public FacturaCabecera(int codigo, GregorianCalendar fecha, double descuentoFact, double ivaFact,
			double subtotalFact, double totalFact, List<FacturaDetalle> listaFacturasDetalles, Usuario usuario) {
		this.codigo = codigo;
		this.fecha = fecha;
		this.descuentoFact = descuentoFact;
		this.ivaFact = ivaFact;
		this.subtotalFact = subtotalFact;
		this.totalFact = totalFact;
		this.listaFacturasDetalles = listaFacturasDetalles;
		this.usuario = usuario;
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

	public double getDescuentoFact() {
		return descuentoFact;
	}

	public void setDescuentoFact(double descuentoFact) {
		this.descuentoFact = descuentoFact;
	}

	public double getIvaFact() {
		return ivaFact;
	}

	public void setIvaFact(double ivaFact) {
		this.ivaFact = ivaFact;
	}

	public double getSubtotalFact() {
		return subtotalFact;
	}

	public void setSubtotalFact(double subtotalFact) {
		this.subtotalFact = subtotalFact;
	}

	public double getTotalFact() {
		return totalFact;
	}

	public void setTotalFact(double totalFact) {
		this.totalFact = totalFact;
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
		return "FacturaCabecera{" + "codigo=" + codigo + ", fecha=" + fecha + ", descuentoFact=" + descuentoFact
				+ ", subtotalFact=" + subtotalFact + ", ivaFact=" + ivaFact + ", totalFact=" + totalFact + '}';
	}
}
