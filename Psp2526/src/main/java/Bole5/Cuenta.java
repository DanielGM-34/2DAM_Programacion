package Bole5;

public class Cuenta {
	private int saldo;

	public Cuenta(int saldo) {
		super();
		this.saldo = saldo;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public synchronized void retiraDinero(int importe) throws CuentaException {
		System.out.println("Retirando: " + importe + " saldo inicial: " + this.saldo);
		if (this.saldo < importe) {
			throw new CuentaException("El importe es mayor al saldo.");
		} else {
			int saldoActual = this.saldo - importe;
			setSaldo(saldoActual);
			System.out.println("Fin Retirando:" + importe + " saldo inicial:" + this.saldo);
		}
	}

	public synchronized void ingresaDinero(int importe) {
		System.out.println("Ingresando: " + importe + " saldo inicial:" + this.saldo);
		int saldoActual = this.saldo + importe;
		setSaldo(saldoActual);

		System.out.println("Fin Ingresando: " + importe + " saldo actual:" + this.saldo);

	}

}
