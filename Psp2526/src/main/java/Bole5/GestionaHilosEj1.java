package Bole5;

public class GestionaHilosEj1 {
    public static void main(String[] args) {
        String ruta = "src/main/resources/pedidos.txt";

        // Crear los 5 hilos, cada uno con una vocal distinta
        CuentaVocalesEj1 hA = new CuentaVocalesEj1('a', ruta);
        CuentaVocalesEj1 hE = new CuentaVocalesEj1('e', ruta);
        CuentaVocalesEj1 hI = new CuentaVocalesEj1('i', ruta);
        CuentaVocalesEj1 hO = new CuentaVocalesEj1('o', ruta);
        CuentaVocalesEj1 hU = new CuentaVocalesEj1('u', ruta);
        
        
        // Lanzar los hilos
        hA.start();
        hE.start();
        hI.start();
        hO.start();
        hU.start();

        // Esperar a que terminen
        try {
            hA.join();
            hE.join(); 
            hI.join();
            hO.join();
            hU.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
 
        // Mostrar el total de vocales
        System.out.println("Total de vocales: " + CuentaVocalesEj1.getSumaVocales());
    }
}
