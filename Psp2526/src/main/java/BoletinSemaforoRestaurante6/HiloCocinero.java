package BoletinSemaforoRestaurante6;

import java.util.concurrent.Semaphore;

public class HiloCocinero implements Runnable {

	private String nombre;

	private Semaphore hayClientes;

	private Semaphore hayPlato;

	public HiloCocinero(String nombre, Semaphore hayClientes, Semaphore hayPlato) {

		super();

		this.nombre = nombre;

		this.hayClientes = hayClientes;

		this.hayPlato = hayPlato;

	}

	@Override

	public void run() {

		cocinar();

	}

	public void cocinar() {

		while (true) {

			try {

				hayClientes.acquire(1);

				System.out.println("Estoy cocinando");

				Thread.sleep(4000);

			} catch (InterruptedException e) {

				e.printStackTrace();

			} finally {

				hayPlato.release();

				System.out.println(nombre + " Hay plato");

			}

		}

	}

}