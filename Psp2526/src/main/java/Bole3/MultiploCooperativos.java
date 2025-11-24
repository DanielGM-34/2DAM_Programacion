package Bole3;


public class MultiploCooperativos {
	

	public MultiploCooperativos() {
		super();
	}


	public MultiploCooperativos(int numero) {
		super();
	}

	
	public static synchronized  void multiplicar(int numero) 
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
