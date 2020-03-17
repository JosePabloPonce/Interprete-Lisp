import java.io.IOException;

public class Interprete {
	
	public static void main(String[] args)  {
		
		String dede = "(+ 3 1 3 (+ 4 3(- 2 3(* 2 3 (/ 2 4)) )))";
		LeerDatos controlador = new LeerDatos();
		Calculos controlador2 = new Calculos();
		
		controlador2.realizaroperacionesdosvariables(controlador.separarparentesis(dede, "("));
		System.out.println(controlador2.getCalculounavariable());
		System.out.println(controlador2.realizaroperacionesunavariable(controlador2.getCalculounavariable()));

		
	}


}
