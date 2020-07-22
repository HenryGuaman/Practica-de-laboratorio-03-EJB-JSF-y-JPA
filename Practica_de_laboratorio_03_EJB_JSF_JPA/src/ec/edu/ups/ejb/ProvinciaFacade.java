package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.entidades.*;
@Stateless
public class ProvinciaFacade extends AbstractFacade<Provincia> {

	@PersistenceContext(unitName = "Practica_de_laboratorio_03_EJB_JSF_JPA")
	private EntityManager em;

	public ProvinciaFacade() {
		super(Provincia.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}

	public Pais validar(String pais) {
		Pais paiss = new Pais();
		try {
			String sql = "SELECT u FROM Pais u where u.nombre='" + pais + "'";
			System.out.println(sql);
			Query query = em.createQuery(sql);
			paiss = (Pais) query.getSingleResult();
			System.out.println("Aqui llego" + pais);
		} catch (Exception e) {
			System.out.println("Pais" + e.getMessage());
		}

		return paiss;

	}

}
