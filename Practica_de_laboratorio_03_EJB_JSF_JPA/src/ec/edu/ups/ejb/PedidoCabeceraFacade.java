package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidades.PedidosCabecera;



@Stateless
public class PedidoCabeceraFacade extends AbstractFacade<PedidosCabecera> {
	@PersistenceContext(unitName = "Practica_de_laboratorio_03_EJB_JSF_JPA")
	private EntityManager em;

	public PedidoCabeceraFacade() {
		// TODO Auto-generated constructor stub
		super(PedidosCabecera.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}

}