package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidades.Ubicacion;;

@Stateless
public class UbicacionFacade extends AbstractFacade<Ubicacion> {

	@PersistenceContext(unitName = "Practica03.EJB.JSF.JPA")
    private EntityManager entityManager;

    public UbicacionFacade(){
        super(Ubicacion.class);
    }

    @Override
    protected  EntityManager getEntityManager(){
        return entityManager;
    }
}
