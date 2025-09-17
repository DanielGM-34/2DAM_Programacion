package servicio;

import modelo.Usuario;
import repositorio.UsuarioRepositorio;

public class UsuarioServicio {
	private UsuarioRepositorio repo;

	public UsuarioRepositorio getRepo() {
		return repo;
	}
 
	public void setRepo(UsuarioRepositorio repo) {
		this.repo = repo;
	}

	public UsuarioServicio() {
		super();
		this.repo = new UsuarioRepositorio();
	} 
	 
	public void agregarUsuario(Usuario u) {
		repo.agregarUsuario(u);
	}
	
	public void buscarUsuarioPorId(String id) {
		repo.buscarPorId(id);
	}

	@Override
	public String toString() {
		return "UsuarioServicio [repo=" + repo + "]";
	}
	
}
