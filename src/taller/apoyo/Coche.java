package taller.apoyo;


public class Coche extends VehiculoArreglable {

	//Atributos
	private int puertas = 0;
	
	//Constructores
	protected Coche() {}
	
	//Getters/Setters
	public int getPuertas() {
		return puertas;
	}

	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}	

	@Override
	public void arreglar() {
		
		if (this.estaRoto()) { 
			super.arreglar();
			System.out.println(this + " ha sido reparado");
		} else System.out.println(this + " no puede ser reparado porque no está averiado");
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(this.getClass().getSimpleName());
		
		sb.append("\t" + super.toString() + "\t" + this.getPuertas() + "\t" + this.estado);
		
		return sb.toString();
	}


	//Invocar construcción del Builder.
	public static Coche.Builder builder() {return new Coche.Builder(); }

	public static class Builder extends Vehiculo.Builder {
		
		//Atributos
		private Coche vehiculo = null;
		
		//Constructores
		public Builder( ) {
			
			super();
			this.vehiculo = (Coche) super.setVehiculo(new Coche());
		}

		//Métodos
		@Override
		public Coche build() {
			
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
		
		public Builder setPuertas(int puertas) {
			this.vehiculo.setPuertas(puertas);
			return this;
		}
		
		
		
	}
}
