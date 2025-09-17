package controlador;

import java.time.LocalDate;

import modelo.Usuario;
import servicio.UsuarioServicio;

public class ControladorUsuario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//modelo y servicios
		Usuario u1= new Usuario("123", "Pepe", "ejemplo.com", LocalDate.now(), true); 
		UsuarioServicio usuarioServ = new UsuarioServicio();
		usuarioServ.agregarUsuario(u1);
		System.out.println(usuarioServ.getRepo().getUsuarios());
	}

}