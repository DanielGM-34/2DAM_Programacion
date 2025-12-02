package Bole5;

public class HiloRetira extends Thread {
	private int importe;
	private Cuenta cu;

	public Cuenta getCu() {
		return cu;
	}

	public void setCu(Cuenta cu) {
		this.cu = cu;
	}

	public int getImporte() { 
		return importe;
	}

	public HiloRetira(Cuenta cu) {
		super();
		this.importe =  (int) (Math.random() * 500 + 1);
		this.cu = cu;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			cu.retiraDinero(importe);
		} catch (CuentaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
