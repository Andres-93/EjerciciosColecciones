package hoja1;

public class Peliculas {

	private String titulo;
	private int precio;
	private String estado;
	
	
	
	@Override
	public String toString() {
		return "titulo=" + titulo + ", precio=" + precio + ", estado=" + estado ;
	}



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public int getPrecio() {
		return precio;
	}



	public void setPrecio(int precio) {
		this.precio = precio;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public Peliculas(String titulo, int precio, String estado) {
		super();
		this.titulo = titulo;
		this.precio = precio;
		this.estado = estado;
	}
	
	
	
}
