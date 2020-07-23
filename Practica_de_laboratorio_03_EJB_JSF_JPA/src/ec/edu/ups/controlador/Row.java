package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Row implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nombre1;
	private String descripcion;
	private double pun;
	private double ppu;
	private int stock;
	private int cantidad;
	private double subtotal;

	public Row() {
		super();
	}

	public Row(String nombre1, String descripcion, double pun, double ppu, int stock) {
		
		this.nombre1 = nombre1;
		this.descripcion = descripcion;
		this.pun = pun;
		this.ppu = ppu;
		this.stock = stock;
	}

	public Row(String nombre1, String descripcion, double pun, double ppu, int stock, int cantidad) {
		super();
		this.nombre1 = nombre1;
		this.descripcion = descripcion;
		this.pun = pun;
		this.ppu = ppu;
		this.stock = stock;
		this.cantidad=cantidad;
	}

	public Row(String nombre1, String descripcion, double pun, double ppu, int stock, int cantidad, double subtotal) {
		super();
		this.nombre1 = nombre1;
		this.descripcion = descripcion;
		this.pun = pun;
		this.ppu = ppu;
		this.stock = stock;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
	}

	public String getNombre1() {
		return nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
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

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	private static Row row;

	public static List<Row> serializeRoww(List<Row> rows) {
		List<Row> rowList = new ArrayList<>();
		rows.forEach(e -> {
			row = new Row(e.getNombre1(), e.getDescripcion(), e.getPun(), e.getPpu(), e.getStock(), e.getCantidad());
			rowList.add(row);
		});
		return rowList;
	}

	@Override
	public String toString() {
		return "Row [nombre1=" + nombre1 + ", descripcion=" + descripcion + ", pun=" + pun + ", ppu=" + ppu
				+ ", stock=" + stock + ", cantidad=" + cantidad + ", subtotal=" + subtotal + "]";
	}

}
