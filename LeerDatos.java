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
	 
	 public void acomodarnumeros() {
		 
		 
		 
	 }
	 
	 //Funcion para separar por el parametro que se le de a la funcion y guardarlos dentro de arraylist
	 public ArrayList<String> separarparentesis(String funcion, String parametro){
		 
		 StringTokenizer tokens = new StringTokenizer(funcion, parametro);
		 
		 while(tokens.hasMoreTokens()) {
			 String tokenactual = tokens.nextToken();
			 
			 
			 funcionseparadaparentesis.add(tokenactual);
		 }
		 //recorrer arraylist para eliminar ")"
		 for(int i=0; i<funcionseparadaparentesis.size() ;i++) {
			
			 //recprremos la cadena del arraylist
			 for (int x=0; x<funcionseparadaparentesis.get(i).length(); x++) {
				 
				 if (String.valueOf(funcionseparadaparentesis.get(i).charAt(x)).equals(")")) {
					 String nuevovalor = funcionseparadaparentesis.get(i).replace(")", "");
					 funcionseparadaparentesis.set(i, nuevovalor);
				 }
				 
			 }
		 }
		 			 
		return funcionseparadaparentesis;
		 
	 }
	 



}

