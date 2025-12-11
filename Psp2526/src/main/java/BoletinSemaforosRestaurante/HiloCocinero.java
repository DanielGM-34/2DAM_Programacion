package BoletinSemaforosRestaurante;

import java.util.concurrent.Semaphore;

public class HiloCocinero implements Runnable {
	private String nombreCocinero;
	private Semaphore semaforoCocinero;

	public HiloCocinero(String nombreCocinero, Semaphore semaforoCocinero) {
		super();
		this.nombreCocinero = nombreCocinero;
		this.semaforoCocinero = semaforoCocinero;
	}

	public String getNombreCocinero() {
		return nombreCocinero;
	}

	public void setNombreCocinero(String nombreCocinero) {
		this.nombreCocinero = nombreCocinero;
	}

	public Semaphore getSemaforoCocinero() {
		return semaforoCocinero;
	}

	public void setSemaforoCocinero(Semaphore semaforoCocinero) {
		this.semaforoCocinero = semaforoCocinero;
	}

	@Override
	public void run() { 
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("Está cocinando el tío.");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				this.semaforoCocinero.release();
				System.out.println("Ha terminado de cocinar, notificación a los comensales.");
			}
		}
		
		
		

	}

}
