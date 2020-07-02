package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.entidades.Ubicacion;;

@Stateless
public class UbicacionFacade extends AbstractFacade<Ubicacion> {

	@PersistenceContext(unitName = "Practica_de_laboratorio_03_EJB_JSF_JPA")
    private EntityManager entityManager;

    public UbicacionFacade(){
        super(Ubicacion.class);
    }

    @Override
    protected  EntityManager getEntityManager(){
        return entityManager;
    }
    
    public Ubicacion readUbicacion(String ciudad) {
    	Query query = entityManager.createNamedQuery("getByCiudad");
    	query.setParameter("ciudad", ciudad);
    	List result = query.getResultList();
    	Ubicacion resp=null;
    	if (!result.isEmpty()) {
    		resp = (Ubicacion)result.get(0);
    	}
    	return resp;
    }
}