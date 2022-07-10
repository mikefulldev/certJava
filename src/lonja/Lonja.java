package lonja;

import java.util.ArrayList;
import java.util.List;

//Cualquier clase genérica T admitida debe implementar la interface Valorable
//Esto de hacer genérica esta clase es porque no he hecho una jerarquía de 
//herencia porque no la he visto necesaria en este caso.
public class Lonja<T extends Valorable> {

	//Atributos
	
	private List<T> inventario;
	private String denominacion;
	
	//Constructores
	
	public Lonja() {
		this("");
	}

	public Lonja(String denominacion) {
		super();
		this.inventario = new ArrayList<T>();
		this.denominacion = denominacion;
	}

	//Getters/Setters
	
	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	//Comportamiento
	
	public T nuevaCaja(T caja) {
		inventario.add(caja);
		return caja;
	}
	
	public T obtenerCaja(int numero) {
		if (numero >= this.inventario.size() 
			|| numero < 0)
			return null;
		else
			return this.inventario.get(numero);
		
	}
	
	public Double valorarCajas() {
		Double valorTotal = 0d;
		
		//Cálculo del valor total.
		for (T caja: this.inventario) {
			valorTotal +=  caja.valorar(); 
		}
		
		return valorTotal;
	}
	
	public T venderCaja(T caja) {
		this.inventario.remove(caja);
		return caja;
	}
	
	public void vaciarLonja() {
		this.inventario.clear();
	}
	
	//Mostrará todas las cajas que tenenos
	public String mostrarInventario() {
		StringBuilder salida = new StringBuilder();
				
		salida.append(this.denominacion + "\n" + "-".repeat(denominacion.length()) + "\n\n");
		
		//Recorrido cajas
		for (T caja: inventario) {
			salida.append(caja.toString() + "\n");
		}
		
		return salida.toString();
	}
	
}
