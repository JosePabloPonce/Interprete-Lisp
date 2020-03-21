import java.io.IOException;
import java.util.Scanner;


public class Interprete {
    public static void main(String args[]) throws IOException {
        LeerDatos operador = new LeerDatos();
        System.out.println("Ingrese el nombre del archivo de texto: \n");
        Scanner myObj = new Scanner(System.in);
        String texto = myObj.nextLine();
        if(operador.sintaxis(operador.importText(texto)) == true){
        	operador.leeryejecutar(operador.importText(texto));
        }
        else {
        	System.out.println("Error de Sintaxis");
        }
        
            
    }
}
