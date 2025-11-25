package Bole5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ContarPalabraFicheroEj2 extends Thread {
	private File directorio;
	private String palabraFichero;

	public File getDirectorio() {
		return directorio;
	}

	public void setDirectorio(File directorio) {
		this.directorio = directorio;
	}

	public String getPalabraFichero() {
		return palabraFichero;
	}

	public void setPalabraFichero(String palabraFichero) {
		this.palabraFichero = palabraFichero;
	}

	@Override
	public void run() {
		buscaPalabraFichero();
		// TODO Auto-generated method stub

	}

	public synchronized void buscaPalabraFichero() {
		File[] ficheroDirectorios = directorio.listFiles();
		int numVeces = 0;
		for (File file : ficheroDirectorios) {
			if (devuelveNumVocTexto(file)) {
				numVeces++;
			}
		}
		System.out.println(numVeces);
	}

	public synchronized boolean devuelveNumVocTexto(File fichero) {
		boolean aparece = false;
		FileReader ficheroALeer = null;
		Scanner leerEscaneador = null;
		try {
			ficheroALeer = new FileReader(fichero);
			leerEscaneador = new Scanner(ficheroALeer);
			while (leerEscaneador.hasNext()) {
				String palabra = leerEscaneador.next();
				if (palabra.toLowerCase().contains(this.palabraFichero.toLowerCase())) {
					aparece = true;
				}

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (ficheroALeer != null) {
			try {
				ficheroALeer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (leerEscaneador != null) {
			leerEscaneador.close();
		}
		return aparece;

	}

}
