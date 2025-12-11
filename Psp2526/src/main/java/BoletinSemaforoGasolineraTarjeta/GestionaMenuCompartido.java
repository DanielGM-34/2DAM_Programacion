package BoletinSemaforoGasolineraTarjeta;

import java.util.concurrent.Semaphore;

public class GestionaMenuCompartido {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Empiezan en 0, porque el cocinero no cocina hasta que no hay clientes
				//Hasta que no hay un plato no se come
				Semaphore hayClientes = new Semaphore(1);
		        Semaphore hayPlato = new Semaphore(3);
		        
		        try { 
					hayClientes.acquire();
					hayPlato.acquire(3);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		        //Solo hay un cocinero
		        Cocinero cocinero = new Cocinero("Cocinero 1", hayClientes, hayPlato);
		        //Me creo el hilo cocinero
		        Thread hiloCocinero = new Thread(cocinero);
		        //Lo inicio
		        hiloCocinero.start(); 
		        
		        //Clientes 
		        for (int i = 1; i <= 7; i++) {
		            Cliente cliente = new Cliente("Cliente " + i, hayClientes, hayPlato);
		            //Me creo hilo clientes
		            Thread hiloCliente = new Thread(cliente);
		            //Lo inicio
		           hiloCliente.start();
		        }
		       
			}
	}