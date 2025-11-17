package Bole2;

import java.io.File;

public class Ejercicio2 {

	public static void main(String[] args) {
		File ficheros = new File("src/main/resources");
		File[] ficherosListar = ficheros.listFiles();
		for (File file : ficherosListar) {
			new Thread(new LeeFichero());
			
			System.out.println(file); 
		}
	}

}
