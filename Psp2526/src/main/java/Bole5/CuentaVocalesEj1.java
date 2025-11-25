package Bole5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class CuentaVocalesEj1 extends Thread {
	private char volcal;
	private String ruta;
	private static int sumaVocales;

	public CuentaVocalesEj1(char volcal, String ruta) {
		super();
		this.volcal = volcal;
		this.ruta = ruta;
	}

	public char getVolcal() {
		return volcal;
	}

	public void setVolcal(char volcal) {
		this.volcal = volcal;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public static int getSumaVocales() {
		return sumaVocales;
	}

	public static void setSumaVocales(int sumaVocales) {
		CuentaVocalesEj1.sumaVocales = sumaVocales;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int numVeces = devuelveNumVocTexto();
		sumaChar(numVeces);
		System.out.println("La vocal '" + volcal + "' aparece " + numVeces + " veces.");
	}
 
	public synchronized int devuelveNumVocTexto() {
		int numVeces = 0;
		char vocal = Character.toLowerCase(this.volcal);
		File fichero = new File(this.ruta);
		try {
			FileReader ficheroALeer = new FileReader(fichero);
			Scanner leerEscaneador = new Scanner(ficheroALeer);

			while (leerEscaneador.hasNext()) {

				String palabra = leerEscaneador.next().toLowerCase();
				for (int i = 0; i < palabra.length(); i++) {
					if (palabra.charAt(i) == vocal) {
						numVeces++;
					}
				}
			}
			leerEscaneador.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return numVeces;

	}

	public synchronized static void sumaChar(int n) {
		sumaVocales += n;

	}

}
