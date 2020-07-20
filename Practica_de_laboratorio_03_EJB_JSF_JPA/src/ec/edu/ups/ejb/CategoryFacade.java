package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.entidades.Category;
import ec.edu.ups.entidades.Ubicacion;

@Stateless
public class CategoryFacade extends AbstractFacade<Category> {
	
	 @PersistenceContext(unitName = "Practica_de_laboratorio_03_EJB_JSF_JPA")
	    private EntityManager em;

	    public CategoryFacade() {
	        super(Category.class);
	    }
	    
	    @Override
	    protected EntityManager getEntityManager() {
	        return em;
	    }
	    
	    public Category readCategory(String descripcion) {
	    	Query query = em.createNamedQuery("getByDescripcion");
	    	query.setParameter("descripcion", descripcion);
	    	List result = query.getResultList();
	    	Category resp=null;
	    	if (!result.isEmpty()) {
	    		resp = (Category)result.get(0);
	    	}
	    	return resp;
	    }
}
