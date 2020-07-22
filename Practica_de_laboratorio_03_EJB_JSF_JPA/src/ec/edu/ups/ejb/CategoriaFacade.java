package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.entidades.Categoria;

@Stateless
public class CategoriaFacade extends AbstractFacade<Categoria> {
	
	 @PersistenceContext(unitName = "Practica_de_laboratorio_03_EJB_JSF_JPA")
	    private EntityManager em;

	    public CategoriaFacade() {
	        super(Categoria.class);
	    }
	    
	    @Override
	    protected EntityManager getEntityManager() {
	        return em;
	    }
	    
	    public Categoria readCategory(String descripcion) {
	    	Query query = em.createNamedQuery("getByDescripcion");
	    	query.setParameter("descripcion", descripcion);
	    	List result = query.getResultList();
	    	Categoria resp=null;
	    	if (!result.isEmpty()) {
	    		resp = (Categoria)result.get(0);
	    	}
	    	return resp;
	    }
}
