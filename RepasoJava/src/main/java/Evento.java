import java.time.LocalDate;

public class Evento {
	private int id;
	private String nombre;
	private final LocalDate fecha;
	private int numEntradasVendidas;
	private int capacidadMax;
	static int contador;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumEntradasVendidas() {
		return numEntradasVendidas;
	}

	public void setNumEntradasVendidas(int numEntradasVendidas) {
		this.numEntradasVendidas = numEntradasVendidas;
	}

	public int getCapacidadMax() {
		return capacidadMax;
	}

	public void setCapacidadMax(int capacidadMax) {
		this.capacidadMax = capacidadMax;
	}

	public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		Evento.contador = contador;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public Evento(String nombre, LocalDate fecha, int numEntradasVendidas, int capacidadMax) {
		super();
		this.id = contador + 1;
		this.nombre = nombre;
		this.fecha = fecha;
		this.numEntradasVendidas = numEntradasVendidas;
		this.capacidadMax = capacidadMax;
	}

}
