import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

//funcion para hacer los calculos aritmeticos
public class Calculos {
	
	//arrraylists para guardar variables con dos o mas numeros para operar o solo uno por separado
	ArrayList<String> calculounavariable = new ArrayList<String>();
	
	//resultado final de operaciones aritmeticas
	double resultadocalculosperaciones;
	//contador de espacios
	int contadorespacios=0;
	int contadororden =0;

	public ArrayList<String> getCalculounavariable() {
		return calculounavariable;
	}

	public void setCalculounavariable(ArrayList<String> calculounavariable) {
		this.calculounavariable = calculounavariable;
	}
	
	//funcion que recorre el arraylist y opera todos los casos donde encuentre dos numeros
	public void realizaroperacionesdosvariables (ArrayList <String> funcion) {
		
		if(calculounavariable !=null) {
			calculounavariable.clear();
		}
		
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
					
					StringTokenizer tokens = new StringTokenizer(funcion.get(i));
					String tokensignosoperacion = tokens.nextToken();
					int operando1;
					int operando2;

					while (tokens.hasMoreTokens()) {
						
						String siguientetoken = tokens.nextToken();
						
						//Chequear si el siguiente token para saber si es otra operacion, si lo es empezar a realizar calculos
						if (siguientetoken.equals("+")|| siguientetoken.equals("-")|| siguientetoken.equals("*")|| siguientetoken.equals("/")) {
							tokensignosoperacion = siguientetoken;
						}
						//realizar operacion si es suma	
						if (tokensignosoperacion.equals("+")) {
							
							while(!siguientetoken.equals("+")&& !siguientetoken.equals("-")&& !siguientetoken.equals("*")&& !siguientetoken.equals("/")  ) {
							
							resultadocalculosperaciones += Double.parseDouble(siguientetoken);
							
							//atrapar error de que no hay ningun siguiente token
							try {
								siguientetoken= tokens.nextToken();

							}
							
							catch(NoSuchElementException errorelemento) {
								siguientetoken = "+";
								
							}
							
						}
						}
						
						//realizar operacion si es resta	
						if (tokensignosoperacion.equals("-")) {
							int contador =0;
							while(!siguientetoken.equals("+")&& !siguientetoken.equals("-")&& !siguientetoken.equals("*")&& !siguientetoken.equals("/")  ) {
							
								//condicion para realizar resta y darle el primer valor que encuentre para que no reste por cero la primera vez
								if (contador<1) {
									resultadocalculosperaciones=Double.parseDouble(siguientetoken);
									contador++;
									
								}
								else {
									resultadocalculosperaciones -= Double.parseDouble(siguientetoken);

								}
								
							
							//atrapar error de que no hay ningun siguiente token
							try {
								siguientetoken= tokens.nextToken();

							}
							
							catch(NoSuchElementException errorelemento) {
								siguientetoken = "+";
								
							}
							
						}
						}
						
						//realizar operacion si es multiplicacion	
						if (tokensignosoperacion.equals("*")) {
							//darle el valor de 1 para que la primera multiplicacion no sea 0
							resultadocalculosperaciones =1;
							while(!siguientetoken.equals("+")&& !siguientetoken.equals("-")&& !siguientetoken.equals("*")&& !siguientetoken.equals("/")  ) {
							resultadocalculosperaciones *= Double.parseDouble(siguientetoken);
							
							//atrapar error de que no hay ningun siguiente token
							try {
								siguientetoken= tokens.nextToken();

							}
							
							catch(NoSuchElementException errorelemento) {
								siguientetoken = "+";
								
							}
							
						}
						}
						
						//realizar operacion si es division	
						if (tokensignosoperacion.equals("/")) {
							int contador=0;
							while(!siguientetoken.equals("+")&& !siguientetoken.equals("-")&& !siguientetoken.equals("*")&& !siguientetoken.equals("/")  ) {
								
								//condicion para realizar division y darle el primer valor que encuentre
								if (contador<1) {
									resultadocalculosperaciones=Double.parseDouble(siguientetoken);
									contador++;
									
								}
								else {
									resultadocalculosperaciones /= Double.parseDouble(siguientetoken);

								}
							
							//atrapar error de que no hay ningun siguiente token
							try {
								siguientetoken= tokens.nextToken();

							}
							
							catch(NoSuchElementException errorelemento) {
								siguientetoken = "+";
								
							}
							
						}
						}
									
					}
					
					//lista donde se van a almacenar los datos operados
					calculounavariable.add(tokensignosoperacion + " "+String.valueOf(resultadocalculosperaciones));
					contadorespacios=0;
					resultadocalculosperaciones=0;
				
				}
		
