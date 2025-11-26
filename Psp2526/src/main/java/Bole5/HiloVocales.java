package Bole5;

public class HiloVocales extends Thread {
	private char vocal;
	private int numVocales;

	public char getVocal() {
		return vocal;
	}

	public void setVocal(char vocal) {
		this.vocal = vocal;
	}

	public int getNumVocales() {
		return numVocales;
	}

	public void setNumVocales(int numVocales) {
		this.numVocales = numVocales;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
