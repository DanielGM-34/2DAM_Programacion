package BoletinSemaforos;

import java.util.ArrayList;
import java.util.List;

public class Gasolinera {
	public static void main(String[] args) {
		SemaforoCoche semaforo = new SemaforoCoche(3);
		List<Thread> listaCoches = new ArrayList<Thread>();

		for (int i = 0; i < 8; i++) {
			listaCoches.add(new Thread(new Coche("Coche " + (i + 1), semaforo)));
		}

		for (Thread coche : listaCoches) {
			coche.start();

		}

	}
}