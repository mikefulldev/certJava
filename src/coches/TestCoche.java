package coches;

public class TestCoche {

	public static void main(String[] args) {
		new TestCoche();
	}	
	
	public TestCoche() {
		Coche c1 = new Coche();
		Coche c2 = new Coche();
		
		c1.color = "verde";
		c2.color = "azul";
		
		System.out.println("c1 -> color: " + c1.color);
		System.out.println("c1 -> color: " + c2.color);
		
		// Clase anidada (interna - inner)
		//	sl es el nombre del objeto -> el objeto tiene nombre -> no es un objeto anónimo
		SoyLavable sl = this.new SoyLavable();
		System.out.println(sl);
		
		//	No hay referencia de objeto -> es un objeto ANONIMO:
		System.out.println( this.new SoyLavable().toString() );
	
		//	instanciamos un objeto CON nombre "il"
		//	de una CLASE ANONIMA
		ILavable il = new ILavable() {
			@Override
			public String toString() {
				return "Que sí, que soy una CLASE ANONIMA";
			}
		};
		
		System.out.println( il );
		
		System.out.println(
				
				//new NoLoSe pero que implements ILAVABLE
				
				(new ILavable() {
					@Override
					public String toString() {
						return "Ahora ni tengo nombre de clase, ni de objeto";
					}
				}).toString()
		);
	
		//		estoy instanciando una Interface
		System.out.println( (new ILavable() {}).texto );
		
		ILavable conTexto = new ILavable() {};
		System.out.println( "Tenemos " + conTexto.texto );
		// no se puede
		// conTexto.texto = "Otro valor";
		
		// SI podemos acceder desde la Clase (en este caso la Inteface)
		System.out.println(	ILavable.texto );
		
		// NO es modificable porque es final
		// ILavable.texto = "Otra cosa";
		
		
		
	}
	
	// Esta clase
	//	- interna(anidada/inner) porque está definida dentro de TestCoche
	//	- SI tiene un nombre (SoyLavable) -> NO es anónima
	private class SoyLavable implements ILavable{
		
		@Override
		public String toString() {
			return "SoyLavable [texto=" + texto + "]";
		}

		private String texto = "Yo soy lavable";			
	
	}
	
	
	
}
