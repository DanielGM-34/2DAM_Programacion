package BoletinSemaforoServidorWeb;

import java.util.concurrent.Semaphore;

public class PeticionWeb implements Runnable {
	private String nombrePeticion;
	private Semaphore semaforo;

	
	
	public PeticionWeb(String nombrePeticion, Semaphore semaforo) {
		super();
		this.nombrePeticion = nombrePeticion;
		this.semaforo = semaforo;
	}

	public String getNombrePeticion() {
		return nombrePeticion;
	}

	public void setNombrePeticion(String nombrePeticion) {
		this.nombrePeticion = nombrePeticion;
	}

	public Semaphore getSemaforo() {
		return semaforo;
	}

	public void setSemaforo(Semaphore semaforo) {
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		realizaRequest();
		liberarRequest();
		//metodo para las peticiones realiza request
		
		
		// TODO Auto-generated method stub
		
	}
	
	public void realizaRequest() {
		System.out.println("Esperando turno " + this.nombrePeticion);

		try {
			semaforo.acquire();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Realizando request " + this.nombrePeticion);
		

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	
	public void liberarRequest() {
		semaforo.release();
		System.out.println("Request " + this.nombrePeticion + " terminada");


	}

}
