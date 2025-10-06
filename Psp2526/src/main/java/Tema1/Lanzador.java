package Tema1;

import java.io.IOException;

public class Lanzador {
	private final static String directorioGenerarClasses = "C:\\Users\\alumno\\Documents\\workspace-spring-tools-for-eclipse-4.31.0.RELEASE\\Psp2526\\target";
	private final static String rutaSource = "C:\\Users\\alumno\\Documents\\workspace-spring-tools-for-eclipse-4.31.0.RELEASE\\Psp2526\\src\\main\\java";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		String[] comando = { "javac", "-d", directorioGenerarClasses,
				rutaSource + "\\Psp2526\\src\\main\\java\\Tema1\\Gestiona.java" };
		ProcessBuilder pb = new ProcessBuilder(comando);
		try {
			pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		Lanzador p = new Lanzador();
		p.ejecutaProcesoCompila();

	}

	public void ejecutaProcesoCompila() {
		String[] comando = {"java", "-cp", "target/classes", rutaSource };
		ProcessBuilder pb = new ProcessBuilder(comando);
		try {
			pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
