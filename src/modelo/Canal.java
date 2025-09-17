package modelo;

import java.time.LocalDate;

public class Canal {
	private String idCanal;
	private String titulo;
	private LocalDate fechaInicio;

	public Canal(String idCanal, String titulo, LocalDate fechaInicio) {
		super();
		this.idCanal = idCanal;
		this.titulo = titulo;
		this.fechaInicio = fechaInicio;
	}

	public String getIdCanal() {
		return idCanal;
	}

	public void setIdCanal(String idCanal) {
		this.idCanal = idCanal;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	@Override
	public String toString() {
		return "Canal [idCanal=" + idCanal + ", titulo=" + titulo + ", fechaInicio=" + fechaInicio + "]";
	}

}
