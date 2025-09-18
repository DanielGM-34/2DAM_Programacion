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
	    int i = 0;
	    boolean encontrado = false;

	    while (i < usuarios.size() && !encontrado) {
	        Usuario usuario = usuarios.get(i);

	        if (usuario.getIdUsuario().equals(id)) {
	            System.out.println("✅ Usuario encontrado: " + usuario);
	            encontrado = true;
	            //prueba
	        }

	        i++;
	    }

	    if (!encontrado) {
	        System.out.println("❌ Usuario con ID '" + id + "' no encontrado.");
	    }
	}



	@Override
	public String toString() {
		return "UsuarioRepositorio [usuarios=" + usuarios + "]";
	}

}
