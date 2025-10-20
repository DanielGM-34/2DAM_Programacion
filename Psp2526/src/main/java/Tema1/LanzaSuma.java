package Tema1;

import java.io.IOException;


public class LanzaSuma {
    private final static String directorioGenerarClasses = "target";
    private final static String rutaSource = "src\\main\\java";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LanzaSuma a = new LanzaSuma();
		a.Compila();
		a.ejecutaProcesoCompila();
	}
	
	  public void ejecutaProcesoCompila() {
	        // Ejecutar la clase compilada usando su nombre de clase, no la ruta al .java
	    	//doy dos argumentos hola y adios
	        String[] comando = { "java", "-cp", directorioGenerarClasses, "Tema1.CalculaSumaImpar","False","5" };
	        ProcessBuilder pb = new ProcessBuilder(comando);
	        try {
	            pb.redirectErrorStream(true);
	            pb.inheritIO();
	            pb.start();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	  
	    public void Compila() {
	        // Compilar el archivo fuente y generar el .class en el directorio target
	        String[] comando = { "javac", "-d", directorioGenerarClasses, rutaSource + "\\Tema1\\CalculaSumaImpar.java" };
	        ProcessBuilder pb = new ProcessBuilder(comando);
	        try {
	            pb.redirectErrorStream(true);
	            pb.inheritIO();
	            pb.start();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

}
