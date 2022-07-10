package carrerasdecoches.apoyo;

public abstract class CocheConMaletero  {
	private String maletero;
	
	//Estos métodos deben ser accesibles y no private
	//como estaban. 
	//Como mínimo debería ser protected para poder ser
	//accedido desde las clases hijas.
	public String getMaletero() {
		return maletero;
	}

	public void setMaletero(String maletero) {
		this.maletero = maletero;
	}


}
