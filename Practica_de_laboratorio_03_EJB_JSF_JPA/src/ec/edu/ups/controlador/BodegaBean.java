package ec.edu.ups.controlador;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ec.edu.ups.ejb.BodegaFacade;


@Named
@SessionScoped
public class BodegaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private BodegaFacade ejbBodegaFacade;
	

}
