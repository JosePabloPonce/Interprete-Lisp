import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeerDatos {
	
	
	private String funcion;
	
	//Funcion para leer archivo de texto y pasarlo a array
	 public String leerarchivoalista(String nombredearchivodetexto) throws IOException 
	    {
	        FileReader leer = new FileReader(nombredearchivodetexto);         
	        BufferedReader bufferedReader = new BufferedReader(leer);
	        String leerlinea = null;
	        int i=0;
	        
	        while ((leerlinea = bufferedReader.readLine()) != null) {
		    funcion +=leerlinea;		    
	        i++;
	        }	         
	        bufferedReader.close();
	        return funcion;
	    }  



}
