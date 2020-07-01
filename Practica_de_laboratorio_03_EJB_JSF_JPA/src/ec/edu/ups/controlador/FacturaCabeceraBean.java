package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import ec.edu.ups.ejb.FacturaCabeceraFacade;
import ec.edu.ups.entidades.FacturaCabecera;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class FacturaCabeceraBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private FacturaCabeceraFacade facturaCabeceraFacade;

	public List<FacturaCabecera> obtenerTodos() {
		return this.facturaCabeceraFacade.findAll();
	}

	public FacturaCabecera obtenerPorCodigo(Integer codigo) {
		return this.facturaCabeceraFacade.find(codigo);
	}

	public void crear(FacturaCabecera facturaCabecera) {
		this.facturaCabeceraFacade.create(facturaCabecera);
	}

	public void modificar(FacturaCabecera facturaCabecera) {
		this.facturaCabeceraFacade.edit(facturaCabecera);
	}

	public void eliminar(String codigo) {
		FacturaCabecera cliente = this.facturaCabeceraFacade.find(codigo);
		this.facturaCabeceraFacade.remove(cliente);
	}

}