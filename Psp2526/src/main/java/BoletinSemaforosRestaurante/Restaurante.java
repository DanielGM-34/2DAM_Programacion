package BoletinSemaforosRestaurante;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Restaurante {
	public static void main(String[] args) {
		Semaphore comensalSema = new Semaphore(3);
		try { 
			comensalSema.acquire(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Thread> comensales = new ArrayList<Thread>();
		for (int i = 0; i < 4; i++) {
			Thread comensal = new Thread(new HiloComensal("comensal "+i, comensalSema ));
			comensales.add(comensal);
			
		}
		Thread coci = new Thread(new HiloCocinero("cocinero 1 " , comensalSema));
		comensales.add(coci);
		
		for (Thread thread : comensales) {
			thread.start();
		}

		
		
	}
	

}
