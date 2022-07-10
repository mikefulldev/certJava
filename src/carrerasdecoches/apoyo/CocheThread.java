package carrerasdecoches.apoyo;

public class CocheThread extends Thread {

	int lentitud = 10;
	
	public CocheThread(String nombre, int lentitud) {
		super( nombre );
		this.lentitud = lentitud;
	}

	@Override
	public void run() {
		
		// Esto se pued hacer
		//int a=0, b=2, c=3;
		
		for ( int i=0; i<=100 ; i++ ) {
			System.out.println( lentitud + " Soy " + this.getName()
				+ " y estoy en la vuelta " + i);
			
				Thread.yield();
				
				try {
					sleep( lentitud );
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				
			//	En alguna parte del bucle se pasa el control al otro hilo
		}
		
		// La i no es accesible fuera del bucle
		//System.out.println("Estoy fuera del bucle " + i);
	}

	public void pinta() {
		System.out.println( this );
	}
	
	
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
	
	

	

}
