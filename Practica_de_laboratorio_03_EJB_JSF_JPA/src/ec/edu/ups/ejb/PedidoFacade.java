package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import ec.edu.ups.entidades.*;
import java.util.GregorianCalendar;
import java.util.List;

@Stateless
public class PedidoFacade extends AbstractFacade<Pedido> {

	@PersistenceContext(unitName = "Practica_de_laboratorio_03_EJB_JSF_JPA")
	private EntityManager entityManager;

	public PedidoFacade() {
		super(Pedido.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

	public Pedido getUltimoPedido(Usuario usuario, GregorianCalendar date) {

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Pedido> criteriaQuery = criteriaBuilder.createQuery(Pedido.class);
		Root<Pedido> pedidoRoot = criteriaQuery.from(Pedido.class);
		Predicate predicateUsuario = criteriaBuilder.equal(pedidoRoot.get("usuario"), usuario);
		Predicate predicateFecha = criteriaBuilder.equal(pedidoRoot.get("fecha_emision"), date);
		Predicate[] predicates = new Predicate[] { predicateUsuario, predicateFecha };

		criteriaQuery.select(pedidoRoot).where(predicates);
		List<Pedido> pedidoList = entityManager.createQuery(criteriaQuery).getResultList();

		return pedidoList.get(pedidoList.size() - 1);
	}

	public Pedido getCurrentPedido(Usuario usuario) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Pedido> criteriaQuery = criteriaBuilder.createQuery(Pedido.class);
		Root<Pedido> pedidoRoot = criteriaQuery.from(Pedido.class);
		Predicate predicateUsuario = criteriaBuilder.equal(pedidoRoot.get("usuario"), usuario);
		Predicate[] predicates = new Predicate[] { predicateUsuario };
		criteriaQuery.select(pedidoRoot).where(predicates);
		List<Pedido> pedidoList = entityManager.createQuery(criteriaQuery).getResultList();
		return pedidoList.get(pedidoList.size() - 1);

	}

}