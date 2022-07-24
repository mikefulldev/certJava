package taller.apoyo;

import taller.especificaciones.Arreglable;

/*Una clase vehiculo abstracta que tenga:
*- marca
*- modelo
*- cilindrada
**/public abstract class Vehiculo {

	//Atributos
	private String marca;
	private String modelo;
	private int cilindrada;
	
	//Constructores
	protected Vehiculo() {
		
		//Creación de un vehículo sin datos.
		this.marca = "";
		this.modelo = "";
		this.cilindrada = 0;
	}

	
	//Getters/Setters
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}
	
	public boolean esArreglable() {
		
		return (this instanceof Arreglable);
	}
	
	//Invocar construcción del Builder.
	public static Builder builder() {return new Builder();}
	
	/*
	 * Clase interna constructora de vehículos.
	 */
	public static class Builder {
		
		//Atributos
		private Vehiculo vehiculo;
		
		//Constructor
		public Builder() {
			
			this.vehiculo = null;
		}
		
		
		protected Vehiculo setVehiculo(Vehiculo vehiculo) {
			
			this.vehiculo = vehiculo;
			return vehiculo;
		}
		
		public Builder setMarca(String marca) {
			vehiculo.marca = marca;
			return this;
		}
		
		public Builder setModelo(String modelo) {
			vehiculo.modelo = modelo;
			return this;
		}
		
		public Builder setCilindrada( int cilindrada ) {
			
			this.vehiculo.setCilindrada(0);
			return this;
		}
		
		public Vehiculo build( ) {
			
			return vehiculo;
		}

	}
	
}
