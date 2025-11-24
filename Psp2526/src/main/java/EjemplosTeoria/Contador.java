package EjemplosTeoria;

class Contador {
	   private int valor = 0;
	   //zona crítica
	   public synchronized void incrementar() { 
	       valor++;
	   }
	   public int getValor() {
	       return valor;
	   }
	}
