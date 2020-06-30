package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidades.Rol;

@Stateless
public class RolFacade extends AbstractFacade<Rol>  {
	
	@PersistenceContext(unitName = "Practica03.EJB.JSF.JPA")
    private EntityManager entityManager;

    public RolFacade(){
        super(Rol.class);
    }

    @Override
    protected  EntityManager getEntityManager(){
        return entityManager;
    }

}
