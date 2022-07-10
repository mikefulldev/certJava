package lonja;

//No veo suficiente funcionalidad o diferencias para especializar
//la clase CajaPescado
public class CajaPescado implements Valorable{

	//CONSTANTES
	//Tipos de medida de las cajas
	//public final int MEDIDA_POR_PESO = 1;
	//public final int MEDIDA_POR_UNIDADES = 2;
	
	//Atributos
	private Boolean contenidoLimpio;
	private Boolean estaMedida;
	private TipoMedida tipoMedida;
	//int unidades;
	private Double medida;
	private Double valorPorUnidad;
	private TipoGenero genero;
	
	//Constructores
	public CajaPescado() {
		this(null,false,TipoMedida.PESO,0d,0d, false);
	}

	public CajaPescado(TipoGenero genero, Boolean estaMedida, TipoMedida tipoMedida, 
						Double medida, Double valorPorUnidad, Boolean contenidoLimpio) {
		super();
		this.contenidoLimpio = contenidoLimpio;
		this.estaMedida = estaMedida;
		this.tipoMedida = tipoMedida;
		this.medida = comprobarMedida(medida);
		this.valorPorUnidad = comprobarValorPorUnidad(valorPorUnidad);
		this.setGenero(genero);
	}
	
	public CajaPescado(TipoGenero genero) {
		this(genero,false,TipoMedida.PESO,0d,0d, false);
	}
	public CajaPescado(TipoGenero genero, Boolean contenidoLimpio) {
		this(genero,false,TipoMedida.PESO,0d,0d, contenidoLimpio);		
	}
	
	public CajaPescado(TipoGenero genero, Boolean estaMedida, TipoMedida tipoMedida,
			Double medida) {
		this(genero,estaMedida,tipoMedida,medida,0d, false);		
	}
	
	public CajaPescado(TipoGenero genero, Boolean estaMedida, TipoMedida tipoMedida,
						Double medida, Boolean contenidoLimpio) {
		this(genero,estaMedida,tipoMedida,medida,0d, contenidoLimpio);		
	}
	
	//Métodos de clase
	
	private static Double comprobarMedida(Double medida) {
		//Solo mediciones mayores de cero
		//En otro caso no se hace ni informa nada
		if (medida >=  0)
			return medida;
		else
			return 0d;
		
	}
	
	private static Double comprobarValorPorUnidad(Double valorPorUnidad) {
		//Solo valores por unidad mayores de cero
		//En otro caso no se hace ni informa nada
		if (valorPorUnidad >=  0)
			return valorPorUnidad;
		else
			return 0d;
		
	}
	
	//Getters/Setters
	
	public Boolean getContenidoLimpio() {
		return contenidoLimpio;
	}

	public void setContenidoLimpio(Boolean contenidoLimpio) {
		this.contenidoLimpio = contenidoLimpio;
	}

	public Boolean getEstaMedida() {
		return estaMedida;
	}

	public void setEstaMedida(Boolean estaMedida) {
		this.estaMedida = estaMedida;
	}

	public TipoMedida getTipoMedida() {
		return tipoMedida;
	}

	public void setTipoMedida(TipoMedida tipoMedida) {
		this.tipoMedida = tipoMedida;
	}

	public Double getMedida() {
		return medida;
	}

	public void setMedida(Double medida) {
				
		this.medida = comprobarMedida(medida);
	}

	public Double getValorPorUnidad() {
		return valorPorUnidad;
	}

	public void setValorPorUnidad(Double valorPorUnidad) {
		
		this.valorPorUnidad = comprobarValorPorUnidad(valorPorUnidad);
	}

	private TipoGenero getGenero() {
		return genero;
	}

	private void setGenero(TipoGenero genero) {
		this.genero = genero;
	}	
	
	
	//Comportamiento
	
	public void limpiar() {
		//Si ya está limpia no decimos nada.
		setContenidoLimpio(true);;
	}
	
	public Double medir(Double medida) {
		setMedida(medida);
		return getMedida();
	}
	
	public Double valorar() {
		
		return getMedida() * getValorPorUnidad();
	}

	@Override
	public String toString() {
		return "Caja de Pescado [ genero = " + genero + " contenidoLimpio = " + contenidoLimpio 
				+ ", estaMedida = " + estaMedida + ", tipoMedida= "
				+ tipoMedida.name() + ", medida = " + medida + ", valorPorUnidad =" + valorPorUnidad +
				", valorTotal = " + valorar() + " ]";
	}
	
	

}
