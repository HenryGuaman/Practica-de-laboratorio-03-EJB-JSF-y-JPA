package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.CategoryFacade;
import ec.edu.ups.entidades.Category;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class CategoryBean implements Serializable{
	
	 private static final long serialVersionUID = 1L;

	    @EJB
	    private CategoryFacade ejbCategoryFacade;
	    private List<Category> list;
	    private String descripcion;

	    public CategoryBean() {

	    }    
	    
	    @PostConstruct
	    public void init() {
		ejbCategoryFacade.create(new Category("Electrodomesticos"));
		ejbCategoryFacade.create(new Category("Sanitarios"));
		list = ejbCategoryFacade.findAll();
	    }
	        
	    public Category[] getList() {
		return list.toArray(new Category[0]);
	    }

	    public void setList(List<Category> list) {
		this.list = list;
	    }

	    public String getDescripcion() {
		return descripcion;
	    }

	    public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	    }

	    public String add() {
		ejbCategoryFacade.create(new Category(this.descripcion));
		list = ejbCategoryFacade.findAll();
		return null;
	    }

	    public String delete(Category c) {	
		ejbCategoryFacade.remove(c);
		list = ejbCategoryFacade.findAll();
		return null;
	    }

	    public String edit(Category c) {
		c.setEditable(true);
		return null;
	    }

	    public String save(Category c) {
		ejbCategoryFacade.edit(c);
		c.setEditable(false);
		return null;
	    }


}
