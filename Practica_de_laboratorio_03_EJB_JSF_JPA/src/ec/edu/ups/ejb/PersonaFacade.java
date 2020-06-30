package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidades.Persona;;

@Stateless
public class PersonaFacade extends AbstractFacade<Persona> {

	
	@PersistenceContext(unitName = "Practica_de_laboratorio_03_EJB_JSF_JPA")
    private EntityManager entityManager;

    public PersonaFacade(){
        super(Persona.class);
    }

    @Override
    protected  EntityManager getEntityManager(){
        return entityManager;
    }
}
