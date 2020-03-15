import java.io.IOException;

public class Interprete {
	
	public static void main(String[] args)  {
		
		String dede = "(/ 1.8 (- 150 32))";
		LeerDatos controlador = new LeerDatos();
		
		System.out.println(controlador.separarparentesis(dede, "("));
		
		
	}


}
