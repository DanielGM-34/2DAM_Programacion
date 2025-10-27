package hijos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class AnalizadorTemperatura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		String nombreFicheroTemp = args[0];
		int umbral = Integer.parseInt(args[1]);
		String nombreFicheroResult=args[2];

	}

	public int analizaTemperatura(String ficheroYRuta, int umbral, String nombreFicheroaEscribir)
			throws FileNotFoundException {
		int tempMayorUmbral = 0;
		File ficheroS = new File(ficheroYRuta);
		FileReader fichero = new FileReader(ficheroYRuta);
		Scanner in = new Scanner(fichero);
		while (in.hasNextLine()) {
			String tempString = in.nextLine();
			int temperatura = Integer.parseInt(tempString);
			if (temperatura > umbral) {
				tempMayorUmbral += 1; 
				this.escribreTemperatura(temperatura, nombreFicheroaEscribir);
			}

		}
		in.close();

		return tempMayorUmbral;
	}

	public void escribreTemperatura(int temperatura, String rutaFichero) {
		PrintWriter out = null;
		try {
			FileWriter ficheroSalida;
			ficheroSalida = new FileWriter(rutaFichero);
			// abre el fichero de texto
			out = new PrintWriter(ficheroSalida);
				String tempString = String.valueOf(temperatura);
				out.println(tempString);
			
			// escribe el listado persona a persona
		} catch (IOException e) {
			System.out.println("IOException");
		} finally {
			if (out != null)
				out.close();
		}
	}

}
