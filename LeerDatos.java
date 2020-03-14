import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeerDatos {
	
	
	ArrayList<String> Dicvalores = new ArrayList<String>();
	
	//Funcion para leer archivo de texto y pasarlo a array
	 public ArrayList<String> leerarchivoalista(String nombredearchivodetexto) throws IOException 
	    {
	        FileReader leer = new FileReader(nombredearchivodetexto);         
	        BufferedReader bufferedReader = new BufferedReader(leer);
	        String leerlinea = null;
	        int i=0;
	        
	        while ((leerlinea = bufferedReader.readLine()) != null) {
		    Dicvalores.add(leerlinea);		    
	        i++;
	        }	         
	        bufferedReader.close();
	        return Dicvalores;
	    }  





}
