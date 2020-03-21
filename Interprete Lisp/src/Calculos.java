import java.util.*;

//funcion para hacer los calculos aritmeticos
public class Calculos {

	//arrraylists y hashmaps para guardar variables con dos o mas numeros para operar o solo uno por separado
	ArrayList<String> calculounavariable = new ArrayList<String>();

	HashMap<String, Double> hashmap = new HashMap<String, Double>();
	public static HashMap<String, Double> auxiliar = new HashMap<String, Double>();

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
	
	public double Suma(Stack<String> StackLinea) {
        double resultado = 0;
        try {
            while (!StackLinea.isEmpty()) {
                if (ComprobarNumero(StackLinea.peek())) {
                    double variable = Double.parseDouble(StackLinea.pop());
                    resultado = resultado + variable;
                } else {
                    if(auxiliar.isEmpty()) {
                        double variable = hashmap.get(StackLinea.pop());
                        resultado = resultado + variable;
                    }
                    else {
                        double variable = auxiliar.get(StackLinea.peek());
                        resultado = resultado + variable;
                        auxiliar.remove(StackLinea.pop());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error de Sintaxis");                                
        }

       
        return resultado;
    }

    public double Resta(Stack<String> StackLinea) {
        double resultado = 0;
        try {
            if (ComprobarNumero(StackLinea.peek())) {
                resultado = Double.parseDouble(StackLinea.pop());
            } else {
                if(auxiliar.isEmpty()) {
                    resultado = hashmap.get(StackLinea.pop());
                }
                else {
                    resultado = auxiliar.get(StackLinea.peek());
                    auxiliar.remove(StackLinea.pop());
                }
            }

            if (StackLinea.isEmpty()) {
                resultado = -resultado;
            }

            while (!StackLinea.isEmpty()) {
                if (ComprobarNumero(StackLinea.peek())) {
                    double variable = Double.parseDouble(StackLinea.pop());
                    resultado = resultado - variable;
                } else {
                    if(auxiliar.isEmpty()) {
                        double variable = hashmap.get(StackLinea.pop());
                        resultado = resultado - variable;
                    }
                    else {
                        double variable = auxiliar.get(StackLinea.peek());
                        resultado = resultado - variable;
                        auxiliar.remove(StackLinea.pop());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error de Sintaxis");
        }

        return resultado;
    }

    public double Multiplicacion(Stack<String> StackLinea) {
        double resultado = 1;
        try {
            if (ComprobarNumero(StackLinea.peek())) {
                resultado = Double.parseDouble(StackLinea.pop());
            } else {
                if(auxiliar.isEmpty()) {
                    resultado = hashmap.get(StackLinea.pop());
                }
                else {
                    resultado = auxiliar.get(StackLinea.peek());
                    auxiliar.remove(StackLinea.pop());
                }
            }

            while (!StackLinea.isEmpty()) {
                if (ComprobarNumero(StackLinea.peek())) {
                    double variable = Double.parseDouble(StackLinea.pop());
                    resultado = resultado * variable;
                } else {
                    if(auxiliar.isEmpty()) {
                        double variable = hashmap.get(StackLinea.pop());
                        resultado = resultado * variable;
                    }
                    else {
                        double variable = auxiliar.get(StackLinea.peek());
                        resultado = resultado * variable;
                        auxiliar.remove(StackLinea.pop());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error de Sintaxis");
        }

        //System.out.println(answer);
        return resultado;
    }

    public double Division(Stack<String> StackLinea) {
//        String answerString = null;
        double resultado = 1;
        try {
            if (ComprobarNumero(StackLinea.peek())) {
                resultado = Double.parseDouble(StackLinea.pop());
            } else {
                if(auxiliar.isEmpty()) {
                    resultado = hashmap.get(StackLinea.pop());
                }
                else {
                    resultado = auxiliar.get(StackLinea.peek());
                    auxiliar.remove(StackLinea.pop());
                }
            }

            while (!StackLinea.isEmpty()) {
                if (ComprobarNumero(StackLinea.peek())) {
                    double variable = Double.parseDouble(StackLinea.pop());
                    resultado = resultado / variable;
                } else {
                    if(auxiliar.isEmpty()) {
                        double variable = hashmap.get(StackLinea.pop());
                        resultado = resultado / variable;
                    }
                    else {
                        double variable = auxiliar.get(StackLinea.peek());
                        resultado = resultado / variable;
                        auxiliar.remove(StackLinea.pop());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error de Sintaxis");
        }

        return resultado;
    }

// Metodo que revisa si un caracter(es) es numerico
  public static boolean ComprobarNumero(String str) {
    try {
      double d = Double.parseDouble(str);
      return true;
    } catch (NumberFormatException nfe) {
      	return false;
    }
  }

// Metodo que realiza la comparacion si un numero es mayor a otro
  public int mayorQue(Stack<String> sta) {

    double val1;
    double val2;
    int resp = -1;

    try {
      if (ComprobarNumero(sta.peek())) {
          val1 = Double.parseDouble(sta.pop());
      } else {
          val1 = hashmap.get(sta.pop());
      }

      if (ComprobarNumero(sta.peek())) {
          val2 = Double.parseDouble(sta.pop());
      } else {
          val2 = hashmap.get(sta.pop());
      }

      if (val1 > val2) {
          resp = 1;
      } else {
          resp = 0;
      }

    } catch (Exception e) {
        System.out.println("Por favor escriba sintaxis Lisp valida!");
    }
    return resp;
  }

// Metodo que realiza la comparacion si un numero es menor a otro
  public int menorQue(Stack<String> sta) {

    double val1;
    double val2;
    int resp = -1;

    try {
    	if (ComprobarNumero(sta.peek())) {
          val1 = Double.parseDouble(sta.pop());
      } else {
          val1 = hashmap.get(sta.pop());
      }

      if (ComprobarNumero(sta.peek())) {
          val2 = Double.parseDouble(sta.pop());
      } else {
          val2 = hashmap.get(sta.pop());
      }

      if (val1<val2) {
          resp = 1;
      } else {
          resp = 0;
      }

    } catch (Exception e) {
        System.out.println("Error de Sintaxis");
    }
    return resp;
  }

// Metodo que realiza la comparacion si un numero es mayor o igual a otro
  public int mayorOIgualQue(Stack<String> sta) {

    double val1;
    double val2;
    int resp = -1;

    try {
      if (ComprobarNumero(sta.peek())) {
          val1 = Double.parseDouble(sta.pop());
      } else {
          val1 = hashmap.get(sta.pop());
      }

      if (ComprobarNumero(sta.peek())) {
          val2 = Double.parseDouble(sta.pop());
      } else {
          val2 = hashmap.get(sta.pop());
      }

      if (val1 >= val2) {
          resp = 1;
      } else {
          resp = 0;
      }

    } catch (Exception e) {
        System.out.println("Error de Sintaxis");
    }
    return resp;
  }

// Metodo que realiza la comparacion si un numero es menor o igual a otro
  public int menorOIgualQue(Stack<String> sta) {

    double val1;
    double val2;
    int resp = -1;

    try {
      if (ComprobarNumero(sta.peek())) {
          val1 = Double.parseDouble(sta.pop());
      } else {
          val1 = hashmap.get(sta.pop());
      }

      if (ComprobarNumero(sta.peek())) {
          val2 = Double.parseDouble(sta.pop());
      } else {
          val2 = hashmap.get(sta.pop());
      }

      if (val1 <= val2) {
          resp = 1;
      } else {
          resp = 0;
      }

    } catch (Exception e) {
        System.out.println("Error de Sintaxis");
    }
    return resp;
  }


// Metodo que realiza la comparacion si un numero es igual a otro
  public int igualA(Stack<String> sta) {

    double val1;
    double val2;
    int resp = -1;

    try {
      if (ComprobarNumero(sta.peek())) {
          val1 = Double.parseDouble(sta.pop());
      } else {
          val1 = hashmap.get(sta.pop());
      }

      if (ComprobarNumero(sta.peek())) {
          val2 = Double.parseDouble(sta.pop());
      } else {
          val2 = hashmap.get(sta.pop());
      }

      if (val1 == val2) {
          resp = 1;
      } else {
          resp = 0;
      }

    } catch (Exception e) {
        System.out.println("Error de Sintaxis");
    }
    return resp;
  }

// Metodo que simula una condicion if
  public double Condicionif(Stack<String> sta) {

    double val1;
    double val2;
    double val3;
    double resp = -1;

    try {
      val1 = Double.parseDouble(sta.pop());

      if (ComprobarNumero(sta.peek())) {
          val2 = Double.parseDouble(sta.pop());
      } else {
          val2 = hashmap.get(sta.pop());
      }

      if (ComprobarNumero(sta.peek())) {
          val3 = Double.parseDouble(sta.pop());
      } else {
          val3 = hashmap.get(sta.pop());
      }

      if (val1 == 1) {
          resp = val2;
      } else {
          resp = val3;
      }

    } catch (Exception e) {
        System.out.println("Error de Sintaxis");
    }
    return resp;
  }

// Metodo que realiza el calculo de raiz cuadrada
  public double raizCuadrada(Stack<String> sta) {

  	double resp = -1;
    double val;

    try {
      if (ComprobarNumero(sta.peek())) {
          val = Double.parseDouble(sta.pop());
      } else {
          val = hashmap.get(sta.pop());
      }
      resp = Math.sqrt(val);

    } catch (Exception e) {
      	System.out.println("Error de Sintaxis");
    }
    return resp;
  }

// Metodo que realiza la funcion de set
	public double set(Stack<String> sta) {

		double val = -1;

		try{
			String txt = sta.pop();

			if(sta.size() == 1){
				val = Double.parseDouble(sta.pop());
				hashmap.put(txt, val);
			}

		} catch (Exception e){
			System.out.println("Error de Sintaxis");
		}
		return val;

	}
	
	public String quote(Stack<String> StackLinea) {
        String quote = "";
        
        while(!StackLinea.isEmpty()) {
            if(StackLinea.peek().equals("(") && StackLinea.get(StackLinea.size() - 2).equals("quote")) {
                quote = quote + "' ";
                StackLinea.pop();
                StackLinea.pop();
                StackLinea.remove(0);
            }
            else
                quote = quote + StackLinea.pop() + " ";
        }
        
        quote = quote.replace(" ( ", "(");
        quote = quote.replace(" ) ", ")");
        quote = quote.replace("( ", "(");
        quote = quote.replace(") ", ")");
                        
        return quote;
    }
    
}
