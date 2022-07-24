package taller.apoyo;

import taller.especificaciones.Arreglable;

public abstract class VehiculoArreglable extends Vehiculo implements Arreglable {

	//Atributos
	Arreglable.Estado estado;
	
	//Constructores
	protected VehiculoArreglable() {	
		
		//this.estado = Arreglable.Estado.ROTO; //Por defecto ROTO.
	}
	
	//Métodos
	protected void setEstado(Estado estado) {
		
		this.estado = estado;
	}
	
	//De interfaz Arreglable
	@Override
	public boolean estaRoto() {
		
		
		return this.estado == Arreglable.Estado.ROTO;
	}

	@Override
	public boolean estaArreglado() {
		
		return this.estado == Arreglable.Estado.ARREGLADO;
	}

	@Override
	public void arreglar() {
		
		this.estado = Arreglable.Estado.ARREGLADO;

	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.getMarca() + " " + this.getModelo()
				+ this.getCilindrada());
		
		return sb.toString();
	}
	

} // VehiculoArreglable
