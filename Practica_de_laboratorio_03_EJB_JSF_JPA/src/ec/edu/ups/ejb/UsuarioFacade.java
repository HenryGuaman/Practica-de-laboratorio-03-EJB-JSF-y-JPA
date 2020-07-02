package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.entidades.Usuario;

@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario>{
	
	@PersistenceContext(unitName = "Practica_de_laboratorio_03_EJB_JSF_JPA")
    private EntityManager entityManager;

    public UsuarioFacade(){
        super(Usuario.class);
    }

    @Override
    protected  EntityManager getEntityManager(){
        return entityManager;
    }

    public Usuario readCorreo(String correo, String pass) {
		// TODO Auto-generated method stub
		
		//No olvidar agregar en model el QUery getByCedula
		Query query = entityManager.createNamedQuery("getByCorreo");
		query.setParameter("correo", correo);
		query.setParameter("pass", pass);
		List result = query.getResultList();
		Usuario respuesta = null;
		if(!result.isEmpty()){
			respuesta = (Usuario) result.get(0);
		}
		return respuesta;
	}
	
	public List<Usuario> listarEmpleados(int cargo){
		Query query = entityManager.createNamedQuery("listarEmpleados");
		query.setParameter("cargo", cargo);
		List<Usuario> respuesta = (List<Usuario>) query.getResultList();
		return respuesta;
	}
	
	public List<Usuario> listarClientes(int cargo){
		Query query = entityManager.createNamedQuery("listarClientes");
		query.setParameter("cargo", cargo);
		List<Usuario> respuesta = (List<Usuario>) query.getResultList();
		return respuesta;
	}
	
	public List<Usuario> listarAdmins(int cargo){
		Query query = entityManager.createNamedQuery("listarAdmins");
		query.setParameter("cargo", cargo);
		List<Usuario> respuesta = (List<Usuario>) query.getResultList();
		return respuesta;
	}
}
