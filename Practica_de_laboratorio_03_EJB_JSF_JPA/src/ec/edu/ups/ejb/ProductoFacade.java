package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidades.Producto;


@Stateless
public class ProductoFacade extends AbstractFacade<Producto>{

	@PersistenceContext(unitName = "Practica03.EJB.JSF.JPA")
    private EntityManager entityManager;

    public ProductoFacade(){
        super(Producto.class);
    }

    @Override
    protected  EntityManager getEntityManager(){
        return entityManager;
    }
}
