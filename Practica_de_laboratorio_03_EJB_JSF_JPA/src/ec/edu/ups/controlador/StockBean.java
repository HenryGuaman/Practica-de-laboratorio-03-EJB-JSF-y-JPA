package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import ec.edu.ups.ejb.*;
import ec.edu.ups.entidades.*;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class StockBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	private StockFacade ejbStcokFacade;
	private List<Stock> listStock;
	private String bodega;
	private Bodega bo;

	public StockBean() {
		super();
	}

	@PostConstruct
	public void init() {
		this.bo = new Bodega();
		listStock = ejbStcokFacade.findAll();
	}

	public String getBodega() {
		return bodega;
	}

	public void setBodega(String bodega) {
		this.bodega = bodega;
	}

	public StockFacade getEjbStcokFacade() {
		return ejbStcokFacade;
	}

	public void setEjbStcokFacade(StockFacade ejbStcokFacade) {
		this.ejbStcokFacade = ejbStcokFacade;
	}

	public List<Stock> getListStock() {
		return listStock;
	}

	public void setListStock(List<Stock> listStock) {
		this.listStock = listStock;
	}

	public Bodega bode() {
		System.out.println(bodega);
		bo = ejbStcokFacade.nombreBodega(bodega);
		System.out.println(bo);
		return bo;
	}

	public List<Stock> listabo() {
		listStock = ejbStcokFacade.listaInventario(bode());
		System.out.println("Inventario:");
		System.out.println(listStock);
		return listStock;
	}
}
