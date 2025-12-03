package BoletinSemaforosRestaurante;

import java.util.concurrent.Semaphore;

public class HiloComensal implements Runnable {
	private String nombre;
	private Semaphore semaforo;

	

	public HiloComensal(String nombre, Semaphore semaforo) {
		super();
		this.nombre = nombre;
		this.semaforo = semaforo;
	} 

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Semaphore getSemaforo() {
		return semaforo;
	}

	public void setSemaforo(Semaphore semaforo) {
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		// metodo comer
		 comer();
		// TODO Auto-generated method stub

	}
	
	public void comer() {
		try {
			semaforo.acquire();
			System.out.println("Está comiendo " + this.nombre);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
