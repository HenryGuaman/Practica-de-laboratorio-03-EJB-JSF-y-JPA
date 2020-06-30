package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidades.Rol;

@Stateless
public class RolFacade extends AbstractFacade<Rol>  {
	
	@PersistenceContext(unitName = "Practica_de_laboratorio_03_EJB_JSF_JPA")
    private EntityManager entityManager;

    public RolFacade(){
        super(Rol.class);
    }

    @Override
    protected  EntityManager getEntityManager(){
        return entityManager;
    }

}
