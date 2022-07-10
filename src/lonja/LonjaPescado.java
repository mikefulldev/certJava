package lonja;

import java.text.DateFormat;
import java.util.Random;

public class LonjaPescado {

	public static void main(String[] args) {

		Lonja<CajaPescado> lonja = new Lonja<CajaPescado>("Exquisiteces del Mar");
		CajaPescado caja;
		Random aleato = new Random(System.currentTimeMillis());
		
		System.out.println("Bienvenidos a mi mi humilde lonja \"" 
							+ lonja.getDenominacion() + "\"" 
							+ "\nComencemos la historia de cada día\n");
		
		System.out.println("¡Uy! Ya están llegando los barcos con los productos\n"
							+ "A ver qué nos traen\n");
		
		System.out.println("El primer barco de mi gran amigo Manuel nos trae:\n");
		
		//Primera caja
		caja = lonja.nuevaCaja(new CajaPescado(TipoGenero.values()[aleato.nextInt(4)], 
								true, TipoMedida.PESO, 20.5, 30d, false)); 
		System.out.println(caja);
		//Segunda caja
		caja = lonja.nuevaCaja(new CajaPescado(TipoGenero.DORADA, true, TipoMedida.UNIDADES, 30.0, 5.25, true)); 
		System.out.println("\n" + caja);
		
		System.out.println("\nEl segundo barco de mi colega Roque nos trae:\n");
		
		//Tercera caja
		caja = lonja.nuevaCaja(new CajaPescado(TipoGenero.PULPO, false)); 
		System.out.println("\n" + caja); 
		//Cuarta caja
		caja = lonja.nuevaCaja(new CajaPescado(TipoGenero.GAMBAS, true, TipoMedida.PESO, 20.0, 13.0, false)); 
		System.out.println("\n" + caja);		
		
		
		
//		public CajaPescado(TipoGenero genero, Boolean estaMedida, TipoMedida tipoMedida, 
//				Double medida, Double valorPorUnidad, Boolean contenidoLimpio)
		
		System.out.println("\nEl inventario es:\n\n" + lonja.mostrarInventario());
		System.out.println("\nY en total nuestros productos están valorados en:" 
							+ lonja.valorarCajas());
		
		lonja.vaciarLonja();
		System.out.println("\nPor suerte lo hemos vendido todo a muy buen precio\n"
							+ "y no nos queda ni el polvo del suelo\n"
							+ "Nuestro inventario ahora es:\n\n"
							+ lonja.mostrarInventario());
		System.out.println("\nEso es todo Amiiiiigos!");
		
	}

}
