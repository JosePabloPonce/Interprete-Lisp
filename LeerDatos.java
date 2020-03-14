import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class LeerDatos {
	
	//variable para almacenar funcion
	private String funcion;
	
	//variable para almacenar funcion separada por parentesis
	ArrayList<String> funcionseparadaparentesis = new ArrayList<String>();
	

	
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
	 
	 
	 public ArrayList<String> separarparentesis(String funcion, String parametro){
		 
		 StringTokenizer tokens = new StringTokenizer(funcion, parametro);
		 
		 while(tokens.hasMoreTokens()) {
			 funcionseparadaparentesis.add(tokens.nextToken());
		 }
		 
			 
		 
		 
		 
		 
		return funcionseparadaparentesis;
		 
	 }



}
