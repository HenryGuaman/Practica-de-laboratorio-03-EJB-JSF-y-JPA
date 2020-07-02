package ec.edu.ups.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;


import ec.edu.ups.entidades.Rol;
import ec.edu.ups.entidades.Usuario;

/**
 * Entity implementation class for Entity: Rol
 *
 */
@NamedQuery(name = "getByCargo", query = "SELECT r FROM Rol r WHERE r.cargo =:cargo")

@Entity
public class Rol implements Serializable {

	
	private static final long serialVersionUID = 1L;
	 	@Id
	    private int codigo;
	    private String cargo;

	    @OneToMany(mappedBy = "rol")
	    private Set<Usuario> usuariosRolesList = new  HashSet<Usuario>();

	    @Transient
	    private boolean editable;
	    
	    public Rol(){}

		/**
		 * @param codigo
		 * @param cargo
		 */
		public Rol(int codigo, String cargo) {
			super();
			this.codigo = codigo;
			this.cargo = cargo;
		}

		/**
		 * @param cargo
		 */
		public Rol(String cargo) {
			super();
			this.cargo = cargo;
		}

		public int getCodigo() {
			return codigo;
		}

		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}

		public String getCargo() {
			return cargo;
		}

		public void setCargo(String cargo) {
			this.cargo = cargo;
		}

		public Set<Usuario> getUsuariosRolesList() {
			return usuariosRolesList;
		}

		public void setUsuariosRolesList(Set<Usuario> usuariosRolesList) {
			this.usuariosRolesList = usuariosRolesList;
		}

		public boolean isEditable() {
			return editable;
		}

		public void setEditable(boolean editable) {
			this.editable = editable;
		}

		public void addUsuario(Usuario usuario) {
			this.usuariosRolesList.add(usuario);
		}
		
		public void removeUsuario(Usuario usuario) {
			this.usuariosRolesList.remove(usuario);
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + codigo;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Rol other = (Rol) obj;
			if (codigo != other.codigo)
				return false;
			return true;
		}
		
}
