package hoja1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class Ejercicio1 {
	
	private static final int NUMERO_ROBOTS = 10;


	public static void main(String[] args) {
				
		ArrayList<Robot> lista = new ArrayList<>();
	
			rellenarLista(lista);
			ordenarPorVida(lista);
			System.out.println("*****LISTA ORDENADA POR VIDA DE ROBOTS*****");
			mostrarRobots(lista);
			robotsMasMitadVida(lista);
			imprimerLos3DeMasVida(lista);
	}
	/*
	 * Imprimir los 3 robots de mas vida.
	 */
	private static void imprimerLos3DeMasVida(ArrayList<Robot> lista) {

		int cont = 0;
		
		Collections.reverse(lista);
		
		Iterator<Robot> it = lista.iterator();
		System.out.println("****Los 3 con mas vida****");
		while(it.hasNext() && cont < 3) {
			
			
			System.out.println(it.next());
			cont++;
			
		}
		
	}

	private static void robotsMasMitadVida(ArrayList<Robot> lista) {
		
		for(Robot e : lista) {
			
			if(e.getVida() >= 50) {
				System.out.println("El robot " + e.getNombre() + " tiene mas del 50% de vida");
			}
		}
		
	}

	private static void ordenarPorVida(ArrayList<Robot> lista) {
		
		Collections.sort(lista);
		
	}

	private static void mostrarRobots(ArrayList<Robot> lista) {
		
		for( Robot e : lista) {
			
			System.out.println(e);
		}
		
		
	}

	private static void rellenarLista(ArrayList<Robot> lista) {
		
		Robot e;
		
		for(int i = 0; i < NUMERO_ROBOTS ; i++) {
			
			e = new Robot(generarAleatorio(), "RBT"+(i+1));		
			lista.add(e);
			
		}		
	}

	private static int generarAleatorio() {
		
		Random rd = new Random();
		
		int aleatorio = rd.nextInt(10-1+1)+1;
		
		return aleatorio;
	}	
}
