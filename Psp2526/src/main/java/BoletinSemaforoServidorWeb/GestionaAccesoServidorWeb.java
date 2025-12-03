package BoletinSemaforoServidorWeb;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;


public class GestionaAccesoServidorWeb {
	public static void main(String[] args) {
		Semaphore peticionesSemaforo = new Semaphore(12);
		List<Thread> listaRequests = new ArrayList<Thread>(); 
		for (int i = 0; i < 20; i++) { 
			listaRequests.add(new Thread(new PeticionWeb("Peticion " + (i + 1), peticionesSemaforo))); 
		}

		for (Thread request : listaRequests) {
			request.start(); 

		}

	}

}
