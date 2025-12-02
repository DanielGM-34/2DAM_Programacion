package Bole5;

public class GestionaCuenta {
	public static void main(String[] args) {
		Cuenta cuen1 = new Cuenta( (int) (Math.random() * 500 + 1));
		HiloIngresa ingresaHilo = new HiloIngresa(cuen1);
		HiloRetira retiraHilo = new HiloRetira(cuen1);
		
		HiloIngresa ingresaHilo2 = new HiloIngresa(cuen1);
		HiloRetira retiraHilo2 = new HiloRetira(cuen1);

		try {
			ingresaHilo.start();
			retiraHilo.start();
			

			ingresaHilo.join();
			retiraHilo.join();
			
			ingresaHilo2.start();
			retiraHilo2.start();
			

			ingresaHilo2.join();
			retiraHilo2.join();
			
			
			

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			
			
			e.printStackTrace(); 
		}

		System.out.println("En el padre:" + cuen1.getSaldo());

	}

}
