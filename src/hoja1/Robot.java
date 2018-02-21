package hoja1;

public class Robot implements Comparable<Robot> {

	private int vida;
	private String nombre;
	
	
	public Robot(int vida, String nombre) {
		
		this.vida = vida;
		this.nombre = nombre;
	}


	public int getVida() {
		return vida;
	}


	public void setVida(int vida) {
		this.vida = vida;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public int compareTo(Robot o) {	
		return vida - o.getVida();
	}


	@Override
	public String toString() {
		return nombre + "   vida = " +vida;
	}
}
