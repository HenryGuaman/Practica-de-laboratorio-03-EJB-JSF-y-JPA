package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidades.Bodega;

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

}
