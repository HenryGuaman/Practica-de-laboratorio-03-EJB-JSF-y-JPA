package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidades.Producto;


@Stateless
public class ProductoFacade extends AbstractFacade<Producto>{

	@PersistenceContext(unitName = "Practica_de_laboratorio_03_EJB_JSF_JPA")
    private EntityManager entityManager;

    public ProductoFacade(){
        super(Producto.class);
    }

    @Override
    protected  EntityManager getEntityManager(){
        return entityManager;
    }
}
