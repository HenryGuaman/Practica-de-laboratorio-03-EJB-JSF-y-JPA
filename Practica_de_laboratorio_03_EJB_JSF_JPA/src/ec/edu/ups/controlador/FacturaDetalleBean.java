package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import ec.edu.ups.ejb.FacturaDetalleFacade;
import ec.edu.ups.entidades.FacturaDetalle;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class FacturaDetalleBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private FacturaDetalleFacade facturaDetalleFacade;

	public List<FacturaDetalle> obtenerTodos() {
		return this.facturaDetalleFacade.findAll();
	}

	public FacturaDetalle obtenerPorCodigo(Integer codigo) {
		return this.facturaDetalleFacade.find(codigo);
	}

	public void crear(FacturaDetalle facturaDetalle) {
		this.facturaDetalleFacade.create(facturaDetalle);
	}

	public void modificar(FacturaDetalle facturaDetalle) {
		this.facturaDetalleFacade.edit(facturaDetalle);
	}

	public void eliminar(String codigo) {
		FacturaDetalle cliente = this.facturaDetalleFacade.find(codigo);
		this.facturaDetalleFacade.remove(cliente);
	}
}
