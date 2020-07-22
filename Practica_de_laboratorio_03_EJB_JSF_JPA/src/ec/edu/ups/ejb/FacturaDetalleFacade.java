package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidades.FacturaDetalle;
import ec.edu.ups.entidades.Producto;
import ec.edu.ups.entidades.Usuario;

import javax.persistence.Query;

@Stateless
public class FacturaDetalleFacade extends AbstractFacade<FacturaDetalle> {

	@PersistenceContext(unitName = "Practica_de_laboratorio_03_EJB_JSF_JPA")
	private EntityManager em;

	public FacturaDetalleFacade() {
		super(FacturaDetalle.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public Producto buscarProductos(String nombre) {
		Producto p = new Producto();

		try {

			String sql = "SELECT p FROM Product p where p.nombre='" + nombre + "'";
			Query qu = em.createQuery(sql);
			System.out.println("El query es" + qu);
			p = (Producto) qu.getSingleResult();
			System.out.println("Recupero :" + nombre);
		} catch (Exception e) {
			System.out.println("Producto : " + e.getMessage());
		}
		return p;
	}

	public Usuario buscarpersona(String nombre) {
		System.out.println("El nombre que llega a las base es" + nombre);
		Usuario usu = new Usuario();
		try {
			String sql = "SELECT u FROM Usuario u where u.nombre= '" + nombre + "'";
			System.out.println(sql);
			Query query = em.createQuery(sql);
			usu = (Usuario) query.getSingleResult();
			System.out.println("recupere : " + nombre);
		} catch (Exception e) {
			System.out.println("Usuario" + e.getMessage());
		}

		return usu;
	}
}