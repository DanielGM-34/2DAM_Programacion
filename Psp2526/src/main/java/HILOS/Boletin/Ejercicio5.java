package HILOS.Boletin;

import java.util.ArrayList;
import java.util.List;

import HILOS.mascota.Mascota;

public class Ejercicio5 {
    public static void main(String[] args) {
        Mascota p = new Mascota("Lulú", 0);

        // Creamos una colección de hilos
        List<Thread> cuidadores = new ArrayList<Thread>();
 
        // Lanzamos 100 cuidadores
        for (int i = 0; i < 100; i++) {
            Thread cui = new Thread(p, "Cuidador " + i);
            cuidadores.add(cui);

            // Asignamos prioridad según par/impar
            if (i % 2 != 0) {  
                cui.setPriority(Thread.MIN_PRIORITY);
                //System.out.println(cui.getName() + " es impar con prioridad " + cui.getPriority());
            } else {
                cui.setPriority(Thread.MAX_PRIORITY);
                //System.out.println(cui.getName() + " es par con prioridad " + cui.getPriority());
            } 

            // Iniciamos el hilo
            cui.start();
        }

        // Esperamos a que todos los hilos terminen
        for (Thread thread : cuidadores) {
            try { 
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Mostramos cuántas veces ha comido la mascota
        System.out.println("La mascota ha comido " + p.getNumVecesCome() + " veces.");
    }
}
