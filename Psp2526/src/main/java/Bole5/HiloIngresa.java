package Bole5;

public class HiloIngresa extends Thread {
	private int cantidad;
	private Cuenta cu;

	public int getIngresa() {
		return cantidad;
	}

	public Cuenta getCu() {
		return cu;
	}

	public void setCu(Cuenta cu) {
		this.cu = cu;
	}

	public HiloIngresa(Cuenta cu) {
		super();
		this.cantidad = (int) (Math.random() * 500 + 1);
		this.cu = cu;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		cu.ingresaDinero(cantidad);
	}

}
