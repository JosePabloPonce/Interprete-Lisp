import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.Stack;

public class Test {
	Stack<String> StackLinea;
	@org.junit.Test
	public void testSuma() throws FileNotFoundException {
		Validacion operacion = new Validacion();
		StackLinea.push("+");
		StackLinea.push("2");
		StackLinea.push("3");
		operacion.encontraroperando(StackLinea);
		assertEquals(5.0, 5.0);
	}
	
	public void testResta() throws FileNotFoundException {
		Validacion operacion = new Validacion();
		StackLinea.push("-");
		StackLinea.push("2");
		StackLinea.push("3");
		operacion.encontraroperando(StackLinea);
		assertEquals(1.00, 1.0);
	}
	
	public void testSintaxis() {
		LeerDatos operacion = new LeerDatos();
		boolean resultado = operacion.sintaxis("(Hola))");
		assertEquals(false,resultado );
		
	}
	
	
	
	
	

}
