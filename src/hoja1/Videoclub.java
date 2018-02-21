package hoja1;

import java.util.ArrayList;
import java.util.Scanner;

public class Videoclub {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Peliculas> lista = new ArrayList<>();
		
		añadirPelisPorDefecto(lista);
		mostrarMenu();
		elegirOpcion(sc,lista);
		
		
		sc.close();
	}

	private static void añadirPelisPorDefecto(ArrayList<Peliculas> lista) {
		
		Peliculas aux = new Peliculas("El señor de los anillos el retorno del rey", 4 , "si");
		lista.add(aux);
		aux = new Peliculas("Titanic", 3 , "no");
		lista.add(aux);
		aux = new Peliculas("Skyfall", 3 , "no");
		lista.add(aux);
	}

	private static void elegirOpcion(Scanner sc, ArrayList<Peliculas> lista) {
		
		int opcion = 0;
		boolean comprobar = true;
		boolean continuar = true;
		do {
			while(comprobar) {
				try {	
					System.out.println("Elija la opcion deseada : ");
					opcion = Integer.parseInt(sc.nextLine());
					if (opcion < 0 || opcion > 5 )throw new FueraDeRango("Por favor seleccione unicamente una opcion valida.");
					comprobar = false;
				}catch(NumberFormatException error) {
					System.out.println("Introduzca unicamente valores enteros." + error.getMessage());
				}catch(FueraDeRango error1) {
					System.out.println(error1.getMessage());
				}
			}
			
			switch(opcion) {
			
			case 1: mostrarPeliculasDisponibles(lista);break;
			case 2: alquilarPelicula(lista,sc);break;
			case 3: devolverPelicula(lista,sc);break;
			case 4: mostrarTodasPeliculas(lista);break;
			default:
				continuar=false;
				break;
			}
			comprobar = true;
		}while(continuar);
		
	}
	
	private static void mostrarTodasPeliculas(ArrayList<Peliculas> lista) {
		
		for(Peliculas e : lista) {
			System.out.println(e);
		}
		
	}

	private static void devolverPelicula(ArrayList<Peliculas> lista, Scanner sc) {
		
		String pelicula="";
		
		System.out.println("Que pelicula desea devolver?");
		pelicula = sc.nextLine();
		
		if(comprobarDisponibilidad(pelicula,lista,1) == 1) {
			System.out.println("-----Devolvio la pelicula cone exito----");
		}
		else {
			System.out.println("No se pudo completar devolver, puede que su pelicula no este alquilada o haya escrito mal el titulo, por favor revise el listado completo.");
		}
	}

	private static void alquilarPelicula(ArrayList<Peliculas> lista, Scanner sc) {
		
		String pelicula="";
		
		System.out.println("¿Que pelicula desea alquilar?");
		pelicula = sc.nextLine();
		
		
		if(comprobarDisponibilidad(pelicula,lista, 0) == 1) {
			System.out.println("-----Alquilo la pelicula con exito----");
		}
		else {
			System.out.println("No se pudo completar el alquiler, puede que su pelicula este ya alquilada o haya escrito mal el titulo, por favor revise el listado de peliculas disponibles.");
		}
		
	}
	/*
	 * La opcion simplemente indicara si lo que queremos es alquilar o devolver, 0 en caso de alquilar 1 en caso de devolver.
	 */
	private static int comprobarDisponibilidad(String pelicula, ArrayList<Peliculas> lista,int opcion) {
		
		int num = 0;
		
		for(Peliculas e : lista) {
			if(opcion == 0) {
				if(e.getTitulo().equalsIgnoreCase(pelicula)) {
					if(e.getEstado().equalsIgnoreCase("no")) {
						num = 1;
						e.setEstado("si");						//Si encontramos la pelicula sin alquilar, cambiaremos el estado a alguilada.-
					}			
				}
			}else if(opcion == 1) {
				if(e.getTitulo().equalsIgnoreCase(pelicula)) {
					if(e.getEstado().equalsIgnoreCase("si")) {
						num = 1;
						e.setEstado("no");						//Si encontramos la pelicula aluilada, cambiaremos el estado a sin alquilar.-
					}			
				}
			}
		}
	return num;
}

	/*
	 * Muestra unicamente las peliculas con estado no alquilado
	 */
	private static void mostrarPeliculasDisponibles(ArrayList<Peliculas> lista) {
		
		System.out.println("*****Peliculas disponibles*****");
		for(Peliculas e : lista) {
			
			if(e.getEstado().equalsIgnoreCase("no")){
				System.out.println(e);
			}			
		}		
	}

	private static void mostrarMenu() {
		
		
		System.out.println("    -------------VIDEOCLUB--------------");
		System.out.println(" 1. Mostrar peliculas disponibles para alquilar.");
		System.out.println(" 2. Alquilar pelicula.");
		System.out.println(" 3. Devolver pelicula.");
		System.out.println(" 4. Mostrar lista completa de peliculas.");
		System.out.println(" 0. Salir.");
	}

}
