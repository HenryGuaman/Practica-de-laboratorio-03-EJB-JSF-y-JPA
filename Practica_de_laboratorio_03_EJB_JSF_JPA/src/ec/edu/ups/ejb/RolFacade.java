package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    
    public Rol readRol(String cargo) {
		Query query = entityManager.createNamedQuery("getByCargo");
		query.setParameter("cargo", cargo);
		List result = query.getResultList();
		Rol respuesta = null;
		if(!result.isEmpty()){
			respuesta = (Rol)result.get(0);
		}
		return respuesta;
	}

}
