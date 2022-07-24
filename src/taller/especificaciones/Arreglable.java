package taller.especificaciones;

/*Una interface arreglable que defina:
*- si está roto
*- si está arreglado
*- un método arreglar
*/
public interface Arreglable {

	boolean estaRoto();
	//Este sobraría porque si no está roto es que está arreglado
	//pero lo haremos en base a un solo atributo de estado.
	boolean estaArreglado();
	void arreglar();
	
	//Vamos a proporcionar los posibles estado de un Arreglabe
	//en vez de utilizar booleans para anticipar otros posibles
	//estados en el futuro.
	public enum Estado {
		
		ROTO,
		ARREGLADO
	}
}
