package carrerasdecoches.apoyo;

import java.util.Random;

public class CocheConMaleteroRunnable extends CocheConMaletero implements Runnable{

	//Atributos para aleaoriedad lentitud.
	private static Random random = new Random(System.currentTimeMillis());
	private static final int LENTITUD_MIN = 15;
	private static final int LENTITUD_MAX = 20;
	
	int lentitud ;
	String nombre;
	
	//Constructores
	
	public CocheConMaleteroRunnable(String nombre, String maletero) {
		this(nombre);
		this.setMaletero(maletero);	
	}
	
	public CocheConMaleteroRunnable(String nombre) {
		this.setNombre(nombre);
	}

	//Getters/Setters
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//Comportamiento
	
	@Override
	public void run() {
		
		// Esto se pued hacer
		//int a=0, b=2, c=3;
		
		for ( int i=0; i<=100 ; i++ ) {	
							
			// No puede ser utilizado si no somos un Thread.
			// Debe ser utilizado aquí porque es estático y no es
			// aplicable a un Thread en concreto, sino al que esté
			// en ejecución en el momento al que se llama.
			// Desde aquí se asegura que este hilo está en 
			// ejecución y, al menos, lo dormirá a él.
		    // Si lo llamanos desde la clase Campeonato... no
			// funciona para el propósito que queremos.
			try {
				
				this.lentitud = dameLentidud();
				Thread.sleep(lentitud);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
				
			//Imprimimos estado
			if (i < 100) {
				System.out.println(this.lentitud + " - " 
						+ this + " y estoy en la vuelta " + i);
			} else {
				//Y si hemos finalizado
				System.out.println("\n" + this
									+ " y HE LLEGADO A META");
			}
			
			//	En alguna parte del bucle se pasa el control al otro hilo
		}
		
		// La i no es accesible fuera del bucle
		//System.out.println("Estoy fuera del bucle " + i);
	}

	private static int dameLentidud() {
		return random.nextInt(LENTITUD_MAX-LENTITUD_MIN) + LENTITUD_MIN;
	}
	
	public void pinta() {
		System.out.println( this );
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder("Soy " + this.nombre);
		sb.append(" y mi maletero es " + super.getMaletero());
		
		return sb.toString();
	}
	
	/*
	 * Esto no funciona porque los métodos de Thread no están 
	 * disponibles.
	@Override
	public String toString() {
		StringBuilder st = new StringBuilder("\nN " + getName());
		st.append( "\nI " + getId() ) ;
		st.append( "\nS " + getState() );
		st.append( "\nP " + getPriority() );
		st.append( "\nG " + getThreadGroup() );
		st.append( "\ns " + interrupted() );
		return  st.toString();
	}
	*/
	

	

}
