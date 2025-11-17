package HILOS.mascota;

public class Mascota implements Runnable{
	private String nombreMascota;
	private int numVecesCome;

	public Mascota() {
		super();
	}

	public Mascota(String nombreMascota, int numVecesCome) {
		super();
		this.nombreMascota = nombreMascota;
		this.numVecesCome = numVecesCome;
	}

	public String getNombreMascota() {
		return nombreMascota;
	}

	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}

	public int getNumVecesCome() {
		return numVecesCome;
	}

	public void setNumVecesCome(int numVecesCome) {
		this.numVecesCome = numVecesCome;
	}

	@Override
	public String toString() {
		return "Mascota [nombreMascota=" + nombreMascota + ", numVecesCome=" + numVecesCome + "]";
	}

	
	public void comer() {
		this.numVecesCome+=1;
	}
	
	@Override
	public void run() {
		try {
			System.out.println(this.getNombreMascota() + " ha comenzado a comer." + Thread.currentThread().getName());
			this.comer();

			Thread.sleep(1000); 
 
			System.out.println("La mascota " + this.getNombreMascota() + " ha terminado de comer." + Thread.currentThread().getName());

			//System.out.println("La mascota" + this.getNombreMascota() + " ha comido " + this.getNumVecesCome());

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// TODO Auto-generated method stub
		
	}

}
