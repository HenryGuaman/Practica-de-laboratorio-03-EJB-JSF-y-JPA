package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidades.FacturaDetalle;

@Stateless
public class FacturaDetalleFacade extends AbstractFacade<FacturaDetalle>{
	
	@PersistenceContext(unitName = "Practica03.EJB.JSF.JPA")
    private EntityManager entityManager;

    public FacturaDetalleFacade(){
        super(FacturaDetalle.class);
    }

    @Override
    protected  EntityManager getEntityManager(){
        return entityManager;
    }

}
