package Tema1;

import java.io.IOException;

public class Lanzador {
	private final static String directorioGenerarClasses = "target";
	private final static String rutaSource = "src\\main\\java";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * String[] comando = { "javac", "-d", directorioGenerarClasses, rutaSource +
		 * "\\Psp2526\\src\\main\\java\\Tema1\\Gestiona.java" }; ProcessBuilder pb = new
		 * ProcessBuilder(comando); try { pb.start(); } catch (IOException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		Lanzador p = new Lanzador();
		p.ejecutaProcesoCompila();
		p.Compila();

	}

	public void ejecutaProcesoCompila() {
		String[] comando = { "java", "-cp", directorioGenerarClasses, rutaSource + "\\Tema1\\Gestiona.java" };
		ProcessBuilder pb = new ProcessBuilder(comando);
		try {
			pb.redirectErrorStream(true);
			pb.inheritIO();
			pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void Compila() {
		String[] comando = { "javac", "-d", directorioGenerarClasses, rutaSource + "\\Tema1\\Gestiona.java" };
		ProcessBuilder pb = new ProcessBuilder(comando);
		try {
			pb.redirectErrorStream(true);
			pb.inheritIO();

			pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
