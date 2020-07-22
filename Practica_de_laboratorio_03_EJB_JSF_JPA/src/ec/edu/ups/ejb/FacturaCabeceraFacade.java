package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ec.edu.ups.entidades.FacturaCabecera;
import ec.edu.ups.entidades.*;

@Stateless
public class FacturaCabeceraFacade extends AbstractFacade<FacturaCabecera> {

	@PersistenceContext(unitName = "Practica_de_laboratorio_03_EJB_JSF_JPA")
	private EntityManager em;

	public FacturaCabeceraFacade() {
		super(FacturaCabecera.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public List<Usuario> validarper() {

		String sql = "SELECT u FROM Usuario u where u.rol.cargo = 'cliente'";

		List<Usuario> list = em.createQuery(sql).getResultList();
		System.out.println("List persona:" + list);
		return list;

	}
}
