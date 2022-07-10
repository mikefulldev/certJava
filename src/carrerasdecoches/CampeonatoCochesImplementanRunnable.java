package carrerasdecoches;

import java.util.*;
import carrerasdecoches.apoyo.*;

public class CampeonatoCochesImplementanRunnable {
	
	public static void main(String[] args) {
		
		
		List<CocheConMaleteroRunnable> parrilla = new ArrayList<CocheConMaleteroRunnable>();
		
		//Nueva lista de procesos para mover los coches.
		List<Thread> procesos;
		
		System.out.println("Va a empezar la carrera");
	
		parrilla.add( new CocheConMaleteroRunnable("Sainz R", "150 lts." ) );
		parrilla.add( new CocheConMaleteroRunnable("Alonso R", "120 lts." ) );
		parrilla.add( new CocheConMaleteroRunnable("Hamilton R", "175 lts." ) );
		
		// Pintamos la parrilla.
		for (CocheConMaleteroRunnable c : parrilla) c.pinta();
				
		//Creación los Treads (Procesos).
		procesos = formadoParrillaSalida(parrilla);
		
		//Pintamos los procesos usando lambdas.
		procesos.forEach(p -> pintar(p));
		System.out.println("\n Arranca la carrera");
	
		long tInicial = System.currentTimeMillis();
		
		//Se apaga el semáforo.
		procesos.forEach(p -> p.start());
		
		//	comprobamos que aún hay alguien corriendo
		boolean laCarreraSigue;
		do {
			laCarreraSigue = false;
			for (Thread p : procesos) {
				if (p.isAlive()) {
					laCarreraSigue = true;
				}
				
			}
		} while (laCarreraSigue);
			
		
		long tFinal = System.currentTimeMillis();

		System.out.println("\n\nLa carrera ha terminado y ha durado " 
				+ (tFinal - tInicial) + " ms");

		//Pintamos los procesos usando lambdas.
		procesos.forEach(p -> pintar(p));

	}

	private static List<Thread> formadoParrillaSalida(List<CocheConMaleteroRunnable> coches) {
		
		List<Thread> procesos = new ArrayList<>();
		Thread proceso;
		
		//Creación de procesos.
		for (CocheConMaleteroRunnable coche : coches) {
			
			proceso = new Thread(coche,coche.getNombre());
			procesos.add(proceso);
		}
		
		return procesos;
	}
	
	// Como tenemos los procesos accesibles aquí y 
	// no hemos sobreescrito la clase Thread
	// pintaremos la info sobre los Threads desde aquí.
	private static void pintar( Thread hilo ) {
				System.out.println( "\nN " + hilo.getName()
				+ "\nI " + hilo.getId()
				+ "\nS " + hilo.getState()
				+ "\nP " + hilo.getPriority()
				+ "\nG " + hilo.getThreadGroup()
				+ "\ns " + hilo.interrupted()
				);
	}
	
	

}
