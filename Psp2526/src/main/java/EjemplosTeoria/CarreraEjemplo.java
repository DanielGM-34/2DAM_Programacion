package EjemplosTeoria;

public class CarreraEjemplo {
	public static void main(String[] args) throws InterruptedException {
        long inicioPadre = System.currentTimeMillis();

	       Contador contador = new Contador();
	       Thread t1 = new Thread(new TareaIncremento(contador));
	       Thread t2 = new Thread(new TareaIncremento(contador));
	       
	       Thread t3= new Thread(new TareaIncremento(contador));
	       Thread t4 = new Thread(new TareaIncremento(contador));
	       Thread t5 = new Thread(new TareaIncremento(contador));
	       Thread t6 = new Thread(new TareaIncremento(contador));
	       
	       t1.start();
	       t2.start();
	       t3.start();
	       t4.start();
	       t5.start();
	       t6.start();


	       
	       
	    
	       


	       t1.join();
	       t2.join();
	       t3.join();
	       t4.join();
	       t5.join();
	       t6.join();
	       
	       

	       t1.join();
	       t2.join();
	       t3.join();
	       t4.join();
	       t5.join();
	       t6.join();
	       System.out.println("Valor final: " + contador.getValor());
	       
	       long finPadre = System.currentTimeMillis();
	       long tiempoPadre = finPadre - inicioPadre;

	        System.out.println("El hilo padre terminó después de esperar a todos sus hijos.");
	        System.out.println("Tiempo total del hilo padre: " + tiempoPadre + " ms");
	    }
	   
	
		


	

}
