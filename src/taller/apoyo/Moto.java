package taller.apoyo;


public class Moto extends VehiculoArreglable {

	//Atributos
	private TipoMotor motor = null;
	
	//Constructores
	protected Moto() {}
	
	//Getters/Setters
	public TipoMotor getMotor() {
		return this.motor;
	}

	public void setMotor(TipoMotor motor) {
		this.motor = motor;
	}

	@Override
	public void arreglar() {
		
		if (this.estaRoto()) {
			super.arreglar();
			System.out.println(this + " ha sido reparada");
		} else System.out.println(this + " no puede ser reparada porque no está averiada");
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(this.getClass().getSimpleName());
		
		sb.append("\t" + super.toString() + "\t" + this.getMotor() + "\t" + this.estado);
		
		return sb.toString();
	}

	//Invocar construcción del Builder.
	public static Moto.Builder builder() {return new Moto.Builder();}
	
	public static class Builder extends Vehiculo.Builder {
		
		//Atributos
		private Moto vehiculo = null;
		
		//Constructores
		public Builder( ) {
			
			super();
			this.vehiculo = (Moto) super.setVehiculo(new Moto());
		}

		//Métodos
		@Override
		public Moto build() {
			
			return this.vehiculo;
		}
		
		@Override
		public Builder setMarca(String marca) {
			
			super.setMarca(marca);
			return this;
		}

		@Override
		public Builder setModelo(String modelo) {
			super.setModelo(modelo);
			return this;
		}

		@Override
		public Builder setCilindrada(int cilindrada) {
			
			super.setCilindrada(cilindrada);
			return this;
		}
		
		public Builder setEstado(Estado estado) {
			
			this.vehiculo.setEstado(estado);
			return this;
		}
		
		public Builder setMotor(TipoMotor motor) {
			this.vehiculo.setMotor(motor);
			return this;
		}
		
	} // Builder
	
	public enum TipoMotor {
		
		DosTiempos,
		CuatroTiempos
	}
	
}// Moto
