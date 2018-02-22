package hoja1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

public class EjercicioRobot2 {
		
		private static final int LIMITE_VIDA_MOSTRAR = 50;
		private static final int NUMERO_ROBOTS = 10;


		public static void main(String[] args) {
					
			TreeSet<Robot> lista = new TreeSet<>();
		
				rellenarLista(lista);
				System.out.println("*****LISTA ORDENADA POR VIDA DE ROBOTS*****");
				mostrarRobots(lista);
				robotsMasMitadVida(lista);
				imprimerLos3DeMasVida(lista);
				//metodoBurbujaOrdenacion(lista);
		}
		/*
		private static void metodoBurbujaOrdenacion(ArrayList<Robot> lista) {
			Robot aux = null;
			
			for(int i = 0; i < (lista.size()-1); i++)
				for(int j = (i+1); j < lista.size()-1; j++) {
					
					if(lista.get(i).getVida() > lista.get(j).getVida()) {
						
						aux = lista.get(i);				
						lista.set(i, lista.get(j));
						lista.set(j, aux);
					}
				
				}
			
		}
		*/
		/*
		 * Imprimir los 3 robots de mas vida.
		 */
		private static void imprimerLos3DeMasVida(TreeSet<Robot> lista) {

			int cont = 0;
			

			
			Iterator<Robot> it = lista.descendingIterator();
			System.out.println("****Los 3 con mas vida****");
			while(it.hasNext() && cont < 3) {
				
				
				System.out.println(it.next());
				cont++;
				
			}
			
		}

		private static void robotsMasMitadVida(TreeSet<Robot> lista) {
			
			for(Robot e : lista) {
				
				if(e.getVida() >= LIMITE_VIDA_MOSTRAR) {
					System.out.println("El robot " + e.getNombre() + " tiene mas del 50% de vida");
				}
			}
			
		}


		private static void mostrarRobots(TreeSet<Robot> lista) {
			
			for( Robot e : lista) {
				
				System.out.println(e);
			}
			
			
		}
		
		

		private static void rellenarLista(TreeSet<Robot> lista) {
			
			Robot e;
			
			for(int i = 0; i < NUMERO_ROBOTS ; i++) {
				
				e = new Robot(generarAleatorio(), "RBT"+(i+1));		
				lista.add(e);
				
			}		
		}

		private static int generarAleatorio() {
			
			Random rd = new Random();
			
			int aleatorio = rd.nextInt(100-1+1)+1;
			
			return aleatorio;
		}	


}
