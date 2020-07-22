package ec.edu.ups.ejb;



import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidades.Rol;

@Stateless
public class RolFacade extends AbstractFacade<Rol> {

	@PersistenceContext(unitName = "Practica_de_laboratorio_03_EJB_JSF_JPA")
	private EntityManager em;

	public RolFacade() {
		super(Rol.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}

	public Rol buscarRol(String nombre) {
		Rol rol = new Rol();
		String sql = "SELECT p FROM Rol p where p.nombre='" + nombre + "'";
		rol = (Rol) em.createQuery(sql).getSingleResult();
		return rol;
	}

}
