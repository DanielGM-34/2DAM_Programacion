package Bole3;


public class Multiplos implements Runnable{
	private int numero; 
	

	public Multiplos(int numero) {
		super();
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public void run() {
		// TODO Auto-enerated method stub
	
			multiplicar(this.numero);

		
		
	} 
	
	public void  multiplicar(int numero) 
	{
		for (int i = 0; i < 11; i++) {
			System.out.println(i * numero);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	}
	

}
