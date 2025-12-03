package BoletinSemaforoRestaurante6;

import java.util.concurrent.Semaphore;

import java.util.concurrent.Semaphore;

public class HiloComensal implements Runnable {

	private String nombre;

	private Semaphore hayClientes;

	private Semaphore hayPlato;

	public HiloComensal(String nombre, Semaphore hayClientes, Semaphore hayPlato) {

		super();

		this.nombre = nombre;

		this.hayClientes = hayClientes;

		this.hayPlato = hayPlato;

	}

	@Override

	public void run() {

		comer();

	}

	public void comer() {

		while (true) {

			try {

				hayClientes.release();

				hayPlato.acquire();

				System.out.println("Estoy comiendo...");

			} catch (InterruptedException e) {

				e.printStackTrace();

			} finally {

				System.out.println(nombre + " He comido");

			}

		}

	}

}