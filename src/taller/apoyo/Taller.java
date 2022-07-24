package taller.apoyo;

import java.util.*;

public class Taller {
	
	//Atributos
	private final int MAXIMA_CAPACIDAD_TALLER = 4; 
	private List<VehiculoArreglable> vehiculos = null;
	
	//Constructores
	public Taller() {
		
		this.vehiculos = new ArrayList<VehiculoArreglable>();
	}
	
	//Métodos
	//Versión de método con mensaje ya incorporado.
	//Para mostrar distintos enfoques.
	public boolean recibeVehiculo(Vehiculo vehiculo) {
		
		if (vehiculos.size() < MAXIMA_CAPACIDAD_TALLER) {
			
			if (vehiculo.esArreglable()) {
				vehiculos.add((VehiculoArreglable)vehiculo);
				return true;
			}
		}
		else
		
			System.out.println("La máxima capacidad del taller (" 
							+ MAXIMA_CAPACIDAD_TALLER 
							+ ") ha sido alcanzada.\n"
							+ "Por favor, espere a que sea retirado algún vehículo.");
		
		//Si llegamos aquí el vehículo no ha podido ser recibido.
		return false;
	}
	
	//Versión de método con mensaje no incorporado, 
	//solamente, si se ha realizado la operación.
	//Creo que este enfoque es mejor.
	//Para mostrar distintos enfoques.
	public boolean retiraVehiculo(VehiculoArreglable vehiculo) {
		
		return ( vehiculos.remove(vehiculo)  ? true : false) ; 	
		
	}
	
	public void arreglaVehiculo(VehiculoArreglable vehiculo) {
		
		vehiculo.arreglar();

	}
	
	public void arreglaTodos() {
		
		vehiculos.forEach(v -> arreglaVehiculo(v));
	}
	
	public List<VehiculoArreglable> damePedidos() {
		
		return (ArrayList) ((ArrayList) vehiculos).clone();
	}

	@Override
	public String toString() {
		StringBuilder st = new StringBuilder("Taller\n"
										+ "-".repeat("Taller".length())
										+ "\n\n");
		
		vehiculos.forEach(v -> st.append("\t" + v + "\n"));
		
		return st.toString();
	}
	
	 

}
