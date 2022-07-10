package carrerasdecoches;

public class CampeonatoThreads {

	public static void main(String[] args) {
		System.out.println("Va a empezar la carrera");
		
		Thread t1 = new Thread("Alonso");
		Thread t2 = new Thread("Sainz");
		
		pintar(t1);
		pintar(t2);
		
		System.out.println("Arranca la carrera");
		
		t1.start();
		t2.start();
		
		pintar(t1);
		pintar(t2);

		
		System.out.println("La carrera ha terminado");

	}
	
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
