import java.io.IOException;


public class Interprete {
    public static void main(String args[]) throws IOException {
        LeerDatos operador = new LeerDatos();
        if(operador.sintaxis(operador.importText()) == true){
        	operador.tokenizer(operador.importText());
        }
        else {
        	System.out.println("Error de Sintaxis");
        }
        
            
    }
}
}
