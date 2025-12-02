package Bole5EjemploSemaforoDiapo;


class SemaforoBinario {
	private boolean estaLibre; // Definimos una bandera que nos dice si el acceso está libre
	public SemaforoBinario() {
		super(); 
//		Class<Semaphore> p = Semaphore.class;
	//	p.getName();
		estaLibre = true;
	}
	public synchronized void adquirir() throws InterruptedException { 
		while (!estaLibre) {
			wait();
		}
		
		estaLibre =false ;
	}
	public synchronized void liberar() {
		estaLibre = true;
		notifyAll(); // Notificamos
	}
}
 
