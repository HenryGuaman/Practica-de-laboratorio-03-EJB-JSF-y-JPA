package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.entidades.*;

@Stateless
public class StockFacade extends AbstractFacade<Stock> {

	@PersistenceContext(unitName = "Practica_de_laboratorio_03_EJB_JSF_JPA")
	private EntityManager em;

	public StockFacade() {
		super(Stock.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public Bodega nombreBodega(String bodega) {
		Bodega cat = new Bodega();
		System.out.println("Bodega:");
		try {
			String sql = "SELECT b FROM Bodega b where b.nombre='" + bodega + "'";
			System.out.println(sql);
			Query query = em.createQuery(sql);
			cat = (Bodega) query.getSingleResult();

		} catch (Exception e) {
			System.out.println("bodega" + e.getMessage());
		}
		return cat;
	}

	public List<Stock> listaInventario(Bodega bodega) {

		String sql = "SELECT s FROM Stock s where  s.bodega.nombre='" + bodega.getNombre() + "'";
		System.out.println(sql);
		List<Stock> list = em.createQuery(sql).getResultList();
		for (Stock stock : list) {
			System.out.println("Nombre  bodega" + stock.getBodega().getNombre());
			System.out.println("Direccion Bodega" + stock.getBodega().getUbicacion().getCiudad());
			System.out.println("Nombre producto" + stock.getProducto().getNombre());
			System.out.println("Costo Unitario" + stock.getProducto().getCostoUnitario());
			System.out.println("Cantidad Stock" + stock.getProducto().getCantidadStock());
			System.out.println("Categoria" + stock.getProducto().getCategoria().getDescripcion());
		}
		System.out.println("Recupero Cantidad Stock");
		System.out.println(list);
		return list;
	}

	public List<Stock> bodegasCategorias_Productos(String bodega, String categoria) {
		System.out.println(bodega);
		System.out.println(categoria);
		String sql = "SELECT s FROM Stock s where  s.bodega.nombre='" + bodega + "' AND  s.producto.categoria.nombre='"
				+ categoria + "'";
		System.out.println(sql);
		List<Stock> list = em.createQuery(sql).getResultList();
		for (Stock stock : list) {
			System.out.println("Codigo" + stock.getBodega().getCodigo());
			System.out.println("Nombre  bodega" + stock.getBodega().getNombre());
			System.out.println("Nombre producto" + stock.getProducto().getNombre());
			System.out.println("Precio Unitario" + stock.getProducto().getCostoUnitario());
			System.out.println("Stock" + stock.getProducto().getCantidadStock());
			System.out.println("Categoria" + stock.getProducto().getCategoria().getDescripcion());
		}
		System.out.println("Recupero Cantidad Stock");
		System.out.println(list);

		return list;

	}
}
