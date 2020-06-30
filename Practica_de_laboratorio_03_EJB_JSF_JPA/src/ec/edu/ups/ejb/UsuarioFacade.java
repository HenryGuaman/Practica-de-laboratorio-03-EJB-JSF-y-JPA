package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidades.Usuario;

@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario>{
	
	@PersistenceContext(unitName = "Practica03.EJB.JSF.JPA")
    private EntityManager entityManager;

    public UsuarioFacade(){
        super(Usuario.class);
    }

    @Override
    protected  EntityManager getEntityManager(){
        return entityManager;
    }

}
