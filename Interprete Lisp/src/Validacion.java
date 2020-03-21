import java.io.FileNotFoundException;
import java.util.Stack;


public class Validacion {
	Stack<String> stack;
    Calculos Operaciones = new Calculos();
    CodigoLisp funcion = new CodigoLisp();

    
    public Stack<String> encontrarparentesis(Stack<String> s) throws FileNotFoundException {
        stack = s;
        String nuevalinea;
        Stack<String> nuevostack = new Stack<String>();
        nuevalinea = stack.pop();
        try {
            while (!(nuevalinea = stack.pop()).equals("(")) {
                nuevostack.push(nuevalinea);
            }
        } catch (Exception e) {
            System.out.println("Error de Sintaxis");
        }
        encontraroperando(nuevostack);
        
        return stack;
    }
    
    public Stack<String> encontrarq(Stack<String> s) throws FileNotFoundException {
        stack = s;
        Stack<String> quoteStack = new Stack<String>();
        
        while(!stack.isEmpty())
            quoteStack.push(stack.pop());
        quoteStack.pop();
        encontraroperando(quoteStack);
        return stack;
    }
    
    
    public void encontraroperando(Stack<String> StackLinea) throws FileNotFoundException {
        String operacion = StackLinea.pop();

        switch (operacion.toLowerCase()) {
            case "+": 
                double resultadosuma = Operaciones.Suma(StackLinea);
                stack.push(String.valueOf(resultadosuma));
                break;
                
            case "-": 
                double resultadoresta = Operaciones.Resta(StackLinea);
                stack.push(String.valueOf(resultadoresta));
                break;
                
            case "*": 
                double resultadomultiplicacion = Operaciones.Multiplicacion(StackLinea);
                stack.push(String.valueOf(resultadomultiplicacion));
                break;
                
            case "/": 
                double resultadodivision = Operaciones.Division(StackLinea);
                stack.push(String.valueOf(resultadodivision));
                break;
                
            case "<": 
                int resultadomenor = Operaciones.menorQue(StackLinea);
                stack.push(String.valueOf(resultadomenor));
                break;
                
            case ">": 
                int resultadomayor = Operaciones.mayorQue(StackLinea);
                stack.push(String.valueOf(resultadomayor));
                break;
                
            case "equal": 
                int resultadoigual = Operaciones.igualA(StackLinea);
                stack.push(String.valueOf(resultadoigual));
                break;
                
            case "<=": 
                int resultadomenoroigual = Operaciones.menorOIgualQue(StackLinea);
                stack.push(String.valueOf(resultadomenoroigual));
                break;
                
            case ">=": 
                int resultadomayoroigual = Operaciones.mayorOIgualQue(StackLinea);
                stack.push(String.valueOf(resultadomayoroigual));
                break;
                
            case "if": 
                double resultadoif = Operaciones.Condicionif(StackLinea);
                stack.push(String.valueOf(resultadoif));
                break;
                
            case "setq": 
                double resultadosetq = Operaciones.set(StackLinea);
                stack.push(String.valueOf(resultadosetq));
                break;
                
          //  case "defun": 
          //      String ResultadoDefun = funcion.defun(StackLinea);
          //      stack.push(String.valueOf(ResultadoDefun));
          //      break;
                
         //   case "fact": 
          //      String Resultadofact = Operaciones.fact(StackLinea);
           //     stack.push(String.valueOf(Resultadofact));
           //     break;
                
            case "quote": 
                String resultadoquote = Operaciones.quote(StackLinea);
                stack.push(String.valueOf(resultadoquote));
                break;
              
            case "cond":
            	double resultado = Operaciones.Condicionif(StackLinea);
            	stack.push(String.valueOf(resultado));
            	break;
                

        }        
    }

}
