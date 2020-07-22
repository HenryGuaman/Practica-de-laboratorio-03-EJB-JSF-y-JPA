package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.entidades.Bodega;
import ec.edu.ups.entidades.Ubicacion;

@Stateless
public class BodegaFacade extends AbstractFacade<Bodega>{
	

    @PersistenceContext(unitName = "Practica_de_laboratorio_03_EJB_JSF_JPA")
    private EntityManager entityManager;

    public BodegaFacade(){
        super(Bodega.class);
    }

    @Override
    protected  EntityManager getEntityManager(){
        return entityManager;
    }

    public Bodega readBodega(String nombre) {
    	Query query = entityManager.createNamedQuery("getByNombre");
    	query.setParameter("nombre", nombre);
    	List result = query.getResultList();
    	Bodega resp=null;
    	if (!result.isEmpty()) {
    		resp = (Bodega)result.get(0);
    	}
    	return resp;
    }
}