package modelo;

import java.time.LocalDate;

public class Retransmision {
	private String idretransmision;
	private String titulo;
	private LocalDate fechaConHora;
	private float duracion;

	public Retransmision(String idretransmision, String titulo, LocalDate fechaConHora, float duracion) {
		super();
		this.idretransmision = idretransmision;
		this.titulo = titulo;
		this.fechaConHora = fechaConHora;
		this.duracion = duracion;
	}

	public String getIdretransmision() {
		return idretransmision;
	}

	public void setIdretransmision(String idretransmision) {
		this.idretransmision = idretransmision;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getFechaConHora() {
		return fechaConHora;
	}

	public void setFechaConHora(LocalDate fechaConHora) {
		this.fechaConHora = fechaConHora;
	}

	public float getDuracion() {
		return duracion;
	}

	public void setDuracion(float duracion) {
		this.duracion = duracion;
	}
	
	@Override
	public String toString() {
		return "Retransmision [idretransmision=" + idretransmision + ", titulo=" + titulo + ", fechaConHora="
				+ fechaConHora + ", duracion=" + duracion + "]";
	}

}
