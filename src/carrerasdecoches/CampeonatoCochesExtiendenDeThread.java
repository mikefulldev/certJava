package carrerasdecoches;

import java.util.*;

import carrerasdecoches.apoyo.*;

public class CampeonatoCochesExtiendenDeThread {

	private static Random random = new Random();
	private static final int LENTITUD_MIN = 15;
	private static final int LENTITUD_MAX = 20;
	
	public static void main(String[] args) {
		
		List<CocheThread> parrilla = new ArrayList<CocheThread>();
		
		System.out.println("Va a empezar la carrera");
	
		parrilla.add( new CocheThread("Alonso T"  , dameLentidud() ) );
		parrilla.add( new CocheThread("Sainz T"   , dameLentidud() ) );
		parrilla.add( new CocheThread("Hamilton T", dameLentidud() ) );
		
		for (CocheThread c : parrilla) c.pinta();
		
		// Mala forma
		/*
		for (int i = 0; i < parrilla.size(); i++) {
			pintar( parrilla.get( i ));
		}
		*/
		
		
		System.out.println("\n Arranca la carrera");
		
		long tInicial = System.currentTimeMillis();
		
		for (CocheThread c : parrilla) {
			c.start();
		}
		
		
		for (CocheThread c : parrilla) c.pinta();
		
		//	comprobamos que aún hay alguien corriendo
		boolean laCarreraSigue;
		do {
			laCarreraSigue = false;
			for (CocheThread c : parrilla) {
				if (c.isAlive()) {
					laCarreraSigue = true;
				}
			}
		} while (laCarreraSigue);
			
		
		long tFinal = System.currentTimeMillis();

		System.out.println("\n\nLa carrera ha terminado y ha durado " 
				+ (tFinal - tInicial) + " ms");

		for (CocheThread c : parrilla) c.pinta();

	}
	
	private static int dameLentidud() {
		return random.nextInt(LENTITUD_MAX-LENTITUD_MIN) + LENTITUD_MIN;
	}

	
	//	 No es la mejor manera
	/*
	private static void pintar( Thread hilo ) {
				System.out.println( "\nN " + hilo.getName()
				+ "\nI " + hilo.getId()
				+ "\nS " + hilo.getState()
				+ "\nP " + hilo.getPriority()
				+ "\nG " + hilo.getThreadGroup()
				+ "\ns " + hilo.interrupted()
				);
	}
	*/
	
	

}