				//lista donde se van a almacenar si solo encuentra un dato para operar
				else {
					calculounavariable.add(funcion.get(i));
					contadorespacios=0;
					resultadocalculosperaciones=0;
					
				}
			
		}	
	}
	
	
	//funcion que realiza las operaciones de todos los casos donde hay una variable
	public Double realizaroperacionesunavariable (ArrayList <String> funcion) {
		
		//mientras en la funcion hayan mas de dos numeros para operar
		while(funcion.size()>=2) {
		
			//separar por token penultima posicion del arraylist
			StringTokenizer tokens = new StringTokenizer(funcion.get(funcion.size()-2));
			StringTokenizer tokens2 = new StringTokenizer(funcion.get(funcion.size()-1));

			//obtener signo de token de penultima operacion
			String tokensignosoperacion = tokens.nextToken();
			
			//omitir simbolo de operacion del ultimo token
			tokens2.nextToken();
			
			//obtener el valor del ultimo token
			String siguientetoken2= tokens2.nextToken();

			
		
			while (tokens.hasMoreTokens()) {
				
				String siguientetoken = tokens.nextToken();
				
				//Chequear si el siguiente token para saber si es otra operacion, si lo es empezar a realizar calculos
				if (siguientetoken.equals("+")|| siguientetoken.equals("-")|| siguientetoken.equals("*")|| siguientetoken.equals("/")) {
					tokensignosoperacion = siguientetoken;
				}
				//realizar operacion si es suma	
				if (tokensignosoperacion.equals("+")) {
					
					while(!siguientetoken.equals("+")&& !siguientetoken.equals("-")&& !siguientetoken.equals("*")&& !siguientetoken.equals("/")  ) {
					
					resultadocalculosperaciones = Double.parseDouble(siguientetoken) +  Double.parseDouble(siguientetoken2) ;
					
					//atrapar error de que no hay ningun siguiente token
					try {
						siguientetoken= tokens.nextToken();

					}
					
					catch(NoSuchElementException errorelemento) {
						siguientetoken = "+";
						
					}
					
				}
				}
				
				//realizar operacion si es resta	
				if (tokensignosoperacion.equals("-")) {
					
					while(!siguientetoken.equals("+")&& !siguientetoken.equals("-")&& !siguientetoken.equals("*")&& !siguientetoken.equals("/")  ) {
					
					resultadocalculosperaciones = Double.parseDouble(siguientetoken)- Double.parseDouble(siguientetoken2);
					
					//atrapar error de que no hay ningun siguiente token
					try {
						siguientetoken= tokens.nextToken();

					}
					
					catch(NoSuchElementException errorelemento) {
						siguientetoken = "+";
						
					}
					
				}
				}
				
				//realizar operacion si es multiplicacion	
				if (tokensignosoperacion.equals("*")) {
					//darle el valor de 1 para que la primera multiplicacion no sea 0
					while(!siguientetoken.equals("+")&& !siguientetoken.equals("-")&& !siguientetoken.equals("*")&& !siguientetoken.equals("/")  ) {
					resultadocalculosperaciones = Double.parseDouble(siguientetoken) *  Double.parseDouble(siguientetoken2);
					
					//atrapar error de que no hay ningun siguiente token
					try {
						siguientetoken= tokens.nextToken();

					}
					
					catch(NoSuchElementException errorelemento) {
						siguientetoken = "+";
						
					}
					
				}
				}
				
				//realizar operacion si es division	
				if (tokensignosoperacion.equals("/")) {
					while(!siguientetoken.equals("+")&& !siguientetoken.equals("-")&& !siguientetoken.equals("*")&& !siguientetoken.equals("/")  ) {
						
						resultadocalculosperaciones = Double.parseDouble(siguientetoken) / Double.parseDouble(siguientetoken2);
								
					
					//atrapar error de que no hay ningun siguiente token
					try {
						siguientetoken= tokens.nextToken();

					}
					
					catch(NoSuchElementException errorelemento) {
						siguientetoken = "+";
						
					}
					
				}
				}
			
				
				calculounavariable.set(funcion.size()-2 ,tokensignosoperacion + " "+String.valueOf(resultadocalculosperaciones));
				funcion.remove(funcion.size()-1);
				contadororden++;
				contadorespacios=0;

			}
			
			
		}
		if(calculounavariable !=null) {
			calculounavariable.clear();
		}
	//	poner el valor de los resultados en 0 por si se ingresara una nueva 
		double resultadocalculosperaciones2 = resultadocalculosperaciones;
		resultadocalculosperaciones=0;
		return resultadocalculosperaciones2;
		
	}
		
	
}
