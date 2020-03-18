import java.io.IOException;

public class Interprete {
	
	public static void main(String[] args) throws IOException  {
		
		
		LeerDatos controlador = new LeerDatos();
		Calculos controlador2 = new Calculos();
		Validacion validar = new Validacion();
		
		//leer el archivo de texto y guardarlo en variable funcion, creada en clase leerdatos
		controlador.leerarchivoalista(System.getProperty("user.dir")+ "\\src\\numeros.txt");

		if(validar.sintaxis(controlador.getFuncion()) == true) {
			controlador.separarparentesis(controlador.getFuncion(), "(");
			controlador2.realizaroperacionesdosvariables(controlador.getFuncionseparadaparentesis());
			System.out.println(controlador2.realizaroperacionesunavariable(controlador2.getCalculounavariable()));
		}
		if(validar.sintaxis(controlador.getFuncion()) == false) {
			System.out.println("Error de Sintaxis");
		}
	
	}
	


}
