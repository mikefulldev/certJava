package taller;

import taller.apoyo.*;
import taller.especificaciones.Arreglable;

public class TestearTaller {

	public static void main(String[] args) {
		Taller taller = new Taller();

		//Recibimos a la vez que creamos vehículos.
		
		//Primer coche
		if (taller.recibeVehiculo(Coche.builder()
						.setMarca("Renault")
						.setModelo("Clio")
						.setCilindrada(1200)
						.setPuertas(3)
						.setEstado(Arreglable.Estado.ROTO)
						.build()
						))
			System.out.println("Nuevo vehículo recibido");
		else System.out.println("No se ha podido recepcionar el vehículo");
		
		separar();
		
		//Segundo coche. Se inserta como no averiado.
		if (taller.recibeVehiculo(Coche.builder()
						.setMarca("Opel")
						.setModelo("Astra")
						.setCilindrada(2000)
						.setPuertas(3)
						.setEstado(Arreglable.Estado.ARREGLADO)
						.build()
						))
			System.out.println("Nuevo vehículo recibido");
		else System.out.println("No se ha podido recepcionar el vehículo");			

		separar();
		
		//Segunda moto
		if (taller.recibeVehiculo(Moto.builder()
						.setMarca("Honda")
						.setModelo("CBR")
						.setCilindrada(600)
						.setMotor(Moto.TipoMotor.DosTiempos)
						.setEstado(Arreglable.Estado.ROTO)
						.build()
						))
			System.out.println("Nuevo vehículo recibido");
		else System.out.println("No se ha podido recepcionar el vehículo");			

		separar();
		
		
		//Tercer coche
		if (taller.recibeVehiculo(Coche.builder()
						.setMarca("Ford")
						.setModelo("Focus")
						.setCilindrada(1800)
						.setPuertas(5)
						.setEstado(Arreglable.Estado.ROTO)
						.build()
						))
			System.out.println("Nuevo vehículo recibido");
		else System.out.println("No se ha podido recepcionar el vehículo");			
		
		separar();
		
		//Cuarta moto
		if (taller.recibeVehiculo(Moto.builder()
						.setMarca("Yamaha")
						.setModelo("RM1")
						.setCilindrada(998)
						.setMotor(Moto.TipoMotor.CuatroTiempos)
						.setEstado(Arreglable.Estado.ROTO)
						.build()
						))
			System.out.println("Nuevo vehículo recibido");
		else System.out.println("No se ha podido recepcionar el vehículo");			

		separar();
		
		//Quinto coche. No puede ser admitido en taller por exceso de capacidad
		if (taller.recibeVehiculo(Coche.builder()
						.setMarca("Citroen")
						.setModelo("Cactus")
						.setCilindrada(1600)
						.setPuertas(5)
						.setEstado(Arreglable.Estado.ROTO)
						.build()
						))
			System.out.println("Nuevo vehículo recibido");
		else System.out.println("No se ha podido recepcionar el vehículo");			
		
		separar(2);
		
		//Mostrar contenido y estado de vehículos del taller.
		System.out.println(taller);

		separar(2);
		
		taller.arreglaVehiculo(taller.damePedidos().get(2));

		separar();
		
		taller.arreglaTodos();

		separar(2);
		
		//Mostrar contenido y estado de vehículos del taller.
		System.out.println(taller);
		
		

	} //main
	
	public static void separar(int numLineas) {
		
		if (numLineas >0) System.out.println("\n".repeat(numLineas-1));
	}
	
	public static void separar() {
		separar(1);
	}
	
} //Taller
