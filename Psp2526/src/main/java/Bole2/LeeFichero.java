package Bole2;

import java.io.File;

public class LeeFichero implements Runnable {
	private File fichero;
	private int numCar;

	public LeeFichero() {
		super();
	}

	public LeeFichero(File fichero, int numCar) {
		super();
		this.fichero = fichero;
		this.numCar = numCar;
	}

	public File getFichero() {
		return fichero;
	}

	public void setFichero(File fichero) {
		this.fichero = fichero;
	}

	public int getNumCar() {
		return numCar;
	}

	public void setNumCar(int numCar) {
		this.numCar = numCar;
	}

	@Override
	public String toString() {
		return "LeeFichero [fichero=" + fichero + ", numCar=" + numCar + "]";
	}
	
	
	//metodo contarCaracteres

	@Override
	public void run() {
		
		//llamada al método contarCaracteres
		// TODO Auto-generated method stub

	}

}
