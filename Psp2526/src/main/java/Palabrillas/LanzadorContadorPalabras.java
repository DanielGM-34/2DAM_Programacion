package Palabrillas;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LanzadorContadorPalabras {
	private static final String rutamain = "src/main/java/";
	private static final String rutaResources = "src/main/resources/";
    private final static String directorioGenerarClasses = "target";
    private final static String rutaSource = "src/main/java/";


	public static void main(String[] args) {
		LanzadorContadorPalabras a = new LanzadorContadorPalabras();
		a.compilaClase(rutaSource+"Palabrillas.ContarPalabras", rutaResources+"fichero.txt","es");
		a.ejecutaClase("Palabrillas.ContarPalabras");
	}
	  public void ejecutaClase(String rutaFicheroJava) {
	        // Ejecutar la clase compilada usando su nombre de clase, no la ruta al .java
	    	//doy dos argumentos hola y adios
	        String[] comando = { "java", "-cp", directorioGenerarClasses, rutaFicheroJava,"False","5" };
	        ProcessBuilder pb = new ProcessBuilder(comando);
	        try {
	            pb.redirectErrorStream(true);
	            pb.inheritIO();
	            pb.start();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	  
	    public void compilaClase(String ruta, String ficherotxt, String palabra) { 
	        // Compilar el archivo fuente y generar el .class en el directorio target
	        String[] comando = { "javac", "-d", directorioGenerarClasses, rutaSource + ruta, ficherotxt, palabra };
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
