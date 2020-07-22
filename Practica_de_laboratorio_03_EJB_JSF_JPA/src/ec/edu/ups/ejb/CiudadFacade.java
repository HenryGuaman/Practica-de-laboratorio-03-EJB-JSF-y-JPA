package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.entidades.*;

@Stateless
public class CiudadFacade extends AbstractFacade<Ciudad> {

	@PersistenceContext(unitName = "Practica_de_laboratorio_03_EJB_JSF_JPA")
	private EntityManager em;
	public CiudadFacade() {
		super(Ciudad.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	public Provincia validarpro(String pais ) {
		Provincia pais2=new Provincia();
		try {
			String sql="SELECT u FROM Provincia u where u.nombre='"+pais+"'";
			System.out.println(sql);
			Query query = em.createQuery(sql);
			pais2= (Provincia) query.getSingleResult();
			System.out.println(pais);	
		} catch (Exception e) {
			System.out.println("Provincia"+e.getMessage());
		}
			
		return pais2;
	
	}


}
