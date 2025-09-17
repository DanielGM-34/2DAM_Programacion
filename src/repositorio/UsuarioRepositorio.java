package repositorio;

import java.util.ArrayList;
import java.util.List;

import modelo.Usuario;

public class UsuarioRepositorio {
	// lista de usuarios con add.

	private List<Usuario> usuarios;

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public UsuarioRepositorio() {
		super();
		this.usuarios = new ArrayList<Usuario>();
	}

	// Agregamos usuario
	public void agregarUsuario(Usuario u) {
		usuarios.add(u);
	}

	// Eliminar usuario
	public void eliminarUsuario(Usuario u) {
		usuarios.remove(u);
	}

	// Leer
	public void buscarPorId(String id) {
		System.out.println(usuarios.contains(id));
		
	}

	@Override
	public String toString() {
		return "UsuarioRepositorio [usuarios=" + usuarios + "]";
	}

}
