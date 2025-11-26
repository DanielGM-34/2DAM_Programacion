package Bole5;

public class CuentaVocales {
	private String texto;
	private int numTotalVoc;
	
	public CuentaVocales(String texto, int numTotalVoc) {
		super();
		this.texto = texto;
		this.numTotalVoc = numTotalVoc;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getNumTotalVoc() {
		return numTotalVoc;
	}

	public void setNumTotalVoc(int numTotalVoc) {
		this.numTotalVoc = numTotalVoc;
	}

}
