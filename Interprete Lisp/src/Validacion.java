import java.io.FileNotFoundException;
import java.util.Stack;


public class Validacion {
	Stack<String> stack;
    Calculos Operaciones = new Calculos();
    CodigoLisp funcion = new CodigoLisp();

    
    public Stack<String> findCommand(Stack<String> s) throws FileNotFoundException {
        stack = s;
        String newcommand;
        Stack<String> newStack = new Stack<String>();
        newcommand = stack.pop();
        try {
            while (!(newcommand = stack.pop()).equals("(")) {
                newStack.push(newcommand);
            }
        } catch (Exception e) {
            System.out.println("Error de Sintaxis");
        }
        findOperation(newStack);
        
        return stack;
    }
    
    public Stack<String> findQuoteCommand(Stack<String> s) throws FileNotFoundException {
        stack = s;
        Stack<String> quoteStack = new Stack<String>();
        
        while(!stack.isEmpty())
            quoteStack.push(stack.pop());
        quoteStack.pop();
        findOperation(quoteStack);
        return stack;
    }
    
    
    public void findOperation(Stack<String> StackLinea) throws FileNotFoundException {
        String operation = StackLinea.pop();

        switch (operation.toLowerCase()) {
            case "+": 
                double plusResult = Operaciones.Suma(StackLinea);
                stack.push(String.valueOf(plusResult));
                break;
                
            case "-": 
                double minusResult = Operaciones.Resta(StackLinea);
                stack.push(String.valueOf(minusResult));
                break;
                
            case "*": 
                double multiplyResult = Operaciones.Multiplicacion(StackLinea);
                stack.push(String.valueOf(multiplyResult));
                break;
                
            case "/": 
                double divideResult = Operaciones.Division(StackLinea);
                stack.push(String.valueOf(divideResult));
                break;
                
            case "<": 
                int lessThanResult = Operaciones.menorQue(StackLinea);
                stack.push(String.valueOf(lessThanResult));
                break;
                
            case ">": 
                int greaterThanResult = Operaciones.mayorQue(StackLinea);
                stack.push(String.valueOf(greaterThanResult));
                break;
                
            case "equal": 
                int equalToResult = Operaciones.igualA(StackLinea);
                stack.push(String.valueOf(equalToResult));
                break;
                
            case "<=": 
                int lessThanEqualToResult = Operaciones.menorOIgualQue(StackLinea);
                stack.push(String.valueOf(lessThanEqualToResult));
                break;
                
            case ">=": 
                int greaterThanEqualToResult = Operaciones.mayorOIgualQue(StackLinea);
                stack.push(String.valueOf(greaterThanEqualToResult));
                break;
                
            case "if": 
                double ifConditionResult = Operaciones.Condicionif(StackLinea);
                stack.push(String.valueOf(ifConditionResult));
                break;
                
            case "setq": 
                double setFunctionResult = Operaciones.set(StackLinea);
                stack.push(String.valueOf(setFunctionResult));
                break;
                
          //  case "defun": 
          //      String quoteResult = funcion.defun(StackLinea);
          //      stack.push(String.valueOf(quoteResult));
          //      break;
                
         //   case "fact": 
          //      String lambdaResult = Operaciones.fact(StackLinea);
           //     stack.push(String.valueOf(lambdaResult));
           //     break;
                
            case "quote": 
                String dynamicLambdaResult = Operaciones.quote(StackLinea);
                stack.push(String.valueOf(dynamicLambdaResult));
                break;
              
            case "cond":
            	double resultado = Operaciones.Condicionif(StackLinea);
            	stack.push(String.valueOf(resultado));
            	break;
                

        }        
    }

}
