import java.util.ArrayList;
import java.util.StringTokenizer;

//funcion para hacer los calculos aritmeticos
public class Calculos {
	
	
	
	
	//arrraylists para guardar variables con dos o mas numeros para operar o solo uno por separado
	ArrayList<String> calculosmasdeunavariable = new ArrayList<String>();
	ArrayList<String> calculounavariable = new ArrayList<String>();
	
	//resultado final de operaciones aritmeticas
	int resultadocalculosperaciones;
	//contador de espacios
	int contadorespacios=0;

	ArrayList <Integer> calculosmasdeunavariableseparadossuma = new ArrayList<Integer>();
	ArrayList <Integer> calculosmasdeunavariableseparadosresta = new ArrayList<Integer>();
	ArrayList <Integer> calculosmasdeunavariableseparadosmultiplicacion = new ArrayList<Integer>();
	ArrayList <Integer> calculosmasdeunavariableseparadosdivision = new ArrayList<Integer>();
	
	
	public ArrayList<String> getCalculosmasdeunavariable() {
		return calculosmasdeunavariable;
	}

	public void setCalculosmasdeunavariable(ArrayList<String> calculosmasdeunavariable) {
		this.calculosmasdeunavariable = calculosmasdeunavariable;
	}

	public ArrayList<String> getCalculounavariable() {
		return calculounavariable;
	}

	public void setCalculounavariable(ArrayList<String> calculounavariable) {
		this.calculounavariable = calculounavariable;
	}
	
	
	

	public void SepararCalculosAritmeticos (ArrayList <String> funcion) {
		
		//recorremos arraylist
		for(int i=0; i<funcion.size();i++) {
			
			//recorremos cadena de arraylist
		//	for (int x =0; x<funcion.get(i).length();x++) {
	
				//recorremos cadena de arraylist otra vez, solo para evitar error al final
				for (int x=0, z =1; z<funcion.get(i).length();z++, x++) {					
					//validar posicion final para que no de error
					if (z == funcion.get(i).length()) {
						z-=1;
					}
					if (x == funcion.get(i).length()) {
						x-=1;
					}
					
					//chequear si tiene mas de dos operaciones
					if (String.valueOf(funcion.get(i).charAt(x)).equals(" ")) {
						if(String.valueOf(funcion.get(i).charAt(z)).equals("0") || String.valueOf(funcion.get(i).charAt(z)).equals("1") || String.valueOf(funcion.get(i).charAt(z)).equals("2") || String.valueOf(funcion.get(i).charAt(z)).equals("3") || String.valueOf(funcion.get(i).charAt(z)).equals("4") || String.valueOf(funcion.get(i).charAt(z)).equals("5") || String.valueOf(funcion.get(i).charAt(z)).equals("6") || String.valueOf(funcion.get(i).charAt(z)).equals("7") || String.valueOf(funcion.get(i).charAt(z)).equals("8") || String.valueOf(funcion.get(i).charAt(z)).equals("9") ) {
							contadorespacios++;
						}
				}
				}
				//agregar a array de mas de dosvariables
				if (contadorespacios> 1) {
					calculosmasdeunavariable.add(funcion.get(i));
				}
				//agregar a array con operaciones de una variable
				else {
					calculounavariable.add(funcion.get(i));
				}
			
			//}
		}	
	}
	
	//funcion para ya realizar calculos aritmeticos correspondientes
	public int realizaroperaciones () {
		
		//recorrer arraylist de dos o mas variables
		for(int i =0; i<calculosmasdeunavariable.size(); i++) {
			StringTokenizer tokens = new StringTokenizer(calculosmasdeunavariable.get(i));
			while (tokens.hasMoreTokens()) {
				
				
			}
			
		}
		
		
		
		
		
		return contadorespacios;
		
	}
	
	
	
}
