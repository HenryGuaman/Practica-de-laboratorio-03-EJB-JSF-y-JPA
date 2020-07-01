package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidades.Category;

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

}
